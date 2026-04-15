import menu.*;
import pelanggan.Pelanggan;

public class MainRestoran {
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   SISTEM MANAJEMEN MENU RESTORAN");
        System.out.println("=========================================\n");

        // 1. Membuat Menu Restoran (Polymorphism)
        ItemMenu[] menuRestoran = new ItemMenu[6];

        menuRestoran[0] = new MakananUtama("Nasi Goreng Spesial", 25000, "Indonesia");
        menuRestoran[1] = new MakananUtama("Ayam Bakar", 32000, "Indonesia");
        menuRestoran[2] = new Minuman("Es Teh Manis", 8000, "Large");
        menuRestoran[3] = new Minuman("Kopi Latte", 18000, "Medium");
        menuRestoran[4] = new Dessert("Pancake Nutella", 22000, 450);
        menuRestoran[5] = new Dessert("Es Krim Vanilla", 15000, 280);

        // 2. Membuat Pelanggan
        Pelanggan pelanggan1 = new Pelanggan("Nasywa", "Meja 5");
        Pelanggan pelanggan2 = new Pelanggan("Andi", "Meja 12");

        // 3. Tampilkan Daftar Menu
        System.out.println("📋 DAFTAR MENU RESTORAN:");
        for (ItemMenu item : menuRestoran) {
            item.tampilkanInfo();
            System.out.println();
        }

        // 4. Simulasi Pemesanan
        System.out.println("--- PROSES PEMESANAN ---");

        // Pelanggan 1 memesan 2 item
        System.out.println("\n" + pelanggan1.getNama() + " (Meja " + pelanggan1.getNoMeja() + ") memesan:");
        if (pelanggan1.bisaPesan()) {
            menuRestoran[0].pesan();  // Nasi Goreng
            pelanggan1.tambahPesanan();
            menuRestoran[2].pesan();  // Es Teh
            pelanggan1.tambahPesanan();
        }

        // Pelanggan 2 memesan 3 item
        System.out.println("\n" + pelanggan2.getNama() + " (Meja " + pelanggan2.getNoMeja() + ") memesan:");
        for (int i = 0; i < 3; i++) {
            if (pelanggan2.bisaPesan()) {
                menuRestoran[i + 1].pesan();
                pelanggan2.tambahPesanan();
            } else {
                System.out.println("❌ " + pelanggan2.getNama() + " sudah mencapai batas pesanan maksimal (3 item)!");
            }
        }

        // 5. Tampilkan Status Menu setelah pemesanan
        System.out.println("\n📋 STATUS MENU SETELAH PEMESANAN:");
        for (ItemMenu item : menuRestoran) {
            item.tampilkanInfo();
            System.out.println();
        }

        // 6. Hitung Total Tagihan (Polymorphism)
        System.out.println("--- TOTAL TAGIHAN ---");
        System.out.println("Tagihan untuk Nasi Goreng (2 porsi): Rp " + 
            String.format("%,.0f", menuRestoran[0].hitungTotal(2)));
        
        System.out.println("Tagihan untuk Es Teh Manis (1 porsi): Rp " + 
            String.format("%,.0f", menuRestoran[2].hitungTotal(1)));
        
        System.out.println("Tagihan untuk Pancake Nutella (1 porsi): Rp " + 
            String.format("%,.0f", menuRestoran[4].hitungTotal(1)));

        System.out.println("\n✅ Program selesai. Terima kasih telah menggunakan sistem!");
    }
}