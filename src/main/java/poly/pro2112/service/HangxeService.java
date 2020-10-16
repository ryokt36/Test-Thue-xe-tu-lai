package poly.pro2112.service;

import poly.pro2112.vo.HangxeVO;

import java.util.List;

public interface HangxeService {
    HangxeVO saveOrUpdate(HangxeVO hangxeVO);
    List<HangxeVO> getAllHangxe();
    HangxeVO getHangxeById(Integer id);
    void deleteById(Integer id);
}
