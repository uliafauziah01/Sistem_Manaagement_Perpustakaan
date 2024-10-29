class Buku {
    private String judul;
    private String penulis;
    private int salinan;
    private boolean tersedia;

    public Buku(String judul, String penulis, int salinan) {
        this.judul = judul;
        this.penulis = penulis;
        this.salinan = salinan;
        this.tersedia = true;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public int getSalinan() {
        return salinan;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public boolean pinjam() {
        if (tersedia) {
            tersedia = false;
            return true;
        }
        return false;
    }

    public boolean kembalikan() {
        if (!tersedia) {
            tersedia = true;
            return true;
        }
        return false;
    }
}