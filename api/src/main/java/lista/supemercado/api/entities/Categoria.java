package lista.supemercado.api.entities;


import jakarta.persistence.*;
import lista.supemercado.api.dtos.CategoriaDto;

import java.io.Serializable;

@Entity
@Table(name = "CATEGORIAS")
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;

    public Categoria() {

    }
    public Categoria (CategoriaDto categoriaDto){
        this.nome = categoriaDto.nome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
