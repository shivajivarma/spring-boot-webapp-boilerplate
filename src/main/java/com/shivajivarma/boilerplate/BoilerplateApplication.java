package com.shivajivarma.boilerplate;

import com.shivajivarma.boilerplate.user.model.User;
import com.shivajivarma.boilerplate.user.service.AppUserService;
import com.shivajivarma.boilerplate.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.InputStream;

@SpringBootApplication
public class BoilerplateApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BoilerplateApplication.class, args);
    }

    @Autowired
    AppUserService appUserService;

    @Override
    public void run(String... args) throws Exception {
        Resource resource = new ClassPathResource("humans.txt");
        InputStream resourceInputStream = resource.getInputStream();
        System.out.println(IOUtils.getStringFromInputStream(resourceInputStream));


        User admin = appUserService.loadUserByUsername("admin");
        if (admin == null) {
            System.out.println("creating admin -->");
            admin = new User();
            admin.setUsername("admin");
            admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
            admin.setAuthorities("ROLE_ADMIN");
            appUserService.post(admin);
        }

        User user = appUserService.loadUserByUsername("user");
        if (user == null) {
            System.out.println("creating user -->");
            user = new User();
            user.setUsername("user");
            user.setPassword(new BCryptPasswordEncoder().encode("user"));
            user.setAuthorities("ROLE_USER");
            appUserService.post(user);
        }


    }
}
