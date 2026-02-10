# Gerenciador de Tarefas

Este é um projeto Java simples para gerenciamento de tarefas, utilizando o paradigma de orientação a objetos. O sistema permite criar, listar, remover e gerenciar tarefas com diferentes prioridades.

## Funcionalidades
- Adicionar novas tarefas
- Listar tarefas existentes
- Remover tarefas
- Definir prioridade das tarefas

## Estrutura do Projeto
```
pom.xml
src/
  main/
    java/
      org/
        example/
          Main.java
          model/
            Prioridade.java
            Tarefa.java
          service/
            GerenciadorDeTarefas.java
    resources/
  test/
    java/
target/
```

- `Main.java`: Classe principal para execução do programa.
- `model/`: Contém as classes de domínio, como `Tarefa` e `Prioridade`.
- `service/`: Contém a classe de serviço `GerenciadorDeTarefas` responsável pela lógica de manipulação das tarefas.

## Pré-requisitos
- Java 17 ou superior
- Maven 3.6+

## Como executar
1. Clone o repositório:
   ```bash
   git clone https://github.com/rick1135/Gerenciador-de-Tarefas.git
   ```
2. Acesse a pasta do projeto:
   ```bash
   cd GerenciadordeTarefas
   ```
3. Compile o projeto com Maven:
   ```bash
   mvn clean package
   ```
4. Execute o programa:
   ```bash
   java -cp target/classes org.example.Main
   ```

