package br.com.desafio.entidades;

import java.util.Objects;
import java.util.Scanner;

public class Cliente {

    private static Integer SEQUENCIA = 1;
    //atributos
    private int codigo;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private  int idade;

    //consturores
    public Cliente(){}

    public Cliente(String nome, String cpf, String email, String senha, int idade) {
        this.codigo = SEQUENCIA++;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.idade = idade;
    }

    //get set
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfFomatado() {
        return cpf.substring(0,3)+"."+cpf.substring(3,6)+"."+cpf.substring(6,9)+"-"+cpf.substring(9);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getSenha() {
        return senha;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

//   //Confirma senha
//    public boolean verDeSenha() {
//        Scanner sc = new Scanner(System.in);
//        boolean liberado = true;
//        String senhaUsuario;
//        for (int tentativas = 3; tentativas>0;tentativas--) {
//            System.out.println("Senha: ");
//            senhaUsuario = sc.nextLine();
//            if (senhaUsuario.equals(getSenha())) {
//                liberado = true;
//                break;
//            }else {
//                liberado = false;
//                System.out.println("Senha incorreta.");
//                System.out.printf("Você tem mais %d tentativas\n", tentativas);
//                System.out.println("Digite uma senha válida:");
//            }
//
//        }
//        return liberado;
//    }

    @Override
    public String toString() {
        return  "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", idade=" + idade ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return cpf.equals(cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
