package org.epcorps.usuarioservice.controller;

import org.epcorps.usuarioservice.persistence.entities.UserEntity;
import org.epcorps.usuarioservice.persistence.models.dtos.LoginDto;
import org.epcorps.usuarioservice.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity userEntity) {
        return ResponseEntity.ok(userService.userRegister(userEntity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/login")
    public ResponseEntity<UserEntity> login(@RequestBody LoginDto loginDto) {
        return ResponseEntity.ok(userService.loginUser(loginDto));
    }
}
