package poly.pro2112.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poly.pro2112.entities.Register;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Integer> {
}
