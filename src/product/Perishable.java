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

    public Date getValidUntil() {
        return this.validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

    @Override
    public String getDetails() {
        return String.format("%s | %d UNITS\nVALID UNTIL %s", this.toString(), this.amount, DateFormatter.formatter.format(validUntil));
    }
}
