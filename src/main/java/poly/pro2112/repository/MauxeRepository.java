package poly.pro2112.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.pro2112.entities.Hangxe;
import poly.pro2112.entities.Mauxe;

import java.util.Optional;

public interface MauxeRepository extends JpaRepository<Mauxe, Integer> {
    Boolean existsMauxeByTenmau(String tenmau);
}
