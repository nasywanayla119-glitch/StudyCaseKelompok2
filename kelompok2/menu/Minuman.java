package menu;

public class Minuman extends ItemMenu {
    private String ukuran;

    public Minuman(String nama, double harga, String ukuran) {
        super(nama, harga);
        this.ukuran = ukuran;
    }

    @Override
    public double hitungTotal(int jumlah) {
        return harga * jumlah * 1.1;  // PPN 10%
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("   Ukuran: " + ukuran);
    }
}