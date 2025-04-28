package com.example.shoppinglist.model;

import jakarta.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer quantidade;
    private Integer ordem;
    private Boolean comprado = false;

    public Item() {}

    public Item(String nome, Integer quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.comprado = false;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }

    public Integer getOrdem() { return ordem; }
    public void setOrdem(Integer ordem) { this.ordem = ordem; }

    public Boolean getComprado() { return comprado; }
    public void setComprado(Boolean comprado) { this.comprado = comprado; }
}
