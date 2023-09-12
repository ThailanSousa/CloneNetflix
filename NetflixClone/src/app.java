import main.java.model.entities.Cliente;
import main.java.repositorio.ClienteRepositorio;

public class app {

    public static void main(String[]args){

        Cliente cliente = new Cliente("Marcelo Arruda", "08375188492");

        ClienteRepositorio clienteRepo = new ClienteRepositorio();
        
        clienteRepo.cadastrarCliente(cliente);

    }
    
}
