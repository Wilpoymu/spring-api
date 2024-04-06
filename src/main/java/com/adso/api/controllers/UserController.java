package com.adso.api.controllers;

import com.adso.api.models.User;
import com.adso.api.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jadso")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public ResponseEntity<Object> get() {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<User> list = userService.findAll();
            return new ResponseEntity<Object>(list, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value = "/users/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        try {
            User data = userService.findById(id);
            return new ResponseEntity<Object>(data, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/users")
    public ResponseEntity<Object> create(@RequestBody User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            User res = userService.save(user);
            return new ResponseEntity<Object>(res, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/users/{id}")
    public ResponseEntity<Object> update(@RequestBody User user, @PathVariable Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            User existingUser = userService.findById(id);
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setCellphone(user.getCellphone());
            User res = userService.save(user);
            return new ResponseEntity<Object>(res, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            User existingUser = userService.findById(id);
            userService.delete(existingUser);
            map.put("deleted", true);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
