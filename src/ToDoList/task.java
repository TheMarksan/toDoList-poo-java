package ToDoList;

public class task {
    private String titulo;

    private String descricao;
    private String categoria;
    private boolean status;
    public task(String titulo, String descricao, String categoria){
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.status = false;
    }

    public String showTitulo(){
        return this.titulo;
    }
    public String showDescricao(){
        return this.descricao;
    }
    public String showCategoria(){
        return this.categoria;
    }
    public boolean showStatus(){
        return status;
    }

    public void marcarConcluida() {
        this.status = true;
    }
    public void desmarcarConcluida() {
        this.status = false;
    }
}
