package poly.pro2112.service;

import poly.pro2112.entities.Register;
import poly.pro2112.vo.RegisterVO;

import java.util.List;

public interface RegisterService {
    List<Register> findAll();
    RegisterVO saveOrUpdate(RegisterVO registerVO);
    void deleteById(Integer id);
}
