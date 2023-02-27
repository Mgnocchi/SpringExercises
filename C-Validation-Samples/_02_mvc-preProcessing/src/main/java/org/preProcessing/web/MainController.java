package org.preProcessing.web;

import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.preProcessing.exercises.Customer;
import org.preProcessing.exercises.CustomerTracker;

import java.beans.PropertyEditorSupport;
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

    // this method will pre-process ALL web request coming into this controller because of the annotation:
    // it is possible to add "(value = "field")" so that only requests for field are processed
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true)); //almost always useful! Removes spaces that are not needed.
        dataBinder.registerCustomEditor(String.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                if (text != null) {
                    super.setValue(""); // when the conversion happens it forces a check for the old value (which is null if no default is forced) and a hidden type check makes sure
                                        // that "setAsText" doesn't give an exception only when the old value is also a string. null is not instanceOf String
                    super.setAsText(text + " processed");
                }
                else {
                    super.setAsText(null);
                }
            }
        });
    }

    /* here it would need something like:
    InitBinder(value = "customer")
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(String.class, new PropertyEditorSupport() {

            @Override
            public void setValue(Object value) {
                // some code that turn value into a customer object and does preprocessing on it.
                super.setValue(customer)
            }

        });
    }
    */

}
