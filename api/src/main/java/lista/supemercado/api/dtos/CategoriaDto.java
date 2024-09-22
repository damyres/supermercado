package lista.supemercado.api.dtos;

import jakarta.validation.constraints.NotBlank;

public record CategoriaDto(@NotBlank String nome) {

}
