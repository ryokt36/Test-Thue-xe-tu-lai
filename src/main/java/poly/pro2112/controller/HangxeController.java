package poly.pro2112.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import poly.pro2112.controller.handlers.ExceptionHandlers;
import poly.pro2112.entities.Hangxe;
import poly.pro2112.errors.AlreadyUsedException;
import poly.pro2112.errors.NotExistException;
import poly.pro2112.repository.HangxeRepository;
import poly.pro2112.service.HangxeService;
import poly.pro2112.vo.HangxeVO;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "${crossOrigin}")
@RestController
public class HangxeController extends ExceptionHandlers {

    @Autowired
    HangxeService hangxeService;

    @Autowired
    HangxeRepository hangxeRepository;

    @GetMapping("/hangxe")
    public List<HangxeVO> getAllHangxe(){
        return hangxeService.getAllHangxe();
    }

    @GetMapping("/hangxe/{id}")
    public HangxeVO getHangxebyId(@PathVariable Integer id){
        return hangxeService.getHangxeById(id);
    }

    @PostMapping("/hangxe")
    public HangxeVO creatHangxe(@Valid @RequestBody HangxeVO hangxeVO) {
        if(hangxeRepository.existsHangxeByTenhang(hangxeVO.getTenhang())){
            throw new AlreadyUsedException("Tenhangxe", null);
        }
        else {
            return hangxeService.saveOrUpdate(hangxeVO);
        }
    }

    @PutMapping("/hangxe")
    public HangxeVO updateHangxe(@Valid @RequestBody HangxeVO hangxeVO) {
        if(!hangxeRepository.existsById(hangxeVO.getId())){
            throw new NotExistException("Hangxe", null);
        }
        else if(hangxeRepository.existsHangxeByTenhang(hangxeVO.getTenhang())){
            throw new AlreadyUsedException("Tenhangxe", null);
        }
        else {
            return hangxeService.saveOrUpdate(hangxeVO);
        }
    }

    @DeleteMapping("/hangxe/{id}")
    public void deleteHangxe(@PathVariable Integer id){
        if(hangxeRepository.existsById(id)){
            hangxeService.deleteById(id);
        } else {
            throw new NotExistException("Hangxe", null);
        }
    }
}
