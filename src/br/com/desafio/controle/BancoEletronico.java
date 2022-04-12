package br.com.desafio.controle;

import java.util.Scanner;

public class BancoEletronico {
    public static void main(String[] args) {

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

    //criando menu
    public static void MenuCliente() {

        System.out.println("\n**********Menu de Cliente**********\n");
        System.out.println("1 - Cadastrar Cliete");
        System.out.println("2 - Listar Cliete por código");
        System.out.println("3 - Editar Cliete");
        System.out.println("4 - Excluir Cliete");
        System.out.println("5 - Voltar ao menu anterior");
    }

    public static int getOpcaoUsuario() {
        return getInt("\nInforme a opção escolhida: ");
    }
}
