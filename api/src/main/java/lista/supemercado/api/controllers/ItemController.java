package lista.supemercado.api.controllers;

import lista.supemercado.api.entities.Item;
import lista.supemercado.api.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @PostMapping("/inserir")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity <Item> save(@RequestBody Item item){
        final var newItem = itemService.save(item);
        return ResponseEntity.ok().body(newItem);
    }

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Item>> findAll() {
        final var list = itemService.findall();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Object> findById(@PathVariable (value = "id") Long id){
        Optional<Item> itemById = itemService.findById(id);
        if(itemById.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa not found");
        }
        itemById.get().add(linkTo(methodOn(ItemController.class).findAll()).withRel("List pessoa"));
        return ResponseEntity.status(HttpStatus.OK).body(itemById.get());
    }

    @PutMapping("atualizar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Item> update(@RequestBody Item item){
        final var updateItem = itemService.update(item);
        return ResponseEntity.ok().body(updateItem);
    }

    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Item> delete(@PathVariable Long id){
        itemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
