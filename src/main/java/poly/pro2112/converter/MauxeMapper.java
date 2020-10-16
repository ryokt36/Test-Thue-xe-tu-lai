package poly.pro2112.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import poly.pro2112.entities.Mauxe;
import poly.pro2112.vo.MauxeVO;

import java.util.List;

@Mapper
public interface MauxeMapper {
    MauxeMapper INSTANCE = Mappers.getMapper(MauxeMapper.class);

    Mauxe mauxeVOToMauxe(MauxeVO MauxeVO);

    MauxeVO mauxeToMauxeVO(Mauxe Mauxe);

    List<Mauxe> mauxeVOsToMauxes(List<MauxeVO> mauxeVOS);

    List<MauxeVO> toMauxeDtos(List<Mauxe> mauxes);
}
