package br.com.desafio.entidades;

public class ContaCorente extends Conta {


    public ContaCorente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtraco() {
        System.out.println("*== Extrato Conta Corrente ==*");
        super.imprimirInfosComuns();
    }

}
