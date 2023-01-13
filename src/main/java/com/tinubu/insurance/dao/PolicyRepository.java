package com.tinubu.insurance.dao;

import com.tinubu.insurance.domain.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/***
 * Policy repository
 */
@Repository
public interface PolicyRepository extends JpaRepository<Policy, Integer> {
}
