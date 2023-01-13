package com.tinubu.insurance;

import com.tinubu.insurance.domain.Policy;
import com.tinubu.insurance.service.PolicyService;
import jdk.jfr.Registered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * Insurance controller to manage policies data
 */
@RestController
@RequestMapping("/api/v1/policy")
public class InsurancePolicyController {

    @Autowired
    PolicyService policyService;

    /***
     * Post method to add new policy
     * @param policy The policy to add
     */
    @PostMapping("/new")
    public void newPolicy(@RequestBody Policy policy) {
        policyService.newPolicy(policy);
    }

    /***
     * Get method to find Policy by th given id
     * @param id Id of Policy
     * @return Policy if exist
     */
    @GetMapping("/{policyId}")
    public Policy getPolicy(@PathVariable("policyId") Integer id) {
        return policyService.getPolicy(id);
    }

    /***
     * Get method to find all Policies
     * @return List of policies
     */
    @GetMapping
    public List<Policy> getPolicies() {
        return policyService.getPolicies();
    }

    /***
     * Put method to update data of the given policy
     * @param id Id of Policy
     * @param name Name of Policy
     */
    @PutMapping("{policyId}")
    public void updatePolicy(@PathVariable("policyId") Integer id,
                             @RequestParam(required = false) String name) {
        policyService.updatePolicy(id, name);
    }
}
