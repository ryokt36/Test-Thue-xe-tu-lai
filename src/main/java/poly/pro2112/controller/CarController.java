package poly.pro2112.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import poly.pro2112.entities.Car;
import poly.pro2112.service.CarService;
import poly.pro2112.vo.CarVO;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CarController {
    @Autowired
    CarService carService;
    private String pathFolderCar = "../../Frontend/CarRental/src/assets/FileUpload/car/";
    private String pathFolderRegister = "../../Frontend/CarRental/src/assets/FileUpload/register/";
    private String pathFolderRegistry = "../../Frontend/CarRental/src/assets/FileUpload/registry/";

    @GetMapping(value = "/admin/car")
    public List<CarVO> findAll(){
        return carService.findAll();
    }

    @GetMapping(value = "/admin/car/{id}")
    public Car findById(@PathVariable("id") Integer id){
        return carService.findByID(id);
    }

    @PostMapping(value = "/admin/car")
    public CarVO save(
            @RequestParam(required=false, name = "car") String carStr,
            @RequestParam(required=false, name = "register_image") MultipartFile register_image,
            @RequestParam(required=false, name = "registry_image") MultipartFile registry_image,
            @RequestParam(required=false, name = "anhxe") MultipartFile anhxe)throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        CarVO carVO = objectMapper.readValue(carStr, CarVO.class);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(carStr);
        System.out.println("-----------------------------------------------------------------------------------------");
        try {
            if (anhxe!=null) { //Nếu file có tồn tại thi...
                //lưu ảnh
                byte[] bytes_car_image = anhxe.getBytes();
                Path path_car = Paths.get(pathFolderCar + anhxe.getOriginalFilename());
                Files.write(path_car, bytes_car_image);
                //lưu tên ảnh vào database
                carVO.setImage(anhxe.getOriginalFilename());
            }
            if(register_image!=null){
                byte[] bytes_register_image = register_image.getBytes();
                Path path_register = Paths.get(pathFolderRegister + register_image.getOriginalFilename());
                Files.write(path_register, bytes_register_image);
                carVO.getRegister().setImage(register_image.getOriginalFilename());
            }
            if(registry_image!=null){
                byte[] bytes_registry_image = registry_image.getBytes();
                Path path_registry = Paths.get(pathFolderRegistry + registry_image.getOriginalFilename());
                Files.write(path_registry, bytes_registry_image);
                carVO.getRegistry().setImage(registry_image.getOriginalFilename());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return carService.saveOrUpdate(carVO);
    }

    @PutMapping(value = "/admin/car/{id}")
    public CarVO update(
            @RequestParam(required=false, name = "car") String carStr,
            @RequestParam(required=false, name = "register_image") MultipartFile register_image,
            @RequestParam(required=false, name = "registry_image") MultipartFile registry_image,
            @RequestParam(required=false, name = "anhxe") MultipartFile anhxe)throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        CarVO carVO = objectMapper.readValue(carStr, CarVO.class);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(carStr);
        System.out.println("-----------------------------------------------------------------------------------------");
        try {
            if (anhxe!=null) { //Nếu file có tồn tại thi...
                //lưu ảnh
                byte[] bytes_car_image = anhxe.getBytes();
                Path path_car = Paths.get(pathFolderCar + anhxe.getOriginalFilename());
                Files.write(path_car, bytes_car_image);
                //lưu tên ảnh vào database
                carVO.setImage(anhxe.getOriginalFilename());
            }
            if(register_image!=null){
                byte[] bytes_register_image = register_image.getBytes();
                Path path_register = Paths.get(pathFolderRegister + register_image.getOriginalFilename());
                Files.write(path_register, bytes_register_image);
                carVO.getRegister().setImage(register_image.getOriginalFilename());
            }
            if(registry_image!=null){
                byte[] bytes_registry_image = registry_image.getBytes();
                Path path_registry = Paths.get(pathFolderRegistry + registry_image.getOriginalFilename());
                Files.write(path_registry, bytes_registry_image);
                carVO.getRegistry().setImage(registry_image.getOriginalFilename());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(carVO.toString());
        System.out.println("-----------------------------------------------------------------------------------------");
        return carService.saveOrUpdate(carVO);
    }

    @DeleteMapping(value = "/admin/car/{id}")
    public void delete(@PathVariable("id") Integer id){
        carService.deleteById(id);
    }
}
