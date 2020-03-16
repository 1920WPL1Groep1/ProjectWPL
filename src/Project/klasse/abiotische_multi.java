package Project.klasse;

public class abiotische_multi {
    private Integer abiotische_id;
    private Integer plant_id;
    private String eigenschap;
    private String  waarde;

    public abiotische_multi(Integer abiotische_id, Integer plant_id, String eigenschap, String waarde) {
        this.abiotische_id = abiotische_id;
        this.plant_id = plant_id;
        this.eigenschap = eigenschap;
        this.waarde = waarde;
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

    public String getEigenschap() {
        return eigenschap;
    }

    public void setEigenschap(String eigenschap) {
        this.eigenschap = eigenschap;
    }

    public String getWaarde() {
        return waarde;
    }

    public void setWaarde(String waarde) {
        this.waarde = waarde;
    }
}
