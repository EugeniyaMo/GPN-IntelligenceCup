package ru.task.gpnintelligencecup.models;

public class User {
    private String lastName;
    private String firstName;
    private boolean isMember;

    public User(String lastName, String firstName, boolean isMember) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.isMember = isMember;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public boolean isMember() {
        return isMember;
    }
}
