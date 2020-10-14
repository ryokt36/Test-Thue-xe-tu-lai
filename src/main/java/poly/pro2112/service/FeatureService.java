package poly.pro2112.service;

import poly.pro2112.vo.FeatureVO;

import java.util.List;

public interface FeatureService {
    List<FeatureVO> findAll();
    FeatureVO saveOrUpdate(FeatureVO featureVO);
    void deleteById(Integer id);
    FeatureVO findById(Integer id);
}
