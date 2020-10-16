package poly.pro2112.service;

import poly.pro2112.entities.Mauxe;
import poly.pro2112.vo.MauxeVO;

import java.util.List;

public interface MauxeService {
    MauxeVO saveOrUpdate(MauxeVO MauxeVO);
    List<MauxeVO> getAllMauxe();
    MauxeVO getMauxeById(Integer id);
    void deleteById(Integer id);
}
