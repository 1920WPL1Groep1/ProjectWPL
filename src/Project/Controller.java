package Project;

import Project.dao.plantdao;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import main.java.dao.Database;
import main.java.model.plant;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Controller {
    public TextField bladhoogteMinimumTxt;
    public TextField bladhoogteMaximumTxt;
    public TextField bladhoogteMaandTxt;
    public TextField bloeihoogteMinimumTxt;
    public TextField bloeihoogteMaximumTxt;
    public TextField bloeihoogteMaandTxt;
    public TextField bladkleurKleurTxt;
    public TextField bladkleurMaandTxt;
    public TextField bloeikleurKleurTxt;
    public TextField bloeikleurMaandTxt;
    public TextField bladgrootteMinimumTxt;
    public TextField bladgrootteMaximumTxt;
    public TextField levensvormXTxt;
    public TextField levensvormYTxt;
    public ComboBox bladvormCombo;
    public ComboBox ratioCombo;
    public ComboBox spruitCombo;
    public ComboBox bloeiwijzeCombo;
    public ComboBox habitusCombo;
    public ComboBox bezonningCombo;
    public ComboBox grondsoortCombo;
    public ComboBox vochtbehoefteCombo;
    public ComboBox voedingsbehoefteCombo;
    public ComboBox reactieCombo;
    public ComboBox habitat1Combo;
    public ComboBox habitat2Combo;
    public ComboBox habitat3Combo;
    public ComboBox habitat4Combo;
    public ComboBox habitatEnOfCombo;
    public ComboBox ontwikkelingssnelheidCombo;
    public ComboBox levensduurCombo;
    public CheckBox sociabiliteit1Check;
    public CheckBox sociabiliteit2Check;
    public CheckBox sociabiliteit3Check;
    public CheckBox sociabiliteit4Check;
    public CheckBox sociabiliteit5Check;
    public ComboBox strategie1Combo;
    public ComboBox strategie2Combo;
    public ComboBox strategieEnOfCombo;
    public TextField zoekenTxt;
    public Button zoekenBtn;
    public CheckBox geavanceerdCheck;
    public ComboBox beheerbehandelingCombo;
    public ComboBox maandCombo;
    public ComboBox frequentieCombo;
    public RadioButton bijBtnJa;
    public RadioButton bijBtnNee;
    public RadioButton vlinderBtnJa;
    public RadioButton vlinderBtnNee;
    public ListView<String> resultatentxt;
    public TabPane tabpane;
    public Tab fentotyptab;
    public Tab abiotischetab;
    public Tab commensalimsetab;
    public Tab beheertab;
    public Tab extratab;
    public Tab resultaatab;
    public TextArea extrainfottxtx;
    public RadioButton variatieRadioButton;
    public ToggleGroup selecteerGroep;
    public RadioButton SoortRadioButton;
    public RadioButton GeslcahtRadioButton;
    public RadioButton TypeRadiobutton;
    public RadioButton familieradiobutton;
    public Label zoekInfolabel;
    private Connection dbConnection;
    private List<plant> plantenlijst;
    private int keuzenummer;
    private int getal;
    private String database;
    private  String Keuze;


    public void initialize() throws SQLException {
        dbConnection = Database.getInstance().getConnection();
        fentotyptab.setDisable(true);
        abiotischetab.setDisable(true);
        commensalimsetab.setDisable(true);
        beheertab.setDisable(true);
        extratab.setDisable(true);
        resultaatab.setDisable(false);
    }
    public void click_zoekenBtn(MouseEvent mouseEvent) throws SQLException {
        plantdao plantdao = new plantdao(dbConnection);
        extrainfottxtx.setText("");
        resultatentxt.getItems().clear();
        showByName(plantdao);

    }
    /** BEGIN HulpMethoden voor daoDemo **/
    /**
     * Print de lijst van de studenten uit
     * @param titel
     * @param planten
     */
    public void showplanten(String titel, List<plant> planten) {
        System.out.println("Lijst planten : " + titel);
        int getal =0;
        resultatentxt.getItems().clear();
        System.out.println(planten.size()+" grote");
        for (int i = 0; i<planten.size();i++) {
                resultatentxt.getItems().add(i,  planten.get(i).getFgsv());
        }
        if (planten.size()==0)
        {
            resultatentxt.getItems().add(0,"Er zijn geen planten terug gevonden.");
        }
    }
    /**
     * @param plantdao
     * @throws SQLException
     */
    private void showByName(plantdao plantdao) throws SQLException {
        System.out.println(Keuze+ " "+ getal);
        while (true) {
            String zoekterm = zoekenTxt.getText();
            System.out.println(zoekterm);
            if(zoekterm==null)
            {
                plantenlijst=plantdao.getAllPlant();
            }
            else
            {
                plantenlijst = plantdao.getplantbykeuze(Keuze,zoekterm,getal,database);
            }
            showplanten("planten bij "+"familie",plantenlijst);
            break;
        }

    }
    public void click_advance(MouseEvent mouseEvent) {
        if(geavanceerdCheck.isSelected())
        {
            fentotyptab.setDisable(false);
            abiotischetab.setDisable(false);
            commensalimsetab.setDisable(false);
            beheertab.setDisable(false);
            extratab.setDisable(false);
        }
        else
        {
            fentotyptab.setDisable(true);
            abiotischetab.setDisable(true);
            commensalimsetab.setDisable(true);
            beheertab.setDisable(true);
            extratab.setDisable(true);
        }
    }
    public void listview_clicked(MouseEvent mouseEvent) {
        String tekst  = resultatentxt.getSelectionModel().getSelectedItem();
        System.out.println(tekst);
        for(int i =0; i < plantenlijst.size();i++)
        {
            if(plantenlijst.get(i).getFgsv()==tekst)
            {
                extrainfottxtx.setText("PlantID: " +plantenlijst.get(i).getPlant_id().toString()+"\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+ "Familie: " +plantenlijst.get(i).getFamilie()+"\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+ "Type: " +plantenlijst.get(i).getType()+"\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+ "Geslacht: " +plantenlijst.get(i).getGeslacht()+"\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+ "Soort: " +plantenlijst.get(i).getSoort()+"\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+ "Variatie: " +plantenlijst.get(i).getVariatie()+"\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+ "Plantdichtheid minimum: " +plantenlijst.get(i).getPlantdichtheid_min()+"\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+ "Plantdichtheid maximum: " +plantenlijst.get(i).getPlantdichtheid_min()+"\r\n");

            }

        }
    }
    public void ZetZoekinfo()
    {
        if(keuzenummer==0)
        {
            zoekInfolabel.setText("Maak een keuze op wat je wilt zoeken.");
            getal=0;
            database="plant";
        }
        if(keuzenummer==1)
        {
            zoekInfolabel.setText("Kies op naam van familie. Het hoeft niet volledig te zijn.");
            getal=1;
            database="plant";
        }
        if(keuzenummer==2)
        {
            zoekInfolabel.setText("Kies op naam van type. Het hoeft niet volledig te zijn.");
            getal=1;
            database="plant";

        }
        if(keuzenummer==3)
        {
            zoekInfolabel.setText("Kies op naam van geslacht. Het hoeft niet volledig te zijn.");
            getal=1;
            database="plant";

        }
        if(keuzenummer==4)
        {
            zoekInfolabel.setText("Kies op naam van soort. Het hoeft niet volledig te zijn.");
            getal=1;
            database="plant";

        }
        if(keuzenummer==5)
        {
            zoekInfolabel.setText("Kies op naam van variatie. Het hoeft niet volledig te zijn.");
            getal=1;
            database="plant";

        }
        if(keuzenummer==6)
        {
            zoekInfolabel.setText("Geef een cijfer in en we zullen alles teruggeven wat erboven zit.");
            getal=2;
            database="plant";

        }
        if(keuzenummer==7)
        {
            zoekInfolabel.setText("Geef een cijfer in en we zullen alles teruggeven wat eronder zit.");
            getal=3;
            database="plant";

        }
        if(keuzenummer==8)
        {
            zoekInfolabel.setText("Kies op naam van het FGSV. Het hoeft niet volledig te zijn.n");
            getal=1;
            database="plant";
        }

    }
    public int controleKeuzeZoekterm()
    {
        keuzenummer =0 ;
        Keuze="familie";
        if(familieradiobutton.isSelected())
        {
            keuzenummer=1;
            Keuze = "familie";
        }
        if(TypeRadiobutton.isSelected())
        {
            keuzenummer=2;
            Keuze="type";
        }
        if(GeslcahtRadioButton.isSelected())
        {
            keuzenummer=3;
            Keuze="geslacht";
        }
        if(SoortRadioButton.isSelected())
        {
            keuzenummer=4;
            Keuze="soort";
        }
        if(variatieRadioButton.isSelected())
        {
            keuzenummer=5;
            Keuze="variatie";
        }
        return keuzenummer;
    }
    public void zoekterm(MouseEvent mouseEvent) {
        getal=0;
        controleKeuzeZoekterm();
        ZetZoekinfo();
    }
}
