package poly.pro2112.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import poly.pro2112.entities.Hoadon;
import poly.pro2112.vo.HoadonVO;

import java.util.List;

@Mapper
public interface HoadonMapper {
    HoadonMapper INSTANCE = Mappers.getMapper(HoadonMapper.class);

    Hoadon hoadonVOToHoadon(HoadonVO hoadonVO);

    HoadonVO hoadonToHoadonVO(Hoadon hoadon);

    List<Hoadon> hoadonVOsToHoadons(List<HoadonVO> hoadonVO);

    List<HoadonVO> hoadonsToHoadonVOs(List<Hoadon> hoadons);
}
