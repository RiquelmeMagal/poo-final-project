
import product.Category;
import product.NoPerishable;
import product.Perishable;
import product.Product;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Category bolachasAndBiscoitos = new Category("Bolachas e Biscoitos", "BSC");
        Category limpeza = new Category("Limpeza", "LPZ");

    
        Product bolacha = new Perishable("Bolacha maria", 100, bolachasAndBiscoitos, "31/12/2023");
        Product detergente = new NoPerishable("Detergente", 200, limpeza);

        System.out.println(bolacha.getDetails());
        System.out.println(detergente.getDetails());

    }
}
