package lista.supemercado.api.services;

import lista.supemercado.api.entities.Item;
import lista.supemercado.api.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class ItemService {

    private ItemRepository itemRepository;

    public void setItemRepository (ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public List<Item> findall() {
        return itemRepository.findAll();
    }

    public Item save(final Item item){
        return itemRepository.save(item);
    }

}
