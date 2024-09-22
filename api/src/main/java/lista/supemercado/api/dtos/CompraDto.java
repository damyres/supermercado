package lista.supemercado.api.dtos;

import jakarta.validation.constraints.NotBlank;
import lista.supemercado.api.entities.Pessoa;

import java.util.List;

public record CompraDto(List items, Pessoa pessoa) {

}
