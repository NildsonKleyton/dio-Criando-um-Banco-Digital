package br.com.desafio.controle;

import br.com.desafio.entidades.Cliente;
import br.com.desafio.entidades.Conta;
import br.com.desafio.entidades.ContaCorente;
import br.com.desafio.entidades.ContaPoupanca;

import java.util.Scanner;

public class BancoEletronico {
    public static void main(String[] args) {
        menuBancos();
        getOpcaoUsuario();

        menuCliente();
        getOpcaoUsuario();

        Cliente cliente = new Cliente();
        Conta cc = new ContaCorente(cliente);
        Conta cp = new ContaPoupanca(cliente);


    }

    public static int getInt(String mensagem) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensagem);
        return scanner.nextInt();
    }

    public static long getLong(String mensagem) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensagem);
        return scanner.nextLong();
    }

    public static String getString(String mensagem) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    public static int getOpcaoUsuario() {

        return getInt("\nInforme a opção escolhida: ");
    }

    /**
     * Menu cliente
     */
    public static void menuCliente() {

        System.out.println("\n*========== Menu de Cliente ==========*");
        System.out.println("\t1 - Cadastrar Cliete");
        System.out.println("\t2 - Listar Cliete por código");
        System.out.println("\t3 - Editar Cliete");
        System.out.println("\t4 - Excluir Cliete");
        System.out.println("\t5 - Voltar ao menu anterior");
    }

    /**
     * Menu Banco
     */
    public static void menuBancos() {
        System.out.println("\n*========== Menu de Banco ==========*");
        System.out.println("\t1 - NetBank");
        System.out.println("\t2 - VirtualBank");
        System.out.println("\t3 - CryptoBank");
    }
}
