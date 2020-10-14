package poly.pro2112.service;

import poly.pro2112.entities.Administrator;

import java.util.List;

public interface AdministratorService {
    List<Administrator> findAll();
    Administrator saveOrUpdate(Administrator administrator);
    void deleteById(Integer id);
    Administrator findById(Integer id);
}
