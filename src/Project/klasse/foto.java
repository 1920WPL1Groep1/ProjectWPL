package Project.klasse;

import java.awt.*;
import java.sql.Blob;

public class foto {
    private Integer foto_id;
    private Integer plant_id;
    private String eigenschap;
    private String url;
    private Blob figuur;

    public foto(Integer foto_id, Integer plant_id, String eigenschap, String url, Blob figuur) {
        this.foto_id = foto_id;
        this.plant_id = plant_id;
        this.eigenschap = eigenschap;
        this.url = url;
        this.figuur = figuur;
    }

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

    public Blob getFiguur() {
        return figuur;
    }

    public void setFiguur(Blob figuur) {
        this.figuur = figuur;
    }
}
