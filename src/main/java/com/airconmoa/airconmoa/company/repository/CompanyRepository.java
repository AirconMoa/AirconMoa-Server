package com.airconmoa.airconmoa.company.repository;

import com.airconmoa.airconmoa.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
