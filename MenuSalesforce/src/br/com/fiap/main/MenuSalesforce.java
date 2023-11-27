package br.com.fiap.main;

import br.com.fiap.beans.Catalogo;
import br.com.fiap.beans.Pessoa;
import br.com.fiap.beans.PessoaFisica;
import br.com.fiap.beans.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuSalesforce {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();
        List<Pessoa> pessoas = new ArrayList<>();

        catalogo.inicializarCatalogo();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                exibirMenu();

                System.out.print("Digite o numero da opcao escolhida: ");
                String opcao = scanner.nextLine();

                switch (opcao) {
                    case "1":
                        catalogo.listarProdutos();
                        break;

                    case "2":
                        catalogo.produtoMaisCaro();
                        break;

                    case "3":
                        catalogo.produtoMaisBarato();
                        break;

                    case "4":
                        System.out.print("Digite o primeiro produto: ");
                        String prod1 = scanner.nextLine();
                        System.out.print("Digite o segundo produto: ");
                        String prod2 = scanner.nextLine();
                        catalogo.orcamentoProdutos(prod1, prod2);
                        break;

                    case "5":
                        cadastrarPessoa(scanner, pessoas);
                        break;

                    case "6":
                        listarPessoas(pessoas);
                        break;

                    case "7":
                        encerrarPrograma(scanner);
                        break;

                    default:
                        System.out.println("Opção inválida! Escolha uma opção válida.");
                }
            }
        }
    }

    private static void cadastrarPessoa(Scanner scanner, List<Pessoa> pessoas) {
        System.out.println("Escolha o tipo de pessoa:");
        System.out.println("[1] Pessoa Juridica");
        System.out.println("[2] Pessoa Fisica");
        System.out.print("Digite o numero da opcao escolhida: ");
        String tipoPessoa = scanner.nextLine();

        System.out.print("Digite o nome da pessoa: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Digite o telefone: ");
        String telefone = scanner.nextLine();

        if ("1".equals(tipoPessoa)) {
            System.out.print("Digite o CNPJ: ");
            String cnpj = scanner.nextLine();
            PessoaJuridica pessoaJuridica = new PessoaJuridica(nome, endereco, telefone, cnpj);
            pessoas.add(pessoaJuridica);
        } else if ("2".equals(tipoPessoa)) {
            System.out.print("Digite o CPF: ");
            String cpf = scanner.nextLine();
            PessoaFisica pessoaFisica = new PessoaFisica(nome, endereco, telefone, cpf);
            pessoas.add(pessoaFisica);
        } else {
            System.out.println("Opcao invalida! Cadastro de pessoa cancelado.");
        }
    }

    private static void listarPessoas(List<Pessoa> pessoas) {
        System.out.println("Lista de Pessoas:");
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof PessoaJuridica) {
                PessoaJuridica juridica = (PessoaJuridica) pessoa;
                System.out.println("Pessoa Juridica: " + juridica.getNome() + ", CNPJ: " + juridica.getCnpj());
            } else if (pessoa instanceof PessoaFisica) {
                PessoaFisica fisica = (PessoaFisica) pessoa;
                System.out.println("Pessoa Fisica: " + fisica.getNome() + ", CPF: " + fisica.getCpf());
            } else {
                System.out.println("Pessoa: " + pessoa.getNome());
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("MENU SALESFORCE");
        System.out.println("[1] Listar produtos");
        System.out.println("[2] Ver produto com maior valor");
        System.out.println("[3] Ver produto com menor valor");
        System.out.println("[4] Orcar 2 produtos");
        System.out.println("[5] Cadastrar Pessoa");
        System.out.println("[6] Listar Pessoas");
        System.out.println("[7] Encerrar menu");
    }

    private static void encerrarPrograma(Scanner scanner) {
        System.out.println("Obrigado, encerrando por aqui!");
        System.exit(0);
    }
}
