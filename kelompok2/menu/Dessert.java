package menu;

public class Dessert extends ItemMenu {
    private int kalori;

    public Dessert(String nama, double harga, int kalori) {
        super(nama, harga);
        this.kalori = kalori;
    }

    @Override
    public double hitungTotal(int jumlah) {
        return harga * jumlah * 0.9;  // Diskon 10%
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("   Kalori: " + kalori + " kcal");
    }
}