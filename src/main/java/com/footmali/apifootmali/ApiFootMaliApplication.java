package com.footmali.apifootmali;

import com.footmali.apifootmali.entity.UserEntity;
import com.footmali.apifootmali.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ApiFootMaliApplication implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(ApiFootMaliApplication.class, args);
    }

    @Override
    public void run(String... args) {
        UserEntity user = new UserEntity();
        user.setEmail("a@a.com");
        user.setNom("Dembele");
        user.setPrenom("Mamadou");

        UserEntity user1 = new UserEntity();
        user1.setEmail("b@b.com");
        user1.setNom("Diarra");
        user1.setPrenom("Lamine");

        userRepository.saveAllAndFlush(List.of(user, user1));
    }
}
