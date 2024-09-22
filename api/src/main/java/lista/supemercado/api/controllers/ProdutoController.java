package lista.supemercado.api.controllers;

import lista.supemercado.api.entities.Produto;
import lista.supemercado.api.model.ObjectId;
import lista.supemercado.api.services.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Produto>> findAll() {
        final var list = produtoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Object> findById(@PathVariable (value = "id") UUID id){
        Optional<Produto> produtoById = produtoService.findById(id);
        if(produtoById.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(produtoById.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto not found");
    }


    @PostMapping("/inserir")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity <Produto> save(@RequestBody Produto produto){
        final var newProduto = produtoService.save(produto);
        return ResponseEntity.ok().body(newProduto);
    }

    @PutMapping("/atualizar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Produto> update(@RequestBody Produto produto){
        final var updateProduto = produtoService.update(produto);
        return ResponseEntity.ok().body(updateProduto);
    }

    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Produto> delete(@PathVariable UUID id){
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<ObjectId> deletar(@RequestBody ObjectId id){
        produtoService.delete(id.getId());
        return ResponseEntity.ok().build();
    }
}
