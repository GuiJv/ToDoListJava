package models;

public class TaskModel {
    private int id;
    private String tarefa;
    private String tipo;
    private boolean feita;

    public TaskModel(int id, String tarefa, String tipo, boolean feita) {
        this.id = id;
        this.tarefa = tarefa;
        this.tipo = tipo;
        this.feita = feita;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isFeita() {
        return feita;
    }

    public void setFeita(boolean feita) {
        this.feita = feita;
    }
}