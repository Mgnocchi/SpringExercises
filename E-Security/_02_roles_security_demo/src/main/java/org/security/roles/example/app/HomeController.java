package org.security.roles.example.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/index")
    public String showHomePage() {
        return "homepage";
    }

    @RequestMapping("/users")
    public String showUsersPage() {
        return "page_users";
    }
    @RequestMapping("/admins")
    public String showAdminsPage() {
        return "page_admins";
    }


}
