package lista.supemercado.api.services;

import lista.supemercado.api.dtos.CompraDto;
import lista.supemercado.api.dtos.ItemsCompraDto;
import lista.supemercado.api.entities.Compra;
import lista.supemercado.api.repositories.CompraRepository;
import lista.supemercado.api.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CompraService {
    private final CompraRepository compraRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public CompraService(CompraRepository compraRepository, ItemRepository itemRepository) {
        this.compraRepository = compraRepository;
        this.itemRepository = itemRepository;
    }

    public Compra save(final ItemsCompraDto itemsCompraDto) {
        final var compra = new Compra();
        compra.setPessoa(itemsCompraDto.pessoa());
        final var newCompra = compraRepository.save(compra);
        itemsCompraDto.items().stream().forEach(item -> {
            item.setCompra(newCompra);
            itemRepository.save(item);
        });
        return newCompra;
    }

    public List<Compra> findAll() {
        return compraRepository.findAll();
    }

    //USO de DTO
//    public CompraDto findByIdDto(UUID id) {
//        Optional<Compra> compra = compraRepository.findById(id);
//
//        if (compra.isPresent()) {
//            return new CompraDto(compra.get().getItems(), compra.get().getPessoa());
//        } else {
//            throw new RuntimeException("Produto não encontrado para o id");
//        }
//    }

    public Optional<Compra> findById(final UUID id) {
        return compraRepository.findById(id);
    }

//    public CompraDto save(final CompraDto compraDto){
//        //TODO converter o DTO para um objeto compra
//
//        //TODO salvar o objeto compra
//
//        //TODO converter o objeto compra para DTO e retornar
//
//    }

    //USO de DTO
//    public CompraDto save(final CompraDto compraDto) {
//        final var compra = new Compra(compraDto);
//        final var newCompra = compraRepository.save(compra);
//        return new CompraDto(newCompra.getItems(), newCompra.getPessoa());
//    }
    public void delete(final UUID id) {
        compraRepository.deleteById(id);
    }

}
