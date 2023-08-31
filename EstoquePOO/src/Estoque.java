import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Estoque {
    private List<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<Produto>();
    }

    public void cadastrarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public void adicionarProdutos(String nome, int quantidade) {
        for (Produto produto : this.produtos) {
            if (produto.getNome().toUpperCase().equals(nome.toUpperCase())) {
                produto.setQuantidade(quantidade);
                return;
            }
        }
    }

    public void removerProdutos(String nome, int quantidade) {
        for (Produto produto : this.produtos) {
            if (produto.getNome().toUpperCase().equals(nome.toUpperCase())) {
                produto.setQuantidade(-quantidade);
                return;
            }
        }
    }

    public List<Map<String, String>> verificar() {
        List<Map<String, String>> dados = new ArrayList<Map<String, String>>();
        
        for (Produto produto : this.produtos) {
            Map<String, String> dadosProduto = new HashMap<>();
            dadosProduto.put("nome", produto.getNome());
            dadosProduto.put("quantidade", Integer.toString(produto.getQuantidade()));
            dados.add(dadosProduto);
        }
        
        return dados;
    }
}
