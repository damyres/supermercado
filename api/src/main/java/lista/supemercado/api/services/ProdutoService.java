package lista.supemercado.api.services;

import lista.supemercado.api.entities.Produto;
import lista.supemercado.api.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;

    public List<Produto> findAll(){
        return repository.findAll();
    }
}
