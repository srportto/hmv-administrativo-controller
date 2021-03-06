package br.com.hmv.dtos.request;

import br.com.hmv.models.enums.StatusEspecialidadeEnum;
import br.com.hmv.services.validation.convenio.atualizacao_status.ConvenioAtualizaStatusValid;
import br.com.hmv.services.validation.especialidade.atualizacao_status.EspecialidadeAtualizaStatusValid;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Data
@EspecialidadeAtualizaStatusValid
public class EspecialidadeAtualizaStatusRequestDTO {
    private static final long serialVersionUID = 1L;

    @NotNull( message = "Campo status deve ser preenchido")
    @JsonProperty("status")
    private StatusEspecialidadeEnum statusEspecialidade;
}