package br.com.hmv.models.mappers;

import br.com.hmv.dtos.request.FuncionarioInsertRequestDTO;
import br.com.hmv.dtos.responses.FuncionarioDefaultResponseDTO;
import br.com.hmv.models.entities.Funcionario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = MapperConfig.class, componentModel = "spring")
public interface FuncionarioMapper {
    FuncionarioMapper INSTANCE = Mappers.getMapper(FuncionarioMapper.class);

    Funcionario deDtoParaFuncionario(FuncionarioInsertRequestDTO dto);

    FuncionarioDefaultResponseDTO deFuncionarioParaDto(Funcionario entity);
}
