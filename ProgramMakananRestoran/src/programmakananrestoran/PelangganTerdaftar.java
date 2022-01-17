/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmakananrestoran;


public class PelangganTerdaftar {
    private Pelanggan plgn;
    private int indexMenu;
    private String kodePelanggan;
    
    public PelangganTerdaftar(Pelanggan pelanggan, int indexMenu, String kodePelanggan){
        this.plgn = plgn;
        this.indexMenu = indexMenu;
        this.kodePelanggan = kodePelanggan;
    }
    
    public Pelanggan getPelanggan(){
        return plgn;
    }
    
    public int getIndexMenu(){
        return indexMenu;
    }
    
     public String getkodePelanggan(){
        return kodePelanggan;
    }
 
    public void setPelanggan(Pelanggan plgn){
        this.plgn = plgn;
    }
    
    public void setIndexMenu(int indexMenu){
        this.indexMenu = indexMenu;
    }
    
    public void setKodePelanggan(String kodePelanggan){
        this.kodePelanggan = kodePelanggan;
    }    
}

