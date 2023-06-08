package builder_dp;

public class Menemen {

    private String yumurta; // required
    private String tereyag; //required
    private String baharat; //optional
    private String sogan;   //optional
    private String biber;   //optional
    private String sucuk;   //optional
    private String salam;   //optional
    private String pastirma;//optional
    private String kavurma; //optional
    private String sarimsak;//optional

    public static class Builder{
        private final String yumurta;
        private final String tereyag;

        private String baharat;
        private String sogan;
        private String biber;
        private String sucuk;
        private String salam;
        private String pastirma;
        private String kavurma;
        private String sarimsak;

        public Builder(String yumurta, String tereyag) {
            this.yumurta = yumurta;
            this.tereyag = tereyag;
        }

        public Builder baharatTayfa(String baharat){
            this.baharat = baharat;
            return this;
        }

        public Builder soganTayfa(String sogan){
            this.sogan = sogan;
            return this;
        }

        public Builder biberTayfa(String biber){
            this.biber = biber;
            return this;
        }

        public Builder etTayfa(String sucuk, String salam, String pastirma, String kavurma){
            this.sucuk = sucuk;
            this.salam = salam;
            this.pastirma = pastirma;
            this.kavurma = kavurma;
            return this;
        }

        public Builder sarimsakTayfa(String sarimsak){
            this.sarimsak = sarimsak;
            return this;
        }

        public Menemen build(){
            return new Menemen(this);
        }
    }

    public Menemen(Builder builder){
        yumurta = builder.yumurta;
        tereyag = builder.tereyag;
        baharat = builder.baharat;
        sogan = builder.sogan;
        biber = builder.biber;
        sucuk = builder.sucuk;
        salam = builder.salam;
        pastirma = builder.pastirma;
        kavurma = builder.kavurma;
        sarimsak = builder.sarimsak;
    }

    public String getYumurta() {
        return yumurta;
    }

    public String getTereyag() {
        return tereyag;
    }

    public String getBaharat() {
        return baharat;
    }

    public String getSogan() {
        return sogan;
    }

    public String getBiber() {
        return biber;
    }

    public String getSucuk() {
        return sucuk;
    }

    public String getSalam() {
        return salam;
    }

    public String getPastirma() {
        return pastirma;
    }

    public String getKavurma() {
        return kavurma;
    }

    public String getSarimsak() {
        return sarimsak;
    }
}
