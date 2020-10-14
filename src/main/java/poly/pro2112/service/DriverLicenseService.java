package poly.pro2112.service;

import poly.pro2112.entities.Driverlicense;

import java.util.List;

public interface DriverLicenseService {
    List<Driverlicense> findAll();
    Driverlicense saveOrUpdate(Driverlicense driverlicense);
    void deleteById(String id);
    Driverlicense findById(String id);
}
