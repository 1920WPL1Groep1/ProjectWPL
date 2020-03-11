package Project.klasse;
public class abiotische_factoren {
    private Integer abiotische_id;
    private Integer plant_id;
    private String bezonning;
    private String grondsoort;
    private String vochtbehoefte;
    private String voedingsbehoefte;
    private String reactie_antagoistische_omg;
    public abiotische_factoren(Integer abiotische_id, Integer plant_id, String bezonning, String grondsoort, String vochtbehoefte, String voedingsbehoefte, String reactie_antagoistische_omg) {
        this.abiotische_id = abiotische_id;
        this.plant_id = plant_id;
        this.bezonning = bezonning;
        this.grondsoort = grondsoort;
        this.vochtbehoefte = vochtbehoefte;
        this.voedingsbehoefte = voedingsbehoefte;
        this.reactie_antagoistische_omg = reactie_antagoistische_omg;
    }
    public Integer getAbiotische_id() {
        return abiotische_id;
    }
    public void setAbiotische_id(Integer abiotische_id) {
        this.abiotische_id = abiotische_id;
    }
    public Integer getPlant_id() {
        return plant_id;
    }
    public void setPlant_id(Integer plant_id) {
        this.plant_id = plant_id;
    }
    public String getBezonning() {
        return bezonning;
    }
    public void setBezonning(String bezonning) {
        this.bezonning = bezonning;
    }
    public String getGrondsoort() {
        return grondsoort;
    }
    public void setGrondsoort(String grondsoort) {
        this.grondsoort = grondsoort;
    }
    public String getVochtbehoefte() {
        return vochtbehoefte;
    }
    public void setVochtbehoefte(String vochtbehoefte) {
        this.vochtbehoefte = vochtbehoefte;
    }
    public String getVoedingsbehoefte() {
        return voedingsbehoefte;
    }
    public void setVoedingsbehoefte(String voedingsbehoefte) {
        this.voedingsbehoefte = voedingsbehoefte;
    }
    public String getReactie_antagoistische_omg() {
        return reactie_antagoistische_omg;
    }
    public void setReactie_antagoistische_omg(String reactie_antagoistische_omg) {
        this.reactie_antagoistische_omg = reactie_antagoistische_omg;
    }
}
