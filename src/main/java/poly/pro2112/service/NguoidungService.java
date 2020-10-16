package poly.pro2112.service;


import poly.pro2112.entities.Nguoidung;

import java.util.List;

public interface NguoidungService {
    Nguoidung saveOrUpdate(Nguoidung Nguoidung);
    List<Nguoidung> getAllNguoidung();
    Nguoidung getNguoidungById(Integer id);
    void deleteById(Integer id);
}
