package product;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;



public class Perishable extends Product {
    protected Date validUntil;
    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/mm/yyyy", new Locale("pt","BR"));

    public Perishable(String name, int amount, Category category, String validUntil) throws ParseException {
        super(name, amount, category);
        this.validUntil = dateFormatter.parse(validUntil);
    }

    @Override
    public String getDetails() {
        return String.format("%s | %d unidades | Válido até %s", this.toString(), this.amount, dateFormatter.format(validUntil));
    }

}
