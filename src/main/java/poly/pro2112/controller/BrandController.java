package poly.pro2112.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import poly.pro2112.entities.Administrator;
import poly.pro2112.entities.Brand;
import poly.pro2112.service.BrandService;
import poly.pro2112.vo.BrandVO;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BrandController {
    @Autowired
    BrandService brdService;

    @GetMapping(value = "/admin/brand")
    public List<BrandVO> findAll() {
        return brdService.findAll();
    }

    @GetMapping(value = "/admin/brand/{id}")
    public BrandVO findById(@PathVariable("id") Integer id){
        return brdService.findById(id);
    }

    @PostMapping(value = "/admin/brand")
    public BrandVO save(@RequestBody BrandVO brandVO){
        return brdService.saveOrUpdate(brandVO);
    }

    @PutMapping(value = "/admin/brand/{id}")
    public BrandVO update(@RequestBody BrandVO brandVO) {
        return brdService.saveOrUpdate(brandVO);
    }

    @DeleteMapping(value = "/admin/brand/{id}")
    public void delete(@PathVariable("id") Integer id) {
        brdService.deleteById(id);
    }
}
