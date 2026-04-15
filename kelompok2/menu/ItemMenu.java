package menu;

public abstract class ItemMenu {
    protected String nama;
    protected double harga;
    protected boolean tersedia;

    public ItemMenu(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
        this.tersedia = true;
    }

    public void pesan() {
        if (tersedia) {
            tersedia = false;
            System.out.println("✅ " + nama + " berhasil dipesan.");
        } else {
            System.out.println("❌ " + nama + " sudah tidak tersedia.");
        }
    }

    public void batalkanPesanan() {
        tersedia = true;
        System.out.println("🔄 " + nama + " telah dibatalkan dan tersedia kembali.");
    }

    public abstract double hitungTotal(int jumlah);

    public void tampilkanInfo() {
        System.out.printf("🍽️ %s - Rp %.0f | Status: %s%n", 
            nama, harga, tersedia ? "Tersedia" : "Tidak Tersedia");
    }

    // Getter
    public String getNama() { return nama; }
    public double getHarga() { return harga; }
    public boolean isTersedia() { return tersedia; }
}