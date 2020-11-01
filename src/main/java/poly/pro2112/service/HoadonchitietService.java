package poly.pro2112.service;

import poly.pro2112.entities.Hoadonchitiet;
import poly.pro2112.vo.HoadonVO;
import poly.pro2112.vo.HoadonchitietVO;

import java.util.List;

public interface HoadonchitietService {
    HoadonchitietVO saveOrUpdate(HoadonchitietVO hoadonchitietVO);
    List<HoadonchitietVO> getAllHoadonchitiet();
    HoadonchitietVO getHoadonchitietByPk(Hoadonchitiet.Pk pk);
    void deleteById(Integer id);
}
