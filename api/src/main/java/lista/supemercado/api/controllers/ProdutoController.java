package lista.supemercado.api.controllers;

import lista.supemercado.api.entities.Produto;
import lista.supemercado.api.services.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tb_produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Produto>> findAll() {
        final var list = service.findAll();
        return ResponseEntity.ok().body(list);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity <Produto> save(@RequestBody Produto produto){
        final var newProduto = service.save(produto);
        return ResponseEntity.ok().body(newProduto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Produto> update(@RequestBody Produto produto){
        final var updateProduto = service.update(produto);
        return ResponseEntity.ok().body(updateProduto);
    }
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> delete(@RequestBody Produto produto){
        service.delete(produto.getId());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity <Void> deleteById(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
