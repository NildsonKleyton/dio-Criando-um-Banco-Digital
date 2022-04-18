package br.com.desafio.controle;

import br.com.desafio.entidades.*;
import br.com.desafio.repositorio.ClienteRepositorio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class mainTeste {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Nildson","99988877700","nildson@desafio.com","asdf",11);
        Cliente cliente2 = new Cliente("kleyton","99988877701","kleyton@desafio.com","qwer",11);
        Cliente teste = new Cliente();

        teste.setCpf("32165498700");

        Conta cc = new ContaCorente(cliente);
        Conta cp = new ContaPoupanca(cliente);
        ContaCorente cc2 = new ContaCorente(cliente2);
        ContaPoupanca cp2 = new ContaPoupanca(cliente2);
        ContaCorente cc3 = new ContaCorente(teste);
        ContaPoupanca cp3 = new ContaPoupanca(teste);

        List<Conta> contas = new ArrayList<>(Arrays.asList(cc,cp));

        List<Conta> contas2 = new ArrayList<>(){{
            add(cc2);
            add(cp2);
        }};

        List<Conta> contas3 = new ArrayList<>();
        contas3.add(cc3);
        contas3.add(cp3);

        /**
         * Arrays.asList(cc,cp)
         */
        Banco nb = new Banco("NetBanc", contas);//cria OBJ banco
        Banco vb = new Banco("VirtualBanc", contas2);
        Banco cb = new Banco("CryptoBank",contas3);

//        cc.imprimirExtraco();
//        cc2.imprimirExtraco();
//
//        cc.depositar(1100);
//        System.out.println();
//        cc.imprimirExtraco();
//        cc.transferir(100, cc2);
//        cc2.imprimirExtraco();
//        System.out.println();
//
//        cc.imprimirExtraco();
//        cp.imprimirExtraco();
//        System.out.println();


        nb.exibir();
        vb.exibir();
        nb.getContas().clear();
        vb.getContas().remove(cc2);
        nb.exibir();
        vb.exibir();
//        List<Conta> contas = new ArrayList<>();
//        contas.add(cc);
//        contas.add(cp);
//        contas.add(cc2);

//        for (Conta conta : nb.getContas()) {
//            System.out.println(nb.getNome()+"\nCliente " + conta.getCliente() + "Agencia: " + conta.getAgencia() + " Saldo: " + conta.getSaldo() + "Conta: " + conta.getNumero());
//        }
//
//        System.out.println();
//        System.out.println(nb.getNome());
//        nb.getContas().forEach(System.out::println);
//
//        System.out.println();
//        System.out.println(vb.toString());

        //criptografando
        String senha = getString("Digite sua senha");
        int chave = senha.length();

        String msgCifrada = criptografar(senha, chave);
        System.out.println("Msg criptografada: " + msgCifrada);
        String textoPuro = descriptografar(msgCifrada, chave);
        System.out.println("Msg original: " + textoPuro);

        ClienteRepositorio clienteRepositorio = new ClienteRepositorio();
        clienteRepositorio.criar(cliente2);
        clienteRepositorio.lertodos();

        if(clienteRepositorio.contains(cliente2)) System.out.println("v");
        else System.out.println("f");

    }

    public static String criptografar(String msg, int chave) {
        String msgCript = "";
        for(int i = 0; i < msg.length(); i++) {
            msgCript += (char) (msg.charAt(i) + chave);
        }
        return msgCript;
    }

    public static String descriptografar(String msgCript, int chave) {
        String msg = "";
        for(int i = 0; i < msgCript.length(); i++) {
            msg += (char) (msgCript.charAt(i) - chave);
        }
        return msg;
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
}
