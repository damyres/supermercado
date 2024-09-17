package lista.supemercado.api.services;

import lista.supemercado.api.entities.Produto;
import lista.supemercado.api.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;

    public List<Produto> findAll() {
        return repository.findAll();
    }

    public Produto save(final Produto produto) {
        return repository.save(produto);
    }

    public Produto update(final Produto produto) {
        final var update = repository.findById(produto.getId());
        if (update.isPresent()) {
            update.get().setId(produto.getId());
            update.get().setNome(produto.getNome());
            return repository.saveAndFlush(update.get());
        }
        throw new RuntimeException("Produto não existe");
    }

    public void delete(UUID id){
       repository.deleteById(id);
    }
}
