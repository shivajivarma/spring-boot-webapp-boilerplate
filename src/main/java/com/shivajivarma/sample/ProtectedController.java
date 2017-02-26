package com.shivajivarma.sample;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("protected")
public class ProtectedController {

    /**
     * Explicitly you can authorize individual methods, apart from 'WebSecurityConfiguration'
     */
    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<?> getDaHoney() {
        return ResponseEntity.ok("{\"success\":true}");
    }


}
