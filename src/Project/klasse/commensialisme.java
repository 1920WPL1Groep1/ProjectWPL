package Project.klasse;

public class commensialisme {
    private Integer commensialisme_id;
    private Integer plant_id;
    private String strategie;
    private String ontwikkelingssnelheid;

    public commensialisme(Integer commensialisme_id, Integer plant_id, String strategie, String ontwikkelingssnelheid) {
        this.commensialisme_id = commensialisme_id;
        this.plant_id = plant_id;
        this.strategie = strategie;
        this.ontwikkelingssnelheid = ontwikkelingssnelheid;
    }

    public Integer getCommensialisme_id() {
        return commensialisme_id;
    }

    public void setCommensialisme_id(Integer commensialisme_id) {
        this.commensialisme_id = commensialisme_id;
    }

    public Integer getPlant_id() {
        return plant_id;
    }

    public void setPlant_id(Integer plant_id) {
        this.plant_id = plant_id;
    }

    public String getStrategie() {
        return strategie;
    }

    public void setStrategie(String strategie) {
        this.strategie = strategie;
    }

    public String getOntwikkelingssnelheid() {
        return ontwikkelingssnelheid;
    }

    public void setOntwikkelingssnelheid(String ontwikkelingssnelheid) {
        this.ontwikkelingssnelheid = ontwikkelingssnelheid;
    }
}
