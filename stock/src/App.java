import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean working = true;

        while (working) {
            System.out.print("=======================\n     STOCK MANAGER     \n=======================\n1 - SELL\n2 - MANAGEMENT\n: ");
            String opc = scanner.nextLine(); 

            switch (opc) {
                case "1":
                    //sell();
                    break;
                case "2":
                    //management();
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
        Stock stock = new Stock();
        String bebidasCode = stock.createCategory("Bebidas", "BBD");
        String lanchesCode = stock.createCategory("Lanches", "LCH");

        String cocaCode = stock.registerProduct("Coca-cola", 200, bebidasCode, "22/11/2023");
        stock.registerProduct("Fanta", 200, bebidasCode, "27/11/2023");
        stock.registerProduct("Doritos", 100, lanchesCode, "10/10/2023");

        stock.stockResume();
        */
    }
}
