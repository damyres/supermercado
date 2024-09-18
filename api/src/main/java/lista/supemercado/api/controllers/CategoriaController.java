package lista.supemercado.api.controllers;

import lista.supemercado.api.entities.Categoria;
import lista.supemercado.api.services.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tb_categoria")
@RequiredArgsConstructor
public class CategoriaController {
    private final CategoriaService categoriaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Categoria>> findAll(){
        final var list = categoriaService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Categoria> save(@RequestBody Categoria categoria){
        final var newCategoria = categoriaService.save(categoria);
        return ResponseEntity.ok().body(newCategoria);
    }
}
