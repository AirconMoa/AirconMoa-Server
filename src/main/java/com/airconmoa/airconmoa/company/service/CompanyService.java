package com.airconmoa.airconmoa.company.service;

import com.airconmoa.airconmoa.company.repository.CompanyRepository;
import com.airconmoa.airconmoa.domain.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    /**
     * Company 엔티티 반환 메서드
     * @param companyId
     * @return Company
     */
    public Company getCompanyById(Long companyId) {
        return companyRepository.findById(companyId)
                .orElseThrow(() -> new IllegalArgumentException("No such company"));
    }
}
