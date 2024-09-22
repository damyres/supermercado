package lista.supemercado.api.controllers;

import lista.supemercado.api.dtos.CompraDto;
import lista.supemercado.api.dtos.ItemsCompraDto;
import lista.supemercado.api.entities.Compra;
import lista.supemercado.api.services.CompraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/compra")
public class CompraController {
    private final CompraService compraService;
    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping("/inserir")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Compra> save(@RequestBody ItemsCompraDto itemsCompraDto){
        final var newCompra = compraService.save(itemsCompraDto);
        return ResponseEntity.ok().body(newCompra);
    }

    //USO de DTO
//    @PostMapping("/inserir")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<CompraDto> save(@RequestBody CompraDto compraDto){
//        final var newCompra = compraService.save(compraDto);
//        return ResponseEntity.ok().body(newCompra);
//    }

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Compra>> findAll() {
        List<Compra> list = compraService.findAll();
        if (!list.isEmpty()) {
            for (Compra compra : list) {
                UUID id = compra.getId();
                compra.add(linkTo(methodOn(CompraController.class).findAll()).withSelfRel());
            }
        }
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Object> findById(@PathVariable (value = "id") UUID id){
        Optional<Compra> compraById = compraService.findById(id);
        if(compraById.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(compraById.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Compra not found");
    }

    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Compra> delete(@PathVariable UUID id){
        compraService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
