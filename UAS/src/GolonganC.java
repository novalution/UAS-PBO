/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class GolonganC extends Golongan{
    public final int status;
    public final int umur;
    public final int anak;
    public GolonganC (int a){
        this.status = a;
        this.umur = a;
        this.anak = a;
    }
        long tunjanganNikah(){
            if(this.status == 1){
                long tunj = this.gajiPokokC()/10;
                return tunj;
            }
            else{
                return 0;
            } 
        }
        long tunjanganAnak(){
            if(this.anak > 0){
                long tunanak = this.gajiPokokC()/20*this.anak;   
                return tunanak; 
                }
            else{
                return 0;
                }                  
        }
        long tunjanganUsia(){
            if (umur > 30){
                long tunj = this.gajiPokokC()*15/100;
                return tunj;
            }
            else{
                return 0;
            }
        }
}
