package product;
import utils.RandomID;


public abstract class Product {
    protected String id;
    protected String code;
    protected String name;
    protected int amount;
    protected Category category;

    public Product(String name, int amount, Category category) {
        this.id = RandomID.random();
        this.code = category.getPrefix() + RandomID.randomWithoutLetters(4);
        this.name = name;
        this.amount = amount;
        this.category = category;
    }

    public String getId() {
        return id;
    }
    
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setCategory(Category category) {
        this.category = category;
        this.code = category.getPrefix() + RandomID.randomWithoutLetters(4);
    }

    public void replenishQuantity(int amount) {
        this.amount += amount;
    }

    @Override
    public String toString() {
        return String.format("[%s] | %s", this.code, this.name);
    }

    public String getDetails() {
        return String.format("%s | %d unidades", this.toString(), this.amount);
    }
}
