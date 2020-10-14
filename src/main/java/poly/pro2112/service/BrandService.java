package poly.pro2112.service;

import poly.pro2112.entities.Brand;
import poly.pro2112.vo.BrandVO;

import java.util.List;

public interface BrandService {
    List<BrandVO> findAll();
    BrandVO saveOrUpdate(BrandVO brandVO);
    void deleteById(Integer id);
    BrandVO findById(Integer id);
    Brand findByNameBrand(String name);
}
