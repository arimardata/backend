package com.pfproject.api.controller;

import org.springframework.http.HttpStatus;
import com.pfproject.api.dto.MessageDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class SecuredController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> sayHello() {
        final MessageDTO response = new MessageDTO();
        response.setMessage("Secured hello!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
