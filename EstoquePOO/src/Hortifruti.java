import java.time.LocalDate;

public class Hortifruti extends Produto {
    private boolean organico;

    public Hortifruti(String nome, float preco, int quantidade, LocalDate validade, boolean organico) {
        super(nome, preco, quantidade, validade);
        this.organico = organico;
    }

    @Override
    public String toString() {
        return super.toString() + "\nÉ orgânico: " + ((this.organico) ? "sim!" : "não!") + "\n====================";
    }
}
