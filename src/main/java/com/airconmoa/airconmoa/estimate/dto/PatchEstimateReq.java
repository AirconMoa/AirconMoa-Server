package com.airconmoa.airconmoa.estimate.dto;

import com.airconmoa.airconmoa.domain.constant.InstallationStatus;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PatchEstimateReq {
    private InstallationStatus status;
    private Long fee;
    private LocalDateTime installationDt;
    private String extraComment;
}
