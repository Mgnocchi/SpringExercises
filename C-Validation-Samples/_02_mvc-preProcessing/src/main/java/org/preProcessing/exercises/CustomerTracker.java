package org.preProcessing.exercises;

import jakarta.validation.*;

import jakarta.validation.constraints.NotNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CustomerTracker {
    private final Set<Customer> customers = ConcurrentHashMap.newKeySet();
    private static final Logger logger = LogManager.getLogger(CustomerTracker.class);

    private final Validator validator;

    public CustomerTracker() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    // uses Jakarta default validations which are compatible with these annotations
    public boolean addCustomer(@Valid @NotNull Customer customer) {
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        if (violations.size() == 0) {
            customers.add(customer);
            return true;
        } else {
            logger.info("Not tracking customer: found {} violations", violations.size());
            for (ConstraintViolation<Customer> violation: violations) {
                logger.info(violation.getMessage());
            }
            return false;
        }
    }

    public Set<Customer> getCustomers() {
        return new HashSet<>(this.customers);
    }

}
