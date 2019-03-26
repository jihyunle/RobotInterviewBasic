/* Let's add some accounts so that we can log in! */

/* It was possiblt to have both DataLoader class and PostConstruct */

package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String...strings) throws Exception{

        // adding roles
        roleRepository.save(new Role("APPLICANT"));
        roleRepository.save(new Role("EMPLOYER"));

        Role applicantRole = roleRepository.findByRole("APPLICANT");
        Role employerRole = roleRepository.findByRole("EMPLOYER");

        // adding users
        User user = new User("jim@jim.com", "password", "Jim",
                "Jimmerson", true, "jim",
                "123-456-7890", "03/22/19 10:30", "submitted");
        user.setUserpicture("https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50?s=80");
        user.setRoles(Arrays.asList(applicantRole));
        userRepository.save(user);

        user = new User("sam@sammy.com", "password", "Sam",
                "Sammy", true, "sam",
                "703-456-7890", "03/21/19 16:15", "pending interview");
        user.setRoles(Arrays.asList(applicantRole));
        userRepository.save(user);


    }
}
