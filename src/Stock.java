import product.Category;
import product.NoPerishable;
import product.Perishable;
import product.Product;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProducts(Product product) {
        this.products.add(product);
    }

    private void setCategories(String title, String prefix, String description) {
        Category category = new Category(title, prefix, description.toUpperCase());
        this.categories.add(category);
    }

    private Product findProduct(int value) {
        if (value > -1 && value < this.products.size()) {
            return this.products.get(value);
        }

        return null;
    }

    public void registerProduct(String name, int amount, int categoryCode) throws Exception {
        Category category = this.categories.get(categoryCode);

        if (category == null) {
            throw new Exception("CATEGORY NOT FOUND!");
        }

        try {
            NoPerishable newProduct = new NoPerishable(name.toUpperCase(), amount, category);
            this.setProducts(newProduct);
        } catch(Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public void registerProduct(String name, int amount, int categoryCode, String validUntil) throws Exception {
        Category category = this.categories.get(categoryCode);
        
        if (category == null) {
            throw new Exception("CATEGORY NOT FOUND!");
        }

        if (LocalDate.parse(validUntil, DateTimeFormatter.ofPattern("dd/MM/yyyy")).isBefore(LocalDate.now())) {
            throw new Exception("INVALID DATE!");
        }

        try {
            Perishable newProduct = new Perishable(name.toUpperCase(), amount, category, DateFormatter.formatter.parse(validUntil));
            this.setProducts(newProduct);
        } catch(Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public void replaceProduct(int value, int amount) throws Exception {
        Product product = findProduct(value);

        if (product == null) {
            throw new Exception("THERE IS NO PRODUCT REGISTERED WITH THIS CODE!");
        }

        try {    
            product.replenishQuantity(amount);
        } catch(Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public void replaceProduct(int value, int amount, String validUntil) throws Exception {
        Product product = findProduct(value);

        if (product == null) {
            throw new Exception("THERE IS NO PRODUCT REGISTERED WITH THIS CODE!");
        }

        if (LocalDate.parse(validUntil, DateTimeFormatter.ofPattern("dd/MM/yyyy")).isBefore(LocalDate.now())) {
            throw new Exception("INVALID DATE!");
        }
        
        try {
            if (validUntil.equals(DateFormatter.formatter.format(((Perishable) product).getValidUntil()))) {
                product.replenishQuantity(amount);
            } else {
                Perishable newProduct = new Perishable(product.getName(), amount, product.getCategory(), DateFormatter.formatter.parse(validUntil), product.getCode());
                this.products.add(newProduct);
            }

        } catch(Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public void sellProduct(int value, int amount) throws Exception {
        Product product;

        if (value > -1 && value < this.products.size()) {
            product = this.products.get(value);
        } else {
            throw new Exception("THERE IS NO PRODUCT REGISTERED WITH THIS CODE!");
        }

        if (product.getAmount() >= amount) {
            product.setAmount(product.getAmount() - amount);
        } else {
            throw new Exception("INSUFFICIENT QUANTITY IN STOCK!");
        }

        if (product.getAmount() == 0) {
            this.products.remove(product);
        }
    }

    public boolean isPerishable(int value) throws Exception {
        Product product = findProduct(value);

        try {
            if (product instanceof Perishable) {
                return true;
            } else {
                return false;
            }
        } catch(Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public void createCategory(String title) throws Exception {
        try {
            if (title.length() == 3) {
                this.setCategories(title.toUpperCase(), title.toUpperCase(), "");
            } else if (title.length() > 3) {
                for (int i = 0; i < 3 - title.length(); i++) {
                    title.replaceFirst("[AEIOU]", "");
                }

                this.setCategories(title.toUpperCase(), title.toUpperCase().substring(0, 3), "");
            } else {
                String newTitle = title;
                for (int i = 0; i < 3 - title.length(); i++) {
                    newTitle += "0";
                }
            
                this.setCategories(title.toUpperCase(), newTitle.toUpperCase(), "");
            }
        } catch(Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public void createCategory(String title, String description) throws Exception {
        try {
            if (title.length() == 3) {
                this.setCategories(title.toUpperCase(), title.toUpperCase(), description);
            } else if (title.length() > 3) {
                for (int i = 0; i < 3 - title.length(); i++) {
                    title.replaceFirst("[AEIOU]", "");
                }

                this.setCategories(title.toUpperCase(), title.toUpperCase().substring(0, 3), description);
            } else {
                String newTitle = title;
                for (int i = 0; i < 3 - title.length(); i++) {
                    newTitle += "0";
                }
            
                this.setCategories(title.toUpperCase(), newTitle.toUpperCase(), description);
            }
        } catch(Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public int categoriesResume(boolean numbers) {
        for (int i = 0; i < this.categories.size(); i++) {
            String selectionNumber;
            if (numbers) {
                selectionNumber = Integer.toString(i+1) +" - ";
            } else {
                selectionNumber = "";
            }

            if (i == this.categories.size() - 1) {
                System.out.printf("%s%s", selectionNumber, this.categories.get(i).toString());
            } else {
                System.out.printf("%s%s\n-------------------\n", selectionNumber, this.categories.get(i).toString());
            }
        }

        return this.categories.size();
    }

    public int stockResume() {
        if (this.products.size() > 0) {
            for (int i = 0; i < this.products.size(); i++) {
                if (i == this.products.size() - 1) {
                    System.out.printf("%d - %s", i+1, this.products.get(i).getDetails());
                } else {
                    System.out.printf("%d - %s\n-------------------\n", i+1, this.products.get(i).getDetails());
                }
            }
            System.out.println("\n===================");
        }

        return this.products.size();
    }
}
