package poly.pro2112.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import poly.pro2112.service.CustomerService;
import poly.pro2112.vo.CustomerVO;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CustomerController {
    @Autowired
    private CustomerService cusService;

    @GetMapping(value = "/admin/customer")
    public List<CustomerVO> findAll() {
        return cusService.findAll();
    }

    @GetMapping(value = "/admin/customer/{id}")
    public CustomerVO findById(@PathVariable("id") Integer id) {
        return cusService.findById(id);
    }

    @PostMapping(value = "/admin/customer")
    public CustomerVO save(CustomerVO customerVO) {
        return cusService.saveOrUpdate(customerVO);
    }

    @PutMapping(value = "/admin/customer")
    public CustomerVO update(CustomerVO customerVO) {
        return cusService.saveOrUpdate(customerVO);
    }

    @DeleteMapping(value = "/admin/customer/{id}")
    public void delete(@PathVariable("id") Integer id) {
        cusService.deleteByID(id);
    }

}
