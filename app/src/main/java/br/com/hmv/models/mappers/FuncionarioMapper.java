package br.com.hmv.models.mappers;

import br.com.hmv.dtos.general.FuncionarioDTO;
import br.com.hmv.dtos.request.FuncionarioInsertRequestDTO;
import br.com.hmv.models.entities.Funcionario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class FuncionarioMapper {
    public static final FuncionarioMapper INSTANCE = Mappers.getMapper(FuncionarioMapper.class);

    public abstract Funcionario deDtoParaFuncionario(FuncionarioInsertRequestDTO dto);

    public abstract FuncionarioDTO deFuncionarioParaDto(Funcionario entity);
}
