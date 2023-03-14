import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        App.reader();
    }

    public static void bingo(ArrayList<String[]> linha){
        ListaMacacos listademacacos = new ListaMacacos();
        int rodadas = Integer.parseInt(linha.get(0)[1]);
        //System.out.println("Entrou na lista loop");
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
        
        //System.out.println("Entrou nas rodads loop");
        for (int p = 0; p < rodadas; p++) {
            //
            int k = listademacacos.getMacacos().size();
            for (int i = 0; i < k; i++) {
        
                Macaco macacoAtual = listademacacos.getMacacos().get(i);

                int impar = macacoAtual.getImpar();
                int par = macacoAtual.getPar();

                Macaco macacopar = listademacacos.buscaMacaco(par);
                Macaco macacoimpar = listademacacos.buscaMacaco(impar);
                
                
                macacopar.trocaCoco(macacoAtual.getCocosPares(), true);
                macacoimpar.trocaCoco(macacoAtual.getCocosImpares(), false);
                listademacacos.buscaMacaco(par).trocaMacaco(macacopar);
                listademacacos.buscaMacaco(par).trocaMacaco(macacoimpar);
                listademacacos.getMacacos().get(i).trocaMacaco(macacoAtual);

            }         
        }
        Macaco maior = listademacacos.getMacacos().get(0);

        for (int i = 1; i < listademacacos.getMacacos().size(); i++) {
            if(listademacacos.getMacacos().get(i).getCocos() >= maior.getCocos()){
                maior = listademacacos.getMacacos().get(i);
            }
        }
        String nomeGanhador = "Macaco Ganhador: " + maior.getNome() + "\n";
        System.out.println(nomeGanhador);
    }

    public static void reader(){
        long start = System.currentTimeMillis();
        String stringnome = "";
        for (int i = 0; i < 8; i++) {
            switch(i){
                case 0:
                stringnome = String.format("%04d", 50);
                break;
                case 1:
                stringnome = String.format("%04d", 100);
                break;
                case 2:
                stringnome = String.format("%04d", 200);
                break;
                case 3:
                stringnome = String.format("%04d", 400);
                break;
                case 4:
                stringnome = String.format("%04d", 600);
                break;
                case 5:
                stringnome = String.format("%04d", 800);
                break;
                case 6:
                stringnome = String.format("%04d", 900);
                break;
                case 7:
                stringnome = "1000";
            }
            Path path = Paths.get("Macaquinhos\\src\\testes\\"+ stringnome + "macacos.txt");
            try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))){
                System.out.println("Teste" + stringnome +" rodando");
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
        long end = System.currentTimeMillis();
        long timeTakenMS = end - start;
        System.out.println("Tempo de execução da construção do macaco: " + timeTakenMS + "ms");
    }
}
