package poly.pro2112.service;

import org.springframework.beans.factory.annotation.Autowired;
import poly.pro2112.entities.Driverlicense;
import poly.pro2112.repository.DriverlicenseRepository;

import java.util.List;
import java.util.Optional;

public class DriverLicenseServiceImpl implements DriverLicenseService{
    @Autowired
    DriverlicenseRepository driverlicenseRepo;

    @Override
    public List<Driverlicense> findAll() {
        return driverlicenseRepo.findAll();
    }

    @Override
    public Driverlicense saveOrUpdate(Driverlicense driverlicense) {
        return driverlicenseRepo.save(driverlicense);
    }

    @Override
    public void deleteById(String id) {
        driverlicenseRepo.deleteById(id);
    }

    @Override
    public Driverlicense findById(String id) {
        Optional<Driverlicense> driverlicense = driverlicenseRepo.findById(id);
        if (driverlicense.isPresent()){
            return driverlicense.get();
        }
        return null;
    }
}
