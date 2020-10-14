package poly.pro2112;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;
import poly.pro2112.entities.Administrator;
import poly.pro2112.repository.AdministratorRepository;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class CarrentalApplication {
    @Autowired
    AdministratorRepository administratorRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

//    @PostConstruct
//    public void initUser(){
//        Administrator admin = new Administrator();
//        admin.setUsername("admin");
//        admin.setPassword(passwordEncoder.encode("admin"));
//        administratorRepository.save(admin);
//    }
    public static void main(String[] args) {
        SpringApplication.run(CarrentalApplication.class, args);
    }

}
