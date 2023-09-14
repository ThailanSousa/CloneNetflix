import main.java.model.entities.Cliente;
import main.java.model.entities.Filme;
import main.java.repositorio.ClienteRepositorio;
import main.java.repositorio.FilmeRepositorio;

public class app {

    public static void main(String[]args){

        ClienteRepositorio clienteRepo = new ClienteRepositorio();
        FilmeRepositorio    filmeRepo = new FilmeRepositorio();

        Filme filme = new Filme("O Poderoso Chefão", "Marcos Mion", 120, 2010, "Drama", "Conta a história de um Máfioso da Itália", false);

        //Cliente cliente = new Cliente("Thially", "01234567891");
        filmeRepo.cadastrarFilme(filme);
        System.out.println(filme);
        
        
        //clienteRepo.cadastrarCliente(cliente);

    }
    
}
