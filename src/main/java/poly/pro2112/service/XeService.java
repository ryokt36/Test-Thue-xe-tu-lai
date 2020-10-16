package poly.pro2112.service;

import poly.pro2112.entities.Xe;
import poly.pro2112.vo.XeVO;

import java.util.List;

public interface XeService {
    XeVO saveOrUpdate(XeVO xeVO);
    List<XeVO> getAllXe();
    XeVO getXeById(Integer id);
    void deleteById(Integer id);
}
