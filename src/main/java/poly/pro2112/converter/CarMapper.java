package poly.pro2112.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import poly.pro2112.entities.*;
import poly.pro2112.vo.*;

import java.util.List;

@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    List<CarVO> toCarDtos(List<Car> cars);

    List<Car> toCar(List<CarVO> carvos);

    CarVO carToCarVO(Car car);

    Car toCarCreateOrUpdate(CarVO carvo);

    RegisterVO registerToRegisterVO(Register register);

    Register registerVOToRegister(RegisterVO registervo);

    RegistryVO registryToRegistryVO(Registry registry);

    Registry registryVOToRegistry(RegistryVO registryvo);

    ModelVO modelToModelVO(Model model);

    Model modelVOToModel(ModelVO modelVO);

    List<ContractVO> toContractDtos(List<Contract> contracts);

    List<Contract> toContract(List<ContractVO> contractVOS);

    List<FeatureVO> toFeatureDtos(List<Feature> features);

    List<Feature> toFeature(List<FeatureVO> featureVOS);

    FeatureVO featureToFeatureVO(Feature feature);

    Feature featureVOToFeature(FeatureVO featureVO);

    List<InvoiceVO> toInvoiceDtos(List<Invoice> invoices);

    List<Invoice> toInvoice(List<InvoiceVO> invoiceVOS);
}
