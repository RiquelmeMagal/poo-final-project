package product;

public class NoPerishable extends Product{

    public NoPerishable(String name, int amount, Category category) {
        super(name, amount, category);
    }

    public NoPerishable(String name, int amount, Category category, String code) {
        super(name, amount, category);
        this.setCode(code);
    }

    
}
