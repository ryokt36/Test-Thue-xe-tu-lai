package poly.pro2112.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import poly.pro2112.controller.handlers.ExceptionHandlers;
import poly.pro2112.entities.Hangxe;
import poly.pro2112.entities.Mauxe;
import poly.pro2112.errors.AlreadyUsedException;
import poly.pro2112.errors.NotExistException;
import poly.pro2112.repository.HangxeRepository;
import poly.pro2112.repository.MauxeRepository;
import poly.pro2112.service.MauxeService;
import poly.pro2112.vo.MauxeVO;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "${crossOrigin}")
@RestController
public class MauxeController extends ExceptionHandlers {
    @Autowired
    MauxeService mauxeService;

    @Autowired
    MauxeRepository mauxeRepository;

    @Autowired
    HangxeRepository hangxeRepository;

    @GetMapping("/mauxe")
    public List<MauxeVO> getAllMauxe(){
        return mauxeService.getAllMauxe();
    }

    @GetMapping("/mauxe/{id}")
    public MauxeVO getMauxeById(@PathVariable Integer id){
        return mauxeService.getMauxeById(id);
    }

    @PostMapping("/mauxe")
    public MauxeVO createMauxe(@RequestBody MauxeVO mauxeVO){
        if(mauxeRepository.existsMauxeByTenmau(mauxeVO.getTenmau())){
            throw new AlreadyUsedException("Tenmauxe", null);
        }
        else if(!hangxeRepository.existsById(mauxeVO.getHangxe().getId())){
            throw new NotExistException("Hangxe", null);
        }
        else {
            return mauxeService.saveOrUpdate(mauxeVO);
        }
    }

    @PutMapping("/mauxe")
    public MauxeVO updateMauxe(@RequestBody MauxeVO mauxeVO){
        if(!mauxeRepository.existsById(mauxeVO.getId())){
            throw new NotExistException("Mauxe", null);
        }
        else if(mauxeRepository.existsMauxeByTenmau(mauxeVO.getTenmau())){
            throw new AlreadyUsedException("Tenmauxe", null);
        }
        else if(!hangxeRepository.existsById(mauxeVO.getHangxe().getId())){
            throw new NotExistException("Hangxe", null);
        }
        else {
            return mauxeService.saveOrUpdate(mauxeVO);
        }
    }

    @DeleteMapping("/mauxe/{id}")
    public void deleteHangxe(@PathVariable Integer id){
        if(mauxeRepository.existsById(id)){
            mauxeRepository.deleteById(id);
        } else {
            throw new NotExistException("Mauxe", null);
        }
    }
}
