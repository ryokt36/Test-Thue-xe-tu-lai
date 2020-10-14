package poly.pro2112.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poly.pro2112.entities.Driverlicense;

@Repository
public interface DriverlicenseRepository extends JpaRepository<Driverlicense, String> {
}
