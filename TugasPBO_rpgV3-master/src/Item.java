import java.util.ArrayList;

public class Item extends Objek{
    private String deskripsi;
    private Ruangan objRuangan;
    //ruangan tempat item
    // jika null artinya item dipegang npc atau plyaer

    //constructor
    public Item (String nama){
        super.setNama(nama);
        // -- dipindahkan karena dinamik tergantung diambil atau dibuang
    }

    @Override
    public void prosesAksi(int pil) {
        //pilihan user untuk aksi yang akan diambil
        //urutan harus sama dengan isi arrAksi
        if (pil==1) {
            System.out.println(deskripsi);
        } else  if (pil==2) {  //bisa ambil atau buang
            if (objRuangan==null) {
                //dipegang player, buang ke ruangan
                dibuang();
            } else {
                //ada di ruangan, diambil player
                diambil();
            }
        }
    }

    private void dibuang() {
        System.out.println("Item dibuang player ke ruangan");
        super.objGameInfo.getObjPlayer().hapusItem(this); //hapus dari player
        super.objGameInfo.getObjRuangan().addItem(this);  //tambah ke ruangan
        objRuangan = super.objGameInfo.getObjRuangan(); // set ruangan
    }


    //pindahkan item dari ruangan ke player
    private void diambil() {
        System.out.println("Item diambil player");
        super.objGameInfo.getObjPlayer().addItem(this);     //tambahkan  objek ini (this) pada player
        objRuangan.hapusItem(this);                    //hapus item dari ruangan
        objRuangan = null;
    }

    public void printItem() {
        //print deskripsi item
        System.out.println(deskripsi);
    }


    public ArrayList<String> getAksi() {
        //aksi dinamik tergantung ada di ruangan atau dipegang player/npc
        ArrayList<String> arrOut = new ArrayList<>();
        if (objRuangan==null) {
            //ada di player, ada opsi buang
            arrOut.add("Deskripsi Item");
            arrOut.add("Buang item");
        } else {
            //ada di ruangan ada opsi ambil
            arrOut.add("Deskripsi Item");
            arrOut.add("Ambil item");
        }
        return(arrOut);
    }

    public void setObjRuangan(Ruangan objRuangan) {
        this.objRuangan = objRuangan;
    }
    public String getDeskripsi() {
        return deskripsi;
    }
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }


}
