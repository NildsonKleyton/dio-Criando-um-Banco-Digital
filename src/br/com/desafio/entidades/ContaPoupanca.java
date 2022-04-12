package br.com.desafio.entidades;

public class ContaPoupanca  extends Conta{

    public ContaPoupanca(Cliente cliente) {
        super(cliente);

    }

    @Override
    public void imprimirExtraco() {
        System.out.println("*== Extrato Conta Poupanca ==*");
        super.imprimirInfosComuns();
    }


}
