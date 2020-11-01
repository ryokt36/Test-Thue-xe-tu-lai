package poly.pro2112.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.pro2112.converter.HangxeMapper;
import poly.pro2112.converter.HoadonMapper;
import poly.pro2112.entities.Hangxe;
import poly.pro2112.entities.Hoadon;
import poly.pro2112.repository.HoadonRepository;
import poly.pro2112.vo.HangxeVO;
import poly.pro2112.vo.HoadonVO;

import java.util.List;
import java.util.Optional;

@Service
public class HoadonServiceImpl implements HoadonService{

    private HoadonMapper hoadonMapper = HoadonMapper.INSTANCE;

    @Autowired
    HoadonRepository hoadonRepository;

    @Override
    public HoadonVO saveOrUpdate(HoadonVO hoadonVO) {
        Hoadon hoadon = hoadonMapper.hoadonVOToHoadon(hoadonVO);
        hoadon = hoadonRepository.save(hoadon);
        hoadonVO.setId(hoadon.getId());
        return hoadonVO;
    }

    @Override
    public List<HoadonVO> getAllHoadon() {
        List<Hoadon> hoadons = hoadonRepository.findAll();
        List<HoadonVO> hoadonVOS = hoadonMapper.hoadonsToHoadonVOs(hoadons);
        return hoadonVOS;
    }

    @Override
    public HoadonVO getHoadonById(Integer id) {
        Optional<Hoadon> hoadon = hoadonRepository.findById(id);
        if(hoadon.isPresent()){
            return hoadonMapper.hoadonToHoadonVO(hoadon.get());
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
