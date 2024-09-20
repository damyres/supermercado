package lista.supemercado.api.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name= "TB_COMPRA")
public class Compra implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToMany
    @JoinTable(
            name="tb_compra_item",
            joinColumns = @JoinColumn(name = "compra_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> items;


    @ManyToOne
    private Pessoa pessoa;

    public Compra(){

    }

    public UUID getId(){
        return id;
    }

    public void setId(UUID id){
        this.id = id;
    }

    public List<Item> getItems(){
        return items;
    }

    public void setItems(List<Item> items){
        this.items = items;
    }

    public Pessoa getPessoa(){
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa){
        this.pessoa = pessoa;
    }
}
