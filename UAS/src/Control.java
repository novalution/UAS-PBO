
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Date;  
import java.util.GregorianCalendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class Control {
    int nikah;
    Date tanggal;
    String golongan;
    String nomor;
    String kodes;
    int idx;
    Scanner input = new Scanner(System.in);
    ArrayList<String> kode = new ArrayList<>();
    ArrayList<String> nama = new ArrayList<>();
    ArrayList<String> gol = new ArrayList<>();
    ArrayList<Date> tgl = new ArrayList<>();
    ArrayList<Integer> married = new ArrayList<>();
    ArrayList<Integer> kids = new ArrayList<>();
    ArrayList<Integer> age = new ArrayList<>();
    void menu(){
        System.out.println("------------------");
        System.out.println("    Olah Data");
        System.out.println("------------------");
        System.out.println("Menu: ");
        System.out.println("1.Tambah data");
        System.out.println("2.Hapus data");
        System.out.println("3.Cari data");
        System.out.println("4.Tampilkan data");
        System.out.println("5.Keluar");
        System.out.print("Masukan pilihan anda : ");
        String pilihan = input.nextLine();
        switch(pilihan){
            case "1":
                tambah();
                break;
            case "2":
                hapus();
                break;
            case "3":
                cari();
                break;
            case "4":
                lihat();
                break;
            case "5":
                System.exit(0);
            default:
                System.out.println("Masukan sesuai menu!");
                menu();
        }
    }
    void tambah(){
        System.out.println("-------------------");
        System.out.println("    Tambah Data");
        System.out.println("-------------------");
        while(true){
            System.out.print("Masukan Kode Karyawan : ");
            this.kodes = input.nextLine();
            if(kode.contains(kodes)){
                System.out.println("Kode sudah terdaftar");
            }
            else{
                break;
            }
        }
        System.out.print("Masukan Nama Karyawan : ");
        String namas = input.nextLine();
        System.out.print("Masukan Alamat Karyawan : ");
        String Alamat = input.nextLine();
        System.out.print("Masukan Tahun Lahir Karyawan yang ingin ditambahkan : ");
        int tahun = input.nextInt();
        System.out.print("Masukan Bulan Lahir Karyawan yang ingin ditambahkan : ");
        int bulan = input.nextInt();
        System.out.print("Masukan Hari Lahir Karyawan yang ingin ditambahkan  : ");
        int hari = input.nextInt();
        input.nextLine();
        this.tanggal = new GregorianCalendar(tahun, bulan - 1, hari).getTime();
        LocalDate ld = new java.sql.Date( tanggal.getTime())
                                .toLocalDate();
        LocalDate x = LocalDate.now();
        Period usia = Period.between(ld, x);
        int umur = usia.getYears();
        while(true){
            System.out.print("Masukan Golongan (A / B / C / D) : ");
            this.golongan = input.nextLine();
            if(!("A".equals(golongan)) & !("B".equals(golongan)) & !("C".equals(golongan)) &!("D".equals(golongan))){
                System.out.println("Masukan sesuai menu!");
            }
            else{
                break;
            }
        }
        while(true){
            System.out.print("Masukan Status Menikah (0: Belum Menikah, 1: Sudah Menikah) : ");
            this.nikah = input.nextInt();
            if(this.nikah != 0 & this.nikah!= 1){
                System.out.println("Masukan sesuai menu!");
            }
            else{
                break;
            }
        }
        kode.add(kodes);
        nama.add(namas);
        tgl.add(tanggal);
        gol.add(golongan);
        married.add(nikah);
        age.add(umur);
        if(nikah == 1){
            System.out.print("Masukan Jumlah Anak : ");
            int anak = input.nextInt();
            kids.add(anak);
        }
        else{
            kids.add(0);
        }
        System.out.println("Data telah ditambahkan");
        System.out.println("\n");
        while(true){
            System.out.println("------------------");
            System.out.println("    SubMenu");
            System.out.println("------------------");
            System.out.println("1. Kembali ke menu utama");
            System.out.println("2. Tambah Data lagi");
            System.out.println("Pilih SubMenu : ");
            int submenu = input.nextInt();
            input.nextLine();
            switch (submenu) {
                case 1:
                    menu();
                    break;
                case 2:
                    tambah();
                    break;
                default:
                    System.out.println("Masukan angka sesuai menu!");
                    break;
        }
    }
    }
    void hapus(){
        System.out.println("------------------");
        System.out.println("    Hapus Data");
        System.out.println("------------------");
        System.out.print("Masukkan Kode Karyawan yang akan dihapus: ");
        this.nomor = input.next();
        idx = Collections.binarySearch(kode, nomor);
        if (married.get(idx) == 0){
            kode.remove(idx);
            nama.remove(idx);
            tgl.remove(idx);
            gol.remove(idx);
            married.remove(idx);
        }
        else{
            kode.remove(idx);
            nama.remove(idx);
            tgl.remove(idx);
            gol.remove(idx);
            married.remove(idx);
            kids.remove(idx);
        }
        
        System.out.println("Data telah dihapus");
        System.out.println("\n");
        while(true){
            System.out.println("------------------");
            System.out.println("    SubMenu");
            System.out.println("------------------");
            System.out.println("1. Kembali ke menu utama");
            System.out.println("2. Hapus Data lagi");
            System.out.println("Pilih SubMenu : ");
            int submenu = input.nextInt();
            input.nextLine();
            switch (submenu) {
                case 1:
                    menu();
                    break;
                case 2:
                    hapus();
                    break;
                default:
                    System.out.println("Masukan angka sesuai menu!");
                    break;
        }
    }
    }
    void cari(){
        System.out.print("Masukkan Kode Karyawan yang akan dicari : ");
        this.nomor = input.next();
        System.out.println("====================================================");
        System.out.println("              DATA PROFILE KARYAWAN ");
        System.out.println("----------------------------------------------------");
        idx = Collections.binarySearch(kode, nomor);
        System.out.println("Kode Karyawan               : "+this.kode.get(idx));
        System.out.println("Nama Karyawan               : "+this.nama.get(idx));
        System.out.println("Golongan Karyawan           : "+this.gol.get(idx));
        System.out.println("Usia Karyawan               : "+this.age.get(idx));
        System.out.println("Status Menikah              : "+this.married.get(idx));
        System.out.println("Jumlah Anak                 : "+this.kids.get(idx));
        System.out.println("----------------------------------------------------");
        Golongan g1 = new Golongan();
        GolonganA p1 = new GolonganA (this.married.get(idx));
        GolonganA u1 = new GolonganA (this.age.get(idx));
        GolonganA a1 = new GolonganA (this.kids.get(idx));
        GolonganB p2 = new GolonganB (this.married.get(idx));
        GolonganB u2 = new GolonganB (this.age.get(idx));
        GolonganB a2 = new GolonganB (this.kids.get(idx));
        GolonganC p3 = new GolonganC (this.married.get(idx));
        GolonganC u3 = new GolonganC (this.age.get(idx));
        GolonganC a3 = new GolonganC (this.kids.get(idx));
        GolonganD p4 = new GolonganD (this.married.get(idx));
        GolonganD u4 = new GolonganD (this.age.get(idx));
        GolonganD a4 = new GolonganD (this.kids.get(idx));
        if("A".equals(this.gol.get(idx))){
            System.out.println("Gaji Pokok               : Rp " + g1.gajiPokokA()); 
            System.out.println("Tunjangan Istri/Suami    : Rp "+ p1.tunjanganNikah());
            System.out.println("Tunjangan Pegawai        : Rp "+ u1.tunjanganUsia());
            System.out.println("Tunjangan Anak           : Rp "+ a1.tunjanganAnak());
            System.out.println("---------------------------------------------------- +");
            long gk = g1.gajiPokokA() + p1.tunjanganNikah() + u1.tunjanganUsia() + a1.tunjanganAnak();
            System.out.println("Gaji Kotor               : Rp "+ gk);
            long pot = gk/40;
            System.out.println("Potongan                 : Rp "+ pot);
            System.out.println("---------------------------------------------------- -");
            long gb = gk - pot;
            System.out.println("Gaji Bersih              : Rp "+ gb);
        }
        if("B".equals(this.gol.get(idx))){
            System.out.println("Gaji Pokok               : Rp " + g1.gajiPokokB()); 
            System.out.println("Tunjangan Istri/Suami    : Rp "+ p2.tunjanganNikah());
            System.out.println("Tunjangan Pegawai        : Rp "+ u2.tunjanganUsia());
            System.out.println("Tunjangan Anak           : Rp "+ a2.tunjanganAnak());
            System.out.println("---------------------------------------------------- +");
            long gk = g1.gajiPokokB() + p1.tunjanganNikah() + u1.tunjanganUsia() + a2.tunjanganAnak();
            System.out.println("Gaji Kotor               : Rp "+ gk);
            long pot = gk/40;
            System.out.println("Potongan                 : Rp "+ pot);
            System.out.println("---------------------------------------------------- -");
            long gb = gk - pot;
            System.out.println("Gaji Bersih              : Rp "+ gb);
        }
        if("C".equals(this.gol.get(idx))){
            System.out.println("Gaji Pokok               : Rp " + g1.gajiPokokC()); 
            System.out.println("Tunjangan Istri/Suami    : Rp "+ p3.tunjanganNikah());
            System.out.println("Tunjangan Pegawai        : Rp "+ u3.tunjanganUsia());
            System.out.println("Tunjangan Anak           : Rp "+ a3.tunjanganAnak());
            System.out.println("---------------------------------------------------- +");
            long gk = g1.gajiPokokB() + p1.tunjanganNikah() + u1.tunjanganUsia() + a3.tunjanganAnak();
            System.out.println("Gaji Kotor               : Rp "+ gk);
            long pot = gk/40;
            System.out.println("Potongan                 : Rp "+ pot);
            System.out.println("---------------------------------------------------- -");
            long gb = gk - pot;
            System.out.println("Gaji Bersih              : Rp "+ gb);
        }
        if("D".equals(this.gol.get(idx))){
            System.out.println("Gaji Pokok               : Rp " + g1.gajiPokokD()); 
            System.out.println("Tunjangan Istri/Suami    : Rp "+ p2.tunjanganNikah());
            System.out.println("Tunjangan Pegawai        : Rp "+ u4.tunjanganUsia());
            System.out.println("Tunjangan Anak           : Rp "+ a4.tunjanganAnak());
            System.out.println("---------------------------------------------------- +");
            long gk = g1.gajiPokokB() + p1.tunjanganNikah() + u1.tunjanganUsia() + a4.tunjanganAnak();
            System.out.println("Gaji Kotor               : Rp "+ gk);
            long pot = gk/40;
            System.out.println("Potongan                 : Rp "+ pot);
            System.out.println("---------------------------------------------------- -");
            long gb = gk - pot;
            System.out.println("Gaji Bersih              : Rp "+ gb);
        }
        while(true){
            System.out.println("------------------");
            System.out.println("    SubMenu");
            System.out.println("------------------");
            System.out.println("1. Kembali ke menu utama");
            System.out.println("2. Cari Data lagi");
            System.out.println("Pilih SubMenu : ");
            int submenu = input.nextInt();
            input.nextLine();
            switch (submenu) {
                case 1:
                    menu();
                    break;
                case 2:
                    cari();
                    break;
                default:
                    System.out.println("Masukan angka sesuai menu!");
                    break;
        }
    }
    }
    void lihat(){
            Align align = new Align();
            System.out.println("=======================================================================");
            System.out.println("                       DATA KARYAWAN ");
            System.out.println("-----------------------------------------------------------------------");
            SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
            align.addLine("KODE", "NAMA", "GOL", "STATUS NIKAH", "JML ANAK");

            for ( int i = 0; i < nama.size(); i++) { 
                String menikah = (married.get(i)==0)?"Belum Menikah":"Sudah Menikah";
                if ("Sudah Menikah".equals(menikah)){
                    String anaknya = kids.get(i).toString();
                    align.addLine(kode.get(i),nama.get(i),gol.get(i),menikah,anaknya);   
                }
                else if("Belum Menikah".equals(menikah)){
                    align.addLine(kode.get(i),nama.get(i),gol.get(i),menikah);
                }           
            }
            align.output((String s) -> System.out.println(s));
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("Jumlah Karyawan : " + nama.size()); 
            System.out.println("\n");
            while(true){
                System.out.println("------------------");
                System.out.println("    SubMenu");
                System.out.println("------------------");
                System.out.println("1. Kembali ke menu utama");
                System.out.println("2. Lihat Data lagi");
                System.out.println("Pilih SubMenu : ");
                int submenu = input.nextInt();
                input.nextLine();
                switch (submenu) {
                    case 1:
                        menu();
                        break;
                    case 2:
                        lihat();
                        break;
                    default:
                        System.out.println("Masukan angka sesuai menu!");
                        break;
            }
        }
    }
}
