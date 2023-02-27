package org.validation.exercises;

import jakarta.validation.constraints.NotBlank;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Customer {
    private String name;
    @NotBlank(message = "Surname field is mandatory")
    private String surname;

    private static final Logger logger = LogManager.getLogger(Customer.class);
    public Customer() {
        logger.info("created Customer bean");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}


