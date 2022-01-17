/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmakananrestoran;
import java.util.*;

public class ProgramMakananRestoran {
private static Scanner input = new Scanner(System.in);
private static Pelanggan[] pelanggan = new Pelanggan[20];
private static Admin[] admin = new Admin[20];
private static PelangganTerdaftar[] terdaftar = new PelangganTerdaftar[20];
public static int pilMenu;
private static int qtypesan;
private static int jumPelanggan = 0;
private static int cekAdmin;


    
    public static void main(String[] args) {
    dataAdmin();
       int pil;
        
        do{
            System.out.println("Jumlah Pelanggan : " +jumPelanggan);
            System.out.println("1. Login Admin");
            System.out.println("2. Lihat Pelanggan");
            System.out.println("3. Biodata Admin");
            
            System.out.print("Pilih : ");
            pil = input.nextInt();
            input.nextLine();
            switch(pil){
                case 1:
                    loginAdmin();
                    break;
                    
                case 2:
                    viewPelanggan();
                    break;
                   
                case 3:
                    viewAdmin();
                    break;
                default:
                    System.out.println("Exit");
            }
        }while(pil < 4 && pil != 4);
    }
    static int dataAdmin(){
        String namaAdmin[] = {"Rafly", "Alvian"};
        String passAdmin[] = {"01", "02"};
        String noTelpAdmin[] = {"083", "085"};
        String alamatAdmin[] = {"Jl. Merpati", "Jl. Mawar"};
        
        for (int i=0; i < namaAdmin.length; i++){
            admin[i] = new Admin(passAdmin[i], namaAdmin[i], noTelpAdmin[i], alamatAdmin[i]);
        }
        return namaAdmin.length;
    }
    static void loginAdmin(){
        System.out.println("Nama : ");
        String nama = input.next();
        System.out.println("Password : ");
        String password = input.next();
        cekAdmin = login(nama, password);
        System.out.println("Selamat Datang " +admin[cekAdmin].getNama());
        int pil;
        
        do{
            System.out.println("Jumlah Pelanggan : " +jumPelanggan);
            System.out.println("1. Daftarkan Pelanggan");
            System.out.println("2. Ubah Data Pelanggan");
            System.out.println("3. Lihat Pelanggan Terdaftar");
            System.out.println("4. Hapus Pelanggan");
            System.out.println("0. Log out");
            
            System.out.print("Pilih : ");
            pil = input.nextInt();
            input.nextLine();
            switch(pil){
                case 1:
                    insertPelanggan();
                    break;
                case 2:
                    updatePelanggan();
                    break;
                case 3:
                    viewPelanggan();
                    break;
                case 4:
                    deletePelanggan();
                    break;
            }
        }while (pil !=0);    
    
    }
    static int login (String nama, String password){
        int loop = 0;
        for(int i=0; i <= dataAdmin(); i++){
            if(admin[i].getNama().equals(nama) && admin[i].getPassword().equals(password)){
                break;
            }else{
                loop++;
            }
        }
        return loop;
    }
    
    static void insertPelanggan(){
        System.out.println("Input Nama : ");
        String nama = input.nextLine();
        System.out.println("Input Antrian : ");
        String umur = input.nextLine();
        System.out.println("Input Alamat : ");
        String alamat = input.nextLine();
        System.out.println("Input No. Telp : ");
        String noTelp = input.nextLine();
        
        pelanggan[jumPelanggan] = new Pelanggan(umur, nama, noTelp, alamat);
        insertMenu();
    }
    static void insertMenu(){
        
        System.out.println("Menu : ");
        for(int i=0; i < MenuMakanan.menu.length; i++){
            System.out.println(i + ". " + MenuMakanan.menu[i]);
        }
        System.out.println("Pilih Menu : ");
        pilMenu = input.nextInt();
        System.out.println("Berapa Pesanan : ");
        qtypesan = input.nextInt();
        System.out.println("Input Kode Pelanggan : ");
        String kodePelanggan = input.next();
        terdaftar[jumPelanggan] = new PelangganTerdaftar(pelanggan[jumPelanggan],pilMenu, kodePelanggan);
        jumPelanggan = jumPelanggan + 1;

    }
    static void updatePelanggan(){
        System.out.print("Masukan kode pelanggan yang mau di EDIT : ");
        String search = input.next();
        int cari = 0;
        do{
            if(cari == jumPelanggan){
                System.err.println("Tidak ada data");
                break;
            }else if(terdaftar[cari].getkodePelanggan().equals(search)){
                int pilEdit;
                do{
                    System.out.println("Pilih data yang ingin diubah : ");
                    System.out.println("1. Lihat Pelanggan");
                    System.out.println("2. Nama");
                    System.out.println("3. Alamat");
                    System.out.println("4. No Telp");
                    System.out.println("5. Antrian");
                    System.out.println("6. Menu");
                    System.out.println("0. Exit");
                    pilEdit = input.nextInt();
                    input.nextLine();
                    if (pilEdit == 1){
                        System.out.println("======================================================");
                        System.out.println("Kode Peserta : " +terdaftar[cari].getkodePelanggan());
                        System.out.println("======================================================");
                        System.out.println("Nama : " +pelanggan[cari].getNama()
                                + "\n Antrian : " +pelanggan[cari].getantrian()
                                + "\n Alamat : " +pelanggan[cari].getAlamat()
                                + "\n No Telp : " +pelanggan[cari].getNoTelp()
                                + "\n Menu : " +MenuMakanan.menu[terdaftar[cari].getIndexMenu()]
                                + "\n Banyak Pesanan : " +qtypesan);
                        System.out.println("======================================================");
                        
                    }else if (pilEdit == 2){
                        System.out.print("Ubah Nama : ");
                        String editNama = input.nextLine();
                        pelanggan [cari].setNama(editNama);
                    }else if(pilEdit == 3){
                        System.out.print("Ubah Alamat : ");
                        String editAlamat = input.nextLine();
                        pelanggan [cari].setAlamat(editAlamat);
                    }else if(pilEdit == 4){
                        System.out.print("Ubah No Telp : ");
                        String editNoTelp = input.nextLine();
                        pelanggan [cari].setNoTelp(editNoTelp);
                    }else if (pilEdit == 5){
                        System.out.print("Ubah Antrian : ");
                        String editUmur = input.nextLine();
                        pelanggan [cari].setantrian(editUmur);
                    }else if (pilEdit == 6){
                        System.out.println("Pilih Menu : ");
                        for (int i=0; i < MenuMakanan.menu.length; i++){
                            System.out.println(i + ". " + MenuMakanan.menu[i]);
                        }System.out.println("Pilih Menu : ");
                        int editMenu = input.nextInt();
                        terdaftar[cari].setIndexMenu(editMenu);
                        System.out.println("Banyak Pesanan : ");
                        qtypesan = input.nextInt();
                    }
                    
                }while(pilEdit != 0);
                break;
            }else{
                cari = cari + 1;
            }
        }while(true);
    }
    static void viewPelanggan(){
        if(jumPelanggan == 0){
            System.out.println("Belum ada pelanggan terdaftar");
        }else{
            for(int i=0; i < jumPelanggan; i++){
                System.out.println("======================================================");
                System.out.println("Kode Pelanggan : " + terdaftar[i].getkodePelanggan());
                System.out.println("======================================================");
                System.out.println("Nama                : " +pelanggan[i].getNama()
                                + "\n Antrian           : " +pelanggan[i].getantrian()
                                + "\n Alamat            : " +pelanggan[i].getAlamat()
                                + "\n No Telp           : " +pelanggan[i].getNoTelp()
                                + "\n Menu              : " +MenuMakanan.menu[terdaftar[i].getIndexMenu()]
                                + "\n Banyak Pesanan    : " +qtypesan);
                        System.out.println("======================================================");
            }
        }
    }
    static void viewAdmin(){
        for (int i=0; i < dataAdmin(); i++){
            System.out.println("======================================================");
            System.out.println("Nama : " +admin[i].getNama()
                                + "\n No Telp : " +admin[i].getNoTelp()
                                + "\n Alamat : " +admin[i].getAlamat());
            System.out.println("======================================================");
        }
    }
    static void deletePelanggan(){
        System.out.print("Masukan kode pelanggan yang akan di HAPUS : ");
        String search = input.next();
        input.nextLine();
        int cari = 0;
        do{
            if(cari == jumPelanggan){
                System.err.println("Tidak Ada Data!");
                break;
            }else if(terdaftar[cari].getkodePelanggan().equals(search)){
                if(cari == jumPelanggan - 1){
                    jumPelanggan = jumPelanggan - 1;
                }else{
                    for(int i=cari; i < jumPelanggan; i++){
                        terdaftar[i] = terdaftar[i + 1];
                        pelanggan[i] = pelanggan[i + 1];
                    }jumPelanggan = jumPelanggan - 1;
                }break;
            }else{
                cari = cari + 1;
            }
        }while (true);
    }
}

