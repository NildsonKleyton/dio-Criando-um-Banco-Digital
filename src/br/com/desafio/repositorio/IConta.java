package br.com.desafio.repositorio;

import br.com.desafio.entidades.Conta;

public interface IConta {
    double depositar(double valor);
    boolean sacar(double valor);
    boolean transferir(double valor, Conta contaDestino);
    void imprimirExtraco();
}
