package br.com.desafio.controle;

import br.com.desafio.entidades.*;
import br.com.desafio.repositorio.ClienteRepositorio;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BancoEletronico {
    public static void main(String[] args) {
        List<Banco> bancos = new ArrayList<>();//para usar como um banco de dados de "Banco"

        Cliente cliente = new Cliente();

        Conta cc = new ContaCorente(cliente);
        Conta cp = new ContaPoupanca(cliente);
        List<Conta> contas = new ArrayList<>(){{
            add(cc);
            add(cp);
        }};
        Banco banco = new Banco();
        banco.setContas(contas);

        ClienteRepositorio clienteRepositorio = new ClienteRepositorio();

//        Cliente cliente = new Cliente("Teste1", "99988877700", "teste1@desafio.com", "asdf", 11);
//        Cliente cliente2 = new Cliente("Teste2", "99988877701", "teste2@desafio.com", "qwer", 22);
//        Cliente cliente3 = new Cliente("Teste3", "99988877702", "teste3@desafio.com", "123!@#", 33);
//        clienteRepositorio.criar(cliente);
//        clienteRepositorio.criar(cliente2);
//        clienteRepositorio.criar(cliente3);

        int opcao = 0;
        boolean resultado = true;
        // Escolha do banco
        while (resultado) {
            menuBancos();
            opcao = getOpcaoUsuario();

            switch (opcao) {
                case 1:
                    banco.setNome("NetBank");

                    login(banco, clienteRepositorio);


                    break;
                case 2:
                    banco.setNome("VirtualBank");
                    login(banco, clienteRepositorio);

                    break;
                case 3:
                    banco.setNome("CryptoBank");
                    login(banco, clienteRepositorio);

                    break;
                case -1:
                    System.out.println("Sistema Fechado.");
                    resultado = false;
                    break;
                default:
                    opcaoInvalido();
                    break;
            }

        }
    }

    /**
     * Usa um Scanser.
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
     * Usa um Scanser.
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
     * Usa um Scanser.
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

    /**
     * Menu Banco
     */
    public static void menuBancos() {
        System.out.println("\n*===================================*");
        System.out.println("            Menu de Banco            ");
        System.out.println("*===================================*");
        System.out.println("\t1 - NetBank");
        System.out.println("\t2 - VirtualBank");
        System.out.println("\t3 - CryptoBank");
        System.out.println("*===================================*");
    }

    /**
     * Login
     */
    public static void login(Banco banco, ClienteRepositorio clienteRepositorio) {
        do {
            System.out.println("\n*===================================*");
            System.out.println("\t\t\t" + banco.getNome());
            System.out.println("\tLogin");
            System.out.println("*===================================*");
            System.out.println("\t1 - Funcionário");
            System.out.println("\t2 - Cliente");
            System.out.println("\t3 - Sair");
            System.out.println("*===================================*");
            int op = getOpcaoUsuario();

            if (op == 1) {
                menuCliente(banco, clienteRepositorio);
            } else if (op == 2) {
                menuCaixaEletronico(banco, clienteRepositorio);
            } else if (op == 3) {
                break;
            } else {
                opcaoInvalido();
            }
        } while (true);

    }

    /**
     * Cadastro cliente
     */
    public static void menuCliente(Banco banco, ClienteRepositorio clienteRepositorio) {
        int op = 0;
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
                case 1:
                    String nome = getString("Nome do cliente: ");
                    String cpf = getString("CPF do cliente (apensa os números): ");
                    String email = getString("Email do cliente: ");
                    String valorSenha = getString("Senha do cliente: ");
                    int idade = getInt("Idade do cliente: ");

                    Cliente cliente = new Cliente(nome, cpf, email, valorSenha, idade);
                    clienteRepositorio.criar(cliente);

                    break;
                case 2:
                    if (!clienteRepositorio.isEmpty()) {
                        System.out.println("\n\n1 - Listar todos Clientes\n" + "2- Consultar Cliente");
                        op = getOpcaoUsuario();
                        if (op == 1) {
                            clienteRepositorio.lertodos();
                        } else if (op == 2) {
                            int cod = getInt("Digite o códogo do cliente: ");
                            if (clienteRepositorio.contains( clienteRepositorio.ler(cod))){
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
                    System.out.println("ate maisl");
                    break;
                default:
                    break;
            }
        } while (op != 5);
    }
    /**
     * Menu Caixa Eletrônico
     */
    public static void menuCaixaEletronico(Banco banco, ClienteRepositorio clienteRepositorio) {
        System.out.println("\n*===================================*");
        System.out.println("\t\t\t" + banco.getNome());
        System.out.println("*===================================*");
        System.out.println("\t1 - Extrato");
        System.out.println("\t2 - Depositar");
        System.out.println("\t3 - Sacar");
        System.out.println("\t4 - Transferir");
        System.out.println("\t5 - Voltar ao menu anterior");
        System.out.println("*===================================*");
    }


}
