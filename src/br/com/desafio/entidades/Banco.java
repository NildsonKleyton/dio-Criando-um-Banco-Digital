package br.com.desafio.entidades;

import java.util.ArrayList;
import java.util.List;

public class Banco  {

    private String nome;
    private List<Conta> contas = new ArrayList<>();

    public Banco(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

//    public void setNome(String nome) {
//        this.nome = nome;
//    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(Conta contas) {
        this.contas.add(contas);
    }

    @Override
    public String toString() {
        return nome + "\n" + contas ;
    }
}
