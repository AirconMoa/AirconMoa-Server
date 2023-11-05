package com.airconmoa.airconmoa.estimate.repository;

import com.airconmoa.airconmoa.domain.Estimate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstimateRepository extends JpaRepository<Estimate, Long> {
}
