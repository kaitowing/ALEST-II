import java.util.ArrayList;


public class Macaco {
    private LinkedLista cocosPares = new LinkedLista();
    private LinkedLista cocosImpares = new LinkedLista();
    private int nome;
    private int impar;
    private int par;

    public Macaco(int cocos, ArrayList<Integer> pedrinhas, int numero, int imp, int pog){
        nome = numero;
        impar = imp;
        par = pog;
        for (int i = 0; i < cocos; i++) {
            Coco newcoco = new Coco(pedrinhas.get(i));
            if(newcoco.getPedrinhas()%2 == 0){
                cocosPares.add(newcoco);
            }else cocosImpares.add(newcoco);
        }
    }

    public void trocaMacaco(Macaco macaconovo){
        this.cocosImpares = macaconovo.cocosImpares;
        this.cocosPares = macaconovo.cocosPares;
    }

    public Coco passaCoco(boolean valor){
        if(valor) return cocosPares.removeFirst();
        else return cocosImpares.removeFirst();
    } 
    
    public void addCoco(Coco coco){
        if(coco.getPedrinhas()%2 == 0) cocosPares.add(coco);
        else cocosImpares.add(coco);
    }

    /**
     * @return ArrayList<Coco> return the cocos
     */
    public LinkedLista getCocosPares() {
        return cocosPares;
        
    }

    public LinkedLista getCocosImpares() {
        
        return cocosImpares ;
    }

    /**
     * @param cocos the cocos to set
     */

    /**
     * @return int return the nome
     */
    public int getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(int nome) {
        this.nome = nome;
    }


    /**
     * @return int return the impar
     */
    public int getImpar() {
        return impar;
    }

    /**
     * @param impar the impar to set
     */
    public void setImpar(int impar) {
        this.impar = impar;
    }

    /**
     * @return int return the par
     */
    public int getPar() {
        return par;
    }

    /**
     * @param par the par to set
     */
    public void setPar(int par) {
        this.par = par;
    }

    public int getCocos() {
        return cocosImpares.getSize() + cocosPares.getSize();
    }

    public void trocaCoco(LinkedLista cocosnovos, boolean valor){
        if(valor){
            cocosPares.addAll(cocosnovos);
        }else cocosImpares.addAll(cocosnovos);
    }

}
