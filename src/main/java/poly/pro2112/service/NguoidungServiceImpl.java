package poly.pro2112.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.pro2112.entities.Nguoidung;
import poly.pro2112.repository.NguoidungRepository;

import java.util.List;

@Service
public class NguoidungServiceImpl implements NguoidungService{
    @Autowired
    NguoidungRepository nguoidungRepository;

    @Override
    public Nguoidung saveOrUpdate(Nguoidung Nguoidung) {
        return null;
    }

    @Override
    public List<Nguoidung> getAllNguoidung() {
        return nguoidungRepository.findAll();
    }

    @Override
    public Nguoidung getNguoidungById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
