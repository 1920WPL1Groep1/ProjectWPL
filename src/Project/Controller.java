package Project;

import Project.dao.plantdao;
import Project.klasse.*;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import main.java.dao.Database;

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
    private List<beheer> beheerlijst;
    private List<abiotische_factoren> abiotischeFactorenList;
    private List<abiotische_multi> abiotischeFactorenMultiList;
    private List<commensialisme> commensialismeList;
    private List<commensialisme_multi> commensialismeMultiList;
    private List<extra> extraList;
    private List<fenotype> fenotypeList;
    private List<fenotype_multi> fenotypeMultiList;
    private List<foto> fotoList;

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
                beheerlijst = plantdao.returnBeheerlijst();
                abiotischeFactorenList = plantdao.returnAbiotischeFactoren();
                abiotischeFactorenMultiList = plantdao.returnAbiotischeFactorenMulti();
                commensialismeList = plantdao.returnCommensalisme();
                commensialismeMultiList = plantdao.returnCommensalismeMulti();
                extraList = plantdao.returnExtra();
                fenotypeList = plantdao.returnFenotype();
                fenotypeMultiList = plantdao.returnFenotypeMulti();
                fotoList = plantdao.returnFoto();
            }
            else
            {
                plantenlijst = plantdao.getplantbykeuze(Keuze,zoekterm,getal,database);
                beheerlijst = plantdao.returnBeheerlijst();
                abiotischeFactorenList = plantdao.returnAbiotischeFactoren();
                abiotischeFactorenMultiList = plantdao.returnAbiotischeFactorenMulti();
                commensialismeList = plantdao.returnCommensalisme();
                commensialismeMultiList = plantdao.returnCommensalismeMulti();
                extraList = plantdao.returnExtra();
                fenotypeList = plantdao.returnFenotype();
                fenotypeMultiList = plantdao.returnFenotypeMulti();
                fotoList = plantdao.returnFoto();
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
        int plant_id=0;
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
                 plant_id = plantenlijst.get(i).getPlant_id();
            }
        }
        //Eigenschappen beheer
        extrainfottxtx.setText(extrainfottxtx.getText() + "\r\n");
        extrainfottxtx.setText(extrainfottxtx.getText() + "Eigenschappen beheer\r\n");
        for (int j=0; j < beheerlijst.size(); j++)
        {
            if(beheerlijst.get(j).getPlant_id()==plant_id)
            {
                extrainfottxtx.setText(extrainfottxtx.getText()+"Beheer Id: "+ beheerlijst.get(j).getBeheer_id() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+"Beheerdaad: "+ beheerlijst.get(j).getBeheerdaad() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+"Opmerking: "+ beheerlijst.get(j).getOpmerking() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+"Maand: "+ beheerlijst.get(j).getMaand() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+"Frequentiejaar: "+ beheerlijst.get(j).getFrequentie_jaar() + "\r\n");
            }
        }
        //Eigenschappen abiostische factoren
        extrainfottxtx.setText(extrainfottxtx.getText() + "\r\n");
        extrainfottxtx.setText(extrainfottxtx.getText() + "Eigenschappen abiotische factoren\r\n");
        for (int j=0; j < abiotischeFactorenList.size(); j++)
        {
            if(beheerlijst.get(j).getPlant_id()==plant_id)
            {
                extrainfottxtx.setText(extrainfottxtx.getText()+"Abiotische factoren ID: "+ abiotischeFactorenList.get(j).getAbiotische_id() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+"Vochtbehoefte: "+ abiotischeFactorenList.get(j).getVochtbehoefte() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+"Bezonning: "+ abiotischeFactorenList.get(j).getBezonning() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+"Grondsoort: "+ abiotischeFactorenList.get(j).getGrondsoort() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+"Voedingsbehoefte: "+ abiotischeFactorenList.get(j).getVoedingsbehoefte() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+"Reactie angonistische omgeving: "+ abiotischeFactorenList.get(j).getReactie_antagoistische_omg() + "\r\n");
            }
        }

        //Eigenschappen abiotische factoren multi
        extrainfottxtx.setText(extrainfottxtx.getText() + "\r\n");
        extrainfottxtx.setText(extrainfottxtx.getText() + "Eigenschappen abiotische factoren multi\r\n");
        for (int j=0; j < abiotischeFactorenMultiList.size(); j++)
        {
            if(beheerlijst.get(j).getPlant_id()==plant_id)
            {
                extrainfottxtx.setText(extrainfottxtx.getText()+"Abiotische factoren ID: "+ abiotischeFactorenMultiList.get(j).getAbiotische_id() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+"Plant ID: "+ abiotischeFactorenMultiList.get(j).getPlant_id() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+"Eigenschap: "+ abiotischeFactorenMultiList.get(j).getEigenschap() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+"Waarde: "+ abiotischeFactorenMultiList.get(j).getWaarde() + "\r\n");
            }
        }

        //Eigenschappen commensalisme
        extrainfottxtx.setText(extrainfottxtx.getText() + "\r\n");
        extrainfottxtx.setText(extrainfottxtx.getText() + "Eigenschappen commensalisme\r\n");
        for (int j=0; j < commensialismeList.size(); j++)
        {
            if(commensialismeList.get(j).getPlant_id()==plant_id)
            {
                extrainfottxtx.setText(extrainfottxtx.getText()+"Abiotische factoren ID: "+ commensialismeList.get(j).getPlant_id() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+"Plant ID: "+ commensialismeList.get(j).getStrategie() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+"Eigenschap: "+ commensialismeList.get(j).getCommensialisme_id() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+"Waarde: "+ commensialismeList.get(j).getOntwikkelingssnelheid() + "\r\n");
            }
        }

        //Eigenschappen commensalisme multi
        extrainfottxtx.setText(extrainfottxtx.getText() + "\r\n");
        extrainfottxtx.setText(extrainfottxtx.getText() + "Eigenschappen commensalisme multi\r\n");
        for (int j=0; j < commensialismeMultiList.size(); j++)
        {
            if(commensialismeMultiList.get(j).getPlant_id()==plant_id)
            {
                extrainfottxtx.setText(extrainfottxtx.getText()+"Plant ID: "+ commensialismeMultiList.get(j).getPlant_id() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+"Commensialisme ID: "+ commensialismeMultiList.get(j).getCommensialisme_id() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+"Eigenschap: "+ commensialismeMultiList.get(j).getEigenschap() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+"Waarde: "+ commensialismeMultiList.get(j).getWaarde() + "\r\n");
            }
        }

        //Eigenschappen extra
        extrainfottxtx.setText(extrainfottxtx.getText() + "\r\n");
        extrainfottxtx.setText(extrainfottxtx.getText() + "Eigenschappen extra\r\n");
        for (int j=0; j < extraList.size(); j++)
        {
            if(extraList.get(j).getPlant_id()==plant_id)
            {
                extrainfottxtx.setText(extrainfottxtx.getText()+"Plant ID: "+ extraList.get(j).getPlant_id() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+"Extra ID: "+ extraList.get(j).getExtra_id() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+"Bijvriendelijk: "+ extraList.get(j).getBijvriendelijk() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+"Eetbaar en kruidgebruik: "+ extraList.get(j).getEetbaar_kruidgebruik() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+"Geurend: "+ extraList.get(j).getGeurend() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+"Nectarwaarde: "+ extraList.get(j).getNectarwaarde() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+"Pollenwaarde: "+ extraList.get(j).getPollenwaarde() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+"Vorstgevoelig: "+ extraList.get(j).getVorstgevoelig() + "\r\n");
            }
        }

        //Eigenschappen fenotype
        extrainfottxtx.setText(extrainfottxtx.getText() + "\r\n");
        extrainfottxtx.setText(extrainfottxtx.getText() + "Eigenschappen fenotype\r\n");
        for (int j=0; j < fenotypeList.size(); j++)
        {
            if(fenotypeList.get(j).getPlant_id()==plant_id)
            {
                extrainfottxtx.setText(extrainfottxtx.getText()+"Plant ID: "+ fenotypeList.get(j).getPlant_id() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+"Fenotype ID: "+ fenotypeList.get(j).getFenotype_id() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+"Bladvorm: "+ fenotypeList.get(j).getBladvorm() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+"Levensvorm: "+ fenotypeList.get(j).getLevensvorm() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+"Habitus: "+ fenotypeList.get(j).getHabitus() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+"Bloeiwijze: "+ fenotypeList.get(j).getBloeiwijze() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+"Bladgrootte: "+ fenotypeList.get(j).getBladgrootte() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+"Ratio bloei/blad: "+ fenotypeList.get(j).getRatio_bloei_blad() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText()+"Spruitfenologie: "+ fenotypeList.get(j).getSpruitfenelogie() + "\r\n");
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
            zoekInfolabel.setText("Kies op naam van het FGSV. Het hoeft niet volledig te zijn.");
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
