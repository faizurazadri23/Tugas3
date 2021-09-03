package product;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;

public class Product {

    public static void main(String[] args) {

        System.out.println("==========Selamat Datang==========");
        System.out.println("------MENU UTAMA-----");


        Scanner scanner = new Scanner(System.in);

        int pilihan = 0;

        System.out.println("====Silahkan Pilih Menu===");
        System.out.println("1. Input Produk");
        System.out.println("2. exit");

        System.out.print("Pilihan : ");
        pilihan = scanner.nextInt();

        switch (pilihan) {
            case 1:
                setProduk();
                break;

            case 2:
                System.exit(0);
                break;
        }


    }


    public static void setProduk() {
        System.out.println("==========Selamat Datang==========");
        System.out.println("Silahkan Masukkan Jenis Produk");


        Scanner scanner = new Scanner(System.in);

        String nama_produk, merek, satuan;
        double harga;

        System.out.println("====Pendaataan Data Pengguna===");
        System.out.println("Nama : ");
        nama_produk = scanner.nextLine();

        System.out.println("Merek : ");
        merek = scanner.nextLine();

        System.out.println("Satuan : ");
        satuan = scanner.nextLine();

        System.out.println("Harga : ");
        harga = scanner.nextDouble();

        Jenis_Produk jenis_produk = new Jenis_Produk();
        jenis_produk.setNama_produk(nama_produk);
        jenis_produk.setMerek(merek);
        jenis_produk.setHarga(harga);
        jenis_produk.setSatuan(satuan);

        Tanya(jenis_produk);


    }

    public static void Tanya(Jenis_Produk jenis_produk){
        Scanner scanner = new Scanner(System.in);
        int a =0;

        System.out.println("Apakah ingin melihat data yang anda masukkan ? ");
        System.out.println("Jika Ya , tekan 1");
        a = scanner.nextInt();
        if (a==1){
            getProduk(jenis_produk);
        }else {
            setProduk();
        }
    }

    public static void getProduk(Jenis_Produk jenis_produk) {
        System.out.println("====Data Anda======");
        System.out.println("Nama : " + jenis_produk.getNama_produk());
        System.out.println("Merek : " + jenis_produk.getMerek());
        System.out.println("Satuan " + jenis_produk.getSatuan());

        DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        decimalFormat.setDecimalFormatSymbols(formatRp);
        System.out.println("Harga : " + decimalFormat.format(jenis_produk.getHarga()));
    }
}
