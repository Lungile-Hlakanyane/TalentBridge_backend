package com.talent_bridge.TalentBridge.serviceImp;
import com.talent_bridge.TalentBridge.DTO.CompanyInformationDTO;
import com.talent_bridge.TalentBridge.entity.CompanyInformation;
import com.talent_bridge.TalentBridge.entity.User;
import com.talent_bridge.TalentBridge.mapper.CompanyInformationMapper;
import com.talent_bridge.TalentBridge.repository.CompanyInformationRepository;
import com.talent_bridge.TalentBridge.repository.UserRepository;
import com.talent_bridge.TalentBridge.service.CompanyInformationService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyInformationServiceImpl implements CompanyInformationService {

    private final CompanyInformationMapper companyInformationMapper;
    private final CompanyInformationRepository companyInfoRepo;
    private final UserRepository userRepo;

    public CompanyInformationServiceImpl(CompanyInformationMapper companyInformationMapper, CompanyInformationRepository companyInfoRepo, UserRepository userRepo) {
        this.companyInformationMapper = companyInformationMapper;
        this.companyInfoRepo = companyInfoRepo;
        this.userRepo = userRepo;
    }

    @Override
    public CompanyInformationDTO createCompanyInfo(CompanyInformationDTO dto) {
        User user = userRepo.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        CompanyInformation companyInfo = CompanyInformationMapper.toEntity(dto, user);
        CompanyInformation saved = companyInfoRepo.save(companyInfo);
        return CompanyInformationMapper.toDTO(saved);
    }

    @Override
    public CompanyInformationDTO getCompanyInfoByUserId(Long userId) {
        CompanyInformation companyInfo = companyInfoRepo.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Company info not found for user ID: " + userId));
        return CompanyInformationMapper.toDTO(companyInfo);
    }

    @Override
    public List<CompanyInformationDTO> getAllCompanyInfos() {
        return companyInfoRepo.findAll().stream()
                .map(CompanyInformationMapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public void deleteCompanyInfo(Long id) {
        companyInfoRepo.deleteById(id);
    }

    @Override
    public CompanyInformationDTO updateCompanyInfo(Long userId, CompanyInformationDTO updatedInfo) {
        CompanyInformation existing = companyInfoRepo.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Company information not found for user ID: " + userId));

        // Update only fields provided
        existing.setCompanyDescription(updatedInfo.getCompanyDescription());
        existing.setTaxNumber(updatedInfo.getTaxNumber());
        existing.setRegisteredAddress(updatedInfo.getRegisteredAddress());

        if (updatedInfo.getRegistrationDocument() != null) {
            existing.setRegistrationDocument(updatedInfo.getRegistrationDocument());
        }
        if (updatedInfo.getTaxClearanceDocument() != null) {
            existing.setTaxClearanceDocument(updatedInfo.getTaxClearanceDocument());
        }
        if (updatedInfo.getLeaseAgreement() != null) {
            existing.setLeaseAgreement(updatedInfo.getLeaseAgreement());
        }
        CompanyInformation saved = companyInfoRepo.save(existing);
        return CompanyInformationMapper.toDTO(saved);
    }
}
