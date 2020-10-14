package poly.pro2112.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import poly.pro2112.service.FeatureService;
import poly.pro2112.vo.BrandVO;
import poly.pro2112.vo.FeatureVO;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FeatureController {
    @Autowired
    FeatureService featureService;

    @GetMapping(value = "/admin/feature")
    public List<FeatureVO> findAll() {
        return featureService.findAll();
    }

    @GetMapping(value = "/admin/feature/{id}")
    public FeatureVO findById(@PathVariable("id") Integer id){
        return featureService.findById(id);
    }
}
