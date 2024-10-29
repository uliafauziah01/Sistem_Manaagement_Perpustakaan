class Peminjaman {
    private Buku buku;
    private Anggota anggota;

    public Peminjaman(Buku buku, Anggota anggota) {
        this.buku = buku;
        this.anggota = anggota;
    }

    public void eksekusi() {
        System.out.println("Peminjaman buku berhasil.");
    }

}