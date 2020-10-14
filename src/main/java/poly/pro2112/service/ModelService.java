package poly.pro2112.service;

import poly.pro2112.entities.Model;
import poly.pro2112.vo.ModelVO;

import java.util.List;

public interface ModelService {
    List<ModelVO> findAll();
    ModelVO saveOrUpdate(ModelVO modelVO);
    ModelVO findById(Integer id);
    List<ModelVO> findAllByBrand(Integer id);
    void deleteById(Integer id);
}
