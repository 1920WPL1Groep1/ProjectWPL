package Project.klasse;

public class fenotype_multi {
    private Integer fenotype_id;
    private Integer plant_id;
    private String eigenschap;
    private String jan;
    private String feb;
    private String maa;
    private String apr;
    private String mei;
    private String jun;
    private String jul;
    private String aug;

    public fenotype_multi(Integer fenotype_id, Integer plant_id, String eigenschap, String jan, String feb, String maa, String apr, String mei, String jun, String jul, String aug, String sep, String okt, String nov, String dec) {
        this.fenotype_id = fenotype_id;
        this.plant_id = plant_id;
        this.eigenschap = eigenschap;
        this.jan = jan;
        this.feb = feb;
        this.maa = maa;
        this.apr = apr;
        this.mei = mei;
        this.jun = jun;
        this.jul = jul;
        this.aug = aug;
        this.sep = sep;
        this.okt = okt;
        this.nov = nov;
        this.dec = dec;
    }

    public Integer getFenotype_id() {
        return fenotype_id;
    }

    public void setFenotype_id(Integer fenotype_id) {
        this.fenotype_id = fenotype_id;
    }

    public Integer getPlant_id() {
        return plant_id;
    }

    public void setPlant_id(Integer plant_id) {
        this.plant_id = plant_id;
    }

    public String getEigenschap() {
        return eigenschap;
    }

    public void setEigenschap(String eigenschap) {
        this.eigenschap = eigenschap;
    }

    public String getJan() {
        return jan;
    }

    public void setJan(String jan) {
        this.jan = jan;
    }

    public String getFeb() {
        return feb;
    }

    public void setFeb(String feb) {
        this.feb = feb;
    }

    public String getMaa() {
        return maa;
    }

    public void setMaa(String maa) {
        this.maa = maa;
    }

    public String getApr() {
        return apr;
    }

    public void setApr(String apr) {
        this.apr = apr;
    }

    public String getMei() {
        return mei;
    }

    public void setMei(String mei) {
        this.mei = mei;
    }

    public String getJun() {
        return jun;
    }

    public void setJun(String jun) {
        this.jun = jun;
    }

    public String getJul() {
        return jul;
    }

    public void setJul(String jul) {
        this.jul = jul;
    }

    public String getAug() {
        return aug;
    }

    public void setAug(String aug) {
        this.aug = aug;
    }

    public String getSep() {
        return sep;
    }

    public void setSep(String sep) {
        this.sep = sep;
    }

    public String getOkt() {
        return okt;
    }

    public void setOkt(String okt) {
        this.okt = okt;
    }

    public String getNov() {
        return nov;
    }

    public void setNov(String nov) {
        this.nov = nov;
    }

    public String getDec() {
        return dec;
    }

    public void setDec(String dec) {
        this.dec = dec;
    }

    private String sep;
    private String okt;
    private String nov;
    private String dec;
}
