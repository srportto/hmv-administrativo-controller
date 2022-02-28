package br.com.hmv.dtos.request;

import br.com.hmv.services.validation.hospital.add_especialidade.HospitalAddEspecialidadeValid;
import br.com.hmv.services.validation.hospital.atualizacao_status.HospitalAtualizaStatusValid;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Data
@HospitalAddEspecialidadeValid
public class HospitalAddEspecialidadeRequestDTO {
    private static final long serialVersionUID = 1L;

    @NotNull( message = "Campo id_especialidade deve ser preenchido")
    @JsonProperty("id_especialidade")
    private Long idEspecialidade;
}