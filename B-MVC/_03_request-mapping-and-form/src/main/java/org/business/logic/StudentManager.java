package org.business.logic;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class StudentManager {
    private final List<Student> registeredStudents = new ArrayList<>();

    public List<Student> getRegisteredStudents() {
        registeredStudents.sort(Comparator.naturalOrder());
        return registeredStudents;
    }

    public void addStudent(Student student) {
        this.registeredStudents.add(student);
    }


}
