package com.talent_bridge.TalentBridge.serviceImp;
import com.talent_bridge.TalentBridge.DTO.ResumeAnalysisResult;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

@Service
public class ResumeAnalysisService {

    @Value("${file.upload-dir:uploads}")
    private String uploadDir;

    private static final List<String> TECH_KEYWORDS = List.of(
            "Angular", "React", "Vue", "Spring Boot", "Java", "TypeScript",
            "JavaScript", "SQL", "Python", "HTML", "CSS", "Node.js", "Docker", "AWS"
    );

    public ResumeAnalysisResult analyzeResume(String fileName) throws IOException {
        File file = new File(uploadDir + File.separator + fileName);
        if (!file.exists()) {
            throw new IOException("File not found: " + fileName);
        }
        String text = extractTextFromPdf(file);
        ResumeAnalysisResult result = new ResumeAnalysisResult();
        result.setRawText(text);
        result.setEmails(extractEmails(text));
        result.setPhones(extractPhones(text));
        result.setSkills(extractSkills(text));
        result.setKeywordCounts(countTechKeywords(text));
        return result;
    }

    private String extractTextFromPdf(File file) throws IOException {
        try (PDDocument document = PDDocument.load(file)) {
            return new PDFTextStripper().getText(document);
        }
    }

    private List<String> extractEmails(String text) {
        List<String> emails = new ArrayList<>();
        Pattern p = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,}");
        Matcher m = p.matcher(text);
        while (m.find()) emails.add(m.group());
        return emails;
    }

    private List<String> extractPhones(String text) {
        List<String> phones = new ArrayList<>();
        Pattern p = Pattern.compile("\\+?\\d[\\d\\s().-]{6,}\\d");
        Matcher m = p.matcher(text);
        while (m.find()) phones.add(m.group().trim());
        return phones;
    }

    private List<String> extractSkills(String text) {
        List<String> skills = new ArrayList<>();
        for (String skill : TECH_KEYWORDS) {
            if (text.toLowerCase().contains(skill.toLowerCase())) {
                skills.add(skill);
            }
        }
        return skills;
    }

    private Map<String, Integer> countTechKeywords(String text) {
        Map<String, Integer> counts = new HashMap<>();
        for (String keyword : TECH_KEYWORDS) {
            int count = countOccurrences(text.toLowerCase(), keyword.toLowerCase());
            if (count > 0) counts.put(keyword, count);
        }
        return counts;
    }

    private int countOccurrences(String text, String sub) {
        int count = 0, index = 0;
        while ((index = text.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length();
        }
        return count;
    }
}
