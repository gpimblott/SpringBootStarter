package com.pimblott.samples.spring.boot.service.services;

import com.pimblott.samples.spring.boot.domain.Person;
import com.pimblott.samples.spring.boot.service.security.FakeUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * REST controller to retrieve <code>Person</code> information
 */
@RestController
public class PersonService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    FakeUserDetailsService userDetails;

    /**
     * REST method to retrieve individual person records.  The method is protected using Spring Security.
     *
     * A user can only retrieve their own record based on the username matching the authenticated user
     * or the user has the ADMIN role.
     *
     * @param username Username parameter from the REST url
     * @return The <code>Person</code> object for the username
     */
    @RequestMapping(value = "/person/{username}", method = RequestMethod.GET)
    @PostAuthorize("(returnObject != null and returnObject.username == principal.username) or hasRole('ROLE_ADMIN')")
    public Person getPersonByUsername(@PathVariable String username) {
        LOGGER.info("Getting person by username : " + username);
        return userDetails.getPerson(username);
    }

    /**
     * Admin users can list all users
     * @return A collection of all users
     */
    @RequestMapping(value = "/person/", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Collection<Person> list(){
        return userDetails.list();
    }

}
