package br.com.desafio.repositorio;


import br.com.desafio.entidades.*;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepositorio {
    // Seria um banco de dados, porem temporário alocado na memória.
    private List<Cliente> clientes = new ArrayList<Cliente>();

    public boolean isEmpty() {//verifica se a lista esta vazia
        return clientes.isEmpty();
    }

    public boolean contains(Cliente cliente) {
        if (clientes.contains(cliente))
            return true;

        return false;
    }

    // CRUD (Create->criar, Read->ler, Update->Atualizar, Delete->Excluir)
    // CRIAR CLIENTE
    public void criar(Cliente cliente) {
        clientes.add(cliente);
        Conta cc = new ContaCorente(cliente);
        Conta cp = new ContaPoupanca(cliente);
        List<Conta> contas = new ArrayList<>(){{
           add(cc);
           add(cp);
        }};

    }

    // Ler
    public Cliente ler(long codigo) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            if (cliente.getCodigo() == codigo) {
                System.out.println("Código: " + cliente.getCodigo() + " Nome: " + cliente.getNome());

                return cliente;
            }
            if (clientes.isEmpty()) System.out.println("Não a cliente cadastrado!");
        }
        return null;
    }

    public Cliente lertodos() {
        System.out.println("\nLista de Clientes:");
        if (!clientes.isEmpty()) {
            for (Cliente cliente : clientes) {
                System.out.println("Código: " + cliente.getCodigo() + " Nome: " + cliente.getNome());
            }
        }
        if (clientes.isEmpty()) System.out.println("Não a cliente cadastrado!");
        return null;
    }

    // Atualizar
    public void atualizar(Cliente clienteAtualizar) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente usu = clientes.get(i);
            if (usu.getCodigo() == clienteAtualizar.getCodigo()) {
                clientes.set(i, clienteAtualizar);
                break;
            }
        }
    }

    // Excluir
    public void excluir(long codigo) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente usu = clientes.get(i);
            if (usu.getCodigo() == codigo) {
                clientes.remove(i);
                break;
            }
        }
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
