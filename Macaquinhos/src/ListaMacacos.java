import java.util.ArrayList;

public class ListaMacacos {
    private ArrayList<Macaco> macacos;

    public ListaMacacos(){
        macacos = new ArrayList<>();
    }

    public Macaco buscaMacaco(int nomeMacaco){
        for (int i = 0; i < macacos.size(); i++) {
            if(macacos.get(i).getNome() == nomeMacaco){
                return macacos.get(i);
            }
        }
        return null;
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
