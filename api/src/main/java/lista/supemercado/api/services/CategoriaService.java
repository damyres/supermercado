package lista.supemercado.api.services;

import jakarta.transaction.Transactional;
import lista.supemercado.api.dtos.CategoriaDto;
import lista.supemercado.api.entities.Categoria;
import lista.supemercado.api.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria save(final Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> findById(Integer id){
        return categoriaRepository.findById(id);

    }

    public Categoria update(final Categoria categoria) {
        final var update = categoriaRepository.findById(categoria.getId());
        if (update.isPresent()) {
            update.get().setNome(categoria.getNome());
        }
        return categoriaRepository.saveAndFlush(update.get());
    }

    public void delete(final Integer id) {
        categoriaRepository.deleteById(id);
    }

}
