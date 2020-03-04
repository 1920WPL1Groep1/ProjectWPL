package Project.klasse;

public class extra {
    private Integer extra_id;
    private Integer plant_id;
    private String nectarwaarde;
    private String pollenwaarde;
    private String bijvriendelijk;
    private String eetbaar_kruidgebruik;
    private String geurend;
    private String vorstgevoelig;

    public Integer getExtra_id() {
        return extra_id;
    }

    public void setExtra_id(Integer extra_id) {
        this.extra_id = extra_id;
    }

    public Integer getPlant_id() {
        return plant_id;
    }

    public void setPlant_id(Integer plant_id) {
        this.plant_id = plant_id;
    }

    public String getNectarwaarde() {
        return nectarwaarde;
    }

    public void setNectarwaarde(String nectarwaarde) {
        this.nectarwaarde = nectarwaarde;
    }

    public String getPollenwaarde() {
        return pollenwaarde;
    }

    public void setPollenwaarde(String pollenwaarde) {
        this.pollenwaarde = pollenwaarde;
    }

    public String getBijvriendelijk() {
        return bijvriendelijk;
    }

    public void setBijvriendelijk(String bijvriendelijk) {
        this.bijvriendelijk = bijvriendelijk;
    }

    public String getEetbaar_kruidgebruik() {
        return eetbaar_kruidgebruik;
    }

    public void setEetbaar_kruidgebruik(String eetbaar_kruidgebruik) {
        this.eetbaar_kruidgebruik = eetbaar_kruidgebruik;
    }

    public String getGeurend() {
        return geurend;
    }

    public void setGeurend(String geurend) {
        this.geurend = geurend;
    }

    public String getVorstgevoelig() {
        return vorstgevoelig;
    }

    public void setVorstgevoelig(String vorstgevoelig) {
        this.vorstgevoelig = vorstgevoelig;
    }

    public extra(Integer extra_id, Integer plant_id, String nectarwaarde, String pollenwaarde, String bijvriendelijk, String eetbaar_kruidgebruik, String geurend, String vorstgevoelig) {
        this.extra_id = extra_id;
        this.plant_id = plant_id;
        this.nectarwaarde = nectarwaarde;
        this.pollenwaarde = pollenwaarde;
        this.bijvriendelijk = bijvriendelijk;
        this.eetbaar_kruidgebruik = eetbaar_kruidgebruik;
        this.geurend = geurend;
        this.vorstgevoelig = vorstgevoelig;
    }
}
