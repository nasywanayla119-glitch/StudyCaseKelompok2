package pelanggan;

public class Pelanggan {
    private String nama;
    private String noMeja;
    private int jumlahPesananSaatIni;

    public Pelanggan(String nama, String noMeja) {
        this.nama = nama;
        this.noMeja = noMeja;
        this.jumlahPesananSaatIni = 0;
    }

    public boolean bisaPesan() {
        return jumlahPesananSaatIni < 3;
    }

    public void tambahPesanan() {
        jumlahPesananSaatIni++;
    }

    public void kurangiPesanan() {
        if (jumlahPesananSaatIni > 0) {
            jumlahPesananSaatIni--;
        }
    }

    // Getter
    public String getNama() { return nama; }
    public String getNoMeja() { return noMeja; }
    public int getJumlahPesananSaatIni() { return jumlahPesananSaatIni; }

    // Setter dengan validasi
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNoMeja(String noMeja) {
        if (noMeja == null || noMeja.trim().isEmpty()) {
            System.out.println("❌ Nomor meja tidak boleh kosong!");
        } else {
            this.noMeja = noMeja;
        }
    }
}