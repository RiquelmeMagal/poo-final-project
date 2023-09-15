package product;
import java.util.Date;
import utils.DateFormatter;


public class Perishable extends Product {
    protected Date validUntil;

    public Perishable(String name, int amount, Category category, Date validUntil) {
        super(name, amount, category);
        this.validUntil = validUntil;
    }
    
    public Perishable(String name, int amount, Category category, Date validUntil, String code) {
        super(name, amount, category);
        this.validUntil = validUntil;
        this.setCode(code);
    }

    @Override
    public String getDetails() {
        return String.format("%s | %d unidades\nVálido até %s", this.toString(), this.amount, DateFormatter.formatter.format(validUntil));
    }
}
