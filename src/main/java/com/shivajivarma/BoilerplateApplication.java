package com.shivajivarma;

import com.shivajivarma.user.model.User;
import com.shivajivarma.user.service.AppUserService;
import com.shivajivarma.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

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
        if(admin == null){
            System.out.println("creating admin -->");
            admin = new User();
            admin.setUsername("admin");
            admin.setPassword("admin");
            admin.setAuthorities("ROLE_ADMIN");
            appUserService.post(admin);
        }

        User user = appUserService.loadUserByUsername("user");
        if(user == null){
            System.out.println("creating user -->");
            user = new User();
            user.setUsername("user");
            user.setPassword("user");
            user.setAuthorities("ROLE_USER");
            appUserService.post(user);
        }


    }
}
