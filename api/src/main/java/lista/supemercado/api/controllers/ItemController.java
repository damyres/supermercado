package lista.supemercado.api.controllers;

import lista.supemercado.api.entities.Item;
import lista.supemercado.api.entities.Produto;
import lista.supemercado.api.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/tb_item")
@RestController
@RequiredArgsConstructor
public class ItemController {
    private final ItemService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Item>> findAll() {
        final var list = service.findall();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity <Item> save(@RequestBody Item item){
        final var newItem = service.save(item);
        return ResponseEntity.ok().body(newItem);
    }

}
