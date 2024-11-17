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

