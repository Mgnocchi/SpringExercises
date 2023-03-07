package com.rest2.example.application;

import com.rest2.example.errors.ResourceNotFoundException;
import com.rest2.example.student.HandledStudent;
import com.rest2.example.student.Student;
import com.rest2.example.student.StudentHandler;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        return handler.getRegisteredCopy();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        try {
            StudentHandler handler = context.getBean("studentHandler", StudentHandler.class);
            return handler.getRegisteredCopy().get(studentId);
        } catch (IndexOutOfBoundsException e) {
            throw new ResourceNotFoundException("No Student with index " + studentId + " exists");
        }
    }

    @Autowired
    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    // SERVICE METHODS -------------------------------------------------------------------------------------------------
    @PostConstruct
    private void initTestStudents() {
        StudentHandler handler = context.getBean("studentHandler", StudentHandler.class);
        handler.refresh(); //to remove when I add an input system
        HandledStudent current = context.getBean("handledStudent", HandledStudent.class);
        current.set("franco","franchi");
        current = context.getBean("handledStudent", HandledStudent.class);
        current.set("non fa", "ridere");
        current = context.getBean("handledStudent", HandledStudent.class);
        current.set("Terzo", "Terzi");
    }
}
