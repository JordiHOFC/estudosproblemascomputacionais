import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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

        for(int i = 0; i < qtdItens; i++) {
            int valor = scanner.nextInt();
            int peso = scanner.nextInt();
            itens.add(new Par(peso,valor));
        }

        System.out.println("qtdItens " + qtdItens);
        System.out.println("capacidade " + capacidade);
        itens.forEach(System.out::println);
//        System.out.println("itens " + itens);

    }

    public static void main(String[] args) throws FileNotFoundException{
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
