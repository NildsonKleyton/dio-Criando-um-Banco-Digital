package br.com.desafio.controle;

import br.com.desafio.entidades.*;
import br.com.desafio.repositorio.ClienteRepositorio;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CaixaEletronico {
    /**
     * Usa um Scanser tipo inteiro
     *
     * @param mensagem
     * @return um inteiro
     */
    public static int getInt(String mensagem) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensagem);
        int valor = 0;
        try {
            valor = scanner.nextInt();
        } catch (InputMismatchException e) {

        }
        return valor;
    }

    /**
     * Usa um Scanser tipo long
     *
     * @param mensagem
     * @return um Long
     */
    public static long getLong(String mensagem) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensagem);
        return scanner.nextLong();
    }

    /**
     * Usa um Scanser tipo String
     *
     * @param mensagem
     * @return um String line
     */
    public static String getString(String mensagem) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    /**
     * Recebe a opção.
     *
     * @return um número inteiro.
     */
    public static int getOpcaoUsuario() {

        return getInt("\tInforme a opção escolhida: ");
    }

    /**
     * Opção invalida
     */
    public static void opcaoInvalido() {
        System.out.println("Opção invalida, Tente novamente.");
    }

    public static void main(String[] args) {
        //as listas de bando ainda não estar em uso
        List<Banco> bancos = new ArrayList<>();//para usar como um banco de dados de "Banco"
        Banco banco = new Banco("CryptoBank");//cria OBJ banco apenas com o nome do banco
        Cliente cliente = null;
        Conta cc;
        Conta cp;
        List<Conta> contas = new ArrayList<>();
        ClienteRepositorio clienteRepositorio = new ClienteRepositorio();
        int op = 0;

        boolean resultado = true;
        // Escolha do banco
        while (resultado) {

            System.out.println("\n*===================================*");
            System.out.println("\t\t\t" + banco.getNome());
            System.out.println("\tBem Vindo!!!");
            System.out.println("*===================================*");
            System.out.println("\t1 - Funcionário");
            System.out.println("\t2 - Cliente");
            System.out.println("\t3 - Sair");
            System.out.println("*===================================*");
            op = getOpcaoUsuario();

            if (op == 1) {
                //cadastro de cliente
                do {
                    System.out.println("\n*===================================*");
                    System.out.println("\t\t\t" + banco.getNome());
                    System.out.println("\tCadastro de Cliente");
                    System.out.println("*===================================*");
                    System.out.println("\t1 - Cadastrar Cliete");
                    System.out.println("\t2 - Listar Cliete");
                    System.out.println("\t3 - Editar Cliete");
                    System.out.println("\t4 - Excluir Cliete");
                    System.out.println("\t5 - Voltar ao menu anterior");
                    System.out.println("*===================================*");

                    op = getOpcaoUsuario();
                    switch (op) {
                        case 1:// cria usuário em uma conta na lista do bando
                            String nome = getString("Nome do cliente: ");
                            String cpf = getString("CPF do cliente (apensa os números): ");
                            String email = getString("Email do cliente: ");
                            String valorSenha = getString("Senha do cliente: ");
                            int idade = getInt("Idade do cliente: ");

                            cliente = new Cliente(nome, cpf, email, valorSenha, idade);
                            clienteRepositorio.criar(cliente);
                            cc = new ContaCorente(cliente);
                            cp = new ContaPoupanca(cliente);
                            contas.add(cc);
                            contas.add(cp);
                            banco.setContas(contas);
                            bancos.add(banco);


                            break;
                        case 2:
                            if (!clienteRepositorio.isEmpty()) {
                                System.out.println("\n\n1 - Listar todos Clientes\n" + "2- Consultar Cliente");
                                op = getOpcaoUsuario();
                                if (op == 1) {
                                    clienteRepositorio.lertodos();
                                } else if (op == 2) {
                                    int cod = getInt("Digite o códogo do cliente: ");
                                    if (clienteRepositorio.contains(clienteRepositorio.ler(cod))) {
                                    } else System.out.println("Não a cliente cadastrado!");
                                    continue;
                                } else {
                                    opcaoInvalido();
                                }
                            } else System.out.println("Não a cliente cadastrado!");
                            break;
                        case 3:
                            if (!clienteRepositorio.isEmpty()) {
                                int cod = getInt("\nDigite o códogo: ");
                                System.out.println("\n\nCliente: " + clienteRepositorio.ler(cod));

                                String resp;
                                do {
                                    System.out.println("Qua campo deseja altera?\n N - nome\n E - email\n I - idade\n S - senha\n\tR - sair");
                                    resp = getString("Esconlha um campo: ");

                                    if (resp.equalsIgnoreCase("nome") || resp.equalsIgnoreCase("n")) {
                                        nome = getString("Novo Nome do usuário: ");
                                        // altera o nome da posição refente ao cod
                                        clienteRepositorio.ler(cod).setNome(nome);
                                    }
                                    if (resp.equalsIgnoreCase("email") || resp.equalsIgnoreCase("e")) {
                                        email = getString("Novo Email do usuário: ");
                                        clienteRepositorio.ler(cod).setEmail(email);
                                    }
                                    if (resp.equalsIgnoreCase("idade") || resp.equalsIgnoreCase("i")) {
                                        idade = getInt("Nova Idade do usuário: ");
                                        clienteRepositorio.ler(cod).setIdade(idade);
                                    }
                                    if (resp.equalsIgnoreCase("senha") || resp.equalsIgnoreCase("s")) {
                                        valorSenha = getString("Nova Senha do usuário: ");
                                        clienteRepositorio.ler(cod).setSenha(valorSenha);
                                    }

                                } while (!resp.equalsIgnoreCase("r") & !resp.equalsIgnoreCase("sair"));

                                Cliente usu = clienteRepositorio.ler(cod);
                                clienteRepositorio.atualizar(usu);
                                System.out.println("Cliente alterado: " + usu.toString());
                            } else System.out.println("Não a cliente cadastrado!");
                            break;
                        case 4:
                            if (!clienteRepositorio.isEmpty()) {
                                int codExcluir = getInt("Digite o códogo: ");
                                Cliente nomeDelete = clienteRepositorio.ler(codExcluir);
                                clienteRepositorio.excluir(codExcluir);
                                System.out.println("Cliente: " + codExcluir);
                            } else System.out.println("Não a cliente cadastrado!");
                            break;
                        case 5:
                            System.out.println("até mais");
                            break;
                        default:
                            opcaoInvalido();
                            break;
                    }
                } while (op != 5);

            }
            else if (op == 2) {
                String recebeCPF = getString("Digite seu CPF: ");
                String recebeSenha = getString("Digite a senha: ");
                cliente = clienteRepositorio.ler(recebeCPF);
                System.out.println(cliente);
                for (Conta conta : contas) {
                    if (conta.getCliente().getCpf().equals(cliente)) {
                        System.out.println("ok"+conta);// por em uma variável

                        break;
                    }else System.out.println(conta);
                }
//                Banco acessaConta = contas.contains();
//                int cod =
//                        clienteRepositorio.ler(cod);
                // Operação bancária
                do {
                    System.out.println("\n*===================================*");
                    System.out.println("\t\t\t" + banco.getNome());
                    System.out.println("*===================================*");
                    System.out.println("\t1 - Extrato");
                    System.out.println("\t2 - Depositar");
                    System.out.println("\t3 - Sacar");
                    System.out.println("\t4 - Transferir");
                    System.out.println("\t5 - Voltar ao menu anterior");
                    System.out.println("*===================================*");
                    op = getOpcaoUsuario();
                    switch (op) {
                        case 1:
                            if (!contas.isEmpty()) {
                                System.out.println("extrato");
                            } else System.out.println("Nao existe cliente no Banco");

                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        default:
                            opcaoInvalido();
                            break;
                    }
                } while (op != 5);

            } else if (op == 3) {
                break;
            } else {
                opcaoInvalido();
            }
        }
    }
}

