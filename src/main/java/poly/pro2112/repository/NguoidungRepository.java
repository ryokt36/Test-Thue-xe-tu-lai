package poly.pro2112.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.pro2112.entities.Nguoidung;

import java.util.Optional;

public interface NguoidungRepository extends JpaRepository<Nguoidung, Integer> {
    Optional<Nguoidung> findNguoidungByTaikhoan(String taikhoan);
    Boolean existsNguoidungByTaikhoan(String taikhoan);
    Boolean existsNguoidungByEmail(String email);
}
