package poly.pro2112.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poly.pro2112.entities.Administrator;

import java.util.Optional;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {
    Optional<Administrator> findByUsername(String username);
    Boolean existsAdministratorByUsername(String username);
    Boolean existsAdministratorByEmail(String email);
}
