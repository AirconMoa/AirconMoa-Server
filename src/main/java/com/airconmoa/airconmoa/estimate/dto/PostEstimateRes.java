package com.airconmoa.airconmoa.estimate.dto;

import com.airconmoa.airconmoa.domain.Estimate;
import com.airconmoa.airconmoa.domain.constant.InstallationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class PostEstimateRes {
    private Long estimateId;
    private InstallationStatus status;
    private Long fee;
    private LocalDateTime installationDt;
    private String extraComment;
    private Long companyId;
    private String companyName;
    private String companyNumber;
    private String companyEmail;
    private String companyAddress;

    public PostEstimateRes(Estimate estimate) {
        this.estimateId = estimate.getEstimateId();
        this.status = estimate.getStatus();
        this.fee = estimate.getFee();
        this.installationDt = estimate.getInstallationDt();
        this.extraComment = estimate.getExtraComment();
        this.companyId = estimate.getCompany().getCompanyId();
        this.companyName = estimate.getCompany().getCompanyName();
        this.companyNumber = estimate.getCompany().getCompanyNumber();
        this.companyEmail = estimate.getCompany().getCompanyEmail();
        this.companyAddress = estimate.getCompany().getCompanyAddress();
    }
}
