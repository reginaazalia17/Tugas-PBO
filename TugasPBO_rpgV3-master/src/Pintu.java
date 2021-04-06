import java.util.ArrayList;

public class Pintu extends Objek{

    public Pintu() {
        //init pilihan
        super.setNama("Pintu");
        super.setArrAksi("Deskripsikan "+super.getNama());
        super.setArrAksi("Coba buka "+super.getNama());
    }

    @Override
    public void prosesAksi(int subPil) {
        //1: deskripsikan
        //2: buka pintu
        if (subPil==1) {
            System.out.println(super.getNama()+" berwarna merah dengan tulisan 'EXIT' di atas ");
        } else if (subPil==2) {
            //cek apakah mempunyai kunci
            if (super.objGameInfo.getObjPlayer().cariItem("Kunci")) {
                //kunci ada, pintu terbuka
                System.out.println("Player menggunakan kunci untuk membuka "+getNama()+" dan "+getNama()+" terbuka!");
                super.objGameInfo.setGameOver(true); //game over
            } else {
                //kunci tidak ada
                System.out.println("Player mencboa membuka "+getNama()+". TERKUNCI!");
            }
        }
    }
}