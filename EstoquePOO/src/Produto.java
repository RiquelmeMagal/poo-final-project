import java.text.DecimalFormat;
import java.time.LocalDate;


public class Produto {
    private String nome;
    private float preco;
    //private int quantidade;
    private LocalDate validade;

    public Produto(String nome, float preco, LocalDate validade) {
        this.nome = nome;
        this.preco = preco;
        //this.quantidade = quantidade;
        this.validade = validade;
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String precoFormatado = decimalFormat.format(this.preco);

        return "Nome: " + this.nome + "\nPreço: R$" + precoFormatado + "\nValidade: " + this.validade;
    }
}
