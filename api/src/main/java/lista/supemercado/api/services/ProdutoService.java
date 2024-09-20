package lista.supemercado.api.services;

import lista.supemercado.api.entities.Produto;
import lista.supemercado.api.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
//@RequiredArgsConstructor
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService (ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto save(final Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto update(final Produto produto) {
        final var update = produtoRepository.findById(produto.getId());
        if (update.isPresent()) {
            update.get().setId(produto.getId());
            update.get().setNome(produto.getNome());
            return produtoRepository.saveAndFlush(update.get());
        }
        throw new RuntimeException("Produto não existe");
    }

    public void delete(UUID id){
        produtoRepository.deleteById(id);
    }
}
