package poly.pro2112.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.pro2112.entities.Administrator;
import poly.pro2112.repository.AdministratorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdministratorServiceImpl implements AdministratorService{
    @Autowired
    AdministratorRepository admRepo;

    @Override
    public List<Administrator> findAll() {
        return admRepo.findAll();
    }

    @Override
    public Administrator saveOrUpdate(Administrator administrator) {
        return admRepo.save(administrator);
    }

    @Override
    public void deleteById(Integer id) {
        admRepo.deleteById(id);
    }

    @Override
    public Administrator findById(Integer id) {
        Optional<Administrator> administrator = admRepo.findById(id);
        if(administrator.isPresent()){
            return administrator.get();
        }
        return null;
    }
}
