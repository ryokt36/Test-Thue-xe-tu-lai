package poly.pro2112.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.pro2112.converter.HangxeMapper;
import poly.pro2112.converter.MauxeMapper;
import poly.pro2112.entities.Mauxe;
import poly.pro2112.repository.MauxeRepository;
import poly.pro2112.vo.MauxeVO;

import java.util.List;
import java.util.Optional;

@Service
public class MauxeServiceImpl implements MauxeService{

    private MauxeMapper mauxeMapper = MauxeMapper.INSTANCE;

    @Autowired
    MauxeRepository mauxeRepository;

    @Override
    public MauxeVO saveOrUpdate(MauxeVO mauxeVO) {
        Mauxe mauxe = mauxeRepository.save(mauxeMapper.mauxeVOToMauxe(mauxeVO));
        mauxeVO.setId(mauxe.getId());
        return mauxeVO;
    }

    @Override
    public List<MauxeVO> getAllMauxe() {
        List<Mauxe> mauxes = mauxeRepository.findAll();
        List<MauxeVO> mauxeVOS = mauxeMapper.toMauxeDtos(mauxes);
        return mauxeVOS;
    }

    @Override
    public MauxeVO getMauxeById(Integer id) {
        Optional<Mauxe> mauxe = mauxeRepository.findById(id);
        if(mauxe.isPresent()){
            return mauxeMapper.mauxeToMauxeVO(mauxe.get());
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        try {
            mauxeRepository.deleteById(id);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
