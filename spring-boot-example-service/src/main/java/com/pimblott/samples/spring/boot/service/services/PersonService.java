package com.pimblott.samples.spring.boot.service.services;

import com.pimblott.samples.spring.boot.domain.Person;
import com.pimblott.samples.spring.boot.service.security.FakeUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gordon on 17/05/2015.
 */
@RestController
public class PersonService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    FakeUserDetailsService userDetails;

    @RequestMapping(value = "/person/{username}", method = RequestMethod.GET)
    @PostAuthorize("(returnObject != null and returnObject.username == principal.username) or hasRole('ROLE_ADMIN')")
    public Person getPersonByUsername(@PathVariable String username) {
        LOGGER.info("Getting person by username : " + username);
        return userDetails.getPerson(username);
    }

}
