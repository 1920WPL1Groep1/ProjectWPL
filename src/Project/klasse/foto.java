package Project.klasse;

import java.awt.*;

public class foto {
    private Integer foto_id;
    private Integer plant_id;
    private String eigenschap;
    private String url;
    private Image figuur;

    public Integer getFoto_id() {
        return foto_id;
    }

    public void setFoto_id(Integer foto_id) {
        this.foto_id = foto_id;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Image getFiguur() {
        return figuur;
    }

    public void setFiguur(Image figuur) {
        this.figuur = figuur;
    }
}
