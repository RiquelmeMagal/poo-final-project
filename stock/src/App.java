import java.util.Scanner;

public class App {
    public static void sell(Stock stock) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\nWHAT TO BUY?\n===================");
        int quantityOfProducts = stock.stockResume();
        if (quantityOfProducts == 0) {
            System.out.println("NO PRODUCTS AVAILABLE!\n===================\n");
            return;
        }

        System.out.print(": ");
        int chosenProduct = scanner.nextInt();
        scanner.nextLine();
        System.out.print("\nENTER QUANTITY: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        stock.sellProduct(chosenProduct-1, quantity);
    }

    public static void management(Stock stock) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n========================\n       MANAGEMENT       \n========================\n1 - STOCK RESUME\n2 - REGISTER PRODUCT\n3 - REPLEACE PRODUCT\n4 - RESUME CATEGORIES\n5 - CREATE CATEGORIES\n: ");
        String opt = scanner.nextLine();

        switch (opt) {
            case "1":
                System.out.println("\nSTOCK REPORT ======");
                stock.stockResume();
                System.out.println();
                break;
            case "2":
                System.out.println("\nWHAT TO REGISTER?\n===================");

                System.out.print("\nNAME: ");
                String nameRegister = scanner.nextLine();
                System.out.print("\nAMOUNT: ");
                int amount = scanner.nextInt();
                scanner.nextLine();

                System.out.println("\nSELECT THE CATEGORY:");
                stock.categoriesResume(true);
                System.out.println("\n===================");
                System.out.print(": ");
                int category = scanner.nextInt();
                scanner.nextLine();

                System.out.print("\nPERISHABLE PRODUCT? [y/n]: ");
                String perishableRegister = scanner.nextLine();

                switch (perishableRegister.toLowerCase()) {
                    case "y":
                        System.out.print("\nEXPIRATION DATE (dd/mm/yyyy): ");
                        String date = scanner.nextLine();
                        stock.registerProduct(nameRegister, amount, category-1, date);
                        break;
                    case "n":
                        stock.registerProduct(nameRegister, amount, category-1);
                        break;
                    default:
                        System.out.println("\nINVALID OPTION! PLEASE TRY AGAIN.");
                        break;
                }
                System.out.println();
                break;
            case "3":
                System.out.println("\nWHAT TO REPLACE?\n===================");
                int quantityOfProducts = stock.stockResume();

                if (quantityOfProducts == 0) {
                    System.out.println("NO PRODUCTS AVAILABLE!\n===================\n");
                    return;
                }

                System.out.print(": ");
                int chosenProduct = scanner.nextInt();
                scanner.nextLine();
                System.out.print("\nENTER QUANTITY: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();

                System.out.print("\nPERISHABLE PRODUCT? [y/n]: ");
                String perishableReplace = scanner.nextLine();
                switch (perishableReplace.toLowerCase()) {
                    case "y":
                        System.out.print("\nEXPIRATION DATE (dd/mm/yyyy): ");
                        String date = scanner.nextLine();
                        stock.replaceProduct(chosenProduct-1, quantity, date);
                        System.out.println();
                        break;
                    case "n":
                        stock.replaceProduct(chosenProduct-1, quantity);
                        break;
                    default:
                        System.out.println("\nINVALID OPTION! PLEASE TRY AGAIN.");
                        break;
                }
                System.out.println();
                break;
            case "4":
                System.out.println("\nCATEGORIES ========");
                stock.categoriesResume(false);
                System.out.println("\n===================\n");
                break;
            case "5":
                System.out.println("\nA NEW CATEGORY\n===================");

                System.out.print("\nNAME: ");
                String nameCategory = scanner.nextLine();
                System.out.print("\nWITH DESCRIPTION? [y/n]: ");
                String chooseCategory = scanner.nextLine();
                switch (chooseCategory.toLowerCase()) {
                    case "y":
                        System.out.print("\nDESC: ");
                        String description = scanner.nextLine();
                        stock.createCategory(nameCategory, description);
                        break;
                    case "n":
                        stock.createCategory(nameCategory);
                        break;
                    default:
                        System.out.println("\nINVALID OPTION! PLEASE TRY AGAIN.");
                        break;
                }
                System.out.println();
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

        stock.createCategory("Bebidas", "Bebidas geladas");
        stock.createCategory("Lanches");
        stock.registerProduct("Fanta", 200, 0, "27/11/2023");
        stock.registerProduct("Doritos", 100, 1, "10/10/2023");
        stock.replaceProduct(0, 15, "27/11/2023");


        while (working) {
            System.out.print("========================\n  INVENTORY MANAGEMENT  \n========================\n1 - SELL\n2 - MANAGEMENT\n0 - QUIT\n: ");
            String opt = scanner.nextLine();

            switch (opt) {
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
    }
}
