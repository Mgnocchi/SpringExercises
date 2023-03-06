package org.exercises;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Dude dudo = mapper.readValue(App.class.getClassLoader().getResource("example.json"), Dude.class);
            System.out.println("dude is " + dudo.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
