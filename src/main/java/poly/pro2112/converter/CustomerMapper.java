package poly.pro2112.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import poly.pro2112.entities.Customer;
import poly.pro2112.vo.CustomerVO;

import java.util.List;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerVO customerToCustomerVO(Customer customer);

    Customer customerVOToCustomer(CustomerVO customervo);

    List<CustomerVO> toCustomerVOS(List<Customer> customers);

    List<Customer> toCustomers(List<CustomerVO> customerVOS);
}
