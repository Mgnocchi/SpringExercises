package org.mvc.controllerdemo;


import org.business.logic.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    /* any method returning a string can be used as a Controller method. Any amount of arguments can be used.
     * here we map the method to the root address
     */
    @RequestMapping("/")
    public String showHomePage() {
        // view name to return (with the prefix and suffix specified in the MVC view resolver bean)
        return "homepage";
    }

    @RequestMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("Student") Student student, Model model) {
        model.addAttribute("message","hello " + student.getName() + " " + student.getSurname());
        return "formSuccess";
    }

}
