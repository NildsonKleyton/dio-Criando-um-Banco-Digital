package br.com.desafio.entidades;

import br.com.desafio.repositorio.IConta;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;//conta tante da Agencia (número da agencia)
    private static int SEQUENCIAL = 1; // variável que tem relação com a contra corrente

    // atributos
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    //construtor
    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;// criado uma sequendia para o número do cliente
        this.cliente = cliente;
    }

    // get
    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    // métodos
    @Override
    public double depositar(double valorDeposito) {
        this.saldo += valorDeposito;
        return this.saldo;
    }

    @Override
    public boolean sacar(double valorSaque) {
        if (this.saldo >= valorSaque) {
            this.saldo -= valorSaque;
            return true;
        } else {
            System.out.println("Saldo insuficiente.");
            return false;
        }
    }

    @Override
    public boolean transferir(double valor, Conta contaDestino) {
        if (sacar(valor)) {
            contaDestino.depositar(valor);
            return true;
        } else
            return false;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s ", this.cliente.getNome()));
        System.out.println(String.format("CPF: %s ", this.cliente.getCpf()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.printf("Numero: %d%n", this.numero);
        System.out.printf("Saldo: %.2f%n", this.saldo);
    }

    @Override
    public String toString() {
        return "Conta{" + cliente +
                ",agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                '}';
    }
}
