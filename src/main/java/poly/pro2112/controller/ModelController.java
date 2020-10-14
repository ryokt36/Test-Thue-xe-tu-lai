package poly.pro2112.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import poly.pro2112.service.ModelService;
import poly.pro2112.vo.ModelVO;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ModelController {
    @Autowired
    ModelService modelService;

    @GetMapping(value = "/admin/model")
    public List<ModelVO> findAll() {
        return modelService.findAll();
    }

    @GetMapping(value = "/admin/model/brand/{id}")
    public List<ModelVO> findAllByBrand(@PathVariable("id") Integer id) {
        return modelService.findAllByBrand(id);
    }

    @GetMapping(value = "/admin/model/{id}")
    public ModelVO findById(@PathVariable("id") Integer id) {
        return modelService.findById(id);
    }

    @PostMapping(value = "/admin/model")
    public ModelVO save( @RequestParam(required=false, name = "model") String modelStr) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ModelVO modelVO = objectMapper.readValue(modelStr, ModelVO.class);
        System.out.println(modelVO.toString());
        return modelService.saveOrUpdate(modelVO);
    }

//    @PostMapping(value = "/admin/model")
//    public ModelVO save( @RequestBody ModelVO modelVO){
//        System.out.println(modelVO.toString());
//        return modelService.saveOrUpdate(modelVO);
//    }

    @PutMapping(value = "/admin/model/{id}")
    public ModelVO update(@RequestParam(required=false, name = "model") String modelStr) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ModelVO modelVO = objectMapper.readValue(modelStr, ModelVO.class);
        System.out.println(modelVO.toString());
        return modelService.saveOrUpdate(modelVO);
    }

    @DeleteMapping(value = "/admin/model/{id}")
    public void delete(@PathVariable("id") Integer id) {
        modelService.deleteById(id);
    }
}
