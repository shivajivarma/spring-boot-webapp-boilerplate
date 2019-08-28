package com.shivajivarma.boilerplate.sample;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * All the  'api' urls are protect should 'WebSecurityConfiguration'
 */
@RestController
@RequestMapping("api/sample")
public class ApiController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getDaHoney() {
        return ResponseEntity.ok("{\"success\":true}");
    }

    @RequestMapping(value = "admin", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<?> getAdmin() {
        return ResponseEntity.ok("{\"success\":true}");
    }

    @RequestMapping(value = "user", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public ResponseEntity<?> getUser() {
        return ResponseEntity.ok("{\"success\":true}");
    }

}

