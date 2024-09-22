package lista.supemercado.api.dtos;

import lista.supemercado.api.entities.Item;
import lista.supemercado.api.entities.Pessoa;

import java.util.List;

public record ItemsCompraDto(List<Item> items, Pessoa pessoa) {
}
