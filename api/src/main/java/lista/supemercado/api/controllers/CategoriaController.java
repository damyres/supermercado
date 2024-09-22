package lista.supemercado.api.controllers;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import lista.supemercado.api.entities.Categoria;
import lista.supemercado.api.services.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class CategoriaController {
    private final CategoriaService categoriaService;

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Categoria>> findAll(){
        final var list = categoriaService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Object> findById(@PathVariable (value = "id") Integer id){
        Optional<Categoria> categoriaById = categoriaService.findById(id);
        if(categoriaById.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(categoriaById.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria not found");
    }

    @PostMapping("/inserir")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Categoria> save(@RequestBody  @Valid Categoria categoria){
        final var newCategoria = categoriaService.save(categoria);
        return ResponseEntity.ok().body(newCategoria);
    }

    @PutMapping("atualizar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Categoria> update(@RequestBody Categoria categoria){
        final var updateCategoria = categoriaService.update(categoria);
        return ResponseEntity.ok().body(updateCategoria);
    }

    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Categoria> delete(@PathVariable Integer id){
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
