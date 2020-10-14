package poly.pro2112.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.pro2112.converter.CarMapper;
import poly.pro2112.entities.Registry;
import poly.pro2112.repository.RegistryRepository;
import poly.pro2112.vo.RegistryVO;

import java.util.List;

@Service
public class RegistryServiceImpl implements RegistryService{
    @Autowired
    RegistryRepository registryRepo;
    private CarMapper carMapper = CarMapper.INSTANCE;

    @Override
    public List<Registry> findAll() {
        return registryRepo.findAll();
    }

    @Override
    public RegistryVO saveOrUpdate(RegistryVO registryVO) {
        Registry registry = carMapper.registryVOToRegistry(registryVO);
        registry = registryRepo.save(registry);
        registryVO.setId(registry.getId());
        return registryVO;
    }

    @Override
    public void deleteById(Integer id) {
        registryRepo.deleteById(id);
    }
}
