package org.validation.web;

import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.validation.exercises.Customer;
import org.validation.exercises.CustomerTracker;

import java.util.Set;

@Controller
public class MainController {
    private final ApplicationContext applicationContext;
    private static final Logger logger = LogManager.getLogger(CustomerTracker.class);
    public MainController(@Autowired ApplicationContext applicationContext) {
        logger.info("creating MainController and injecting application context");
        this.applicationContext = applicationContext;
    }

    @RequestMapping("/")
    public String homepage() {
        return "homepage";
    }

    @RequestMapping("/form")
    public String form(Model model) {
        logger.info("preparing and running form");
        model.addAttribute("customer", applicationContext.getBean(Customer.class));
        return "form";
    }

    @RequestMapping("/processForm")
    public String formProcessing (@Valid @ModelAttribute("customer") Customer customer,
                                  BindingResult resultOfTheValidationOperation) {
        logger.info("tracking of valid customer clients");
        if (resultOfTheValidationOperation.hasErrors()) {
            return "form";
        } else {
            applicationContext.getBean("customerTracker", CustomerTracker.class).addCustomer(customer);
            return "formSuccess";
        }
    }

    @RequestMapping("/list")
    public String listCustomers(Model model) {
        logger.info("listing customers");
        Set<Customer> customers = applicationContext.getBean("customerTracker", CustomerTracker.class).getCustomers();
        model.addAttribute("customerSet",customers);
        return "list";
    }


}
