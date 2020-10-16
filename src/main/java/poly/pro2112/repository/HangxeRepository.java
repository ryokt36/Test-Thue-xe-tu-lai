package poly.pro2112.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.pro2112.entities.Hangxe;

import java.util.Optional;

public interface HangxeRepository extends JpaRepository<Hangxe, Integer> {
    Boolean existsHangxeByTenhang(String tenhang);
}
