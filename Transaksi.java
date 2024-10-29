class Transaksi {
    protected Buku buku;
    protected Anggota anggota;

    public Transaksi(Buku buku, Anggota anggota) {
        this.buku = buku;
        this.anggota = anggota;
    }

    public void eksekusi() {
        // Metode ini akan dioverride di kelas anak
    }
}