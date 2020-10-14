package poly.pro2112.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.pro2112.converter.CustomerMapper;
import poly.pro2112.converter.ModelMapper;
import poly.pro2112.entities.Customer;
import poly.pro2112.repository.CustomerRepository;
import poly.pro2112.vo.CustomerVO;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    private CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @Override
    public List<CustomerVO> findAll() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerVO> customerVOS = customerMapper.toCustomerVOS(customers);
        return customerVOS;
    }

    @Override
    public CustomerVO saveOrUpdate(CustomerVO customerVO) {
        Customer customer = customerMapper.customerVOToCustomer(customerVO);
        customer = customerRepository.save(customer);
        customerVO.setId(customer.getId());
        return customerVO;
    }

    @Override
    public void deleteByID(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public CustomerVO findById(Integer id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()){
            Customer customerOut = customer.get();
            return customerMapper.customerToCustomerVO(customerOut);
        }
        return null;
    }
}
