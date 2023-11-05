package com.airconmoa.airconmoa.estimate.service;

import com.airconmoa.airconmoa.company.service.CompanyService;
import com.airconmoa.airconmoa.domain.Company;
import com.airconmoa.airconmoa.domain.Estimate;
import com.airconmoa.airconmoa.estimate.dto.*;
import com.airconmoa.airconmoa.estimate.repository.EstimateRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstimateService {
    private final EstimateRepository estimateRepository;
    private final CompanyService companyService;
}
