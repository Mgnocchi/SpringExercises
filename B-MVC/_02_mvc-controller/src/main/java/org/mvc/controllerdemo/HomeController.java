package org.mvc.controllerdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    /* any method returning a string can be used as a Controller method. Any amount of arguments can be used.
     * here we map the method to the root adress
     */
    @RequestMapping("/")
    public String showHomePage() {
        // view name to return (with the prefix and suffix specified in the MVC view resolver bean)
        return "homepage";
    }

    @RequestMapping("/form")
    public String showForm() {
        return "form";
    }

    @RequestMapping("/formSuccess")
    public String showFormSuccess() {
        return "formSuccess";
    }
}
