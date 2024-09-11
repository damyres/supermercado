package lista.supemercado.api.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Produto(){

    }
    public Produto(String nome){
        this.nome = nome;

    }

}
