package br.com.hmv.models.mappers;

import br.com.hmv.dtos.request.FuncionarioInsertRequestDTO;
import br.com.hmv.dtos.responses.FuncionarioDefaultResponseDTO;
import br.com.hmv.dtos.responses.FuncionarioForListResponseDTO;
import br.com.hmv.models.entities.Funcionario;
import br.com.hmv.models.enums.GrupoFuncaoFuncionarioEnum;
import br.com.hmv.models.enums.StatusFuncionarioEnum;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(config = MapperConfig.class, componentModel = "spring")
public interface FuncionarioMapper {
    FuncionarioMapper INSTANCE = Mappers.getMapper(FuncionarioMapper.class);

    Funcionario deDtoParaFuncionario(FuncionarioInsertRequestDTO dto);

    FuncionarioDefaultResponseDTO deFuncionarioParaDto(Funcionario entity);

    @BeforeMapping
    default void preparaAntesDeMapearEntityParaListDto(Funcionario entity, @MappingTarget FuncionarioForListResponseDTO dto) {
        dto.setStatusFuncionario(StatusFuncionarioEnum.obterStatusConvenio(entity.getCodigoStatusFuncionario()));
        dto.setGrupoFuncaoFuncionario(GrupoFuncaoFuncionarioEnum.obterGrupoFuncaoFuncionario(entity.getCodigoGrupoFuncao()));
    }

    FuncionarioForListResponseDTO deEntityParaRespresentacaoEmLista(Funcionario entity);
}
