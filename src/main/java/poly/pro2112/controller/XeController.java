package poly.pro2112.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import poly.pro2112.entities.Xe;
import poly.pro2112.errors.AlreadyUsedException;
import poly.pro2112.errors.NotExistException;
import poly.pro2112.repository.MauxeRepository;
import poly.pro2112.repository.XeRepository;
import poly.pro2112.service.XeService;
import poly.pro2112.vo.XeVO;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "${crossOrigin}")
@RestController
public class XeController {
    @Autowired
    XeService xeService;

    @Autowired
    XeRepository xeRepository;

    @Autowired
    MauxeRepository mauxeRepository;

    @GetMapping("/xe")
    public List<XeVO> getAllXe(){
        return xeService.getAllXe();
    }

    @GetMapping("/xe/{id}")
    public XeVO getXeById(@PathVariable Integer id){
        return xeService.getXeById(id);
    }

    @PostMapping("/xe")
    public XeVO createXe(@RequestBody XeVO xeVO){
        if(xeRepository.existsXeBySokhung(xeVO.getSokhung())){
            throw new AlreadyUsedException("Sokhung", null);
        }
        else if(xeRepository.existsXeByBiensoxe(xeVO.getBiensoxe())){
            throw new AlreadyUsedException("Biensoxe", null);
        }
        else {
            return xeService.saveOrUpdate(xeVO);
        }

    }

    @PutMapping("/xe")
    public XeVO updateXe(@RequestBody XeVO xeVO){
        if(!xeRepository.existsById(xeVO.getId())){
            throw new NotExistException("Xe", null);
        }
        else if(xeRepository.existsXeBySokhung(xeVO.getSokhung())){
            throw new AlreadyUsedException("Sokhung", null);
        }
        else if(xeRepository.existsXeByBiensoxe(xeVO.getBiensoxe())){
            throw new AlreadyUsedException("Biensoxe", null);
        }
        else {
            return xeService.saveOrUpdate(xeVO);
        }

    }

    @DeleteMapping("/xe/{id}")
    public void deleteXe(@PathVariable Integer id){
        Optional<Xe> xe = xeRepository.findById(id);
        if(xeRepository.existsById(id)){
            xeService.deleteById(id);
        }
        else {
            throw new NotExistException("Xe", null);
        }
    }
}
