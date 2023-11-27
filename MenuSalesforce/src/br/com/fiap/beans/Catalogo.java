package br.com.fiap.beans;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private List<Produto> produtos;

    public Catalogo() {
        this.produtos = new ArrayList<>();
    }

    public void inicializarCatalogo() {
        adicionarProduto(new Produto("Vendas", 250.0, 0, "", ""));
        adicionarProduto(new Produto("Serviços", 950.0, 0, "", ""));
        adicionarProduto(new Produto("Marketing", 750.0, 0, "", ""));
        adicionarProduto(new Produto("Commerce", 550.0, 0, "", ""));
        adicionarProduto(new Produto("Analytics", 150.0, 0, "", ""));
        adicionarProduto(new Produto("Integração", 2250.0, 0, "", ""));
        adicionarProduto(new Produto("Slack", 850.0, 0, "", ""));
        adicionarProduto(new Produto("Plataforma", 425.0, 0, "", ""));
        adicionarProduto(new Produto("Indústrias", 255.0, 0, "", ""));
        adicionarProduto(new Produto("Aprendizado", 3550.0, 0, "", ""));
        adicionarProduto(new Produto("Saúde", 350.0, 0, "", ""));
        adicionarProduto(new Produto("Parceiros", 695.0, 0, "", ""));
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void listarProdutos() {
        System.out.println("Lista de Produtos:");
        for (Produto produto : produtos) {
            System.out.println("Nome: " + produto.getNome() + ", Preco: R$" + produto.getPreco());
        }
    }

    public void produtoMaisCaro() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto no catalogo.");
            return;
        }

        Produto maisCaro = produtos.get(0);

        for (Produto produto : produtos) {
            if (produto.getPreco() > maisCaro.getPreco()) {
                maisCaro = produto;
            }
        }

        System.out.println("Produto mais caro: " + maisCaro.getNome() + ", Preco: R$" + maisCaro.getPreco());
    }

    public void produtoMaisBarato() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto no catalogo.");
            return;
        }

        Produto maisBarato = produtos.get(0);

        for (Produto produto : produtos) {
            if (produto.getPreco() < maisBarato.getPreco()) {
                maisBarato = produto;
            }
        }

        System.out.println("Produto mais barato: " + maisBarato.getNome() + ", Preco: R$" + maisBarato.getPreco());
    }

    public void orcamentoProdutos(String nomeProduto1, String nomeProduto2) {
        Produto produto1 = buscarProdutoPorNome(nomeProduto1);
        Produto produto2 = buscarProdutoPorNome(nomeProduto2);

        if (produto1 != null && produto2 != null) {
            double total = produto1.getPreco() + produto2.getPreco();
            System.out.println("Orçamento para " + produto1.getNome() + " e " + produto2.getNome() + ": R$" + total);
        } else {
            System.out.println("Pelo menos um dos produtos nao foi encontrado.");
        }
    }

    private Produto buscarProdutoPorNome(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        return null;
    }
}
