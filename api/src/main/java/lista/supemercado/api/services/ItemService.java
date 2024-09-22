package lista.supemercado.api.services;

import lista.supemercado.api.entities.Item;
import lista.supemercado.api.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public void setItemRepository (ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public List<Item> findall() {
        return itemRepository.findAll();
    }

    public Optional<Item> findById(Long id){
        return itemRepository.findById(id);
    }

    public Item save(final Item item){
        return itemRepository.save(item);
    }

    public Item update (final Item item){
        final var update = itemRepository.findById(item.getId());
        if(update.isPresent()){
            update.get().setProduto(item.getProduto());
            update.get().setQuantidade(item.getQuantidade());
        }
        return itemRepository.saveAndFlush(update.get());
    }

    public void delete(final Long id){
        itemRepository.deleteById(id);
    }
}
