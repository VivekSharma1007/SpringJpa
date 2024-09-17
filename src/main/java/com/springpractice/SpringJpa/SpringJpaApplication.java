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


		 User user1 = new User(1, "Vivek", "Rohtak");
//		 User afterSaveUser1 = userRepository.save(user1);
//		 System.out.println(afterSaveUser1);

		 User user2 = new User();
		 user2.setName("Abhishek");
		 user2.setCity("Delhi");

		 User user3 = new User(4, "Vaibhav", "Bhiwani");

		 List<User> users = new ArrayList<>();
		 users.add(user1); users.add(user2); users.add(user3);

		 List afterSaveUsers = userRepository.saveAll(users);

		 afterSaveUsers.forEach(user -> System.out.println(user));

	}

}
