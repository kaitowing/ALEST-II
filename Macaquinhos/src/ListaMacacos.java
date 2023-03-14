import java.util.ArrayList;

public class ListaMacacos {
    private ArrayList<Macaco> macacos;

    public ListaMacacos(){
        macacos = new ArrayList<>();
    }

    public Macaco buscaMacaco(int nomeMacaco){
            return macacos.get(nomeMacaco);
          
    }

    /**
     * @return ArrayList<Macaco> return the macacos
     */
    public ArrayList<Macaco> getMacacos() {
        return macacos;
    }

    /**
     * @param macacos the macacos to set
     */
    public void setMacacos(ArrayList<Macaco> macacos) {
        this.macacos = macacos;
    }

}
