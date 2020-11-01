package poly.pro2112.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.pro2112.converter.HoadonchitietMapper;
import poly.pro2112.entities.Hoadonchitiet;
import poly.pro2112.repository.HoadonchitietRepository;
import poly.pro2112.vo.HoadonchitietVO;

import java.util.List;
import java.util.Optional;

@Service
public class HoadonchitietServiceImpl implements HoadonchitietService{

    private HoadonchitietMapper hoadonchitietMapper = HoadonchitietMapper.INSTANCE;

    @Autowired
    HoadonchitietRepository hoadonchitietRepository;
    @Override
    public HoadonchitietVO saveOrUpdate(HoadonchitietVO hoadonchitietVO) {
        Hoadonchitiet hoadonchitiet = hoadonchitietMapper.hoadonchitietVOToHoadonchitiet(hoadonchitietVO);
        hoadonchitiet = hoadonchitietRepository.save(hoadonchitiet);
        return hoadonchitietVO;
    }

    @Override
    public List<HoadonchitietVO> getAllHoadonchitiet() {
        List<Hoadonchitiet> hoadonchitiets = hoadonchitietRepository.findAll();
        List<HoadonchitietVO> hoadonchitietVOS = hoadonchitietMapper.hoadonchitietsToHoadonchitietVOs(hoadonchitiets);
        return hoadonchitietVOS;
    }

    @Override
    public HoadonchitietVO getHoadonchitietByPk(Hoadonchitiet.Pk pk) {
        Optional<Hoadonchitiet> hoadonchitiet = hoadonchitietRepository.findByPk(pk);
        if(hoadonchitiet.isPresent()){
            return hoadonchitietMapper.hoadonchitietToHoadonchitietVO(hoadonchitiet.get());
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
