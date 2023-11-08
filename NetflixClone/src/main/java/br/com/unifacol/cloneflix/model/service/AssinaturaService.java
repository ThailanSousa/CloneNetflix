package br.com.unifacol.cloneflix.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


import br.com.unifacol.cloneflix.model.entities.Assinatura;

import br.com.unifacol.cloneflix.model.repositorio.AssinaturaRepositorio;

public class AssinaturaService {
    AssinaturaRepositorio assinaturaRepo = new AssinaturaRepositorio();
    
    public boolean cadastarAssinatura(){
        Scanner inputAss = new Scanner(System.in);
        Assinatura assinatura = new Assinatura();

        Assinatura assintaura = new Assinatura(null, 0, 0);

        System.out.print("Qual o Plano de escolha?");
        assinatura.setNomeAssinatura(inputAss.nextLine());

        System.out.println("Informe o Valor da Assinatura");
        assinatura.setPrecoMensal(inputAss.nextDouble());
        inputAss.nextLine();

        System.out.println("Por Quantos Meses você que a assinatura?");
        assinatura.setPrecoMensal(inputAss.nextDouble());
        inputAss.nextLine();


        inputAss.close();
        System.out.println(assinatura);

        if (!assinatura.getNomeAssinatura().isEmpty()) {
            System.out.println(assinatura);
            assinatura.setAtiva(true);
            assinaturaRepo.cadastrarAssinatura(assinatura);
            return true;
            } else {
                System.out.println("Verifique os dados inseridos");
            return false;
            }
    }
    
    public boolean atualizarCliente() {
        try {
            Scanner inputUpdate = new Scanner(System.in);
            System.out.println("Digite o CPF do cliente que deseja atualizar:");
            String assinaturaToUpdate = inputUpdate.nextLine();

            Assinatura assinaturaoUpdate = assinaturaRepo.obterAssinaturaPorNomeAssinatura(assinaturaToUpdate);

            if (assinaturaToUpdate != null) {
                System.out.println("Digite os novos dados da Assintaura:");

                System.out.print("Qual o Plano de escolha?");
                assinaturaoUpdate.setNomeAssinatura(inputUpdate.nextLine());

                System.out.println("Informe o Valor da Assinatura");
                assinaturaoUpdate.setPrecoMensal(inputUpdate.nextDouble());
                inputUpdate.nextLine();

                System.out.println("Por Quantos Meses você que a assinatura?");
                assinaturaoUpdate.setPrecoMensal(inputUpdate.nextDouble());
                inputUpdate.nextLine();

                assinaturaRepo.atualizarAssinatura(assinaturaoUpdate);
                return true;
            }else{
                throw new Exception ("Informações não encontradas!");

            }
        } catch(Exception e ){
          System.out.println("Erro: "+e);
          return false;
        }
        
    }


}
