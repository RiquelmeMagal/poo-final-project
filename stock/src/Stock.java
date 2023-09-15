import java.util.ArrayList;
import product.Category;
import product.NoPerishable;
import product.Perishable;
import product.Product;
import utils.DateFormatter;
import utils.RandomID;

public class Stock {
    private String id;
    private String description;
    private ArrayList<Product> products;
    private ArrayList<Category> categories;


    public Stock() {
        this.id = "STOCK" + RandomID.randomWithoutLetters(4);
        this.description = "";
        this.products = new ArrayList<Product>();
        this.categories = new ArrayList<Category>();
    }

    public Stock(String description) {
        this.id = "STOCK" + RandomID.randomWithoutLetters(4);
        this.description = description;
        this.products = new ArrayList<Product>();
        this.categories = new ArrayList<Category>();
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private Category findCategory(String code) {
        for(int i = 0; i<this.categories.size(); i++) {
            Category currentCategory = this.categories.get(i);
            if(currentCategory.getCode().equals(code)) {
                return currentCategory;
            }
        }
        return null;
    }

    private Product findProduct(String code) {
        for(int i = 0; i<this.categories.size(); i++) {
            Product currentProduct = this.products.get(i);
            if(currentProduct.getCode().equals(code)) {
                return currentProduct;
            }
        }
        return null;
    }

    public String registerProduct(String name, int amount, String categoryCode) throws Exception {
        Category category = this.findCategory(categoryCode);

        if(category == null) {
            throw new Exception("CATEGORY NOT FOUND!");
        }
        NoPerishable newProduct = new NoPerishable(name, amount, category);

        this.products.add(newProduct);

        return newProduct.getCode();
    }

    public String registerProduct(String name, int amount, String categoryCode, String validUntil) throws Exception {
        Category category = this.findCategory(categoryCode);
        
        if(category == null) {
            throw new Exception("CATEGORY NOT FOUND!");
        }

        try {
            Perishable newProduct = new Perishable(name, amount, category, DateFormatter.formatter.parse(validUntil));
      
            this.products.add(newProduct);

            return newProduct.getCode();

        } catch(Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    private String buildCategory(String title, String prefix, String description) {
        Category category = new Category(title, prefix, description.toUpperCase());
        this.categories.add(category);

        return category.getCode();
    }

    public String createCategory(String title, String prefix) {
        return buildCategory(title.toUpperCase(), prefix, "");
    }

    public String createCategory(String title, String prefix, String description) {
        return buildCategory(title.toUpperCase(), prefix, description);
    }

    public void replaceProduct(String code, int amount) throws Exception {
        Product product = findProduct(code);

        if(product == null) {
            throw new Exception("THERE IS NO PRODUCT REGISTERED WITH THIS CODE!");
        }

        NoPerishable newProduct = new NoPerishable(product.getName(), amount, product.getCategory(), product.getCode());
        this.products.add(newProduct);
    }

    public void replaceProduct(String code, int amount, String validUntil) throws Exception {
        Product product = findProduct(code);

        if(product == null) {
            throw new Exception("THERE IS NO PRODUCT REGISTERED WITH THIS CODE!");
        }
        try {
            Perishable newProduct = new Perishable(product.getName(), amount, product.getCategory(), DateFormatter.formatter.parse(validUntil), product.getCode());
      
            this.products.add(newProduct);

        } catch(Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public void sellProduct(String code, int amount) throws Exception {
        Product product = findProduct(code);

        if(product == null) {
            throw new Exception("THERE IS NO PRODUCT REGISTERED WITH THIS CODE!");
        }

        if(product.getAmount() >= amount) {
            product.setAmount(product.getAmount() - amount);
        } else {
            throw new Exception("INSUFFICIENT QUANTITY IN STOCK!");
        }

        if((product.getAmount() == 0)) {
            this.products.remove(product);
        }
    }

    public void stockResume() {
        System.out.println("\nREPORT =======");
        for(int i = 0; i<this.products.size(); i++) {
            if (i == this.products.size() - 1) {
                System.out.println(this.products.get(i).getDetails());
            } else {
                System.out.printf("%s\n-------------------\n", this.products.get(i).getDetails());
            }
        }
        System.out.println("===================\n");
    }

    public void categoriesResume() {
        System.out.println("\nCATEGORIES ========");
        for(int i = 0; i < this.categories.size(); i++) {
            if (i == this.categories.size() - 1) {
                System.out.println(this.categories.get(i).toString());
            } else {
                System.out.printf("%s\n-------------------\n", this.categories.get(i).toString());
            }
        }
        System.out.println("===================\n");
    }
}
