package poly.pro2112.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.pro2112.converter.MauxeMapper;
import poly.pro2112.converter.XeMapper;
import poly.pro2112.entities.Xe;
import poly.pro2112.repository.XeRepository;
import poly.pro2112.vo.HangxeVO;
import poly.pro2112.vo.XeVO;

import java.util.List;
import java.util.Optional;

@Service
public class XeServiceImpl implements XeService{

    private XeMapper xeMapper = XeMapper.INSTANCE;

    @Autowired
    XeRepository xeRepository;

    @Override
    public XeVO saveOrUpdate(XeVO xeVO) {
        Xe xe = xeRepository.save(xeMapper.xeVOToXe(xeVO));
        xeVO.setId(xe.getId());
        return xeVO;
    }

    @Override
    public List<XeVO> getAllXe() {
        return xeMapper.xesToXeVOs(xeRepository.findAll());
    }

    @Override
    public XeVO getXeById(Integer id) {
        Optional<Xe> xe = xeRepository.findById(id);
        if(xe.isPresent()){
            return xeMapper.xeToXeVO(xe.get());
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        try {
            xeRepository.deleteById(id);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
