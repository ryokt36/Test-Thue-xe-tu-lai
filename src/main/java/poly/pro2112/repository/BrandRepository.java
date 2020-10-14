package poly.pro2112.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poly.pro2112.entities.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
