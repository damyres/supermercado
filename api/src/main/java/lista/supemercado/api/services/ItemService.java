package lista.supemercado.api.services;

import lista.supemercado.api.entities.Item;
import lista.supemercado.api.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository repository;

    public List<Item> findall() {
        return repository.findAll();

    }

}
