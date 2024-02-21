package ToDoList;
import javax.swing.undo.UndoableEditSupport;
import java.util.ArrayList;
import java.util.Scanner;
public class main{
    private static ArrayList<task> tarefas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao;

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        user Usuario = new user(nome);

        if(!senha.equals(Usuario.confirmarSenha())){
            while(!senha.equals(Usuario.confirmarSenha())){
                System.out.println("Senha inválida! Tente novamente: ");
                senha = scanner.nextLine();
            }
        }
        do {
            System.out.println("\nSeja bem-vindo(a) de volta, "+Usuario.showUsername());
            System.out.println();
            System.out.println("===== Todo List =====");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Marcar Tarefa como Concluída");
            System.out.println("4. Desmarcar Tarefa");
            System.out.println("5. Filtrar por Categoria");
            System.out.println("6. Deletar Tarefa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    addTarefa();
                    break;
                case 2:
                    listarTarefas();
                    break;
                case 3:
                    //marcarTarefa();
                    break;
                case 4:
                    //desmarcarTarefa();
                    break;
                case 5:
                    //filtrarTarefa();
                    break;
                case 6:
                    removerTarefa();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);




    }
    private static void addTarefa() {
        scanner.nextLine();
        System.out.print("Digite o título da tarefa: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite a descrição da tarefa: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite a categoria da tarefa: ");
        String categoria = scanner.nextLine();
        task tarefa = new task(titulo, descricao, categoria);
        tarefas.add(tarefa);
        System.out.println("\nTarefa adicionada com sucesso!");
    }
    private static void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("\nNão há tarefas na lista.");
        } else {
            System.out.println("\n===== Lista de Tarefas =====");
            for (int i = 0; i < tarefas.size(); i++) {
                task tarefa = tarefas.get(i);
                String status = tarefa.showStatus() ? "[Concluída]" : "[Pendente]";
                System.out.println((i + 1) + ". "+tarefa.showTitulo() + "\n - Descrição: " + tarefa.showDescricao() + "\n - Categoria: " + tarefa.showCategoria() + "\n - Satus: "+status+"\n");
            }
        }
    }

    private static void removerTarefa(){
        if(tarefas.isEmpty()){
            System.out.println("Não há tarefas na Lista.");
        }else{
            for (int i = 0; i < tarefas.size(); i++) {
                task tarefa = tarefas.get(i);
                System.out.println((i + 1) + ". " + tarefa.showTitulo());
            }
            System.out.println("Qual tarefa deseja remover? (1-"+tarefas.size()+")");
            int index = scanner.nextInt();
            tarefas.remove(index-1);
            System.out.println("\nTarefa removida com sucesso!");
        }
    }
    //private static void marcarTarefa(){} - chamar método marcarConcluida() de uma instancia da classe task da lista
    //private static void desmarcarTarefa(){} - chamar método desmarcarConcluida() de uma instancia da classe task da lista
    //private static void filtrarTarefa(){} - peça do usuário uma string e compare com a categoria da instancia tarefa no index atual da lista (metódo showCategoria()) e imprima a instancia listada

}


