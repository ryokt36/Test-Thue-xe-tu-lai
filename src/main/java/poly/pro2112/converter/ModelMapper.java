package poly.pro2112.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import poly.pro2112.entities.Brand;
import poly.pro2112.entities.Model;
import poly.pro2112.vo.BrandVO;
import poly.pro2112.vo.ModelVO;

import java.util.List;

@Mapper
public interface ModelMapper {
    ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);

    List<ModelVO> toModelDtos(List<Model> models);

    List<Model> toModel(List<ModelVO> modelVOS);

    Model modelvoToModel(ModelVO modelVO);

    ModelVO modelToModelVO(Model model);

    List<BrandVO> toBrandDtos(List<Brand> brands);

    List<Brand> toBrand(List<BrandVO> brandVOS);
}
