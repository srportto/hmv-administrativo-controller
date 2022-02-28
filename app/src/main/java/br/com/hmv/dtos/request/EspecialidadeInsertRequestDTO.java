package br.com.hmv.dtos.request;

import br.com.hmv.dtos.general.EspecialidadeDTO;
import br.com.hmv.services.validation.especialidade.criacao.EspecialidadeInsertValid;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Data
@EspecialidadeInsertValid
public class EspecialidadeInsertRequestDTO extends EspecialidadeDTO {

    @NotBlank(message = "Campo nome deve ser preenchido")
    private String nome;
}