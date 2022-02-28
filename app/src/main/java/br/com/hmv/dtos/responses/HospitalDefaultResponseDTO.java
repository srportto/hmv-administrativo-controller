package br.com.hmv.dtos.responses;

import br.com.hmv.dtos.general.HospitalDTO;
import br.com.hmv.models.entities.Especialidade;
import br.com.hmv.models.entities.Hospital;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class HospitalDefaultResponseDTO extends HospitalDTO {

    //Construtor diferenciado
    public HospitalDefaultResponseDTO(Hospital entity) {
        super(entity);
    }

    public HospitalDefaultResponseDTO(Hospital entity, Set<Especialidade> especialidades) {
        super(entity, especialidades);
    }
}
