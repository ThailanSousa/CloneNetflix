package br.com.unifacol.cloneflix.model.service;

import java.util.Scanner;

import br.com.unifacol.cloneflix.model.entities.Assinatura;

public class AssinaturaService {

    public static void cadastrarAssinatura() {
        Scanner inputAss = new Scanner(System.in);

    Assinatura assinatura = new Assinatura();

    

    inputAss.close();
    System.out.println(assinatura);
    }
    
}
