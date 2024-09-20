package lista.supemercado.api.dtos;

import jakarta.validation.constraints.NotBlank;

public record PessoaDto(@NotBlank String nome) {

}
