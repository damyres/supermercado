package lista.supemercado.api.model;

import java.io.Serializable;
import java.util.UUID;


public class ObjectId implements Serializable {

    private UUID id;

    public UUID getId(){
        return id;
    }

    public void setId(UUID id){
        this.id = id;
    }
}
