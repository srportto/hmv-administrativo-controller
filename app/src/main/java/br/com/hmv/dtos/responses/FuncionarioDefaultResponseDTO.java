package br.com.hmv.dtos.responses;

import br.com.hmv.dtos.general.EspecialidadeDTO;
import br.com.hmv.dtos.general.FuncionarioDTO;
import br.com.hmv.dtos.general.TelefoneDTO;
import br.com.hmv.dtos.request.EnderecoInsertRequestDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
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

    private EnderecoDefaultResponseDTO endereco;

    @JsonProperty("codigo_grupo_funcao")
    private Long codigoGrupoFuncao;

    Set<EspecialidadeDTO> especialidades = new HashSet<>();

    Set<TelefoneDTO> telefones = new HashSet<>();
}