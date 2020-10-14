package poly.pro2112.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import poly.pro2112.entities.Brand;
import poly.pro2112.vo.BrandVO;

@Mapper
public interface BrandMapper {
    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);

    Brand brandvoToBrand(BrandVO brandVO);

    BrandVO brandToBrandVO(Brand model);
}
