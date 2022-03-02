package br.com.hmv.models.mappers;

import br.com.hmv.dtos.general.FuncionarioDTO;
import br.com.hmv.dtos.request.FuncionarioInsertRequestDTO;
import br.com.hmv.dtos.responses.FuncionarioDefaultResponseDTO;
import br.com.hmv.models.entities.Funcionario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(config = MapperConfig.class)
public interface FuncionarioMapper {
    FuncionarioMapper INSTANCE = Mappers.getMapper(FuncionarioMapper.class);

//    @Mapping(target = "id_funcionario", ignore = true)
//    @Mapping(target = "endereco", ignore = true)
//    @Mapping(target = "codigo_grupo_funcao", ignore = true)
//    @Mapping(target = "status", ignore = true)
//    @Mapping(target = "especialidades", ignore = true)
//    @Mapping(target = "telefones", ignore = true)
    Funcionario deDtoParaFuncionario(FuncionarioInsertRequestDTO dto);

    FuncionarioDefaultResponseDTO deFuncionarioParaDto(Funcionario entity);
}
