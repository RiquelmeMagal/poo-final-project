import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Estoque estoque = new Estoque();
        String opc;

        do {
            System.out.println("=================\n     ESTOQUE\n=================");
            System.out.print("1 - VENDA\n2 - REPOR PRODUTO\n3 - CADASTRAR PRODUTO\n4 - VERIFICAR ESTOQUE\n0 - SAIR\n: ");
            opc = scan.nextLine();

            switch (opc) {
                case "1": 
                    System.out.print("DIGITE O NOME: ");
                    String vendasNome = scan.nextLine();
                    System.out.print("DIGITE A QUANTIDADE: ");
                    int vendasQuantidade = scan.nextInt();
                    estoque.removerProdutos(vendasNome, vendasQuantidade);
                    break;
                case "2":
                    System.out.print("DIGITE O NOME: ");
                    String reporNome = scan.nextLine();
                    System.out.print("DIGITE A QUANTIDADE: ");
                    int reporQuantidade = scan.nextInt();
                    estoque.adicionarProdutos(reporNome, reporQuantidade);
                    break;
                case "3":
                    System.out.print("NOME: ");
                    String cadastrarNome = scan.nextLine();
                    System.out.print("PREÇO: R$");
                    float cadastrarPreco = scan.nextFloat();
                    System.out.print("QUANTIDADE: ");
                    int cadastrarQuantidade = scan.nextInt();
                    System.out.print("GELADA (s/n): ");
                    String gelada = scan.nextLine();
                    if (gelada.toUpperCase().equals("S")) {
                        Bebida bebida = new Bebida(cadastrarNome, cadastrarPreco, cadastrarQuantidade, LocalDate.now(), true);
                    } else if (gelada.toUpperCase().equals("N")) {
                        Bebida bebida = new Bebida(cadastrarNome, cadastrarPreco, cadastrarQuantidade, LocalDate.now(), false);
                    } else {
                        System.out.println("ERRO!");
                    }
                    break;
                case "4":
                    List<Map<String, String>> dados = estoque.verificar();
                    System.out.println("\n============");
                    for (Map<String, String> produto : dados) {
                        System.out.println("NOME: " + produto.get("nome") + "\nQTD: " + produto.get("quantidade"));
                    }
                    System.out.println("\n============");
                    break;
                default:
                    System.out.println("\nOPÇÃO INVÁLIDA! POR FAVOR, TENTE NOVAMENTE.\n");
                    break;
            }
        } while (!opc.equals("0"));
    }
}
