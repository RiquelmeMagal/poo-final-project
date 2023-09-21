import java.util.Scanner;


public class App {
    public static void sell(Stock stock, Scanner scanner) throws Exception {
        System.out.println("\nWHAT TO BUY?\n===================");
        if (stock.stockResume() == 0) {
            System.out.println("NO PRODUCTS AVAILABLE!\n===================\n");
            return;
        }

        try {
            System.out.print(": ");
            int chosenProduct = scanner.nextInt();
            scanner.nextLine();

            System.out.print("\nENTER QUANTITY: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            stock.sellProduct(chosenProduct-1, quantity);
        } catch(Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public static void management(Stock stock, Scanner scanner) throws Exception {
        System.out.print("\n========================\n       MANAGEMENT       \n========================\n1 - STOCK RESUME\n2 - REGISTER PRODUCT\n3 - REPLEACE PRODUCT\n4 - RESUME CATEGORIES\n5 - CREATE CATEGORIES\n: ");
        String opt = scanner.nextLine();

        switch (opt) {
            case "1":
                System.out.println("\nSTOCK REPORT ======");
                if (stock.stockResume() == 0) {
                    System.out.println("===================\nEMPTY STOCK!\n===================");
                }
                break;
            case "2":
                System.out.println("\nWHAT TO REGISTER?\n===================");
                if (stock.getCategories().size() == 0) {
                    System.out.println("NO CATEGORIES REGISTERED\n===================\n");
                    return;
                }

                try {
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
                } catch(Exception exception) {
                    throw new Exception(exception.getMessage());
                }
                break;
            case "3":
                System.out.println("\nWHAT TO REPLACE?\n===================");
                if (stock.stockResume() == 0) {
                    System.out.println("NO PRODUCTS AVAILABLE!\n===================\n");
                    return;
                }

                try {
                    System.out.print(": ");
                    int chosenProduct = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("\nENTER QUANTITY: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();

                    if (stock.isPerishable(chosenProduct-1)) {
                        System.out.print("\nEXPIRATION DATE (dd/mm/yyyy): ");
                        String date = scanner.nextLine();
                        stock.replaceProduct(chosenProduct-1, quantity, date);
                    } else {
                        stock.replaceProduct(chosenProduct-1, quantity);
                    }    
                } catch(Exception exception) {
                    throw new Exception(exception.getMessage());
                }
                break;
            case "4":
                System.out.println("\nCATEGORIES ========");
                if (stock.categoriesResume(false) == 0) {
                    System.out.print("===================\nNO CATEGORIES REGISTERED");
                }
                System.out.print("\n===================\n");
                break;
            case "5":
                System.out.print("\nA NEW CATEGORY\n===================\nNAME: ");
                
                try {
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
                            System.out.print("\nINVALID OPTION! PLEASE TRY AGAIN.");
                            break;
                    }
                } catch(Exception exception) {
                    throw new Exception(exception.getMessage());
                }
                break;
            default:
                System.out.print("\nINVALID OPTION! PLEASE TRY AGAIN.\n");
                break;
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean working = true;
        Stock stock = new Stock();

        while (working) {
            System.out.print("========================\n  INVENTORY MANAGEMENT  \n========================\n1 - SELL\n2 - MANAGEMENT\n0 - QUIT\n: ");

            try {
                String opt = scanner.nextLine();

                switch (opt) {
                    case "1":
                        sell(stock, scanner);
                        break;
                    case "2":
                        management(stock, scanner);
                        break;
                    case "0":
                        working = false;
                        break;
                    default:
                        System.out.println("\nINVALID OPTION! PLEASE TRY AGAIN.\n");
                        break;
                }
            } catch(Exception exception) {
                throw new Exception(exception.getMessage());
            }
        }
    scanner.close();
    }
}
