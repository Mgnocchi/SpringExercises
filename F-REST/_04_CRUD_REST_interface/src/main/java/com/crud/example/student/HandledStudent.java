package com.crud.example.student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class HandledStudent extends Student {
    @JsonIgnore
    StudentHandler handler;

    @Autowired
    public HandledStudent(StudentHandler handler) {
        super();
        this.handler = handler;
        handler.register(this);
    }

    public StudentHandler getHandler() {
        return handler;
    }
}
