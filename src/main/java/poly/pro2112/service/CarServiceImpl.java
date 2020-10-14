package poly.pro2112.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.pro2112.converter.CarMapper;
import poly.pro2112.entities.Car;
import poly.pro2112.repository.CarRepository;
import poly.pro2112.vo.CarVO;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService{
    @Autowired
    CarRepository carRepo;
    private CarMapper carMapper = CarMapper.INSTANCE;

    @Override
    public List<CarVO> findAll() {
        List<Car> cars = carRepo.findAll();
        List<CarVO> carVOS = carMapper.toCarDtos(cars);
        return carVOS;
    }

    @Override
    public CarVO saveOrUpdate(CarVO carVO) {
        Car car = carMapper.toCarCreateOrUpdate(carVO);
        car = carRepo.save(car);
        carVO.setId(car.getId());
        return carVO;
    }

    @Override
    public void deleteById(Integer id) {
        carRepo.deleteById(id);
    }

    @Override
    public Car findByID(Integer id) {
        Optional<Car> car = carRepo.findById(id);
        if (car.isPresent()) {
            return car.get();
        }
        return null;
    }


}
