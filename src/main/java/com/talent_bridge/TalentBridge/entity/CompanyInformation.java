package com.talent_bridge.TalentBridge.entity;
import jakarta.persistence.*;

@Entity
@Table(name="company_informations")
public class CompanyInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyDescription;
    private String taxNumber;
    private String registeredAddress;
    @Lob
    @Column(name = "registration_document", columnDefinition = "MEDIUMBLOB")
    private byte[] registrationDocument;
    @Lob
    @Column(name = "tax_clearance_document", columnDefinition = "MEDIUMBLOB")
    private byte[] taxClearanceDocument;
    @Lob
    @Column(name = "lease_agreement", columnDefinition = "MEDIUMBLOB")
    private byte[] leaseAgreement;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    // --- Getters and Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCompanyDescription() { return companyDescription; }
    public void setCompanyDescription(String companyDescription) { this.companyDescription = companyDescription; }
    public String getTaxNumber() { return taxNumber; }
    public void setTaxNumber(String taxNumber) { this.taxNumber = taxNumber; }
    public String getRegisteredAddress() { return registeredAddress; }
    public void setRegisteredAddress(String registeredAddress) { this.registeredAddress = registeredAddress; }
    public byte[] getRegistrationDocument() {
        return registrationDocument;
    }
    public void setRegistrationDocument(byte[] registrationDocument) {
        this.registrationDocument = registrationDocument;
    }
    public byte[] getTaxClearanceDocument() {
        return taxClearanceDocument;
    }

    public void setTaxClearanceDocument(byte[] taxClearanceDocument) {
        this.taxClearanceDocument = taxClearanceDocument;
    }

    public byte[] getLeaseAgreement() {
        return leaseAgreement;
    }

    public void setLeaseAgreement(byte[] leaseAgreement) {
        this.leaseAgreement = leaseAgreement;
    }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
