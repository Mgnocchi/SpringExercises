package org.security.roles.example.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String showHomePage() {
        return "homepage";
    }

    @GetMapping("/users")
    public String showUsersPage() {
        return "page_users";
    }
    @GetMapping("/admins")
    public String showAdminsPage() {
        return "page_admins";
    }


}
