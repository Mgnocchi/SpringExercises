package com.rest2.example.student;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentHandler {

    List<Student> registered = new ArrayList<>();

    public List<Student> getRegisteredCopy(boolean deep) {
        if (!deep) {
            return new ArrayList<>(registered);
        } else {
            List<Student> copy = new ArrayList<>();
            for (Student student:
                    registered) {
                copy.add(new Student(student.getName(), student.getSurname()));
            }
            return copy;
        }
    }

    public List<Student> getRegisteredCopy() {
        return getRegisteredCopy(false);
    }

    public boolean register(Student student) {
        if (student instanceof HandledStudent) {
            return this.registered.add(student);
        } else {
            return this.registered.add(new HandledStudent(student.getName(), student.getSurname(), this, true));
        }
    }

    public boolean register(String name, String surname) {
        return this.register(new HandledStudent(name,surname,this, true));
    }

    public boolean register(Student[] students) {
        boolean allSuccess = true;
        for (Student student :
                students) {
            boolean success = this.register(student);
            if (!success) allSuccess = false;
        }
        return allSuccess;
    }

    public List<Student> refresh() {
        List<Student> old = this.registered;
        this.registered = new ArrayList<>();
        return old;
    }


}
