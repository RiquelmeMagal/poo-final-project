import java.sql.Date;
import java.time.LocalDate;

public class Bebidas extends Produto {
    private boolean gelada;
    
    public Bebidas(String nome, float preco, LocalDate validade, boolean gelada) {
        super(nome, preco, validade);
        this.gelada = gelada;
    }

    @Override
    public String toString() {
        return super.toString() + "\nEstá gelada: " + ((this.gelada) ? "sim!" : "não!") + "\n====================";
    }
}
