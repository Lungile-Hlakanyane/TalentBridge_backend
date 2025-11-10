package com.talent_bridge.TalentBridge.controller;
import com.talent_bridge.TalentBridge.DTO.ResumeAnalysisResult;
import com.talent_bridge.TalentBridge.serviceImp.ResumeAnalysisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

@RestController
@RequestMapping("/api/resume")
public class ResumeAnalysisController {
    private final ResumeAnalysisService resumeAnalysisService;
    public ResumeAnalysisController(ResumeAnalysisService resumeAnalysisService) {
        this.resumeAnalysisService = resumeAnalysisService;
    }
    @GetMapping("/analyze")
    public ResponseEntity<ResumeAnalysisResult> analyzeResume(@RequestParam String fileName) {
        try {
            ResumeAnalysisResult result = resumeAnalysisService.analyzeResume(fileName);
            return ResponseEntity.ok(result);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
