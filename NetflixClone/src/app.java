import java.util.Scanner;

import main.java.model.entities.Cliente;
import main.java.repositorio.ClienteRepositorio;

public class app {

    public static void main(String[] args) {

        Scanner inputCad = new Scanner(System.in);

        Cliente cliente = new Cliente(null, null);

        System.out.println("Digite seu nome:");
        cliente.setName(inputCad.nextLine());
        System.out.println("digite sua idade: ");
        cliente.setAge(inputCad.nextInt());
        inputCad.nextLine(); // consume quebra de linha 
        System.out.println("Digite seu CPF:");
        cliente.setCpf(inputCad.nextLine());
        System.out.println("Digite seu telefone: ");
        cliente.setPhone(inputCad.nextLine());
        System.out.println("Digite seu E-mail: ");
        cliente.setEmail(inputCad.nextLine());
        System.out.println("Digite sua senha: ");
        cliente.setPassword(inputCad.nextLine());
        System.out.println("Data de cadastro (no formato AAAA-MM-DD):");
        cliente.setDataDeCadastro(inputCad.nextLine());

        ClienteRepositorio clienteRepo = new ClienteRepositorio();

        clienteRepo.cadastrarCliente(cliente);

        inputCad.close();

    }

}
