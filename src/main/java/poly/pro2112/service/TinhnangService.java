package poly.pro2112.service;

import poly.pro2112.vo.TinhnangVO;

import java.util.List;

public interface TinhnangService {
    TinhnangVO saveOrUpdate(TinhnangVO tinhnangVO);
    List<TinhnangVO> getAllTinhnang();
    TinhnangVO getTinhnangById(Integer id);
    void deleteById(Integer id);
}
