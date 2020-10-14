package poly.pro2112.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.pro2112.converter.BrandMapper;
import poly.pro2112.entities.Brand;
import poly.pro2112.repository.BrandRepository;
import poly.pro2112.vo.BrandVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandRepository brandRepo;
    private BrandMapper brandMapper = BrandMapper.INSTANCE;

    @Override
    public List<BrandVO> findAll() {
        List<Brand> brands = brandRepo.findAll();
        List<BrandVO> brandVOS = new ArrayList<>();
        for (Brand brand : brands){
            BrandVO brandVO = new BrandVO();
            brandVO.setId(brand.getId());
            brandVO.setBrand_name(brand.getBrand_name());
            brandVOS.add(brandVO);
        }
        return brandVOS;
    }

    @Override
    public BrandVO saveOrUpdate(BrandVO brandVO) {
        Brand brand = brandMapper.brandvoToBrand(brandVO);
        brand = brandRepo.save(brand);
        brandVO.setId(brand.getId());
        return brandVO;
    }

    @Override
    public void deleteById(Integer id) {
        brandRepo.deleteById(id);
    }

    @Override
    public BrandVO findById(Integer id) {
        Optional<Brand> brand = brandRepo.findById(id);
        if(brand.isPresent()){
            Brand brandOut =  brand.get();
            return brandMapper.brandToBrandVO(brandOut);
        }
        return null;
    }

    @Override
    public Brand findByNameBrand(String name) {
        return null;
    }
}
