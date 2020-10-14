package poly.pro2112.service;

import poly.pro2112.entities.Customer;
import poly.pro2112.vo.CustomerVO;

import java.util.List;

public interface CustomerService {
    List<CustomerVO> findAll();
    CustomerVO saveOrUpdate(CustomerVO customerVO);
    void deleteByID(Integer id);
    CustomerVO findById(Integer id);
}
