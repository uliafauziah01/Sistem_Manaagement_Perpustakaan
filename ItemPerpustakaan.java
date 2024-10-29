class ItemPerpustakaan {
    protected String judul;
    protected String penulis;

    public ItemPerpustakaan(String judul, String penulis) {
        this.judul = judul;
        this.penulis = penulis;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }
}