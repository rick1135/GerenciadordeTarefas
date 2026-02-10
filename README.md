# Gerenciador de Tarefas

Este é um projeto Java simples para gerenciamento de tarefas, utilizando o paradigma de orientação a objetos. O sistema permite criar, listar, remover e gerenciar tarefas com diferentes prioridades, além de persistir os dados em arquivo CSV.

## Funcionalidades
- Adicionar novas tarefas
- Listar tarefas existentes
- Remover tarefas
- Definir prioridade das tarefas
- **Salvar tarefas em arquivo CSV**
- **Carregar tarefas automaticamente do arquivo CSV**

## Persistência de Dados

O sistema utiliza um arquivo CSV (`tarefas.csv`) para armazenar as tarefas de forma persistente. As funcionalidades incluem:

- **Salvamento Automático**: As tarefas são salvas em formato CSV com ponto e vírgula (`;`) como delimitador
- **Carregamento Automático**: Ao iniciar o programa, as tarefas são carregadas automaticamente do arquivo
- **Formato do arquivo**: Cada linha representa uma tarefa com os seguintes campos:
  ```
  Descrição;Prioridade;DataLimite;Concluída
  ```
  Exemplo:
  ```
  Estudar Java;ALTA;2026-02-15;false
  Fazer compras;BAIXA;2026-02-12;true
  ```

O arquivo `tarefas.csv` é criado automaticamente na raiz do projeto ao salvar as tarefas pela primeira vez.

## Estrutura do Projeto
```
pom.xml
tarefas.csv (gerado automaticamente)
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
- `service/`: Contém a classe de serviço `GerenciadorDeTarefas` responsável pela lógica de manipulação das tarefas e persistência.
- `tarefas.csv`: Arquivo de persistência das tarefas (gerado automaticamente).

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

## Observações
- As tarefas são automaticamente carregadas do arquivo `tarefas.csv` ao iniciar o programa
- Não esqueça de salvar as tarefas antes de fechar o programa para não perder suas alterações
- O arquivo CSV utiliza codificação UTF-8 e separador de ponto e vírgula (`;`)
