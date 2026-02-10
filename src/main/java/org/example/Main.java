package org.example;

import org.example.model.Prioridade;
import org.example.model.Tarefa;
import org.example.service.GerenciadorDeTarefas;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciadorDeTarefas gerenciador = new GerenciadorDeTarefas();
        Scanner sc = new Scanner(System.in);

        System.out.println("Carregando tarefas...");
        gerenciador.carregarTarefas();

        while (true) {
            System.out.println("\nSistema de tarefas");
            System.out.println("1.Adicionar tarefa");
            System.out.println("2.Listar tarefas");
            System.out.println("3.Listar tarefas por prioridade");
            System.out.println("4.Concluir tarefa");
            System.out.println("5.Salvar e sair");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao){
                case 1:
                    System.out.println("Informe a descrição: ");
                    String descricao = sc.nextLine();

                    System.out.println("Informe a prioridade (BAIXA, MEDIA, ALTA): ");
                    String prioridadeStr = sc.nextLine().toUpperCase();
                    Prioridade prioridade = Prioridade.valueOf(prioridadeStr);

                    System.out.println("Informe a data limite (AAAA-MM-DD): ");
                    String dataLimiteStr = sc.nextLine();
                    LocalDate dataLimite = LocalDate.parse(dataLimiteStr);

                    Tarefa novaTarefa = new Tarefa(descricao, prioridade, dataLimite);
                    gerenciador.adicionarTarefa(novaTarefa);
                    break;
                case 2:
                    gerenciador.listarTarefas();
                    break;
                case 3:
                    System.out.println("Informe a prioridade para filtrar (BAIXA, MEDIA, ALTA): ");
                    String prioridadeFiltro = sc.nextLine().toUpperCase();
                    gerenciador.listarPorPrioridade(Prioridade.valueOf(prioridadeFiltro));
                    break;
                case 4:
                    System.out.println("Informe o número da tarefa a ser concluída: ");
                    int idTarefa = sc.nextInt();
                    gerenciador.concluirTarefa(idTarefa);
                    break;
                case 5:
                    gerenciador.salvarTarefas();
                    System.out.println("Saindo...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}