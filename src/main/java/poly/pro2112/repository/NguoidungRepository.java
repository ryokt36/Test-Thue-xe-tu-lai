package poly.pro2112.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.pro2112.entities.Nguoidung;

import java.util.List;
import java.util.Optional;

public interface NguoidungRepository extends JpaRepository<Nguoidung, Integer> {
    Optional<Nguoidung> findNguoidungByTaikhoan(String taikhoan);
    Boolean existsNguoidungByTaikhoan(String taikhoan);
    Boolean existsNguoidungByEmail(String email);
    List<Nguoidung> findAllByIsdeleteIsNull();
    List<Nguoidung> findAllByChucvuAndIsdeleteIsNull(String chucvu);
    List<Nguoidung> findAllByChucvuAndIdAndIsdeleteIsNull(String chucvu, Integer id);
    List<Nguoidung> findAllByIdAndIsdeleteIsNull(Integer id);
}
