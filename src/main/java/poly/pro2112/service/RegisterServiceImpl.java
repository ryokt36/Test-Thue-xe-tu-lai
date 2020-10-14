package poly.pro2112.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.pro2112.converter.CarMapper;
import poly.pro2112.converter.ModelMapper;
import poly.pro2112.entities.Register;
import poly.pro2112.repository.RegisterRepository;
import poly.pro2112.vo.RegisterVO;

import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService{
    @Autowired
    RegisterRepository registerRepo;
    private CarMapper carMapper = CarMapper.INSTANCE;

    @Override
    public List<Register> findAll() {
        return registerRepo.findAll();
    }

    @Override
    public RegisterVO saveOrUpdate(RegisterVO registerVO) {
        Register register = carMapper.registerVOToRegister(registerVO);
        register = registerRepo.save(register);
        registerVO.setId(register.getId());
        return registerVO;
    }

    @Override
    public void deleteById(Integer id) {
        registerRepo.deleteById(id);
    }
}
