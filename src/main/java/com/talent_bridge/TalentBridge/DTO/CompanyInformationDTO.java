package com.talent_bridge.TalentBridge.DTO;

public class CompanyInformationDTO {

    private Long id;
    private String companyDescription;
    private String taxNumber;
    private String registeredAddress;
    private String registrationDocument;
    private String taxClearanceDocument;
    private String leaseAgreement;
    private Long userId;

    // --- Getters and Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCompanyDescription() { return companyDescription; }
    public void setCompanyDescription(String companyDescription) { this.companyDescription = companyDescription; }

    public String getTaxNumber() { return taxNumber; }
    public void setTaxNumber(String taxNumber) { this.taxNumber = taxNumber; }

    public String getRegisteredAddress() { return registeredAddress; }
    public void setRegisteredAddress(String registeredAddress) { this.registeredAddress = registeredAddress; }

    public String getRegistrationDocument() { return registrationDocument; }
    public void setRegistrationDocument(String registrationDocument) { this.registrationDocument = registrationDocument; }

    public String getTaxClearanceDocument() { return taxClearanceDocument; }
    public void setTaxClearanceDocument(String taxClearanceDocument) { this.taxClearanceDocument = taxClearanceDocument; }

    public String getLeaseAgreement() { return leaseAgreement; }
    public void setLeaseAgreement(String leaseAgreement) { this.leaseAgreement = leaseAgreement; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}
