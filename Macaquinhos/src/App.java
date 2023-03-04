import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        App.reader();
    }

    public static void bingo(ArrayList<String[]> linha){
        ListaMacacos listademacacos = new ListaMacacos();
        int rodadas = Integer.parseInt(linha.get(0)[1]);

        for (int k = 1; k < linha.size(); k++) {
            int cocos;
            ArrayList<Integer> pedrinhas = new ArrayList<>();
            int numero;
            int par, impar;
            String[] idMacacos = linha.get(k);
            par = Integer.parseInt(idMacacos[4]);
            impar = Integer.parseInt(idMacacos[7]);
            cocos = Integer.parseInt(idMacacos[9]);
            numero = Integer.parseInt(idMacacos[1]);
            for (int j = 11; j < idMacacos.length; j++) {
                pedrinhas.add(Integer.parseInt(idMacacos[j]));
            }
            Macaco macaco = new Macaco(cocos, pedrinhas, numero, impar, par);
            listademacacos.getMacacos().add(macaco);
        }
        int vezesRodadas=0;
        for (int p = 0; p < rodadas; p++) {
            vezesRodadas++;
            for (int i = 0; i < listademacacos.getMacacos().size(); i++) {
                Macaco macacoAtual = listademacacos.getMacacos().get(i);
    
                int impar = macacoAtual.getImpar();
                int par = macacoAtual.getPar();
                ArrayList<Coco> coco = macacoAtual.getCocos();
                int tamanho = coco.size();

                for (int j = 0; j < tamanho; j++) {
                    if(coco.get(0).getPedrinhas()%2 == 0){
                        listademacacos.buscaMacaco(par).addCoco(listademacacos.getMacacos().get(i).passaCoco());
                    }else{
                        listademacacos.buscaMacaco(impar).addCoco(listademacacos.getMacacos().get(i).passaCoco());
                    }
                }
            }         
        }
        Macaco maior = listademacacos.getMacacos().get(0);

        for (int i = 1; i < listademacacos.getMacacos().size(); i++) {
            if(listademacacos.getMacacos().get(i).getCocos().size() >= maior.getCocos().size()){
                maior = listademacacos.getMacacos().get(i);
            }
        }
        String nomeGanhador = vezesRodadas + "; Macaco Ganhador: " + maior.getNome();
        System.out.println(nomeGanhador);
    }

    public static void reader(){
            Path path = Paths.get("src\\teste.txt");
            try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))){
                System.out.println("Teste rodando");
                ArrayList<String[]> Linhas = new ArrayList<>();
                while (sc.hasNext()){
                    String str = sc.nextLine();
                    String[] arrOfStr = str.split(" ");
                    Linhas.add(arrOfStr);
            }
            App.bingo(Linhas);
        }catch (IOException x){
                System.err.format("Erro de E/S: %s%n", x);
        }
    }
}
