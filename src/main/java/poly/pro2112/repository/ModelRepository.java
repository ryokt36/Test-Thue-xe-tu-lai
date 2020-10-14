package poly.pro2112.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import poly.pro2112.entities.Model;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {
    @Transactional
    @Modifying
    @Query(value = "SELECT m FROM Model m WHERE m.brand.id = ?1")
    public List<Model> findAllByBrand(Integer id);
}
