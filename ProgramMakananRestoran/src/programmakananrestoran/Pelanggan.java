/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmakananrestoran;


public class Pelanggan extends Biodata {
    private String antrian;
    
    
    public Pelanggan(String antrian, String nama, String noTelp, String alamat){
        super(nama, noTelp, alamat);
        this.antrian = antrian;
    }
    
    public String getantrian(){
        return antrian;
    }
    
    public void setantrian(String NoMeja){
        this.antrian = antrian;
    }
}