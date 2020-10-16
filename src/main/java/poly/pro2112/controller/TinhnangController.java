package poly.pro2112.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import poly.pro2112.entities.Tinhnang;
import poly.pro2112.errors.AlreadyUsedException;
import poly.pro2112.errors.NotExistException;
import poly.pro2112.repository.TinhnangRepository;
import poly.pro2112.service.TinhnangService;
import poly.pro2112.vo.TinhnangVO;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "${crossOrigin}")
@RestController
public class TinhnangController {
    @Autowired
    TinhnangService tinhnangService;

    @Autowired
    TinhnangRepository tinhnangRepository;

    @GetMapping("/tinhnang")
    public List<TinhnangVO> getAllTinhnang(){
        return tinhnangService.getAllTinhnang();
    }

    @GetMapping("/tinhnang/{id}")
    public TinhnangVO getTinhnangById(@PathVariable Integer id){
        return tinhnangService.getTinhnangById(id);
    }

    @PostMapping("/tinhnang")
    public TinhnangVO createTinhnang(@RequestBody TinhnangVO tinhnangVO){
        if(tinhnangRepository.existsTinhnangByTentinhnang(tinhnangVO.getTentinhnag())){
            throw new AlreadyUsedException("Tentinhnang", null);
        }
        else {
            return tinhnangService.saveOrUpdate(tinhnangVO);
        }

    }

    @PutMapping("/tinhnang")
    public TinhnangVO updateTinhnang(@RequestBody TinhnangVO tinhnangVO){
        if(!tinhnangRepository.existsById(tinhnangVO.getId())){
            throw new NotExistException("Tinhnang", null);
        }
        else if(tinhnangRepository.existsTinhnangByTentinhnang(tinhnangVO.getTentinhnag())){
            throw new AlreadyUsedException("Tentinhnang", null);
        }
        else {
            return tinhnangService.saveOrUpdate(tinhnangVO);
        }

    }

    @DeleteMapping("/tinhnang/{id}")
    public void deleteTinhnang(@PathVariable Integer id){
        if(tinhnangRepository.existsById(id)){
            tinhnangService.deleteById(id);
        }
        else {
            throw new NotExistException("Tinhnang", null);
        }
    }
}
