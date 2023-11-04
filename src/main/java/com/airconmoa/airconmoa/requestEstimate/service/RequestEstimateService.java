package com.airconmoa.airconmoa.requestEstimate.service;

import com.airconmoa.airconmoa.domain.RequestEstimate;
import com.airconmoa.airconmoa.requestEstimate.repository.RequestEstimateRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestEstimateService {
    private final RequestEstimateRepository requestEstimateRepository;

    @Autowired
    public RequestEstimateService(RequestEstimateRepository requestEstimateRepository) {
        this.requestEstimateRepository = requestEstimateRepository;
    }

    @Transactional
    public RequestEstimate createRequestEstimate(RequestEstimate requestEstimate) {
        return requestEstimateRepository.save(requestEstimate);
    }
}
