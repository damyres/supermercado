package lista.supemercado.api.services;

import lista.supemercado.api.entities.Categoria;
import lista.supemercado.api.repositories.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

//    public CategoriaService (CategoriaRepository categoriaRepository){
//        this.categoriaRepository = categoriaRepository;
//    }


    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }

    public Categoria save(final Categoria categoria){
        return categoriaRepository.save(categoria);
    }

}
