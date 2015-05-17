package com.pimblott.samples.spring.boot.service.security;


import com.pimblott.samples.spring.boot.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class FakeUserDetailsService implements UserDetailsService {

    private Map<String , Person> fakeUsers = new HashMap<String, Person>();

    private static final Logger LOGGER = LoggerFactory.getLogger(FakeUserDetailsService.class);

    public FakeUserDetailsService() {
        fakeUsers.put( "user1" , new Person( "user1" , "Adam" , "Smith" ));
    }

    /**
     * Simple static lookup for users - The password for all users is password
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info("Loading : " + username);

        Person person = fakeUsers.get(username);

        if (person == null) {
            LOGGER.info("Username " + username + " NOT found");
            throw new UsernameNotFoundException("Username " + username + " not found");
        }
        LOGGER.info(person.toString());
        MyUser user = new MyUser(username, "password", getGrantedAuthorities(username));
        user.setPerson(person);
        return user;
    }

    public Person getPerson(String username) throws UsernameNotFoundException {
        Person person = fakeUsers.get(username);

        if (person == null) {
            LOGGER.info("Username " + username + " NOT found");
            throw new UsernameNotFoundException("Username " + username + " not found");
        }
        return person;
    }

    /**
     *
     * @param username
     * @return
     */
    private Collection<? extends GrantedAuthority> getGrantedAuthorities(String username) {
        Collection<SimpleGrantedAuthority> authorities;
        if (username.equals("admin")) {
            authorities = new ArrayList<SimpleGrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            authorities.add(new SimpleGrantedAuthority("ROLE_BASIC"));
        } else {
            authorities = new ArrayList<SimpleGrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_BASIC"));
        }
        return authorities;
    }
}
