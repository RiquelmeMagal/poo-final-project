
public class App {

    public static void main(String[] args) throws Exception {
        Stock stock = new Stock();
        String bebidasCode = stock.createCategory("Bebidas", "BBD");
        String lanchesCode = stock.createCategory("Lanches", "LCH");

        stock.categoriesResume();
        String cocaCode = stock.registerProduct("Coca-cola", 200, bebidasCode, "22/11/2023");
        stock.registerProduct("Fanta", 200, bebidasCode, "27/11/2023");
        stock.registerProduct("Doritos", 100, lanchesCode, "10/10/2023");

        stock.stockResume();

        stock.replaceProduct(cocaCode, 50, "10/01/2024");

        stock.stockResume();

        stock.sellProduct(cocaCode, 199);

        stock.stockResume();

        stock.sellProduct(cocaCode, 1);

        stock.stockResume();


    }
}
