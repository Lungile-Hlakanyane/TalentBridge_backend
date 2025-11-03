package com.talent_bridge.TalentBridge.controller;
import com.talent_bridge.TalentBridge.DTO.CompanyInformationDTO;
import com.talent_bridge.TalentBridge.service.CompanyInformationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company-info")
public class CompanyInformationController {
    private final CompanyInformationService companyInfoService;

    public CompanyInformationController(CompanyInformationService companyInfoService) {
        this.companyInfoService = companyInfoService;
    }

    @PostMapping("/create")
    public ResponseEntity<CompanyInformationDTO> createCompanyInfo(@RequestBody CompanyInformationDTO dto) {
        CompanyInformationDTO created = companyInfoService.createCompanyInfo(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<CompanyInformationDTO> getByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(companyInfoService.getCompanyInfoByUserId(userId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CompanyInformationDTO>> getAll() {
        return ResponseEntity.ok(companyInfoService.getAllCompanyInfos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        companyInfoService.deleteCompanyInfo(id);
        return ResponseEntity.noContent().build();
    }
}
