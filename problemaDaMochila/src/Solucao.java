import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solucao {


    // java LerArquivo.java < exemplo.txt
    // quantidateDeItens capacidade
    // itens - valor peso
    public static void problemaDaMochila() throws FileNotFoundException {
//        String caminho = "low-dimensional/f1_l-d_kp_10_269";
//        File arquivo = new File(caminho);
        Scanner scanner = new Scanner(System.in);
        int qtdItens = scanner.nextInt();
        int capacidade = scanner.nextInt();


        ArrayList<Par> itens = new ArrayList<>();

        for (int i = 0; i < qtdItens; i++) {
            int valor = scanner.nextInt();
            int peso = scanner.nextInt();
            itens.add(new Par(peso, valor));
        }

        System.out.println("qtdItens " + qtdItens);
        System.out.println("capacidade " + capacidade);
        itens.forEach(System.out::println);
        List<Integer> solucaoExemplo = List.of(1, 0, 1, 0, 0, 1, 0, 1, 1, 0);
        System.out.println("Solucao: " + solucaoExemplo + "  tamanho: " + solucaoExemplo.size());
        System.out.println("Funcao avaliacao: " + funcaoAvaliacao(solucaoExemplo, itens, capacidade, qtdItens));


//        System.out.println("itens " + itens);


    }

    public static double funcaoAvaliacao(List<Integer> solucao, ArrayList<Par> valorEPesoDoItem, int capacidade, int quantidadeItens) {
        double avaliacaoDaMochila = 0;
        int pesoMochila = 0;
        for (int i = 0; i < quantidadeItens; i++) {
            //somando o valor dos itens que estão na mochila -- 0 se nao tiver 1 se tiver portando - valor * item
            avaliacaoDaMochila += solucao.get(i) * valorEPesoDoItem.get(i).valor;
            pesoMochila += solucao.get(i) * valorEPesoDoItem.get(i).peso;
        }
        //caso o peso da mochila seja maior que a capacidade
        if (pesoMochila > capacidade) {
            int quantidadeQueExtrapolou = pesoMochila - capacidade;
            double porcetagemExtrapolada = (double) quantidadeQueExtrapolou / capacidade;
            return avaliacaoDaMochila -= (avaliacaoDaMochila * porcetagemExtrapolada);
        }


        return avaliacaoDaMochila;
    }

    public static void main(String[] args) throws FileNotFoundException {
        problemaDaMochila();
    }


    private static class Par {
        int peso;
        int valor;

        Par(int peso, int valor) {
            this.peso = peso;
            this.valor = valor;
        }

        @Override
        public String toString() {
            return "(" + valor + ", " + peso + ")";
        }
    }
}
