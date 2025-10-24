package com.ecommerce.ecommercebackend.domain.model;

import com.ecommerce.ecommercebackend.domain.enums.KYCStatus;
import java.time.LocalDateTime;
import java.util.UUID;

public class ComplianceRecord {
    private final UUID userId;
    private final KYCStatus kycStatus;
    private final boolean gdprConsent;
    private final LocalDateTime lastUpdated;

    public ComplianceRecord(UUID userId, KYCStatus kycStatus, boolean gdprConsent, LocalDateTime lastUpdated) {
        this.userId = userId;
        this.kycStatus = kycStatus;
        this.gdprConsent = gdprConsent;
        this.lastUpdated = lastUpdated;
    }

    public UUID getUserId() { return userId; }
    public KYCStatus getKycStatus() { return kycStatus; }
    public boolean hasGdprConsent() { return gdprConsent; }
    public LocalDateTime getLastUpdated() { return lastUpdated; }
}
