package Architecture.Assignment;

import Architecture.Assignment.model.User;
import Architecture.Assignment.model.UserRole;
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

	//Command line runner to initialize attribute such as roles, and add 1 admin user into the database.
	@Bean
	CommandLineRunner run(RolesRepo rolesRepo, UserRepo userRepo ){
		return args ->{
			//Add Admin role
			if(rolesRepo.findByAuthority("ADMIN").isPresent()) return;
			UserRole adminRole = rolesRepo.save(new UserRole("ADMIN"));
			rolesRepo.save(new UserRole("USER"));

			Set<UserRole> roles = new HashSet<>();
			roles.add(adminRole);

			User admin = new User(0, "admin", "password", roles);
			userRepo.save(admin);
		};
	}


}
