package poly.pro2112.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import poly.pro2112.entities.Xe;
import poly.pro2112.vo.XeVO;

import java.util.List;

@Mapper
public interface XeMapper {
    XeMapper INSTANCE = Mappers.getMapper(XeMapper.class);

    Xe xeVOToXe(XeVO xeVO);

    XeVO xeToXeVO(Xe xe);

    List<Xe> xeVOsToXes(List<XeVO> xeVO);

    List<XeVO> xesToXeVOs(List<Xe> xes);
}
