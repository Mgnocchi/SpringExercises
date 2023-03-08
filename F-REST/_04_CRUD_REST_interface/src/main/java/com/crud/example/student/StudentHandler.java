package com.crud.example.student;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class StudentHandler implements ApplicationContextAware {

    Map<Integer,Student> registered = new HashMap<>();

    int lastId = -1;

    ApplicationContext context;

    public int register(Student student) {
        int index;
        if (student instanceof HandledStudent) {
            index = generateId();
            this.registered.put(index, student);
        } else {
            HandledStudent handledStudent = this.context.getBean("handledStudent", HandledStudent.class);
            handledStudent.setName(student.getName());
            handledStudent.setSurname(student.getSurname());
            index = generateId();
            this.registered.put(index, handledStudent);
        }
        return index;
    }

    @Autowired
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public Map<Integer, Student> getRegisteredCopy() {
        return this.getRegisteredCopy(false);
    }

    public Map<Integer, Student> getRegisteredCopy(boolean deep) {
        Map<Integer,Student> copy = new HashMap<>();
        if (deep) {
            for (int index : this.registered.keySet()) {
                Student student = context.getBean("student", Student.class);
                student.set(
                        this.registered.get(index).getName(),
                        this.registered.get(index).getSurname());
                copy.put(index, student);
            }
            return copy;
        } else {
            return new HashMap<>(this.registered);
        }
    }

    public Map<Integer,Student> refresh() {
        Map<Integer,Student> old = this.registered;
        this.registered = new HashMap<>();
        lastId = -1;
        return old;
    }

    private int generateId() {
        if (lastId < 0) {
            lastId = 0;
        }
        int safetyValve = 0;
        while (registered.containsKey(lastId)) {
            safetyValve++;
            lastId++;
            if (safetyValve == Integer.MAX_VALUE) throw new RuntimeException("Failed to find a free StudentId... chill");
        }
        return lastId;
    }

}
