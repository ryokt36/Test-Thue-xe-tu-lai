package poly.pro2112.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import poly.pro2112.controller.handlers.ExceptionHandlers;
import poly.pro2112.entities.Nguoidung;
import poly.pro2112.errors.AlreadyUsedException;
import poly.pro2112.errors.NotExistException;
import poly.pro2112.repository.NguoidungRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "${crossOrigin}")
@RestController
public class NguoidungController extends ExceptionHandlers {

    @Autowired
    NguoidungRepository nguoidungRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/admin/nguoidung")
    public List<Nguoidung> getAllNguoidungByAdmin(){
        return nguoidungRepository.findAllByChucvuAndIsdeleteIsNull("S");
    }

    @GetMapping("/staff/nguoidung")
    public List<Nguoidung> getAllNguoidungByStaff(){
        return nguoidungRepository.findAllByChucvuAndIsdeleteIsNull("C");
    }

    @GetMapping("/admin/nguoidung/{id}")
    public List<Nguoidung> getAllNguoidungByAdminAnhId(@PathVariable Integer id){
        return nguoidungRepository.findAllByChucvuAndIdAndIsdeleteIsNull("S", id);
    }

    @GetMapping("/staff/nguoidung/{id}")
    public List<Nguoidung> getAllNguoidungByStaffAnhId(@PathVariable Integer id){
        return nguoidungRepository.findAllByChucvuAndIdAndIsdeleteIsNull("C", id);
    }

    @PostMapping("/admin/nguoidung")
    public Nguoidung createNguoidung(@RequestBody Nguoidung nguoidung){
        if(nguoidungRepository.existsNguoidungByTaikhoan(nguoidung.getTaikhoan())){
            throw new AlreadyUsedException("Taikhoan", null);
        }
        else if(nguoidungRepository.existsNguoidungByEmail(nguoidung.getEmail())){
            throw new AlreadyUsedException("Email", null);
        }
        else {
            nguoidung.setMatkhau(passwordEncoder.encode(nguoidung.getMatkhau()));
            return nguoidungRepository.save(nguoidung);
        }
    }

    @PutMapping("/admin/nguoidung")
    public Nguoidung updateNguoidung(@RequestBody Nguoidung nguoidung){
        if(nguoidungRepository.existsById(nguoidung.getId())){
            throw new NotExistException("Nguoidung", null);
        }
        else if(nguoidungRepository.existsNguoidungByTaikhoan(nguoidung.getTaikhoan())){
            throw new AlreadyUsedException("Taikhoan", null);
        }
        else if(nguoidungRepository.existsNguoidungByEmail(nguoidung.getEmail())){
            throw new AlreadyUsedException("Email", null);
        }
        else {
            nguoidung.setMatkhau(passwordEncoder.encode(nguoidung.getMatkhau()));
            return nguoidungRepository.save(nguoidung);
        }
    }

    @PutMapping("/admin/nguoidung/{id}")
    public Nguoidung deleteNguoidung(@RequestBody Nguoidung nguoidung){
        if(nguoidungRepository.existsById(nguoidung.getId())){
            throw new NotExistException("Nguoidung", null);
        }
        else if(nguoidungRepository.existsNguoidungByTaikhoan(nguoidung.getTaikhoan())){
            throw new AlreadyUsedException("Taikhoan", null);
        }
        else if(nguoidungRepository.existsNguoidungByEmail(nguoidung.getEmail())){
            throw new AlreadyUsedException("Email", null);
        }
        else {
            nguoidung.setMatkhau(passwordEncoder.encode(nguoidung.getMatkhau()));
            nguoidung.setIsdelete(true);
            return nguoidungRepository.save(nguoidung);
        }
    }
}
