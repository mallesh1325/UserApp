package org.users.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.users.dto.AuthRequestDto;
import org.users.dto.AuthResponceDto;
import org.users.services.UserService;
import org.users.utills.JwtUtills;

@RestController
@RequestMapping("user/")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtills utills;

    @PostMapping("register/")
    public ResponseEntity<?> register(@RequestBody AuthRequestDto authRequestDto) {
        userService.register(authRequestDto);
        return ResponseEntity.ok("User Register Successfully");
    }

    @PostMapping("login/")
    public ResponseEntity<AuthResponceDto> login(@RequestBody AuthRequestDto request) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = utills.generateToken(request.getUsername());
        return ResponseEntity.ok(new AuthResponceDto(token));
    }

    // @PreAuthorize("hasRole(ADMIN)")
   /* @DeleteMapping("delete/{id}")
    public String deleteUserbyId(@PathVariable Integer id) {
        if (id == null || id <= 0) {
            return " Provided " + id + "not existed ";
        }

        return userService.deleteUserById(id);

    }*/
}
