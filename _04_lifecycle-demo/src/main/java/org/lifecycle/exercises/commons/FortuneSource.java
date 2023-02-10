package org.lifecycle.exercises.commons;

import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.Random;

public class FortuneSource implements DataSource<String> {
    private RandomAccessFile reader = null;
    private final String fileSource;
    private final Random random = new Random();


    public FortuneSource(String fileSource) {
        this.fileSource = fileSource;
    }

    @Override
    public String getData() {
        try {
            reader.seek(0);

            int lines = 0;
            while (reader.readLine() != null) lines++;

            reader.seek(0);
            int randomLineNumber = random.nextInt(lines); // goes from 0 to n-1

            for (int i = 0; i < randomLineNumber; i++)
                reader.readLine();  // skip 0 to n-1 lines
            return reader.readLine();
        } catch (IOException e) {
            System.out.println("Couldn't read file " + fileSource);
            e.printStackTrace();
        }
        return null;
    }

    private void initMethod() {
        System.out.println("I'm in the init method of " + this.getClass());
        if ( reader != null ) {
            destroyMethod();
        }
        try {
            reader = new RandomAccessFile(new ClassPathResource(fileSource).getFile(),"r");
        } catch (IOException e) {
            System.out.println("couldn't access resource file " + fileSource);
            e.printStackTrace();
        }
    }

    private void destroyMethod() {
        System.out.println("I'm in the destroy method of " + this.getClass());
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println("couldn't close resource file " + fileSource);
            e.printStackTrace();
        }
    }

}
