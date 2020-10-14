package poly.pro2112.service;

import poly.pro2112.entities.Registry;
import poly.pro2112.vo.RegistryVO;

import java.util.List;

public interface RegistryService {
    List<Registry> findAll();
    RegistryVO saveOrUpdate(RegistryVO registryVO);
    void deleteById(Integer id);
}
