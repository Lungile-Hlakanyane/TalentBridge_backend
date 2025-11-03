package com.talent_bridge.TalentBridge.mapper;
import com.talent_bridge.TalentBridge.DTO.CompanyInformationDTO;
import com.talent_bridge.TalentBridge.entity.CompanyInformation;
import com.talent_bridge.TalentBridge.entity.User;
import org.springframework.stereotype.Component;

@Component
public class CompanyInformationMapper {
    public static CompanyInformation toEntity(CompanyInformationDTO dto, User user) {
        CompanyInformation entity = new CompanyInformation();
        entity.setId(dto.getId());
        entity.setCompanyDescription(dto.getCompanyDescription());
        entity.setTaxNumber(dto.getTaxNumber());
        entity.setRegisteredAddress(dto.getRegisteredAddress());
        entity.setRegistrationDocument(dto.getRegistrationDocument());
        entity.setTaxClearanceDocument(dto.getTaxClearanceDocument());
        entity.setLeaseAgreement(dto.getLeaseAgreement());
        entity.setUser(user);
        return entity;
    }

    public static CompanyInformationDTO toDTO(CompanyInformation entity) {
        CompanyInformationDTO dto = new CompanyInformationDTO();
        dto.setId(entity.getId());
        dto.setCompanyDescription(entity.getCompanyDescription());
        dto.setTaxNumber(entity.getTaxNumber());
        dto.setRegisteredAddress(entity.getRegisteredAddress());
        dto.setRegistrationDocument(entity.getRegistrationDocument());
        dto.setTaxClearanceDocument(entity.getTaxClearanceDocument());
        dto.setLeaseAgreement(entity.getLeaseAgreement());
        dto.setUserId(entity.getUser().getId());
        return dto;
    }
}
