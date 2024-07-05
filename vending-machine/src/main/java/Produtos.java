public class Produtos {
    private String produto;
    private double preco;
    private int quantidadeProduto;

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public String getProduto() {
        return produto;
    }

    public double getPreco() {
        return preco;
    }

    public Produtos(String produto, double preco, int quantidadeProduto) {
        this.produto = produto;
        this.preco = preco;
        this.quantidadeProduto = quantidadeProduto;
    }

    @Override
    public String toString() {
        System.out.println("Vending Machine Dev - Produtos Disponíveis:");
        return "Produto: " + produto +
                ", preço: " + preco +
                "- quantidade disponível: " + quantidadeProduto;
    }
}
