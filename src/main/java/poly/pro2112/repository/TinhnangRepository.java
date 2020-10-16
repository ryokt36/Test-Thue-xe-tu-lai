package poly.pro2112.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.pro2112.entities.Tinhnang;

import java.util.Optional;

public interface TinhnangRepository extends JpaRepository<Tinhnang, Integer> {
    Boolean existsTinhnangByTentinhnang(String tentinhnang);
}
