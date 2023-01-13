package com.tinubu.insurance.service;

import com.tinubu.insurance.dao.PolicyRepository;
import com.tinubu.insurance.domain.Policy;
import com.tinubu.insurance.reference.PolicyStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/***
 * Policy service
 */
@Service
public class PolicyService {
    private PolicyRepository policyRepository;

    public PolicyService(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    /***
     * Add new policy
     * @param policy The policy to add
     */
    public void newPolicy(Policy policy) {
        policy.setStatus(policy.getStartDate().isBefore(LocalDateTime.now())
                && policy.getEndDate().isAfter(LocalDateTime.now()) ? PolicyStatus.ACTIVE : PolicyStatus.INACTIVE);
        policy.setCreatedAt(LocalDateTime.now());
        policy.setUpdatedAt(LocalDateTime.now());
        policyRepository.save(policy);
    }

    /***
     * Find Policy by th given id
     * @param id Id of Policy
     * @return Policy if exist
     */
    public Policy getPolicy(Integer id) {
        return policyRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "Policy with id " + id + " does not exists"));
    }

    /***
     * Get all Policies
     * @return List of policies
     */
    public List<Policy> getPolicies() {
        return policyRepository.findAll();
    }

    /***
     * Update data of the given policy
     * @param id Id of Policy
     * @param name Name of Policy
     */
    @Transactional
    public void updatePolicy(Integer id, String name) {
        Policy policy = policyRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "Policy with id " + id + " does not exists"));
        if (name != null && name.length() > 0 && !Objects.equals(policy.getName(), name)) {
            policy.setName(name);
            policy.setUpdatedAt(LocalDateTime.now());
        }
    }
}
