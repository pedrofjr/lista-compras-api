package com.example.shoppinglist.controller;

import com.example.shoppinglist.model.Item;
import com.example.shoppinglist.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> listarTodos() {
        return itemService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> buscarPorId(@PathVariable Long id) {
        Optional<Item> item = itemService.buscarPorId(id);
        return item.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Item adicionar(@RequestBody Item item) {
        return itemService.salvar(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> atualizar(@PathVariable Long id, @RequestBody Item itemAtualizado) {
        Optional<Item> itemExistente = itemService.buscarPorId(id);
        if (itemExistente.isPresent()) {
            Item item = itemExistente.get();
            item.setNome(itemAtualizado.getNome());
            item.setQuantidade(itemAtualizado.getQuantidade());
            item.setComprado(itemAtualizado.getComprado());
            return ResponseEntity.ok(itemService.salvar(item));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (itemService.buscarPorId(id).isPresent()) {
            itemService.deletar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
