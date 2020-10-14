package poly.pro2112.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.pro2112.converter.CarMapper;
import poly.pro2112.converter.ModelMapper;
import poly.pro2112.entities.Brand;
import poly.pro2112.entities.Model;
import poly.pro2112.repository.ModelRepository;
import poly.pro2112.vo.ModelVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ModelServiceImpl implements ModelService {
    @Autowired
    ModelRepository modelRepo;
    private ModelMapper modelMapper = ModelMapper.INSTANCE;

    @Override
    public List<ModelVO> findAll() {
        List<Model> models = modelRepo.findAll();
        List<ModelVO> modelVOS = modelMapper.toModelDtos(models);
        return modelVOS;
    }

    @Override
    public ModelVO saveOrUpdate(ModelVO modelVO) {
        Model model = modelMapper.modelvoToModel(modelVO);
        model = modelRepo.save(model);
        modelVO.setId(model.getId());
        return modelVO;
    }

    @Override
    public ModelVO findById(Integer id) {
        Optional<Model> model = modelRepo.findById(id);
        if(model.isPresent()){
            Model modelOut =  model.get();
            return modelMapper.modelToModelVO(modelOut);
        }
        return null;
    }

    @Override
    public List<ModelVO> findAllByBrand(Integer id) {
        List<Model> models = modelRepo.findAllByBrand(id);
        List<ModelVO> modelVOS = modelMapper.toModelDtos(models);
        return modelVOS;
    }

    @Override
    public void deleteById(Integer id) {
        modelRepo.deleteById(id);
    }
}
