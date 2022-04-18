package br.com.desafio.entidades;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nome;
    private List<Conta> contas;

    public Banco() {

    }

    public Banco(String nome) {
        this.nome = nome;
    }

    public Banco(String nome, List<Conta> contas) {
        this.nome = nome;
        this.contas = contas;
    }

    public void exibir() {
        if (contas.isEmpty())
            System.out.println("Lista está vazia");
        else {
            System.out.println("\n***** "+this.nome+" *****");
            for (int i = 0; i < contas.size(); i++)
                contas.get(i).imprimirExtraco();
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    @Override
    public String toString() {
        return nome + "\n" + contas;
    }
}
