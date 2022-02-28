package br.com.hmv.dtos.general;

import br.com.hmv.models.entities.Especialidade;
import br.com.hmv.models.enums.StatusEspecialidadeEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EspecialidadeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    @JsonProperty("status")
    private StatusEspecialidadeEnum statusEspecialidade;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    //? construtor diferenciado - de entity para DTO
    public EspecialidadeDTO(Especialidade entity) {
        id = entity.getId();
        nome = entity.getNome();
        statusEspecialidade = StatusEspecialidadeEnum.obterStatusEspecialidade(entity.getCodigoStatusEspecialidade());
        dataCriacao = entity.getDataCriacao();
        dataAtualizacao = entity.getDataAtualizacao();
    }
}
