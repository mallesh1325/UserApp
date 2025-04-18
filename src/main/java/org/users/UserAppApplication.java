package org.users;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.Key;
import java.util.Base64;

@SpringBootApplication
public class UserAppApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(UserAppApplication.class, args);

        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // Generates a secure random key
        String base64Key = Base64.getEncoder().encodeToString(key.getEncoded());

        System.out.println(base64Key);

    }


}


