public class Pembeli09 {
    String namaPembeli;
    String noHp;
    int noAntrian;

    public Pembeli09(int noAntrian, String namaPembeli, String noHp) {
        this.noAntrian = noAntrian;
        this.namaPembeli = namaPembeli;
        this.noHp = noHp;
    }

    public void tampil() {
        System.out.println(noAntrian + "\t" + namaPembeli + "\t" + noHp);
    }
}
