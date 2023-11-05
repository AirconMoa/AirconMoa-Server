package com.airconmoa.airconmoa.domain;


import com.airconmoa.airconmoa.domain.constant.InstallationStatus;
import com.airconmoa.airconmoa.estimate.dto.PatchEstimateReq;
import com.airconmoa.airconmoa.estimate.dto.PostEstimateReq;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Estimate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long estimateId;
    @Enumerated(EnumType.STRING)
    private InstallationStatus status;
    private Long fee;
    private LocalDateTime installationDt;
    private String extraComment;
//    @ManyToOne
//    private RequestEstimate requestEstimate;
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    public Estimate(InstallationStatus status, Long fee, LocalDateTime installationDt, String extraComment, Company company) {
        this.status = status;
        this.fee = fee;
        this.installationDt = installationDt;
        this.extraComment = extraComment;
        this.company = company;
    }

    public Estimate(PostEstimateReq postEstimateReq, Company company) {
        this(InstallationStatus.REQUESTED, postEstimateReq.getFee(), postEstimateReq.getInstallationDt(), postEstimateReq.getExtraComment(), company);
    }

    public void updateEstimate(PatchEstimateReq patchEstimateReq) {
        this.status = patchEstimateReq.getStatus() == null ? this.status : patchEstimateReq.getStatus();
        this.fee = patchEstimateReq.getFee() == null ? this.fee : patchEstimateReq.getFee();
        this.installationDt = patchEstimateReq.getInstallationDt() == null ? this.installationDt : patchEstimateReq.getInstallationDt();
        this.extraComment = patchEstimateReq.getExtraComment() == null ? this.extraComment : patchEstimateReq.getExtraComment();
    }
}
