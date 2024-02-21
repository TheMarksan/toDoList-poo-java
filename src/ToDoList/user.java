package ToDoList;

public class user {
    String username;
    String senha = "123";

    public user(String username){
        this.username = username;
        this.senha = senha;
    }

    public String showUsername(){
        return this.username;
    }

    public String confirmarSenha(){
        return this.senha;
    }

}
