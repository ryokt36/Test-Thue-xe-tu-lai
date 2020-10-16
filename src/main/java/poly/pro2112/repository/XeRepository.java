package poly.pro2112.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.pro2112.entities.Xe;

import java.util.Optional;

public interface XeRepository extends JpaRepository<Xe, Integer> {
    Boolean existsXeByBiensoxe(String biensoxe);
    Boolean existsXeBySokhung(String sokhung);
}
