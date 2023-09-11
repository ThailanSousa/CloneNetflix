import main.java.model.entities.Pessoa;

public class app {

    public static void main(String[]args){

        Pessoa thailan = new Pessoa();

        thailan.setName("thailan");
        thailan.setEmail("Thailan@gmail.com");
        thailan.setSenha("123456");

        new Pessoa().cadastrarUsuario(thailan);
        


    }
    
}
