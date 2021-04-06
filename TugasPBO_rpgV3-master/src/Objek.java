import java.util.ArrayList;


public class Objek {

    private String nama;
    public ArrayList<String> arrAksi = new ArrayList<>();
    public GameInfo objGameInfo;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
    }

    public ArrayList<String> getAksi() {
        return arrAksi;
    }

    public void setArrAksi(String vArrAksi){
        arrAksi.add(vArrAksi);
    }

    public void prosesAksi(int pilObj){

    }

}
