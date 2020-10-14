package poly.pro2112.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import poly.pro2112.entities.Administrator;
import poly.pro2112.service.AdministratorService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AdminController {
    @Autowired
    AdministratorService admService;

    @PreAuthorize("hasRole('A')")
    @GetMapping(value = "/admin/staff")
    public List<Administrator> listAll(){
        return admService.findAll();
    }

    private String pathFolder = "../../Frontend/CarRental/src/assets/FileUpload/staff/";
    @GetMapping(value = "/admin/staff/{id}")
    public Administrator findById(@PathVariable("id") Integer id){
        return admService.findById(id);
    }

    @PostMapping(value = "/admin/staff")
    public Administrator save(
            @RequestParam("admin") String adminStr,
            @RequestParam("file") MultipartFile file) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Administrator administrator = objectMapper.readValue(adminStr, Administrator.class);
        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(pathFolder + file.getOriginalFilename());
                Files.write(path, bytes);
                administrator.setImage(file.getOriginalFilename());
                System.out.println(file.getOriginalFilename());
            }
            else {
                administrator.setImage("");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return admService.saveOrUpdate(administrator);
    }

    @PutMapping(value = "/admin/staff/{id}")
    public Administrator update(
            @RequestParam("admin") String adminStr,
            @RequestParam("file") MultipartFile file) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Administrator administrator = objectMapper.readValue(adminStr, Administrator.class);
        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(pathFolder + file.getOriginalFilename());
                Files.write(path, bytes);
                administrator.setImage(file.getOriginalFilename());
                System.out.println(file.getOriginalFilename());
            }
            else {
                administrator.setImage("");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return admService.saveOrUpdate(administrator);
    }

    @DeleteMapping(value = "/admin/staff/{id}")
    public void delete(@PathVariable("id") Integer id){
        admService.deleteById(id);
    }
}
