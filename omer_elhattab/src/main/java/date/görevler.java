package date;

public class görevler {
    private  int id;
    private String gorev_adi;
    private String gorev_acıklama;
    private  String gorev_dercesi;
    private String gorev_tarihi;

    public String getGorev_tarihi() {
        return gorev_tarihi;
    }

    public void setGorev_tarihi(String gorev_tarihi) {
        this.gorev_tarihi = gorev_tarihi;
    }


    public görevler(int id, String gorev_adi, String gorev_acıklama, String gorev_dercesi, String gorev_tarihi) {
        this.id = id;
        this.gorev_adi = gorev_adi;
        this.gorev_acıklama = gorev_acıklama;
        this.gorev_dercesi = gorev_dercesi;
        this.gorev_tarihi = gorev_tarihi;
    }

    public görevler(String gorev_adi, String gorev_acıklama, String gorev_dercesi, String gorev_tarihi) {
        this.gorev_adi = gorev_adi;
        this.gorev_acıklama = gorev_acıklama;
        this.gorev_dercesi = gorev_dercesi;
        this.gorev_tarihi = gorev_tarihi;
    }



    public String getGorev_adi() {
        return gorev_adi;
    }

    public void setGorev_adi(String gorev_adi) {
        this.gorev_adi = gorev_adi;
    }

    public String getGorev_acıklama() {
        return gorev_acıklama;
    }

    public void setGorev_acıklama(String gorev_acıklama) {
        this.gorev_acıklama = gorev_acıklama;
    }

    public String getGorev_dercesi() {
        return gorev_dercesi;
    }

    public void setGorev_dercesi(String gorev_dercesi) {
        this.gorev_dercesi = gorev_dercesi;
    }
}
