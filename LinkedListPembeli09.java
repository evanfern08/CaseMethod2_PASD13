public class LinkedListPembeli09 {
    NodePembeli09 head, tail;
    int counter = 0;                // untuk nomor antrian otomatis

    public LinkedListPembeli09() {
        head = tail = null;
    }

    public void tambahAntrian(String nama, String noHp) {           // Tambah antrian pembeli
        counter++;
        Pembeli09 p = new Pembeli09(counter, nama, noHp);
        NodePembeli09 newNode = new NodePembeli09(p);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Antrian berhasil ditambahkan dengan nomor: " + counter);
    }

    public void cetakAntrian() {                // Cetak seluruh antrian
        if (head == null) {
            System.out.println("Tidak ada antrian.");
            return;
        }
        System.out.println("No Antrian\tNama\tNo HP");
        NodePembeli09 current = head;
        while (current != null) {
            current.data.tampil();
            current = current.next;
        }
    }

    public Pembeli09 hapusAntrian(int noAntrian) {      // Hapus antrian sesuai nomor, sekaligus return data pembeli
        NodePembeli09 current = head;
        while (current != null && current.data.noAntrian != noAntrian) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Nomor antrian tidak ditemukan.");
            return null;
        }
        Pembeli09 p = current.data;
        if (current == head && current == tail) {
            head = tail = null;
        } else if (current == head) {
            head = head.next;
            head.prev = null;
        } else if (current == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        return p;
    }
}
