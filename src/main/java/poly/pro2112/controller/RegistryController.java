package poly.pro2112.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import poly.pro2112.entities.Register;
import poly.pro2112.entities.Registry;
import poly.pro2112.service.RegistryService;
import poly.pro2112.vo.RegistryVO;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RegistryController {
    @Autowired
    RegistryService registryService;
    private String pathFolder = "../../Frontend/CarRental/src/assets/FileUpload/registry/";

    @GetMapping(value = "/admin/registry")
    public List<Registry> findAll(){
        return registryService.findAll();
    }

    @PostMapping(value = "/admin/registry")
    public RegistryVO save(
            @RequestParam("registry") String registryStr,
            @RequestParam("anhdangkiem") MultipartFile anhdangkiem) throws JsonProcessingException, ParseException {
        ObjectMapper objectMapper = new ObjectMapper();
        RegistryVO registryVO = objectMapper.readValue(registryStr, RegistryVO.class);
        try {
            if (!anhdangkiem.isEmpty()) {
                byte[] bytes = anhdangkiem.getBytes();
                Path path = Paths.get(pathFolder + anhdangkiem.getOriginalFilename());
                Files.write(path, bytes);
                registryVO.setImage(anhdangkiem.getOriginalFilename());
            }
            else {
                registryVO.setImage("");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return registryService.saveOrUpdate(registryVO);
    }

//    @PutMapping(value = "/admin/registry")
//    public Registry update(Registry registry){
//        return registryService.saveOrUpdate(registry);
//    }

    @DeleteMapping(value = "admin/registry/{id}")
    public void delete(@PathVariable("id") Integer id){
        registryService.deleteById(id);
    }
}
