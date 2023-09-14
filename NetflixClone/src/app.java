import java.util.Scanner;

import main.java.model.entities.Cliente;
import main.java.model.entities.Filme;
import main.java.repositorio.ClienteRepositorio;
import main.java.repositorio.FilmeRepositorio;

public class app {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao sistema de cadastro e alteração de clientes!");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Alterar cliente");
        System.out.print("Opção: ");

        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                System.out.println("Você escolheu cadastrar cliente.");
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
                break;
            // ...
case 2:
System.out.println("Você escolheu alterar cliente.");
Scanner inputUpdate = new Scanner(System.in);

System.out.println("Digite o CPF do cliente que deseja atualizar:");
String cpfToUpdate = inputUpdate.nextLine();

ClienteRepositorio clienteRepositorio = new ClienteRepositorio();
Cliente clienteToUpdate = clienteRepositorio.obterClientePorCPF(cpfToUpdate);

if (clienteToUpdate != null) {
    System.out.println("Digite os novos dados do cliente:");

    System.out.println("Digite o novo nome:");
    clienteToUpdate.setName(inputUpdate.nextLine());

    System.out.println("Digite a nova idade:");
    clienteToUpdate.setAge(inputUpdate.nextInt());
    inputUpdate.nextLine(); // Consume quebra de linha

    System.out.println("Digite o novo telefone:");
    clienteToUpdate.setPhone(inputUpdate.nextLine());

    System.out.println("Digite o novo E-mail:");
    clienteToUpdate.setEmail(inputUpdate.nextLine());

    // Atualize o cliente no banco de dados2
    boolean atualizadoComSucesso = clienteRepositorio.atualizarCliente(clienteToUpdate);

    if (atualizadoComSucesso) {
        System.out.println("Cliente atualizado com sucesso!");
    } else {
        System.out.println("Ocorreu um erro ao atualizar o cliente.");
    }
} else {
    System.out.println("Cliente com CPF " + cpfToUpdate + " não encontrado.");
}

inputUpdate.close();
break;
// ...

            default:
                System.out.println("Opção inválida. Por favor, escolha 1 para cadastrar ou 2 para alterar.");
                break;
        }

        scanner.close();
    }
}
