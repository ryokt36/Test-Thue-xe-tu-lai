package poly.pro2112.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import poly.pro2112.entities.Hoadonchitiet;
import poly.pro2112.enums.HoadonRequest;
import poly.pro2112.errors.AlreadyUsedException;
import poly.pro2112.errors.NotExistException;
import poly.pro2112.service.HoadonService;
import poly.pro2112.service.HoadonchitietService;
import poly.pro2112.vo.HangxeVO;
import poly.pro2112.vo.HoadonVO;
import poly.pro2112.vo.HoadonchitietVO;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "${crossOrigin}")
@RestController
public class HoadonController {

    @Autowired
    HoadonService hoadonService;

    @Autowired
    HoadonchitietService hoadonchitietService;

    @GetMapping("/hoadon")
    public List<HoadonVO> getAllHoadon(){
        return hoadonService.getAllHoadon();
    }

    @GetMapping("/hoadon/{id}")
    public HoadonVO getHoadonbyId(@PathVariable Integer id){
        return hoadonService.getHoadonById(id);
    }

    @PostMapping("/hoadon")
    public HoadonVO creatHoadon(@Valid @RequestBody HoadonRequest hoadonRequest) {
        HoadonVO hoadonVO = new HoadonVO();
        hoadonVO.setNguoidung(hoadonRequest.getNguoidung());
        hoadonVO.setNgaytao(hoadonRequest.getNgaytao());
        hoadonVO.setTongtien(hoadonRequest.getTongtien());
        hoadonVO.setXeVOS(hoadonRequest.getXeVOS());
        HoadonVO check = hoadonService.saveOrUpdate(hoadonVO);
        if(check != null){
            HoadonchitietVO hoadonchitietVO = new HoadonchitietVO();
            HoadonchitietVO.Pk pk = new HoadonchitietVO.Pk();
            pk.setId_hoadon(check.getId());
            pk.setId_xe(hoadonRequest.getXeVOS().get(0).getId());
            hoadonchitietVO.setPk(pk);
            hoadonchitietVO.setNgaybatdau(hoadonRequest.getNgaybatdau());
            hoadonchitietVO.setNgayketthuc(hoadonRequest.getNgayketthuc());
            hoadonchitietVO.setTongtien(hoadonRequest.getTongtienhdct());
            hoadonchitietVO.setGhichu(hoadonRequest.getGhichu());
            hoadonchitietVO.setIsdelete(null);
            HoadonchitietVO checksavehdct = hoadonchitietService.saveOrUpdate(hoadonchitietVO);
            if(checksavehdct != null){
                return hoadonVO;
            }
            return null;
        } else {
            return null;
        }
    }

    @PutMapping("/hoadon")
    public HoadonVO updateHoadon(@Valid @RequestBody HoadonVO hoadonVO) {
        return hoadonService.saveOrUpdate(hoadonVO);
    }

}
