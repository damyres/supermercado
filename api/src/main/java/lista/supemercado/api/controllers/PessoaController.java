package lista.supemercado.api.controllers;

import jakarta.validation.Valid;
import lista.supemercado.api.dtos.PessoaDto;
import lista.supemercado.api.entities.Pessoa;
import lista.supemercado.api.services.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/tb_pessoa")
public class PessoaController {
    private final PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService){
        this.pessoaService = pessoaService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Pessoa>> findAll() {
        final var list = pessoaService.findAll();
        if(!list.isEmpty()){
            for(Pessoa pessoa: list){
                UUID id = pessoa.getId();
                pessoa.add(linkTo(methodOn(PessoaController.class).getOnePessoa(id)).withSelfRel());
            }
        }
        return ResponseEntity.ok().body(list);
    }

//    @PostMapping
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa) {
//        final var newPessoa = pessoaService.save(pessoa);
//        return ResponseEntity.ok().body(newPessoa);
//    }

    //ultilizando o DTO
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Pessoa> save(@RequestBody @Valid PessoaDto pessoaDto){
        final var newPessoa = pessoaService.save(pessoaDto);
        return ResponseEntity.ok().body(newPessoa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePessoa(@PathVariable(value = "id") UUID id){
        Optional<Pessoa> pessoa = pessoaService.findById(id);
        if(pessoa.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa not found");
        }
        pessoa.get().add(linkTo(methodOn(PessoaController.class).findAll()).withRel("List pessoa"));
        return ResponseEntity.status(HttpStatus.OK).body(pessoa.get());
    }

}
