package br.com.hmv.dtos.responses;

import br.com.hmv.dtos.general.EspecialidadeDTO;
import br.com.hmv.models.entities.Especialidade;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EspecialidadeDefaultResponseDTO extends EspecialidadeDTO {

    //Construtor diferenciado
    public EspecialidadeDefaultResponseDTO(Especialidade entity) {
        super(entity);
    }
}
