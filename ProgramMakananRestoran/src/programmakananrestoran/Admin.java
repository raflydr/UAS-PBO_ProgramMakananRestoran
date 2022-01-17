/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmakananrestoran;


public class Admin extends Biodata {
    private String password;
    
    public Admin(String password, String nama, String noTelp, String alamat){
        super (nama, noTelp, alamat);
        this.password = password;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
}

    
    
    

