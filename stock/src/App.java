import java.util.Scanner;

public class App {
    public static void sell(Stock stock) {
    }

    public static void management(Stock stock) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n========================\n       MANAGEMENT       \n========================\n1 - STOCK RESUME\n2 - REGISTER PRODUCT\n3 - REPLEACE PRODUCT\n4 - RESUME CATEGORIES\n5 - CREATE CATEGORIES\n: ");
        String opc = scanner.nextLine();

        switch (opc) {
            case "1":
                stock.stockResume();
                break;
            case "2":
                //
                break;
            case "4":
                stock.categoriesResume();
                break;
            default:
                System.out.println("\nINVALID OPTION! PLEASE TRY AGAIN.\n");
                break;
        }        
    }
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean working = true;
        Stock stock = new Stock();

        String bebidasCode = stock.createCategory("Bebidas", "BBD", "Bebidas geladas");
        String lanchesCode = stock.createCategory("Lanches", "LCH");
        stock.registerProduct("Fanta", 200, bebidasCode, "27/11/2023");
        stock.registerProduct("Doritos", 100, lanchesCode, "10/10/2023");

        while (working) {
            System.out.print("========================\n  INVENTORY MANAGEMENT  \n========================\n1 - SELL\n2 - MANAGEMENT\n0 - QUIT\n: ");
            String opc = scanner.nextLine();

            switch (opc) {
                case "1":
                    sell(stock);
                    break;
                case "2":
                    management(stock);
                    break;
                case "0":
                    working = false;
                    break;
                default:
                    System.out.println("\nINVALID OPTION! PLEASE TRY AGAIN.\n");
                    break;
            }
        }

        /*
        String bebidasCode = stock.createCategory("Bebidas", "BBD");
        String lanchesCode = stock.createCategory("Lanches", "LCH");

        String cocaCode = stock.registerProduct("Coca-cola", 200, bebidasCode, "22/11/2023");
        stock.registerProduct("Fanta", 200, bebidasCode, "27/11/2023");
        stock.registerProduct("Doritos", 100, lanchesCode, "10/10/2023");

        stock.stockResume();
        */
    }
}
