package poly.pro2112.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import poly.pro2112.entities.Hangxe;
import poly.pro2112.vo.HangxeVO;

import java.util.List;

@Mapper
public interface HangxeMapper {
    HangxeMapper INSTANCE = Mappers.getMapper(HangxeMapper.class);

    Hangxe hangxeVOToHangxe(HangxeVO hangxeVO);

    HangxeVO hangxeToHangxeVO(Hangxe hangxe);

    List<Hangxe> hangxeVOsToHangxes(List<HangxeVO> hangxeVO);

    List<HangxeVO> hangxesToHangxeVOs(List<Hangxe> hangxes);
}
