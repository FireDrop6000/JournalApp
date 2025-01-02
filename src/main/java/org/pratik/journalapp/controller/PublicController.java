package org.pratik.journalapp.controller;

import org.pratik.journalapp.entity.User;
import org.pratik.journalapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    private UserService userService;

    @GetMapping("/health")
    public String healthCheck() {
        return ("OK");
    }

    @PostMapping("/create")
    public ResponseEntity<?> enterUser(@RequestBody User user) {
        User entered = userService.saveNewUser(user);
        if (entered != null) {
            return new ResponseEntity<>(entered, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
