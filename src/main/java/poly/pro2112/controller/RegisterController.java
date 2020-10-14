package poly.pro2112.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import poly.pro2112.entities.Administrator;
import poly.pro2112.entities.Register;
import poly.pro2112.service.RegisterService;
import poly.pro2112.vo.RegisterVO;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RegisterController {
    @Autowired
    RegisterService registerService;
    private String pathFolder = "../../Frontend/CarRental/src/assets/FileUpload/register/";

    @GetMapping(value = "/admin/register")
    public List<Register> findAll(){
        return registerService.findAll();
    }

    @PostMapping(value = "/admin/register")
    public RegisterVO save(
            @RequestParam("register") String registerStr,
            @RequestParam("anhdangky") MultipartFile anhdangky) throws JsonProcessingException, ParseException {
        ObjectMapper objectMapper = new ObjectMapper();
        RegisterVO registerVO = objectMapper.readValue(registerStr, RegisterVO.class);
        try {
            if (!anhdangky.isEmpty()) {
                byte[] bytes = anhdangky.getBytes();
                Path path = Paths.get(pathFolder + anhdangky.getOriginalFilename());
                Files.write(path, bytes);
                registerVO.setImage(anhdangky.getOriginalFilename());
            }
            else {
                registerVO.setImage("");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return registerService.saveOrUpdate(registerVO);
    }

//    @PutMapping(value = "/admin/register")
//    public Register update(Register register){
//        return registerService.saveOrUpdate(register);
//    }

    @DeleteMapping(value = "/customer/register/{id}")
    public void delete(@PathVariable("id") Integer id){
        registerService.deleteById(id);
    }
}
