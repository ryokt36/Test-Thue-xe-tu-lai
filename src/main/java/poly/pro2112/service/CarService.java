package poly.pro2112.service;

import poly.pro2112.entities.Car;
import poly.pro2112.entities.Register;
import poly.pro2112.entities.Registry;
import poly.pro2112.vo.CarVO;
import poly.pro2112.vo.RegisterVO;
import poly.pro2112.vo.RegistryVO;

import java.util.List;

public interface CarService {
    List<CarVO> findAll();
    CarVO saveOrUpdate(CarVO car);
    void deleteById(Integer id);
    Car findByID(Integer id);
}
