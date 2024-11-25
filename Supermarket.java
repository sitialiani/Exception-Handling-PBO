import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Supermarket {
    private static int fakturCounter = 1; // Counter untuk membuat nomor faktur otomatis

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Simulasi Login
        boolean loginBerhasil = false;
        while (!loginBerhasil) {
            System.out.println("+-----------------------------------------------------+");
            System.out.print("Username : ");
            String username = scanner.nextLine();

            System.out.print("Password  : ");
            String password = scanner.nextLine();

            // Generate Captcha secara random
            String captchaGenerated = generateCaptcha();
            System.out.print("Captcha (" + captchaGenerated + ") : ");
            String captchaInput = scanner.nextLine();

            // Validasi login
            if (username.equalsIgnoreCase("siti") && password.equals("Siti123") && captchaGenerated.equals(captchaInput)) {
                loginBerhasil = true;
                System.out.println("Login berhasil!");
            } else {
                System.out.println("Login gagal, silakan coba lagi.\n");
            }
        }
        System.out.println("+----------------------------------------------------+");
        // Menampilkan header Supermarket
        System.out.println("Selamat Datang di Supermarket SuperBasudara");
        System.out.println("Tanggal dan Waktu : " + getCurrentDateTime());
        System.out.println("+----------------------------------------------------+");

        // Generate nomor faktur otomatis
        String noFaktur = "FTR" + String.format("%04d", fakturCounter++);
        System.out.println("No. Faktur      : " + noFaktur);

        // Input data transaksi
        System.out.print("Kode Barang     : ");
        String kodeBarang = scanner.nextLine();

        System.out.print("Nama Barang     : ");
        String namaBarang = scanner.nextLine();

        System.out.print("Harga Barang    : ");
        double hargaBarang = scanner.nextDouble();
        if (hargaBarang <= 0) {
            throw new IllegalArgumentException("Harga barang harus lebih dari 0.");
        }

        System.out.print("Jumlah Beli     : ");
        int jumlahBeli = scanner.nextInt();
        if (jumlahBeli <= 0) {
            throw new IllegalArgumentException("Jumlah beli harus lebih dari 0.");
        }

        // Menghitung total
        double total = hargaBarang * jumlahBeli;

        // Menampilkan faktur transaksi
        System.out.println("+----------------------------------------------------+");
        System.out.println("No. Faktur      : " + noFaktur); // Menampilkan nomor faktur
        System.out.println("Kode Barang     : " + kodeBarang.trim()); // Menghapus spasi ekstra
        System.out.println("Nama Barang     : " + namaBarang.trim()); // Format kapital untuk nama barang
        System.out.println("Harga Barang    : " + String.format("%.2f", hargaBarang)); // Format harga dengan 2 desimal
        System.out.println("Jumlah Beli     : " + jumlahBeli);
        System.out.println("TOTAL           : " + String.format("%.2f", total)); // Format total dengan 2 desimal
        System.out.println("+----------------------------------------------------+");
        System.out.println("Kasir : L. Messi");
        System.out.println("+----------------------------------------------------+");

        scanner.close();
    }

    /**
     * Method untuk mendapatkan waktu dan tanggal saat ini.
     * @return Waktu dan tanggal dalam format "dd-MM-yyyy HH:mm:ss".
     */
    private static String getCurrentDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }

    /**
     * Method untuk generate captcha acak.
     * @return Captcha berupa string 5 karakter alfanumerik.
     */
    private static String generateCaptcha() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder captcha = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int randomIndex = (int) (Math.random() * chars.length());
            captcha.append(chars.charAt(randomIndex));
        }
        return captcha.toString();
    }

}
