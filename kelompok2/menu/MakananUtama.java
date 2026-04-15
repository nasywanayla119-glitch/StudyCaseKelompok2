package menu;

public class MakananUtama extends ItemMenu {
    private String jenisMasakan;

    public MakananUtama(String nama, double harga, String jenisMasakan) {
        super(nama, harga);
        this.jenisMasakan = jenisMasakan;
    }

    @Override
    public double hitungTotal(int jumlah) {
        return harga * jumlah;  // Tidak ada pajak/diskon
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("   Jenis: " + jenisMasakan);
    }
}