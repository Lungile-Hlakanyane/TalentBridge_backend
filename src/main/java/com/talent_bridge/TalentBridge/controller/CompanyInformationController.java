package com.talent_bridge.TalentBridge.controller;
import com.talent_bridge.TalentBridge.DTO.CompanyInformationDTO;
import com.talent_bridge.TalentBridge.service.CompanyInformationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/company-info")
public class CompanyInformationController {
    private final CompanyInformationService companyInfoService;

    public CompanyInformationController(CompanyInformationService companyInfoService) {
        this.companyInfoService = companyInfoService;
    }

    @PostMapping(value = "/create", consumes = "multipart/form-data")
    public ResponseEntity<CompanyInformationDTO> createCompanyInfo(
            @RequestParam("description") String description,
            @RequestParam("taxNumber") String taxNumber,
            @RequestParam("registeredAddress") String registeredAddress,
            @RequestParam(value = "registrationDocument", required = false) MultipartFile registrationDocument,
            @RequestParam(value = "taxClearanceDocument", required = false) MultipartFile taxClearanceDocument,
            @RequestParam(value = "leaseAgreement", required = false) MultipartFile leaseAgreement,
            @RequestParam("userId") Long userId
    ) throws IOException {

        CompanyInformationDTO dto = new CompanyInformationDTO();
        dto.setCompanyDescription(description);
        dto.setTaxNumber(taxNumber);
        dto.setRegisteredAddress(registeredAddress);
        dto.setUserId(userId);

        if (registrationDocument != null && !registrationDocument.isEmpty()) {
            dto.setRegistrationDocument(registrationDocument.getBytes());
        }
        if (taxClearanceDocument != null && !taxClearanceDocument.isEmpty()) {
            dto.setTaxClearanceDocument(taxClearanceDocument.getBytes());
        }
        if (leaseAgreement != null && !leaseAgreement.isEmpty()) {
            dto.setLeaseAgreement(leaseAgreement.getBytes());
        }

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

    @PutMapping(value = "/update/{userId}", consumes = "multipart/form-data")
    public ResponseEntity<CompanyInformationDTO> updateCompanyInfo(
            @PathVariable Long userId,
            @RequestParam("companyDescription") String companyDescription,
            @RequestParam("taxNumber") String taxNumber,
            @RequestParam("registeredAddress") String registeredAddress,
            @RequestParam(value = "registrationDocument", required = false) MultipartFile registrationDocument,
            @RequestParam(value = "taxClearanceDocument", required = false) MultipartFile taxClearanceDocument,
            @RequestParam(value = "leaseAgreement", required = false) MultipartFile leaseAgreement
    ) throws IOException {
        CompanyInformationDTO dto = new CompanyInformationDTO();
        dto.setUserId(userId);
        dto.setCompanyDescription(companyDescription);
        dto.setTaxNumber(taxNumber);
        dto.setRegisteredAddress(registeredAddress);
        if (registrationDocument != null && !registrationDocument.isEmpty()) {
            dto.setRegistrationDocument(registrationDocument.getBytes());
        }
        if (taxClearanceDocument != null && !taxClearanceDocument.isEmpty()) {
            dto.setTaxClearanceDocument(taxClearanceDocument.getBytes());
        }
        if (leaseAgreement != null && !leaseAgreement.isEmpty()) {
            dto.setLeaseAgreement(leaseAgreement.getBytes());
        }
        CompanyInformationDTO updated = companyInfoService.updateCompanyInfo(userId, dto);
        return ResponseEntity.ok(updated);
    }


}
