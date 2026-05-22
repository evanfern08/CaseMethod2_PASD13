public class LinkedListPesanan09 {
    NodePesanan09 head, tail;

    public LinkedListPesanan09 () {                         // Constructor untuk menginisialisasi linked list kosong
        head = tail = null;
    }

    public void tambahPesanan(Pesanan09 psn) {   
        NodePesanan09 newNode = new NodePesanan09(psn);     // Menambahkan pesanan baru ke dalam linked list
        if (head == null) {                                 // Mengecek apakah linked list masih kosong
            head = tail = newNode;
        } else {
            tail.next = newNode;                            // Menghubungkan tail lama ke node baru
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void sortByNama() {                              // Method untuk mengurutkan data berdasarkan nama pesanan
        if (head == null) return;
        boolean swapped;
        do {
            swapped = false;
            NodePesanan09 current = head;
            while (current.next != null) {
                if (current.data.namaPesanan.compareTo(current.next.data.namaPesanan) > 0) {
                    Pesanan09 temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    public void cetakLaporan() {                             // Method untuk mencetak laporan seluruh pesanan
        if (head == null) {
            System.out.println("Belum ada pesanan.");
            return;
        }
        sortByNama();                                        // Mengurutkan data sebelum ditampilkan
        System.out.println("Kode\tNama Pesanan\tHarga");
        NodePesanan09 current = head;
        while (current != null) {
            current.data.tampil();
            current = current.next;
        }
    }

    public void statistikPesanan() {                         // Method untuk menampilkan statistik pesanan
        if (head == null) {
            System.out.println("Belum ada pesanan.");
            return;
        }
                                                                // Menampilkan 3 statistik Pesanan 
        int totalPendapatan = 0;
        Pesanan09 maxPesanan = head.data;
        Pesanan09 minPesanan = head.data;

        NodePesanan09 current = head;                           // 3 Informasinya
        while (current != null) {
            // Tambah total pendapatan                          // 1. Total pendapatan
            totalPendapatan += current.data.harga;

            // Cari harga tertinggi                             // 2. Harga tertinggi 
            if (current.data.harga > maxPesanan.harga) {
                maxPesanan = current.data;
            }

            // Cari harga terendah
            if (current.data.harga < minPesanan.harga) {
                minPesanan = current.data;
            }

            current = current.next;
        }

        System.out.println("=== STATISTIK PESANAN ===");       // 3. Nama pesanan informasi
        System.out.println("Total Pendapatan : Rp" + totalPendapatan);
        System.out.println("Pesanan Termahal : " + maxPesanan.namaPesanan + " (Rp" + maxPesanan.harga + ")");
        System.out.println("Pesanan Termurah : " + minPesanan.namaPesanan + " (Rp" + minPesanan.harga + ")");
    }
}
