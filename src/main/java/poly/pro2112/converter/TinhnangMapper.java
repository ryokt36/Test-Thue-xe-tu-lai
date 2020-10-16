package poly.pro2112.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import poly.pro2112.entities.Tinhnang;
import poly.pro2112.vo.TinhnangVO;

import java.util.List;

@Mapper
public interface TinhnangMapper {
    TinhnangMapper INSTANCE = Mappers.getMapper(TinhnangMapper.class);

    Tinhnang tinhnangVOTotinhnang(TinhnangVO tinhnangVO);

    TinhnangVO tinhnangTotinhnangVO(Tinhnang tinhnang);

    List<Tinhnang> tinhnangVOsTotinhnangs(List<TinhnangVO> tinhnangVO);

    List<TinhnangVO> tinhnangsTotinhnangVOs(List<Tinhnang> tinhnangs);
}
