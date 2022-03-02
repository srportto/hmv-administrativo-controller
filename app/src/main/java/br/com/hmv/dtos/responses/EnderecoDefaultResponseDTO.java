package br.com.hmv.dtos.responses;

import br.com.hmv.dtos.general.EnderecoDTO;
import br.com.hmv.models.entities.Endereco;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDefaultResponseDTO extends EnderecoDTO {
    private static final long serialVersionUID = 1L;

    @JsonProperty("codigo_endereco")
    private String codigoEndereco;

    private String descricao;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String cidade;
    private String uf;
    private Integer cep;

    //? construtor diferenciado - de entity para DTO
    public EnderecoDefaultResponseDTO(Endereco entity) {
        super(entity);
    }
}
