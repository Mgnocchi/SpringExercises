package com.rest2.example.student;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class HandledStudent extends Student {
    StudentHandler handler;
    boolean registered = false;

    public HandledStudent(String name, String surname, StudentHandler handler) {
        this(name,surname,handler, false);
    }
    // package private, to use from StudentHandler
    HandledStudent(String name, String surname, StudentHandler handler, boolean registered) {
        super(name, surname);
        this.handler = handler;
        this.registered = registered;
        if (!this.registered) {
            handler.register(this);
        }
    }

    @JsonIgnore
    public StudentHandler getHandler() {
        return handler;
    }
}
