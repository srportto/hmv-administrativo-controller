package br.com.hmv.dtos.responses;

import br.com.hmv.dtos.general.EspecialidadeDTO;
import br.com.hmv.dtos.general.FuncionarioDTO;
import br.com.hmv.dtos.general.TelefoneDTO;
import br.com.hmv.dtos.request.EnderecoInsertRequestDTO;
import br.com.hmv.models.entities.Especialidade;
import br.com.hmv.models.entities.Funcionario;
import br.com.hmv.models.entities.Telefone;
import br.com.hmv.services.validation.hospital.criacao.HospitalInsertValid;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
@HospitalInsertValid
public class FuncionarioDefaultResponseDTO extends FuncionarioDTO {

    @JsonProperty("email")
    private String email;

    @JsonIgnoreProperties
    private String senha;

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("crm")
    private String crm;

    @JsonProperty("primeiro_nome")
    private String primeiroNome;

    @JsonProperty("nome_completo")
    private String nomeCompleto;

    @JsonProperty("data_nascimento")
    private LocalDate dataNascimento;

    private EnderecoInsertRequestDTO endereco;

    @JsonProperty("codigo_grupo_funcao")
    private Long codigoGrupoFuncao;

    Set<EspecialidadeDTO> especialidades = new HashSet<>();

    Set<TelefoneDTO> telefones = new HashSet<>();

    public FuncionarioDefaultResponseDTO(Funcionario entity) {
        super(entity);
    }

    public FuncionarioDefaultResponseDTO(Funcionario entity, Set<Especialidade> especialidades, Set<Telefone> telefones) {
        super(entity, especialidades, telefones);
    }
}