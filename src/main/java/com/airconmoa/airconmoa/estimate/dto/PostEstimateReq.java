package com.airconmoa.airconmoa.estimate.dto;


import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostEstimateReq {
    private Long fee;
    private LocalDateTime installationDt;
    private String extraComment;
    private Long companyId;
}
