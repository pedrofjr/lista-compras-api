# Shopping List API

API REST para gerenciar uma lista de compras. Desenvolvida em Java com Spring Boot.

## Funcionalidades
- Adicionar item à lista
- Listar todos os itens
- Atualizar item
- Remover item

## Como executar

1. Certifique-se de ter o Java 17+ e Maven instalados.
2. No terminal, execute:
   ```sh
   mvn spring-boot:run
   ```
3. Acesse a API em: http://localhost:8080

## Estrutura do Projeto
- `src/main/java/com/example/shoppinglist/`
  - `ShoppingListApplication.java` (classe principal)
  - `controller/ItemController.java`
  - `model/Item.java`
  - `repository/ItemRepository.java`
  - `service/ItemService.java`
- `src/main/resources/application.properties`
- `pom.xml`

## Exemplos de uso
- Listar itens: `GET /items`
- Adicionar item: `POST /items`
- Atualizar item: `PUT /items/{id}`
- Remover item: `DELETE /items/{id}`
