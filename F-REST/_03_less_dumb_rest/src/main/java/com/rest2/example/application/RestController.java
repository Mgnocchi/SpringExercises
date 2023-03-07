package com.rest2.example.application;

import com.rest2.example.student.HandledStudent;
import com.rest2.example.student.Student;
import com.rest2.example.student.StudentHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    ApplicationContext context;
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/students")
    public List<Student> getSomeStudents() {
        StudentHandler handler = context.getBean("studentHandler", StudentHandler.class);
        handler.refresh(); //to remove when I add an input system
        HandledStudent current = context.getBean("handledStudent", HandledStudent.class);
        current.set("franco","franchi");
        current = context.getBean("handledStudent", HandledStudent.class);
        current.set("non fa", "ridere");
        return handler.getRegisteredCopy();
    }

    @Autowired
    public void setContext(ApplicationContext context) {
        this.context = context;
    }
}
