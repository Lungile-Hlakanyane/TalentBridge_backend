package com.talent_bridge.TalentBridge.service;
import com.talent_bridge.TalentBridge.DTO.CompanyInformationDTO;
import java.util.List;

public interface CompanyInformationService {
    CompanyInformationDTO createCompanyInfo(CompanyInformationDTO dto);
    CompanyInformationDTO getCompanyInfoByUserId(Long userId);
    List<CompanyInformationDTO> getAllCompanyInfos();
    void deleteCompanyInfo(Long id);
}
