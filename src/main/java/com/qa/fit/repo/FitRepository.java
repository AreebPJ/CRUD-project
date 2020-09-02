package com.qa.fit.repo;

import com.qa.fit.domain.Fit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FitRepository extends JpaRepository<Fit, Long> {
}
