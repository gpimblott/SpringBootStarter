package com.pimblott.samples.spring.boot.service.security;

import com.pimblott.samples.spring.boot.domain.Person;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by Gordon on 10/03/2015.
 */
public class MyUser extends User {

    private Person person;

    public MyUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public void setPerson(final Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }
}
