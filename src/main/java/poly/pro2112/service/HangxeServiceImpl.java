package poly.pro2112.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.pro2112.converter.HangxeMapper;
import poly.pro2112.entities.Hangxe;
import poly.pro2112.repository.HangxeRepository;
import poly.pro2112.vo.HangxeVO;

import java.util.List;
import java.util.Optional;

@Service
public class HangxeServiceImpl implements HangxeService{

    private HangxeMapper hangxeMapper = HangxeMapper.INSTANCE;

    @Autowired
    HangxeRepository hangxeRepository;

    @Override
    public HangxeVO saveOrUpdate(HangxeVO hangxeVO) {
        Hangxe hangxe = hangxeMapper.hangxeVOToHangxe(hangxeVO);
        hangxe = hangxeRepository.save(hangxe);
        hangxeVO.setId(hangxe.getId());
        return hangxeVO;
    }

    @Override
    public List<HangxeVO> getAllHangxe() {
        List<Hangxe> hangxes = hangxeRepository.findAll();
        List<HangxeVO> hangxeVOS = hangxeMapper.hangxesToHangxeVOs(hangxes);
        return hangxeVOS;
    }

    @Override
    public HangxeVO getHangxeById(Integer id) {
        Optional<Hangxe> hangxe = hangxeRepository.findById(id);
        if(hangxe.isPresent()){
            return hangxeMapper.hangxeToHangxeVO(hangxe.get());
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        try {
            hangxeRepository.deleteById(id);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
