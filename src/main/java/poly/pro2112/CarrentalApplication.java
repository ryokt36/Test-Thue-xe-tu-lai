package poly.pro2112;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CarrentalApplication {
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
