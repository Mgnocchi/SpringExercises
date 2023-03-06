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
            Dude dudo = mapper.readValue(
                    App.class.getClassLoader().getResource("example.json"), Dude.class);
            System.out.println("dude is " + dudo.getName());
            System.out.println("\n\n");

            ComplexDude drugo = mapper.readValue(
                    App.class.getClassLoader().getResource("more-complex-example.json"), ComplexDude.class);
            System.out.println("dude " + drugo.getName() + " from " + drugo.getAddress().getCity() + " knows");
            if (drugo.getLanguages().length <= 1) {
                for (int i = 0; i < drugo.getLanguages().length; i++) {
                    System.out.println(drugo.getLanguages()[i]);
                }
            } else {
                for (int i = 0; i < drugo.getLanguages().length; i++) {
                    System.out.print(drugo.getLanguages()[i]);
                    if (i < drugo.getLanguages().length - 2) {
                        System.out.print(", ");
                    } else if (i == drugo.getLanguages().length - 2){
                        System.out.print(" and ");
                    } else {
                        System.out.println();
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
