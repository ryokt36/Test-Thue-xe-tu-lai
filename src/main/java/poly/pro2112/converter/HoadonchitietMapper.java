package poly.pro2112.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import poly.pro2112.entities.Hoadonchitiet;
import poly.pro2112.vo.HoadonchitietVO;

import java.util.List;

@Mapper
public interface HoadonchitietMapper {

    HoadonchitietMapper INSTANCE = Mappers.getMapper(HoadonchitietMapper.class);

    Hoadonchitiet hoadonchitietVOToHoadonchitiet(HoadonchitietVO hoadonchitietVO);

    HoadonchitietVO hoadonchitietToHoadonchitietVO(Hoadonchitiet hoadonchitiet);

    List<Hoadonchitiet> hoadonchitietVOsToHoadonchitiets(List<HoadonchitietVO> hoadonchitietVO);

    List<HoadonchitietVO> hoadonchitietsToHoadonchitietVOs(List<Hoadonchitiet> hoadonchitiets);
}
