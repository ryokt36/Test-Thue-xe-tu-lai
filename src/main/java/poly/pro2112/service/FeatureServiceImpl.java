package poly.pro2112.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.pro2112.converter.CarMapper;
import poly.pro2112.entities.Brand;
import poly.pro2112.entities.Feature;
import poly.pro2112.repository.FeatureRepository;
import poly.pro2112.vo.FeatureVO;

import java.util.List;
import java.util.Optional;

@Service
public class FeatureServiceImpl implements FeatureService {
    @Autowired
    FeatureRepository featureRepository;
    private CarMapper carMapper = CarMapper.INSTANCE;

    @Override
    public List<FeatureVO> findAll() {
        List<Feature> features = featureRepository.findAll();
        List<FeatureVO> featureVOS = carMapper.toFeatureDtos(features);
        return featureVOS;
    }

    @Override
    public FeatureVO saveOrUpdate(FeatureVO featureVO) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public FeatureVO findById(Integer id) {
        Optional<Feature> feature = featureRepository.findById(id);
        if(feature.isPresent()){
            Feature featureOut =  feature.get();
            return carMapper.featureToFeatureVO(featureOut);
        }
        return null;
    }
}
