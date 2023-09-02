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
                    String[] dadosVenda = dados('0');
                    estoque.removerProdutos(dadosVenda[0], Integer.parseInt(dadosVenda[1]));
                    break;
                case "2":
                    String[] dadosRepor = dados('0');
                    estoque.adicionarProdutos(dadosRepor[0], Integer.parseInt(dadosRepor[1]));
                    break;
                case "3":
                    String[] dadosUsuario = dados('3');

                    if (dadosUsuario[3].equals("S")) {
                        Bebida bebida = new Bebida(dadosUsuario[0], Float.parseFloat(dadosUsuario[1]), Integer.parseInt(dadosUsuario[2]), LocalDate.now(), true);
                        estoque.cadastrarProduto(bebida);
                    } else if (dadosUsuario[3].equals("N")) {
                        Bebida bebida = new Bebida(dadosUsuario[0], Float.parseFloat(dadosUsuario[1]), Integer.parseInt(dadosUsuario[2]), LocalDate.now(), false);
                        estoque.cadastrarProduto(bebida);
                    } else {
                        System.out.println("\nERRO!");
                    }
                    break;
                case "4": 
                    List<Map<String, String>> dados = estoque.verificar();
                    System.out.println("\n============");
                    for (Map<String, String> produto : dados) {
                        System.out.println("NOME: " + produto.get("nome") + "\nQTD: " + produto.get("quantidade"));
                        System.out.println("============");
                    }
                    System.out.println();
                    break;
                case "0":
                    System.out.println("\nFINALIZANDO APLICAÇÃO!\n");
                    break;
                default:
                    System.out.println("\nOPÇÃO INVÁLIDA! POR FAVOR, TENTE NOVAMENTE.\n");
                    break;
            }
        } while (!opc.equals("0"));
    }

    public static String[] dados(char opc) {
        Scanner scan = new Scanner(System.in);

        System.out.print("\nNOME: ");
        String nome = scan.nextLine();

        float preco = 0;
        if (opc == '3') {
            System.out.print("PREÇO: R$");
            preco = scan.nextFloat();
            scan.nextLine();
        }

        System.out.print("QUANTIDADE: ");
        int quantidade = scan.nextInt();
        scan.nextLine();

        if (opc == '3') {
            System.out.print("GELADO (s/n): ");
            String gelada = scan.nextLine();
            String[] dados = { nome.toUpperCase(), Float.toString(preco), Integer.toString(quantidade), "Z" };

            if (gelada.toUpperCase().equals("S")) {
                dados[3] = "S";
            } else if (gelada.toUpperCase().equals("N")) {
                dados[3] = "N";
            }

            return dados;
        } else {
            String[] dados = { nome, Integer.toString(quantidade) };
            return dados;
        }
    }
}
