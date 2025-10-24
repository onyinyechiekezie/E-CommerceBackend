package com.ecommerce.ecommercebackend.domain.service;

import com.ecommerce.ecommercebackend.domain.exception.ComplianceViolationException;
import com.ecommerce.ecommercebackend.domain.model.ComplianceRecord;
import com.ecommerce.ecommercebackend.domain.enums.KYCStatus;

public class ComplianceDomainService {
    public void verifyKYC(ComplianceRecord record) {
        if (record.getKycStatus() != KYCStatus.VERIFIED)
            throw new ComplianceViolationException("KYC not verified");
    }

    public void ensureGdprConsent(ComplianceRecord record) {
        if (!record.hasGdprConsent())
            throw new ComplianceViolationException("GDPR consent required");
    }

    public void ensureRegionCompliance(String country) {
        if ("NORTH_KOREA".equalsIgnoreCase(country) || "IRAN".equalsIgnoreCase(country))
            throw new ComplianceViolationException("Region not supported due to sanctions");
    }

    public void ensureAMLCheck(boolean passed) {
        if (!passed)
            throw new ComplianceViolationException("AML (Anti-Money Laundering) check failed");
    }
}
