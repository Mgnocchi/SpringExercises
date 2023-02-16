package org.mvc.controllerdemo;


import org.business.logic.Student;
import org.business.logic.StudentManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    StudentManager studentManager;

    public HomeController(StudentManager studentManager) {
        this.studentManager = studentManager;
    }

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
    public String processForm(@ModelAttribute("Student") Student student) {
        String letterPattern = "[A-Za-z]*";
        if (student.getName().matches(letterPattern) && student.getSurname().matches(letterPattern)) {
            studentManager.addStudent(student);
            return "formSuccess";
        } else {
            return "formFailure";
        }
    }

    @RequestMapping("/list")
    public String listStudents(Model model) {
        model.addAttribute("studentsList", studentManager.getRegisteredStudents());
        return "list";
    }

}
