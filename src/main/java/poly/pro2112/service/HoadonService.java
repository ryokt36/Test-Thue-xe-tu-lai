package poly.pro2112.service;

import poly.pro2112.vo.HangxeVO;
import poly.pro2112.vo.HoadonVO;

import java.util.List;

public interface HoadonService {
    HoadonVO saveOrUpdate(HoadonVO hoadonVO);
    List<HoadonVO> getAllHoadon();
    HoadonVO getHoadonById(Integer id);
    void deleteById(Integer id);
}
