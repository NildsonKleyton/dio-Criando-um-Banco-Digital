package br.com.desafio.controle;

import br.com.desafio.entidades.*;
import br.com.desafio.repositorio.ClienteRepositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mainTeste {
    public static void main(String[] args) {
//        Cliente cliente = new Cliente("Nildson","99988877700","nildson@desafio.com","asdf",11);
        Cliente cliente2 = new Cliente("kleyton","99988877701","kleyton@desafio.com","qwer",11);
//        Cliente teste = new Cliente();
//
//        teste.setCpf("32165498700");
//
//
//        Conta cc = new ContaCorente(cliente);
//        Conta cp = new ContaPoupanca(cliente);
//        ContaCorente cc2 = new ContaCorente(cliente2);
//        ContaPoupanca cp2 = new ContaPoupanca(cliente2);
//
//
//        Banco nb = new Banco("NetBanc");//cria OBJ banco
//        Banco vb = new Banco("VirtualBanc ");//cria OBJ banco
//
//        //agoara nao tem construtor vazio
////        cliente.setNome("Nildson");
////        cliente2.setNome("kleyton");
//
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
//
//
////        List<Conta> contas = new ArrayList<>();
////        contas.add(cc);
////        contas.add(cp);
////        contas.add(cc2);
//
//
//        nb.setContas(cc);
//        nb.setContas(cp);
//        vb.setContas(cc2);
//        vb.setContas(cp2);
//
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

//        //criptografando
//        String senha = getString("Digite sua senha");
//        int chave = senha.length();
//
//
//        String msgCifrada = criptografar(senha, chave);
//        System.out.println("Msg criptografada: " + msgCifrada);
//        String textoPuro = descriptografar(msgCifrada, chave);
//        System.out.println("Msg original: " + textoPuro);

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
