package org.example.service;

import org.example.model.Prioridade;
import org.example.model.Tarefa;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeTarefas {
    private List<Tarefa> tarefas = new ArrayList<>();
    private final Path caminhoArquivo = Path.of("tarefas.csv");

    public void adicionarTarefa(Tarefa tarefa){
        tarefas.add(tarefa);
    }

    public void listarTarefas(){
        if(tarefas.isEmpty()) System.out.println("Nenhuma tarefa cadastrada.");
        else for (Tarefa tarefa : tarefas) System.out.println(tarefa);
    }

    public void listarPorPrioridade(Prioridade prioridade){
        tarefas.stream()
                .filter(t -> t.getPrioridade() == prioridade)
                .forEach(System.out::println);
    }

    public void concluirTarefa(int id){
        if(id<tarefas.size() && id>=0){
            tarefas.get(id).setConcluida(true);
            System.out.println("Tarefa " + id + " concluída.");
        } else System.out.println("ID inválido.");
    }

    public void salvarTarefas() {
        List<String> linhas = new ArrayList<>();
        for (Tarefa tarefa : tarefas) {
            String linha = String.format("%s;%s;%s;%b",
                    tarefa.getDescricao(),
                    tarefa.getPrioridade(),
                    tarefa.getDataLimite(),
                    tarefa.isConcluida());
            linhas.add(linha);
        }

        try{
            Files.write(caminhoArquivo, linhas);
            System.out.printf("Tarefas salvas com sucesso!\n");
        } catch (IOException e){
            System.out.printf("Erro ao salvar tarefas: %s", e.getMessage());
        }
    }

    public void carregarTarefas() {
        if(!Files.exists(caminhoArquivo)) return;

        try{
            List<String> linhas = Files.readAllLines(caminhoArquivo);
            tarefas.clear();

            for (String linha : linhas) {
                String[] partes = linha.split(";");
                if(partes.length == 4){
                    Tarefa tarefa = new Tarefa(
                            partes[0],
                            Prioridade.valueOf(partes[1]),
                            java.time.LocalDate.parse(partes[2]));
                    tarefa.setConcluida(Boolean.parseBoolean(partes[3]));
                    tarefas.add(tarefa);
                }
            }
        } catch (IOException e){
            System.out.printf("Erro ao carregar tarefas: %s", e.getMessage());
        }
    }
}
