import java.time.LocalDate;

public class Bebida extends Produto {
    private boolean gelada;
    
    public Bebida(String nome, float preco, int quantidade, LocalDate validade, boolean gelada) {
        super(nome, preco, quantidade, validade);
        this.gelada = gelada;
    }

    @Override
    public String toString() {
        return super.toString() + "\nEstá gelada: " + ((this.gelada) ? "sim!" : "não!") + "\n====================";
    }
}
