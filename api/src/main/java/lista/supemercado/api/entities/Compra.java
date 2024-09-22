package lista.supemercado.api.entities;

import jakarta.persistence.*;
import lista.supemercado.api.dtos.CompraDto;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "COMPRAS")
public class Compra extends RepresentationModel<Compra> implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Pessoa pessoa;

    public Compra() {

    }

    public Compra(CompraDto compraDto) {
        this.pessoa = compraDto.pessoa();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
