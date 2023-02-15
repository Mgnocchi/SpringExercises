package org.mvc.controllerdemo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("/processForm")
    public String processForm(HttpServletRequest request, Model model) {
        final String studentName = request.getParameter("studentName");
        final String goodName = studentName.toLowerCase().charAt(0) + studentName.toLowerCase().substring(1);
        model.addAttribute("message", "hello " + goodName);
        return "formSuccess";
    }

    @RequestMapping("/altProcessForm")
    public String processForm2(@RequestParam("studentName") String studentName, Model model) {
        final String goodName = studentName.toLowerCase().charAt(0) + studentName.toLowerCase().substring(1);
        model.addAttribute("message", "hello " + goodName);
        return "formSuccess";
    }

}
