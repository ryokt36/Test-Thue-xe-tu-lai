package poly.pro2112.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.pro2112.entities.Hoadonchitiet;

import java.util.Optional;

public interface HoadonchitietRepository extends JpaRepository<Hoadonchitiet, Hoadonchitiet.Pk> {
    Optional<Hoadonchitiet> findByPk(Hoadonchitiet.Pk pk);
}
