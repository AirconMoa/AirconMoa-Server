package com.airconmoa.airconmoa.domain.constant;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum InstallationStatus {
    REQUESTED("요청됨"),
    ACCEPTED("승낙됨"),
    PENDING("대기중"),
    PROCESSING("진행중"),
    ;
    private String value;
}
