package Project.klasse;

public class fenotype {
    private Integer fenotype_id;
    private Integer plant_id;
    private String bladvorm;
    private Integer levensvorm;
    private String habitus;
    private String bloeiwijze;
    private Integer bladgrootte;
    private String ratio_bloei_blad;
    private String spruitfenelogie;

    public fenotype(Integer fenotype_id, Integer plant_id, String bladvorm, Integer levensvorm, String habitus, String bloeiwijze, Integer bladgrootte, String ratio_bloei_blad, String spruitfenelogie) {
        this.fenotype_id = fenotype_id;
        this.plant_id = plant_id;
        this.bladvorm = bladvorm;
        this.levensvorm = levensvorm;
        this.habitus = habitus;
        this.bloeiwijze = bloeiwijze;
        this.bladgrootte = bladgrootte;
        this.ratio_bloei_blad = ratio_bloei_blad;
        this.spruitfenelogie = spruitfenelogie;
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

    public String getBladvorm() {
        return bladvorm;
    }

    public void setBladvorm(String bladvorm) {
        this.bladvorm = bladvorm;
    }

    public Integer getLevensvorm() {
        return levensvorm;
    }

    public void setLevensvorm(Integer levensvorm) {
        this.levensvorm = levensvorm;
    }

    public String getHabitus() {
        return habitus;
    }

    public void setHabitus(String habitus) {
        this.habitus = habitus;
    }

    public String getBloeiwijze() {
        return bloeiwijze;
    }

    public void setBloeiwijze(String bloeiwijze) {
        this.bloeiwijze = bloeiwijze;
    }

    public Integer getBladgrootte() {
        return bladgrootte;
    }

    public void setBladgrootte(Integer bladgrootte) {
        this.bladgrootte = bladgrootte;
    }

    public String getRatio_bloei_blad() {
        return ratio_bloei_blad;
    }

    public void setRatio_bloei_blad(String ratio_bloei_blad) {
        this.ratio_bloei_blad = ratio_bloei_blad;
    }

    public String getSpruitfenelogie() {
        return spruitfenelogie;
    }

    public void setSpruitfenelogie(String spruitfenelogie) {
        this.spruitfenelogie = spruitfenelogie;
    }
}
