package poly.pro2112.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.pro2112.entities.Contract;
import poly.pro2112.repository.ContractRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContractServiceImpl implements ContractService{
    @Autowired
    ContractRepository contractRepo;

    @Override
    public List<Contract> findAll() {
        return contractRepo.findAll();
    }

    @Override
    public Contract saveOrUpdate(Contract contract) {
        return contractRepo.save(contract);
    }

    @Override
    public Contract findContract(String name) {
//        Optional<Contract> contract = contractRepo.fin;
//        if (contract.isPresent()){
//
//        }
        return null;
    }

}
