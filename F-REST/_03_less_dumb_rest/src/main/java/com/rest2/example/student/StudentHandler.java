package com.rest2.example.student;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentHandler implements ApplicationContextAware {

    List<Student> registered = new ArrayList<>();

    ApplicationContext context;

    public boolean register(Student student) {
        if (student instanceof HandledStudent) {
            return this.registered.add(student);
        } else {
            HandledStudent handledStudent = this.context.getBean("handledStudent", HandledStudent.class);
            this.registered.add(handledStudent);
            handledStudent.setName(student.getName());
            handledStudent.setSurname(student.getSurname());
            return true;
        }
    }

    @Autowired
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public List<Student> getRegisteredCopy() {
        return this.getRegisteredCopy(false);
    }

    public List<Student> getRegisteredCopy(boolean deep) {
        List<Student> copy = new ArrayList<>();
        if (deep) {
            for (Student student : this.registered) {
                Student Student = context.getBean("student", Student.class);
                Student.set(student.getName(),student.getSurname());
                copy.add(student);
            }
            return copy;
        } else {
            return new ArrayList<>(this.registered);
        }
    }

    public List<Student> refresh() {
        List<Student> old = this.registered;
        this.registered = new ArrayList<>();
        return old;
    }


}
