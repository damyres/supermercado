package lista.supemercado.api.controllers;

import lista.supemercado.api.entities.Item;
import lista.supemercado.api.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequestMapping("/itens")
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

}
