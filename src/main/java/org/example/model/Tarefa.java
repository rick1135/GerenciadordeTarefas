package org.example.model;

import java.time.LocalDate;

public class Tarefa {
    private String descricao;
    private boolean concluida;
    private Prioridade prioridade;
    private LocalDate dataLimite;

    public Tarefa(String descricao, Prioridade prioridade, LocalDate dataLimite) {
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.dataLimite = dataLimite;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public LocalDate getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(LocalDate dataLimite) {
        this.dataLimite = dataLimite;
    }

    @Override
    public String toString() {
        String marcador = concluida ? "[X]" : "[ ]";
        String dataStr = dataLimite != null ? dataLimite.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "";
        return marcador + " " + descricao + " - " + prioridade + " - " + dataStr;
    }

}
