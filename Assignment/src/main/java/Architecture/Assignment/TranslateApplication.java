package Architecture.Assignment;

import Architecture.Assignment.model.User;
import Architecture.Assignment.repo.RolesRepo;
import Architecture.Assignment.repo.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Role;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class TranslateApplication {

	public static void main(String[] args) {
		SpringApplication.run(TranslateApplication.class, args);
	}
//	@Bean
//	CommandLineRunner run(RolesRepo roleRepository, UserRepo userRepository, PasswordEncoder passwordEncode){
//		return args ->{
//			if(roleRepository.findByAuthority("ADMIN").isPresent()) return;
//			Role adminRole = roleRepository.save(new Role("ADMIN"));
//			roleRepository.save(new Role("USER"));
//
//			Set<Role> roles = new HashSet<>();
//			roles.add(new Role());
//
//			User admin = new User(1, "admin", passwordEncode.encode("password"), roles);
//
//			userRepository.save(admin);
//		};
//	}
}
