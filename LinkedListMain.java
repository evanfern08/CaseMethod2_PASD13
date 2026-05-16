import java.util.Scanner;

public class LinkedListMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedListPembeli09 antrian = new LinkedListPembeli09();        // linked list untuk antrian pembeli
        LinkedListPesanan09 pesanan = new LinkedListPesanan09();        // linked list untuk pesanan
        int pilihan;

        do {
            System.out.println("\nSISTEM ANTRIAN ROYAL DELISH");        // Menu utama 
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Cetak Antrian");
            System.out.println("3. Hapus Antrian dan Pesan");
            System.out.println("4. Laporan Pesanan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu : ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Nama Pembeli : ");        // Input data pembeli baru → tambah ke antrian
                    String nama = sc.nextLine();
                    System.out.print("No HP : ");
                    String noHp = sc.nextLine();
                    antrian.tambahAntrian(nama, noHp);
                    break;
                case 2:
                    antrian.cetakAntrian();     // Cetak seluruh antrian pembeli yang sedang menunggu
                    break;
                case 3:
                    System.out.print("Masukkan No Antrian yang dipanggil : ");      // Hapus antrian sesuai nomor → sekaligus input pesanan
                    int noAntrian = sc.nextInt();
                    sc.nextLine();
                    Pembeli09 p = antrian.hapusAntrian(noAntrian);
                    if (p != null) {             // Input data pesanan pembeli yang dipanggil
                        System.out.print("Kode Pesanan : ");
                        int kode = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nama Pesanan : ");
                        String namaPesanan = sc.nextLine();
                        System.out.print("Harga : ");
                        int harga = sc.nextInt();
                        sc.nextLine();
                        Pesanan09 psn = new Pesanan09(kode, namaPesanan, harga);
                        pesanan.tambahPesanan(psn);
                        System.out.println(p.namaPembeli + " telah memesan " + namaPesanan);
                    }
                    break;
                case 4:
                    System.out.println("LAPORAN PESANAN (URUT NAMA PESANAN)");      // Cetak laporan pesanan (sudah diurutkan berdasarkan nama)
                    pesanan.cetakLaporan();
                    break;
                case 0:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Menu tidak valid.");
            }
        } while (pilihan != 0);
        sc.close();
    }
}
