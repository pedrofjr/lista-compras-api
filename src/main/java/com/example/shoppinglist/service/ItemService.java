package com.example.shoppinglist.service;

import com.example.shoppinglist.model.Item;
import com.example.shoppinglist.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> listarTodos() {
        return itemRepository.findAll(Sort.by("ordem"));
    }

    public Optional<Item> buscarPorId(Long id) {
        return itemRepository.findById(id);
    }

    public Item salvar(Item item) {
        if (item.getId() == null) { // Novo item
            Integer maiorOrdem = itemRepository.findMaxOrdem();
            item.setOrdem(maiorOrdem == null ? 1 : maiorOrdem + 1);
        }
        return itemRepository.save(item);
    }

    public void deletar(Long id) {
        itemRepository.deleteById(id);
    }
}
