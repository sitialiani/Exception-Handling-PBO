// Class Produk (kelas induk)
class Produk {
    String kodeBarang; // Menyimpan kode barang
    String namaBarang; // Menyimpan nama barang
    double hargaBarang; // Menyimpan harga barang

    // Konstruktor untuk menginisialisasi data barang
    public Produk(String kodeBarang, String namaBarang, double hargaBarang) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
    }

    // Method untuk menghitung total harga berdasarkan jumlah
    public double hitungTotal(int jumlah) {
        return hargaBarang * jumlah;
    }

    // Method toString untuk menampilkan detail barang
    @Override
    public String toString() {
        return "Kode Barang: " + kodeBarang + "\n" +
               "Nama Barang: " + namaBarang + "\n" +
               "Harga Barang: " + hargaBarang;
    }
}

// Class Pesanan (kelas turunan)
class Pesanan extends Produk {
    String noFaktur; // Menyimpan nomor faktur
    int jumlah; // Menyimpan jumlah barang yang dibeli
    double totalHarga; // Menyimpan total harga untuk pesanan

    // Konstruktor untuk menginisialisasi data pesanan
    public Pesanan(String noFaktur, String kodeBarang, String namaBarang, double hargaBarang, int jumlah) {
        super(kodeBarang, namaBarang, hargaBarang); // Memanggil konstruktor dari kelas induk
        this.noFaktur = noFaktur;
        this.jumlah = jumlah;
        this.totalHarga = hitungTotal(jumlah); // Menghitung total harga
    }

    // Method toString untuk menampilkan detail pesanan
    @Override
    public String toString() {
        return "No Faktur: " + noFaktur + "\n" + // Menampilkan nomor faktur
               super.toString() + "\n" + // Menampilkan detail barang dari kelas induk
               "Jumlah: " + jumlah + "\n" +
               "Total Harga: " + totalHarga;
    }
}

// Class Main (kelas utama)
import java.util.Scanner;

// Class Main (kelas utama)
public class Main {
    private static int fakturCounter = 1; // Counter untuk membuat nomor faktur otomatis

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lanjut; // Variabel untuk menyimpan jawaban apakah ingin menambah pesanan lain

        do {
            try {
                System.out.println("=== Program Transaksi ===");

                // Input data barang dari pengguna
                System.out.print("Masukkan Kode Barang: ");
                String kodeBarang = scanner.nextLine();

                System.out.print("Masukkan Nama Barang: ");
                String namaBarang = scanner.nextLine();

                System.out.print("Masukkan Harga Barang: ");
                double hargaBarang = scanner.nextDouble();
                if (hargaBarang <= 0) { // Validasi harga
                    throw new IllegalArgumentException("Harga barang harus lebih dari 0.");
                }

                System.out.print("Masukkan Jumlah Beli: ");
                int jumlah = scanner.nextInt();
                if (jumlah <= 0) { // Validasi jumlah beli
                    throw new IllegalArgumentException("Jumlah beli harus lebih dari 0.");
                }

                scanner.nextLine(); // Membersihkan buffer input

                // Membuat nomor faktur otomatis
                String noFaktur = "FTR" + String.format("%03d", fakturCounter++);

                // Membuat objek Pesanan berdasarkan data yang diinputkan
                Pesanan pesanan = new Pesanan(noFaktur, kodeBarang, namaBarang, hargaBarang, jumlah);

                // Menampilkan detail pesanan
                System.out.println("\nDetail Pesanan:");
                System.out.println(pesanan);

            } catch (Exception e) {
                // Menangkap error yang mungkin terjadi saat input
                System.out.println("Terjadi kesalahan: " + e.getMessage());
                scanner.nextLine(); // Membersihkan buffer input
            }

            // Menanyakan apakah pengguna ingin menambah pesanan lain
            System.out.print("Masih ada pesanan lain? (ya/tidak): ");
            lanjut = scanner.nextLine().trim().toLowerCase();

        } while (lanjut.equals("ya")); // Perulangan berhenti jika jawaban bukan "ya"

        scanner.close(); // Menutup scanner setelah selesai
        System.out.println("Program telah selesai digunakan.");
    }
}
