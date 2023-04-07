package com.libbioproject;

import com.libbioproject.domain.Role;
import com.libbioproject.domain.User;
import com.libbioproject.domain.enums.RoleType;
import com.libbioproject.repository.RoleRepository;
import com.libbioproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;

@SpringBootApplication
public class LibbioProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(LibbioProjectApplication.class, args);
    }

}

//@Component
//@AllArgsConstructor
//class DemoCommandLineRunner implements CommandLineRunner {
//
//    RoleRepository roleRepository;
//
//    PasswordEncoder passwordEncoder;
//
//    UserRepository userRepository;
//
//    @Override
//    public void run(String... args) throws Exception { // this method will run before app and check if db is empty and add roles
//        // if so.
//
//        if (!roleRepository.findByType(RoleType.ROLE_CUSTOMER).isPresent()) {
//            Role roleCustomer = new Role();
//            roleCustomer.setType(RoleType.ROLE_CUSTOMER);
//            roleRepository.save(roleCustomer);
//        }
//
//        if (!roleRepository.findByType(RoleType.ROLE_ADMIN).isPresent()) {
//            Role roleAdmin = new Role();
//            roleAdmin.setType(RoleType.ROLE_ADMIN);
//            roleRepository.save(roleAdmin);
//        }
//
//        if (!roleRepository.findByType(RoleType.ROLE_LIBRARY_OWNER).isPresent()) {
//            Role roleLibraryOwner = new Role();
//            roleLibraryOwner.setType(RoleType.ROLE_LIBRARY_OWNER);
//            roleRepository.save(roleLibraryOwner);
//        }
//
//        //To add Super-User
//        if (!userRepository.findByEmail("superadmin@gmail.com").isPresent()) {
//            User admin = new User();
//            Role role = roleRepository.findByType(RoleType.ROLE_ADMIN).get();
//            admin.setRoles(new HashSet<>(Collections.singletonList(role)));
//            admin.setAddress("super user address");
//            admin.setEmail("superadmin@gmail.com");
//            admin.setFirstName("superadminfirstname");
//            admin.setLastName("superadminlastname");
//            admin.setBuiltIn(true);
//            admin.setZipCode("123456");
//            admin.setPassword(passwordEncoder.encode("Ankara06"));
//            admin.setPhoneNumber("(541) 317-8828");
//            userRepository.save(admin);
//        }
//
//        if (!userRepository.findByEmail("supercustomer@gmail.com").isPresent()) {
//            User customer = new User();
//            Role role = roleRepository.findByType(RoleType.ROLE_CUSTOMER).get();
//            customer.setRoles(new HashSet<>(Collections.singletonList(role)));
//            customer.setAddress("super customer address");
//            customer.setEmail("supercustomer@gmail.com");
//            customer.setFirstName("supercustomerfirstname");
//            customer.setLastName("supercustomerlastname");
//            customer.setBuiltIn(true);
//            customer.setZipCode("987654");
//            customer.setPassword(passwordEncoder.encode("Ankara06"));
//            customer.setPhoneNumber("(541) 317-8828");
//            userRepository.save(customer);
//
//        }
//
//        if (!userRepository.findByEmail("superlibraryowner@gmail.com").isPresent()) {
//            User libraryowner = new User();
//            Role role = roleRepository.findByType(RoleType.ROLE_LIBRARY_OWNER).get();
//            libraryowner.setRoles(new HashSet<>(Collections.singletonList(role)));
//            libraryowner.setAddress("super library owner address");
//            libraryowner.setEmail("superlibraryowner@gmail.com");
//            libraryowner.setFirstName("superlibraryownerfirstname");
//            libraryowner.setLastName("superlibraryownerlastname");
//            libraryowner.setBuiltIn(true);
//            libraryowner.setZipCode("987654");
//            libraryowner.setPassword(passwordEncoder.encode("Ankara06"));
//            libraryowner.setPhoneNumber("(541) 317-8828");
//            userRepository.save(libraryowner);
//
//        }
//    }
//}
