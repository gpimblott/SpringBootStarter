package com.pimblott.samples.spring.boot.domain;

/**
 * Created by gordon on 17/05/2015.
 */
public class Person {

    private String firstname;
    private String surname;
    private String username;

    public Person(String username , String firstname , String surname) {
        setUsername(username);
        setFirstname(firstname);
        setSurname(surname);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
