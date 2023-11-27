package br.com.fiap.beans;

public class Produto {
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;
    private String categoria;
    private String codigoDeBarras;

    public Produto(String nome, double preco, int quantidadeEmEstoque, String categoria, String codigoDeBarras) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.categoria = categoria;
        this.codigoDeBarras = codigoDeBarras;
    }

    // Métodos de acesso

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }


    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }
}
