import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Buku> daftarBuku = new ArrayList<>();
    private static ArrayList<Anggota> daftarAnggota = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Peminjaman Buku");
            System.out.println("4. Pengembalian Buku");
            System.out.println("5. Tampilkan Daftar Buku");
            System.out.println("6. Tampilkan Daftar Anggota");
            System.out.println("7. Keluar");
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (pilihan) {
                case 1:
                    tambahBuku();
                    break;
                case 2:
                    tambahAnggota();
                    break;
                case 3:
                    pinjamBuku();
                    break;
                case 4:
                    kembalikanBuku();
                    break;
                case 5:
                    tampilkanDaftarBuku();
                    break;
                case 6:
                    tampilkanDaftarAnggota();
                    break;
                case 7:
                    System.out.println("Keluar dari sistem.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void tambahBuku() {
        System.out.print("Masukkan judul buku: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan penulis buku: ");
        String penulis = scanner.nextLine();
        System.out.print("Masukkan jumlah salinan: ");
        int salinan = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Buku bukuBaru = new Buku(judul, penulis, salinan);
        daftarBuku.add(bukuBaru);
        System.out.println("Buku berhasil ditambahkan.");
    }

    private static void tambahAnggota() {
        System.out.print("Masukkan nama anggota: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan ID anggota: ");
        String idAnggota = scanner.nextLine();

        Anggota anggotaBaru = new Anggota(nama, idAnggota);
        daftarAnggota.add(anggotaBaru);
        System.out.println("Anggota berhasil ditambahkan.");
    }

    private static void pinjamBuku() {
        System.out.print("Masukkan ID anggota: ");
        String idAnggota = scanner.nextLine();
        Anggota anggota = cariAnggota(idAnggota);

        if (anggota == null) {
            System.out.println("Anggota tidak ditemukan.");
            return;
        }

        System.out.print("Masukkan judul buku yang ingin dipinjam: ");
        String judulBuku = scanner.nextLine();
        Buku buku = cariBuku(judulBuku);

        if (buku == null) {
            System.out.println("Buku tidak ditemukan.");
            return;
        }

        if (buku.pinjam()) {
            System.out.println("Peminjaman buku berhasil.");
        } else {
            System.out.println("Peminjaman gagal. Buku tidak tersedia.");
        }
    }

    private static void kembalikanBuku() {
        System.out.print("Masukkan ID anggota: ");
        String idAnggota = scanner.nextLine();
        Anggota anggota = cariAnggota(idAnggota);

        if (anggota == null) {
            System.out.println("Anggota tidak ditemukan.");
            return;
        }

        System.out.print("Masukkan judul buku yang ingin dikembalikan: ");
        String judulBuku = scanner.nextLine();
        Buku buku = cariBuku(judulBuku);

        if (buku == null) {
            System.out.println("Buku tidak ditemukan.");
            return;
        }

        if (buku.kembalikan()) {
            System.out.println("Pengembalian buku berhasil.");
        } else {
            System.out.println("Pengembalian gagal. Buku tidak ada dalam status pinjam.");
        }
    }

    private static void tampilkanDaftarBuku() {
        System.out.println("\n=== Daftar Buku ===");
        for (Buku buku : daftarBuku) {
            System.out.println("Judul : " + buku.getJudul());
            System.out.println("Penulis: " + buku.getPenulis());
            System.out.println(" Jumlah Salinan: " + buku.getSalinan());
            System.out.println("Status: " + (buku.isTersedia() ? "Tersedia" : "Dipinjam"));
            System.out.println();
        }
    }

    private static void tampilkanDaftarAnggota() {
        System.out.println("\n=== Daftar Anggota ===");
        for (Anggota anggota : daftarAnggota) {
            System.out.println("Nama: " + anggota.getNama());
            System.out.println("ID Anggota: " + anggota.getIdAnggota());
            System.out.println();
        }
    }

    private static Anggota cariAnggota(String idAnggota) {
        for (Anggota anggota : daftarAnggota) {
            if (anggota.getIdAnggota().equals(idAnggota)) {
                return anggota;
            }
        }
        return null;
    }

    private static Buku cariBuku(String judulBuku) {
        for (Buku buku : daftarBuku) {
            if (buku.getJudul().equals(judulBuku)) {
                return buku;
            }
        }
        return null;
    }
}