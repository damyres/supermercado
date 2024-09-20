package lista.supemercado.api.entities;

import jakarta.persistence.*;
import lista.supemercado.api.dtos.PessoaDto;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_PESSOA")
public class Pessoa extends RepresentationModel<Pessoa> implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    public Pessoa(){

    }

    public Pessoa(PessoaDto pessoaDto){
        this.nome = pessoaDto.nome();
    }

    public UUID getId(){
        return id;
    }

    public void setId(UUID id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

}
