package com.springpractice.SpringJpa;

import com.springpractice.SpringJpa.Dao.UserRepository;
import com.springpractice.SpringJpa.Entites.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringJpaApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringJpaApplication.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);


        User user1 = new User("Vivek", "Rohtak");

        User user2 = new User();
        user2.setName("Abhishek");
        user2.setCity("Delhi");

        User user3 = new User("Vaibhav", "Bhiwani");

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

//		save values of users in db
        List<User> afterSaveUsers = userRepository.saveAll(users);
		System.out.println("Saving users " + afterSaveUsers);


//		fetch saved users
        List<User> userList = userRepository.findAll();
        System.out.print("Saved users ");
        System.out.println(userList);

        User userUpdate = new User("Vivek", "Gurgaon");
        userUpdate.setId(1);
        userRepository.save(userUpdate);

//		update
        List<User> userListAfterUpdate = userRepository.findAll();
        System.out.println("After updating city " + userListAfterUpdate);

//		delete
        userRepository.deleteById(3);
        System.out.println("After deleting user " + userRepository.findAll());

    }

}
