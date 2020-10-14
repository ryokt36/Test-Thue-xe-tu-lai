package poly.pro2112.service;

import poly.pro2112.entities.Contract;

import java.util.List;

public interface ContractService {
    List<Contract> findAll();
    Contract saveOrUpdate(Contract contract);
    Contract findContract(String name);
}
