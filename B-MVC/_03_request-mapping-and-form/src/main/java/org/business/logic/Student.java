package org.business.logic;

public class Student implements Comparable<Student>{
    private String Name;
    private String Surname;

    private String Country;

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = namify(name);
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = namify(surname);
    }

    @Override
    public int compareTo(Student o) {
        int surnameCompare = this.getSurname().compareTo(o.getSurname());
        if (surnameCompare == 0) {
            return this.getName().compareTo(o.getName());
        } else {
            return surnameCompare;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student other = (Student) o;
        return this.getName().equals(other.getName())
                && this.getSurname().equals(other.getSurname());
    }

    private static String namify(String string) {
        String noSpaces = string.trim();
        return Character.toUpperCase(noSpaces.charAt(0)) + noSpaces.substring(1).toLowerCase();
    }
}
