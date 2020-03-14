package Project;

import Project.dao.combodao;
import Project.dao.plantdao;
import Project.klasse.*;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import main.java.dao.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public Label bladhoogtetxt;
    public Label bloeihoogtetxt;
    public Label bladkleurtxt;
    public Label bloeikleurtxt;
    public Label bladgroottetxt;
    public RadioButton eetbaarBtnJa;
    public RadioButton eetbaarBtnNee;
    public RadioButton geurendBtnJa;
    public RadioButton geurendBtnNee;
    public RadioButton vorstBtnJa;
    public RadioButton vorstBtnNee;
    public ComboBox vergelijkenNectarCombo;
    public ComboBox nectarwaardeCombo;
    public ComboBox vergelijkenPollenCombo;
    public ComboBox pollenwaardeCombo;
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
    private List<combo> comboList;

    private int keuzenummer;
    private int getal;
    private String database;
    private String Keuze;


    public void initialize() throws SQLException {
        dbConnection = Database.getInstance().getConnection();
        fentotyptab.setDisable(true);
        abiotischetab.setDisable(true);
        commensalimsetab.setDisable(true);
        beheertab.setDisable(true);
        extratab.setDisable(true);
        resultaatab.setDisable(false);
        opvullencombo("bladvorm");
    }

    private void opvullencombo(String welke) throws SQLException {
        combodao combodao = new combodao(dbConnection);
        String var = null;
        ComboBox test = null;
        for (int i = 1; i < 25; i++) {
            if (i == 1) {
                var = "bladvorm";
                test = bladvormCombo;
            }
            if (i == 2) {
                var = "ratio_bloeiblad";
                test = ratioCombo;
            }
            if (i == 3) {
                var = "spruitfenelogie";
                test = spruitCombo;
            }
            if (i == 4) {
                var = "bloeiwijze";
                test = bloeiwijzeCombo;
            }
            if (i == 5) {
                var = "habitus";
                test = habitusCombo;
            }
            if (i == 6) {
                var = "bezonning";
                test = bezonningCombo;
            }
            if (i == 7) {
                var = "grondsoort";
                test = grondsoortCombo;
            }
            if (i == 8) {
                var = "vochtbehoefte";
                test = vochtbehoefteCombo;
            }
            if (i == 9) {
                var = "voedingsbehoefte";
                test = voedingsbehoefteCombo;
            }
            if (i == 10) {
                var = "reactieomgeving";
                test = reactieCombo;
            }
            //uitleg over wat er ingevuld moet worden in de combo's + vragen of mathias bij iedere keuze een waarde kan toevoegen "leeg" of "geen keuze" of gewoon leeg veld
//            if(i==11)
//            {
//                var="habitat";
//                test=habitat1Combo;
//            }
            if (i == 16) {
                var = "ontwikkelingssnelheid";
                test = ontwikkelingssnelheidCombo;
            }
            if (i == 17) {
                var = "levensduur_concurrentiekracht";
                test = levensduurCombo;
            }
            //strategie invullen vragen combo
            if (i == 18) {
                var = "strategie";
                test = strategie1Combo;
            }
            if (i == 19) {
                var = "strategie";
                test = strategie2Combo;
            }
            if (i == 20) {
                var = "beheer";
                test = beheerbehandelingCombo;
            }
            //maanden
//            if(i==21)
//            {
//
//            }
//            frequentie per jaar na vragen ? apparte tabel?
//            if(i==22)
//            {
//                var=
//            }
            if (i == 23) {
                var = "nectarwaarde";
                test = nectarwaardeCombo;
            }
            if (i == 24) {
                var = "pollenwaarde";
                test = pollenwaardeCombo;
            }
            try {
                comboList = combodao.getcombo(var);
                for (int j = 0; j < comboList.size(); j++) {
                    test.getItems().add(comboList.get(j).getGegeven());
                }
                comboList.clear();

            } catch (SQLException e) {
                System.out.println("in de catch");
                Logger.getLogger(plantdao.class.getName()).log(Level.SEVERE, null, e);
            }
        }
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
     *
     * @param titel
     * @param planten
     */
    public void showplanten(String titel, List<plant> planten) {
        System.out.println("Lijst planten : " + titel);
        int getal = 0;
        resultatentxt.getItems().clear();
        System.out.println(planten.size() + " grote");
        for (int i = 0; i < planten.size(); i++) {
            resultatentxt.getItems().add(i, planten.get(i).getFgsv());
        }
        if (planten.size() == 0) {
            resultatentxt.getItems().add(0, "Er zijn geen planten terug gevonden.");
        }
    }

    /**
     * @param plantdao
     * @throws SQLException
     */
    private void showByName(plantdao plantdao) throws SQLException {
        System.out.println(Keuze + " " + getal);
        while (true) {
            String zoekterm = zoekenTxt.getText();
            System.out.println(zoekterm);
            if (zoekterm == null) {
                plantenlijst = plantdao.getAllPlant();
                beheerlijst = plantdao.returnBeheerlijst();
                abiotischeFactorenList = plantdao.returnAbiotischeFactoren();
                abiotischeFactorenMultiList = plantdao.returnAbiotischeFactorenMulti();
                commensialismeList = plantdao.returnCommensalisme();
                commensialismeMultiList = plantdao.returnCommensalismeMulti();
                extraList = plantdao.returnExtra();
                fenotypeList = plantdao.returnFenotype();
                fenotypeMultiList = plantdao.returnFenotypeMulti();
                fotoList = plantdao.returnFoto();
            } else {
                plantenlijst = plantdao.getplantbykeuze(Keuze, zoekterm, getal, database);
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
//            fenotypetabzoeken();
//            abiotischefactorenzoeken();
            showplanten("planten bij " + "familie", plantenlijst);
            break;
        }

    }

    private void fenotypetabzoeken() {
        for (int i = 0; i < fenotypeMultiList.size(); i++) {
            try {
                if (fenotypeMultiList.get(i).getEigenschap() == "bladhoogte") {
                    int bladgrootte = 0;
                    switch (bladhoogteMaandTxt.getText().toLowerCase()) {
                        case "januarie":
                        case "jan":
                            bladgrootte = Integer.parseInt(fenotypeMultiList.get(i).getJan());
                            break;
                        case "februari":
                        case "feb":
                            bladgrootte = Integer.parseInt(fenotypeMultiList.get(i).getFeb());
                            break;
                        case "maart":
                        case "maa":
                            bladgrootte = Integer.parseInt(fenotypeMultiList.get(i).getMaa());
                            break;
                        case "april":
                        case "apr":
                            bladgrootte = Integer.parseInt(fenotypeMultiList.get(i).getApr());
                            break;
                        case "mei":
                            bladgrootte = Integer.parseInt(fenotypeMultiList.get(i).getMei());
                            break;
                        case "juni":
                        case "jun":
                            bladgrootte = Integer.parseInt(fenotypeMultiList.get(i).getJun());
                            break;
                        case "juli":
                        case "jul":
                            bladgrootte = Integer.parseInt(fenotypeMultiList.get(i).getJul());
                            break;
                        case "augustus":
                        case "aug":
                            bladgrootte = Integer.parseInt(fenotypeMultiList.get(i).getAug());
                            break;
                        case "september":
                        case "sep":
                            bladgrootte = Integer.parseInt(fenotypeMultiList.get(i).getSep());
                            break;
                        case "oktober":
                        case "okt":
                            bladgrootte = Integer.parseInt(fenotypeMultiList.get(i).getOkt());
                            break;
                        case "november":
                        case "nov":
                            bladgrootte = Integer.parseInt(fenotypeMultiList.get(i).getNov());
                            break;
                        case "december":
                        case "dec":
                            bladgrootte = Integer.parseInt(fenotypeMultiList.get(i).getDec());
                            break;
                        default:
                            bladhoogtetxt.setText("vul de maand correct in , of er zijn geen planten die voldoen");
                    }
                    if (bladgrootte <= Integer.parseInt(bladhoogteMinimumTxt.getText())) {
                        int plantID = fenotypeMultiList.get(i).getPlant_id();
                        verwjider(plantID);
                        break;
                    }
                    if (bladgrootte >= Integer.parseInt(bladhoogteMaximumTxt.getText())) ;
                    {
                        int plantID = fenotypeMultiList.get(i).getPlant_id();
                        verwjider(plantID);
                        break;
                    }
//                TextField test = bladhoogteMaandTxt;
//                if(bladhoogteMaandTxt.getText().toLowerCase()=="januari" || bladhoogteMaandTxt.getText().toLowerCase()=="jan" )
//                {
//                    if(Integer.parseInt(fenotypeMultiList.get(i).getJan()) >= Integer.parseInt(bladhoogteMaximumTxt.getText()))
//                    {
//                        int  plantID =fenotypeMultiList.get(i).getPlant_id();
//                        verwjider(plantID);
//                    }
//                    if(Integer.parseInt(fenotypeMultiList.get(i).getJan()) <= Integer.parseInt(bladhoogteMinimumTxt.getText()))
//                    {
//                        int  plantID =fenotypeMultiList.get(i).getPlant_id();
//                        verwjider(plantID);
//                    }
//                }
//                else if(bladhoogteMaandTxt.getText().toLowerCase()=="februari" || bladhoogteMaandTxt.getText().toLowerCase()=="feb" )
//                {
//                    if(Integer.parseInt(fenotypeMultiList.get(i).getFeb()) >= Integer.parseInt(bladhoogteMaximumTxt.getText()))
//                    {
//                        int  plantID =fenotypeMultiList.get(i).getPlant_id();
//                        verwjider(plantID);
//                    }
//                    if(Integer.parseInt(fenotypeMultiList.get(i).getFeb()) <= Integer.parseInt(bladhoogteMinimumTxt.getText()))
//                    {
//                        int  plantID =fenotypeMultiList.get(i).getPlant_id();
//                        verwjider(plantID);
//                    }
//                }
//                else if(bladhoogteMaandTxt.getText().toLowerCase()=="maart" || bladhoogteMaandTxt.getText().toLowerCase()=="maa" )
//                {
//                    if(Integer.parseInt(fenotypeMultiList.get(i).getMaa()) >= Integer.parseInt(bladhoogteMaximumTxt.getText()))
//                    {
//                        int  plantID =fenotypeMultiList.get(i).getPlant_id();
//                        verwjider(plantID);
//                    }
//                    if(Integer.parseInt(fenotypeMultiList.get(i).getMaa()) <= Integer.parseInt(bladhoogteMinimumTxt.getText()))
//                    {
//                        int  plantID =fenotypeMultiList.get(i).getPlant_id();
//                        verwjider(plantID);
//                    }
//                }
//                else if(bladhoogteMaandTxt.getText().toLowerCase()=="april" || bladhoogteMaandTxt.getText().toLowerCase()=="apr" )
//                {
//                    if(Integer.parseInt(fenotypeMultiList.get(i).getApr()) >= Integer.parseInt(bladhoogteMaximumTxt.getText()))
//                    {
//                        int  plantID =fenotypeMultiList.get(i).getPlant_id();
//                        verwjider(plantID);
//                    }
//                    if(Integer.parseInt(fenotypeMultiList.get(i).getApr()) <= Integer.parseInt(bladhoogteMinimumTxt.getText()))
//                    {
//                        int  plantID =fenotypeMultiList.get(i).getPlant_id();
//                        verwjider(plantID);
//                    }
//                }
//                else if(bladhoogteMaandTxt.getText().toLowerCase()=="mei" || bladhoogteMaandTxt.getText().toLowerCase()=="mei" )
//                {
//                    if(Integer.parseInt(fenotypeMultiList.get(i).getMei()) >= Integer.parseInt(bladhoogteMaximumTxt.getText()))
//                    {
//                        int  plantID =fenotypeMultiList.get(i).getPlant_id();
//                        verwjider(plantID);
//                    }
//                    if(Integer.parseInt(fenotypeMultiList.get(i).getMei()) <= Integer.parseInt(bladhoogteMinimumTxt.getText()))
//                    {
//                        int  plantID =fenotypeMultiList.get(i).getPlant_id();
//                        verwjider(plantID);
//                    }
//                }
//                else if(bladhoogteMaandTxt.getText().toLowerCase()=="juni" || bladhoogteMaandTxt.getText().toLowerCase()=="jun" )
//                {
//                    if(Integer.parseInt(fenotypeMultiList.get(i).getJun()) >= Integer.parseInt(bladhoogteMaximumTxt.getText()))
//                    {
//                        int  plantID =fenotypeMultiList.get(i).getPlant_id();
//                        verwjider(plantID);
//                    }
//                    if(Integer.parseInt(fenotypeMultiList.get(i).getJun()) <= Integer.parseInt(bladhoogteMinimumTxt.getText()))
//                    {
//                        int  plantID =fenotypeMultiList.get(i).getPlant_id();
//                        verwjider(plantID);
//                    }
//                }
//                else if(bladhoogteMaandTxt.getText().toLowerCase()=="juli" || bladhoogteMaandTxt.getText().toLowerCase()=="jul" )
//                {
//                    if(Integer.parseInt(fenotypeMultiList.get(i).getJul()) >= Integer.parseInt(bladhoogteMaximumTxt.getText()))
//                    {
//                        int  plantID =fenotypeMultiList.get(i).getPlant_id();
//                        verwjider(plantID);
//                    }
//                    if(Integer.parseInt(fenotypeMultiList.get(i).getJul()) <= Integer.parseInt(bladhoogteMinimumTxt.getText()))
//                    {
//                        int  plantID =fenotypeMultiList.get(i).getPlant_id();
//                        verwjider(plantID);
//                    }
//                }
//                else if(bladhoogteMaandTxt.getText().toLowerCase()=="augustus" || bladhoogteMaandTxt.getText().toLowerCase()=="aug" )
//                {
//                    if(Integer.parseInt(fenotypeMultiList.get(i).getAug()) >= Integer.parseInt(bladhoogteMaximumTxt.getText()))
//                    {
//                        int  plantID =fenotypeMultiList.get(i).getPlant_id();
//                        verwjider(plantID);
//                    }
//                    if(Integer.parseInt(fenotypeMultiList.get(i).getAug()) <= Integer.parseInt(bladhoogteMinimumTxt.getText()))
//                    {
//                        int  plantID =fenotypeMultiList.get(i).getPlant_id();
//                        verwjider(plantID);
//                    }
//                }
//                else if(bladhoogteMaandTxt.getText().toLowerCase()=="september" || bladhoogteMaandTxt.getText().toLowerCase()=="sep" )
//                {
//                    if(Integer.parseInt(fenotypeMultiList.get(i).getSep()) >= Integer.parseInt(bladhoogteMaximumTxt.getText()))
//                    {
//                        int  plantID =fenotypeMultiList.get(i).getPlant_id();
//                        verwjider(plantID);
//                    }
//                    if(Integer.parseInt(fenotypeMultiList.get(i).getSep()) <= Integer.parseInt(bladhoogteMinimumTxt.getText()))
//                    {
//                        int  plantID =fenotypeMultiList.get(i).getPlant_id();
//                        verwjider(plantID);
//                    }
//                }
//                else if(bladhoogteMaandTxt.getText().toLowerCase()=="oktober" || bladhoogteMaandTxt.getText().toLowerCase()=="okt" )
//                {
//                    if(Integer.parseInt(fenotypeMultiList.get(i).getOkt()) >= Integer.parseInt(bladhoogteMaximumTxt.getText()))
//                    {
//                        int  plantID =fenotypeMultiList.get(i).getPlant_id();
//                        verwjider(plantID);
//                    }
//                    if(Integer.parseInt(fenotypeMultiList.get(i).getOkt()) <= Integer.parseInt(bladhoogteMinimumTxt.getText()))
//                    {
//                        int  plantID =fenotypeMultiList.get(i).getPlant_id();
//                        verwjider(plantID);
//                    }
//                }
//                else if(bladhoogteMaandTxt.getText().toLowerCase()=="november" || bladhoogteMaandTxt.getText().toLowerCase()=="nov" )
//                {
//                    if(Integer.parseInt(fenotypeMultiList.get(i).getNov()) >= Integer.parseInt(bladhoogteMaximumTxt.getText()))
//                    {
//                        int  plantID =fenotypeMultiList.get(i).getPlant_id();
//                        verwjider(plantID);
//                    }
//                    if(Integer.parseInt(fenotypeMultiList.get(i).getNov()) <= Integer.parseInt(bladhoogteMinimumTxt.getText()))
//                    {
//                        int  plantID =fenotypeMultiList.get(i).getPlant_id();
//                        verwjider(plantID);
//                    }
//                }
//                else if(bladhoogteMaandTxt.getText().toLowerCase()=="december" || bladhoogteMaandTxt.getText().toLowerCase()=="dec" )
//                {
//                    if(Integer.parseInt(fenotypeMultiList.get(i).getDec()) >= Integer.parseInt(bladhoogteMaximumTxt.getText()))
//                    {
//                        int  plantID =fenotypeMultiList.get(i).getPlant_id();
//                        verwjider(plantID);
//                    }
//                    if(Integer.parseInt(fenotypeMultiList.get(i).getDec()) <= Integer.parseInt(bladhoogteMinimumTxt.getText()))
//                    {
//                        int  plantID =fenotypeMultiList.get(i).getPlant_id();
//                        verwjider(plantID);
//                    }
//                }
//                else
//                {
//                    bladhoogtetxt.setText("gelieve alles correct in te vullen");
//                }
                }
                if (fenotypeMultiList.get(i).getEigenschap() == "bloeihoogte") {
                    int bloeihoogte = 0;
                    switch (bloeihoogteMaandTxt.getText().toLowerCase()) {
                        case "januarie":
                        case "jan":
                            bloeihoogte = Integer.parseInt(fenotypeMultiList.get(i).getJan());
                            break;
                        case "februari":
                        case "feb":
                            bloeihoogte = Integer.parseInt(fenotypeMultiList.get(i).getFeb());
                            break;
                        case "maart":
                        case "maa":
                            bloeihoogte = Integer.parseInt(fenotypeMultiList.get(i).getMaa());
                            break;
                        case "april":
                        case "apr":
                            bloeihoogte = Integer.parseInt(fenotypeMultiList.get(i).getApr());
                            break;
                        case "mei":
                            bloeihoogte = Integer.parseInt(fenotypeMultiList.get(i).getMei());
                            break;
                        case "juni":
                        case "jun":
                            bloeihoogte = Integer.parseInt(fenotypeMultiList.get(i).getJun());
                            break;
                        case "juli":
                        case "jul":
                            bloeihoogte = Integer.parseInt(fenotypeMultiList.get(i).getJul());
                            break;
                        case "augustus":
                        case "aug":
                            bloeihoogte = Integer.parseInt(fenotypeMultiList.get(i).getAug());
                            break;
                        case "september":
                        case "sep":
                            bloeihoogte = Integer.parseInt(fenotypeMultiList.get(i).getSep());
                            break;
                        case "oktober":
                        case "okt":
                            bloeihoogte = Integer.parseInt(fenotypeMultiList.get(i).getOkt());
                            break;
                        case "november":
                        case "nov":
                            bloeihoogte = Integer.parseInt(fenotypeMultiList.get(i).getNov());
                            break;
                        case "december":
                        case "dec":
                            bloeihoogte = Integer.parseInt(fenotypeMultiList.get(i).getDec());
                            break;
                        default:
                            bloeihoogtetxt.setText("vul de maand correct in , of er zijn geen planten die voldoen");
                    }
                    if (bloeihoogte <= Integer.parseInt(bloeihoogteMinimumTxt.getText())) {
                        int plantID = fenotypeMultiList.get(i).getPlant_id();
                        verwjider(plantID);
                        break;
                    }
                    if (bloeihoogte >= Integer.parseInt(bloeihoogteMaximumTxt.getText())) ;
                    {
                        int plantID = fenotypeMultiList.get(i).getPlant_id();
                        verwjider(plantID);
                        break;
                    }

                }
                if (fenotypeMultiList.get(i).getEigenschap() == "bladkleur") {
                    String bladkleur = "";
                    switch (bladkleurMaandTxt.getText().toLowerCase()) {
                        case "januarie":
                        case "jan":
                            bladkleur = fenotypeMultiList.get(i).getJan();
                            break;
                        case "februari":
                        case "feb":
                            bladkleur = fenotypeMultiList.get(i).getFeb();
                            break;
                        case "maart":
                        case "maa":
                            bladkleur = fenotypeMultiList.get(i).getMaa();
                            break;
                        case "april":
                        case "apr":
                            bladkleur = fenotypeMultiList.get(i).getApr();
                            break;
                        case "mei":
                            bladkleur = fenotypeMultiList.get(i).getMei();
                            break;
                        case "juni":
                        case "jun":
                            bladkleur = fenotypeMultiList.get(i).getJun();
                            break;
                        case "juli":
                        case "jul":
                            bladkleur = fenotypeMultiList.get(i).getJul();
                            break;
                        case "augustus":
                        case "aug":
                            bladkleur = fenotypeMultiList.get(i).getAug();
                            break;
                        case "september":
                        case "sep":
                            bladkleur = fenotypeMultiList.get(i).getSep();
                            break;
                        case "oktober":
                        case "okt":
                            bladkleur = fenotypeMultiList.get(i).getOkt();
                            break;
                        case "november":
                        case "nov":
                            bladkleur = fenotypeMultiList.get(i).getNov();
                            break;
                        case "december":
                        case "dec":
                            bladkleur = fenotypeMultiList.get(i).getDec();
                            break;
                        default:
                            bladkleurtxt.setText("vul de maand correct in , of er zijn geen planten die voldoen");
                    }
                    if (bladkleur != bladkleurKleurTxt.getText()) {
                        int plantID = fenotypeMultiList.get(i).getPlant_id();
                        verwjider(plantID);
                        break;
                    }
                }
                if (fenotypeMultiList.get(i).getEigenschap() == "bloeikleur") {
                    String bloeikleur = "";
                    switch (bloeikleurMaandTxt.getText().toLowerCase()) {
                        case "januarie":
                        case "jan":
                            bloeikleur = fenotypeMultiList.get(i).getJan();
                            break;
                        case "februari":
                        case "feb":
                            bloeikleur = fenotypeMultiList.get(i).getFeb();
                            break;
                        case "maart":
                        case "maa":
                            bloeikleur = fenotypeMultiList.get(i).getMaa();
                            break;
                        case "april":
                        case "apr":
                            bloeikleur = fenotypeMultiList.get(i).getApr();
                            break;
                        case "mei":
                            bloeikleur = fenotypeMultiList.get(i).getMei();
                            break;
                        case "juni":
                        case "jun":
                            bloeikleur = fenotypeMultiList.get(i).getJun();
                            break;
                        case "juli":
                        case "jul":
                            bloeikleur = fenotypeMultiList.get(i).getJul();
                            break;
                        case "augustus":
                        case "aug":
                            bloeikleur = fenotypeMultiList.get(i).getAug();
                            break;
                        case "september":
                        case "sep":
                            bloeikleur = fenotypeMultiList.get(i).getSep();
                            break;
                        case "oktober":
                        case "okt":
                            bloeikleur = fenotypeMultiList.get(i).getOkt();
                            break;
                        case "november":
                        case "nov":
                            bloeikleur = fenotypeMultiList.get(i).getNov();
                            break;
                        case "december":
                        case "dec":
                            bloeikleur = fenotypeMultiList.get(i).getDec();
                            break;
                        default:
                            bloeikleurtxt.setText("vul de maand correct in , of er zijn geen planten die voldoen");
                    }
                    if (bloeikleur != bloeikleurKleurTxt.getText()) {
                        int plantID = fenotypeMultiList.get(i).getPlant_id();
                        verwjider(plantID);
                        break;
                    }

                }
            } catch (Exception e) {
                System.out.println("er liep iets verkeerd tijden het builden");
            }
        }
        for (int j = 0; j < fenotypeList.size(); j++) {
            try {
                if (fenotypeList.get(j).getBladgrootte() < Integer.parseInt(bladgrootteMinimumTxt.getText())) {
                    int ID = fenotypeList.get(j).getPlant_id();
                    verwjider(ID);
                } else if (fenotypeList.get(j).getBladgrootte() > Integer.parseInt(bladgrootteMaximumTxt.getText())) {
                    int ID = fenotypeList.get(j).getPlant_id();
                    verwjider(ID);
                }
                //opzoeken levensvorm uitleg vragen
                else if (bladvormCombo.getSelectionModel().getSelectedItem() != fenotypeList.get(j).getBladvorm()) {
                    verwjider(fenotypeList.get(j).getPlant_id());
                } else if (ratioCombo.getSelectionModel().getSelectedItem() != fenotypeList.get(j).getRatio_bloei_blad()) {
                    verwjider(fenotypeList.get(j).getPlant_id());
                } else if (spruitCombo.getSelectionModel().getSelectedItem() != fenotypeList.get(j).getSpruitfenelogie()) {
                    verwjider(fenotypeList.get(j).getPlant_id());
                } else if (bloeiwijzeCombo.getSelectionModel().getSelectedItem() != fenotypeList.get(j).getBloeiwijze()) {
                    verwjider(fenotypeList.get(j).getPlant_id());

                } else if (habitusCombo.getSelectionModel().getSelectedItem() != fenotypeList.get(j).getHabitus()) {
                    verwjider(fenotypeList.get(j).getPlant_id());
                }
            } catch (Exception e) {
                bladgroottetxt.setText("geef zeker een getal in en geen tekst");
            }

        }
        //opzoeken levensvorm uitleg vragen
//        for (int k = 0; k < fenotypeList.size(); k++) {
//            if (bladvormCombo.getSelectionModel().getSelectedItem() != fenotypeList.get(k).getBladvorm()) {
//                verwjider(fenotypeList.get(k).getPlant_id());
//            } else if (spruitCombo.getSelectionModel().getSelectedItem() != fenotypeList.get(k).getSpruitfenelogie()) {
//                verwjider(fenotypeList.get(k).getPlant_id());
//            } else if (ratioCombo.getSelectionModel().getSelectedItem() != fenotypeList.get(k).getRatio_bloei_blad()) {
//                verwjider(fenotypeList.get(k).getPlant_id());
//            }
//
//        }
//        for (int l = 0; l < fenotypeList.size(); l++) {
//            if (ratioCombo.getSelectionModel().getSelectedItem() != fenotypeList.get(l).getRatio_bloei_blad()) {
//                verwjider(fenotypeList.get(l).getPlant_id());
//            }
//        }
//        for (int m = 0; m < fenotypeList.size(); m++) {
//            if (spruitCombo.getSelectionModel().getSelectedItem() != fenotypeList.get(m).getSpruitfenelogie()) {
//                verwjider(fenotypeList.get(m).getPlant_id());
//            }
//        }
    }

    private void abiotischefactorenzoeken() {
        for (int k = 0; k < abiotischeFactorenList.size(); k++) {
            if (bezonningCombo.getSelectionModel().getSelectedItem() != abiotischeFactorenList.get(k).getBezonning()) {
                verwjider(abiotischeFactorenList.get(k).getPlant_id());
            } else if (grondsoortCombo.getSelectionModel().getSelectedItem() != abiotischeFactorenList.get(k).getGrondsoort()) {
                verwjider(abiotischeFactorenList.get(k).getPlant_id());
            } else if (vochtbehoefteCombo.getSelectionModel().getSelectedItem() != abiotischeFactorenList.get(k).getVochtbehoefte()) {
                verwjider(abiotischeFactorenList.get(k).getPlant_id());
            } else if (voedingsbehoefteCombo.getSelectionModel().getSelectedItem() != abiotischeFactorenList.get(k).getVoedingsbehoefte()) {
                verwjider(abiotischeFactorenList.get(k).getPlant_id());
            } else if (reactieCombo.getSelectionModel().getSelectedItem() != abiotischeFactorenList.get(k).getReactie_antagoistische_omg()) {
                verwjider(abiotischeFactorenList.get(k).getPlant_id());
            }
        }

        //zit vast met dit gedeelte omdat als ik niet inzie hoe ik kan zoeken en dan meerdere dingen kan checken...
        // werk ik met een for lus onder de keuze 2 om de overlopen en te checkn of het klopt aan de a-hand van ID ?
//
//        String keuze1;
//        String keuze2;
//        int vorigplantID = 0;
//        boolean verwijder = false;
//        for (int l = 0; l < abiotischeFactorenMultiList.size(); l++) {
//            if (habitatEnOfCombo.getSelectionModel().getSelectedItem() == "en") {
//                keuze1 = habitat1Combo.getSelectionModel().getSelectedItem().toString();
//                keuze2 = habitat3Combo.getSelectionModel().getSelectedItem().toString();
//                boolean bkeuze1 =false;
//                boolean bkeuze2=false;
//                for(int m=0;m<abiotischeFactorenMultiList.size();m++)
//                {
//                    if(abiotischeFactorenMultiList.get(m).getEigenschap()==keuze1)
//                    {
//                        bkeuze1=true;
//                    }
//                    if(abiotischeFactorenMultiList.get(m).getEigenschap()==keuze2)
//                    {
//                        bkeuze2=true;
//                    }
//                }
//                if(bkeuze1!=true && bkeuze2!=true)
//                {
//                    verwijder
//                }
////
//            } else if (habitatEnOfCombo.getSelectionModel().getSelectedItem() == "of") {
//                keuze1 = habitat1Combo.getSelectionModel().getSelectedItem().toString();
//                keuze2 = habitat3Combo.getSelectionModel().getSelectedItem().toString();
//
//            } else if (habitatEnOfCombo.getSelectionModel().getSelectedItem() == "en/of") {
//                keuze1 = habitat1Combo.getSelectionModel().getSelectedItem().toString();
//                keuze2 = habitat3Combo.getSelectionModel().getSelectedItem().toString();
//
//            } else if (habitatEnOfCombo.getSelectionModel().getSelectedItem() == "alleen") {
//                keuze1 = habitat1Combo.getSelectionModel().getSelectedItem().toString();
//                if (keuze1 != abiotischeFactorenMultiList.get(l).getEigenschap()) {
//                }
//            }
//
//        }
    }

    private void commensialismezoeken()   {

    }

    private void beheerzoeken(){}

    private void extratab(){}

    private void verwjider(int plantID) {
        for (int j = 0; j < fenotypeMultiList.size(); j++) {
            if (fenotypeMultiList.get(j).getPlant_id() == plantID) {
                fenotypeMultiList.remove(j);
            }
        }
        for (int j = 0; j < plantenlijst.size(); j++) {
            if (plantenlijst.get(j).getPlant_id() == plantID) {
                plantenlijst.remove(j);
            }
        }
        for (int j = 0; j < beheerlijst.size(); j++) {
            if (beheerlijst.get(j).getPlant_id() == plantID) {
                beheerlijst.remove(j);
            }
        }
        for (int j = 0; j < abiotischeFactorenList.size(); j++) {
            if (abiotischeFactorenList.get(j).getPlant_id() == plantID) {
                abiotischeFactorenList.remove(j);
            }
        }
        for (int j = 0; j < abiotischeFactorenMultiList.size(); j++) {
            if (abiotischeFactorenMultiList.get(j).getPlant_id() == plantID) {
                abiotischeFactorenMultiList.remove(j);
            }
        }
        for (int j = 0; j < commensialismeList.size(); j++) {
            if (commensialismeList.get(j).getPlant_id() == plantID) {
                commensialismeList.remove(j);
            }
        }
        for (int j = 0; j < commensialismeMultiList.size(); j++) {
            if (commensialismeMultiList.get(j).getPlant_id() == plantID) {
                commensialismeMultiList.remove(j);
            }
        }
        for (int j = 0; j < extraList.size(); j++) {
            if (extraList.get(j).getPlant_id() == plantID) {
                extraList.remove(j);
            }
        }
        for (int j = 0; j < fenotypeList.size(); j++) {
            if (fenotypeList.get(j).getPlant_id() == plantID) {
                fenotypeList.remove(j);
            }
        }
        for (int j = 0; j < fotoList.size(); j++) {
            if (fotoList.get(j).getPlant_id() == plantID) {
                fotoList.remove(j);
            }
        }

    }

    public void click_advance(MouseEvent mouseEvent) {
        if (geavanceerdCheck.isSelected()) {
            fentotyptab.setDisable(false);
            abiotischetab.setDisable(false);
            commensalimsetab.setDisable(false);
            beheertab.setDisable(false);
            extratab.setDisable(false);
        } else {
            fentotyptab.setDisable(true);
            abiotischetab.setDisable(true);
            commensalimsetab.setDisable(true);
            beheertab.setDisable(true);
            extratab.setDisable(true);
        }
    }

    public void listview_clicked(MouseEvent mouseEvent) {
        String tekst = resultatentxt.getSelectionModel().getSelectedItem();
        System.out.println(tekst);
        int plant_id = 0;
        for (int i = 0; i < plantenlijst.size(); i++) {
            if (plantenlijst.get(i).getFgsv() == tekst) {
                extrainfottxtx.setText("PlantID: " + plantenlijst.get(i).getPlant_id().toString() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Familie: " + plantenlijst.get(i).getFamilie() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Type: " + plantenlijst.get(i).getType() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Geslacht: " + plantenlijst.get(i).getGeslacht() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Soort: " + plantenlijst.get(i).getSoort() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Variatie: " + plantenlijst.get(i).getVariatie() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Plantdichtheid minimum: " + plantenlijst.get(i).getPlantdichtheid_min() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Plantdichtheid maximum: " + plantenlijst.get(i).getPlantdichtheid_min() + "\r\n");
                plant_id = plantenlijst.get(i).getPlant_id();
            }
        }
        //Eigenschappen beheer
        extrainfottxtx.setText(extrainfottxtx.getText() + "\r\n");
        extrainfottxtx.setText(extrainfottxtx.getText() + "Eigenschappen beheer\r\n");
        for (int j = 0; j < beheerlijst.size(); j++) {
            if (beheerlijst.get(j).getPlant_id() == plant_id) {
                extrainfottxtx.setText(extrainfottxtx.getText() + "Beheer Id: " + beheerlijst.get(j).getBeheer_id() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Beheerdaad: " + beheerlijst.get(j).getBeheerdaad() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Opmerking: " + beheerlijst.get(j).getOpmerking() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Maand: " + beheerlijst.get(j).getMaand() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Frequentiejaar: " + beheerlijst.get(j).getFrequentie_jaar() + "\r\n");
            }
        }
        //Eigenschappen abiostische factoren
        extrainfottxtx.setText(extrainfottxtx.getText() + "\r\n");
        extrainfottxtx.setText(extrainfottxtx.getText() + "Eigenschappen abiotische factoren\r\n");
        for (int j = 0; j < abiotischeFactorenList.size(); j++) {
            if (abiotischeFactorenList.get(j).getPlant_id() == plant_id) {
                extrainfottxtx.setText(extrainfottxtx.getText() + "Abiotische factoren ID: " + abiotischeFactorenList.get(j).getAbiotische_id() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Vochtbehoefte: " + abiotischeFactorenList.get(j).getVochtbehoefte() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Bezonning: " + abiotischeFactorenList.get(j).getBezonning() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Grondsoort: " + abiotischeFactorenList.get(j).getGrondsoort() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Voedingsbehoefte: " + abiotischeFactorenList.get(j).getVoedingsbehoefte() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Reactie angonistische omgeving: " + abiotischeFactorenList.get(j).getReactie_antagoistische_omg() + "\r\n");
            }
        }

        //Eigenschappen abiotische factoren multi
        extrainfottxtx.setText(extrainfottxtx.getText() + "\r\n");
        extrainfottxtx.setText(extrainfottxtx.getText() + "Eigenschappen abiotische factoren multi\r\n");
        for (int j = 0; j < abiotischeFactorenMultiList.size(); j++) {
            System.out.println(beheerlijst.size());
            System.out.println(j);
            if (abiotischeFactorenMultiList.get(j).getPlant_id() == plant_id) {
                extrainfottxtx.setText(extrainfottxtx.getText() + "Abiotische factoren ID: " + abiotischeFactorenMultiList.get(j).getAbiotische_id() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Plant ID: " + abiotischeFactorenMultiList.get(j).getPlant_id() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Eigenschap: " + abiotischeFactorenMultiList.get(j).getEigenschap() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Waarde: " + abiotischeFactorenMultiList.get(j).getWaarde() + "\r\n");
            }
        }

        //Eigenschappen commensalisme
        extrainfottxtx.setText(extrainfottxtx.getText() + "\r\n");
        extrainfottxtx.setText(extrainfottxtx.getText() + "Eigenschappen commensalisme\r\n");
        for (int j = 0; j < commensialismeList.size(); j++) {
            if (commensialismeList.get(j).getPlant_id() == plant_id) {
                extrainfottxtx.setText(extrainfottxtx.getText() + "Abiotische factoren ID: " + commensialismeList.get(j).getPlant_id() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Plant ID: " + commensialismeList.get(j).getStrategie() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Eigenschap: " + commensialismeList.get(j).getCommensialisme_id() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Waarde: " + commensialismeList.get(j).getOntwikkelingssnelheid() + "\r\n");
            }
        }

        //Eigenschappen commensalisme multi
        extrainfottxtx.setText(extrainfottxtx.getText() + "\r\n");
        extrainfottxtx.setText(extrainfottxtx.getText() + "Eigenschappen commensalisme multi\r\n");
        for (int j = 0; j < commensialismeMultiList.size(); j++) {
            if (commensialismeMultiList.get(j).getPlant_id() == plant_id) {
                extrainfottxtx.setText(extrainfottxtx.getText() + "Plant ID: " + commensialismeMultiList.get(j).getPlant_id() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Commensialisme ID: " + commensialismeMultiList.get(j).getCommensialisme_id() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Eigenschap: " + commensialismeMultiList.get(j).getEigenschap() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Waarde: " + commensialismeMultiList.get(j).getWaarde() + "\r\n");
            }
        }

        //Eigenschappen extra
        extrainfottxtx.setText(extrainfottxtx.getText() + "\r\n");
        extrainfottxtx.setText(extrainfottxtx.getText() + "Eigenschappen extra\r\n");
        for (int j = 0; j < extraList.size(); j++) {
            if (extraList.get(j).getPlant_id() == plant_id) {
                extrainfottxtx.setText(extrainfottxtx.getText() + "Plant ID: " + extraList.get(j).getPlant_id() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Extra ID: " + extraList.get(j).getExtra_id() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Bijvriendelijk: " + extraList.get(j).getBijvriendelijk() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Eetbaar en kruidgebruik: " + extraList.get(j).getEetbaar_kruidgebruik() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Geurend: " + extraList.get(j).getGeurend() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Nectarwaarde: " + extraList.get(j).getNectarwaarde() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Pollenwaarde: " + extraList.get(j).getPollenwaarde() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Vorstgevoelig: " + extraList.get(j).getVorstgevoelig() + "\r\n");
            }
        }

        //Eigenschappen fenotype
        extrainfottxtx.setText(extrainfottxtx.getText() + "\r\n");
        extrainfottxtx.setText(extrainfottxtx.getText() + "Eigenschappen fenotype\r\n");
        for (int j = 0; j < fenotypeList.size(); j++) {
            if (fenotypeList.get(j).getPlant_id() == plant_id) {
                extrainfottxtx.setText(extrainfottxtx.getText() + "Plant ID: " + fenotypeList.get(j).getPlant_id() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Fenotype ID: " + fenotypeList.get(j).getFenotype_id() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Bladvorm: " + fenotypeList.get(j).getBladvorm() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Levensvorm: " + fenotypeList.get(j).getLevensvorm() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Habitus: " + fenotypeList.get(j).getHabitus() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Bloeiwijze: " + fenotypeList.get(j).getBloeiwijze() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Bladgrootte: " + fenotypeList.get(j).getBladgrootte() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Ratio bloei/blad: " + fenotypeList.get(j).getRatio_bloei_blad() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Spruitfenologie: " + fenotypeList.get(j).getSpruitfenelogie() + "\r\n");
            }
        }

        //Eigenschappen fenotype multi
        extrainfottxtx.setText(extrainfottxtx.getText() + "\r\n");
        extrainfottxtx.setText(extrainfottxtx.getText() + "Eigenschappen fenotype multi\r\n");
        for (int j = 0; j < fenotypeMultiList.size(); j++) {
            if (fenotypeMultiList.get(j).getPlant_id() == plant_id) {
                extrainfottxtx.setText(extrainfottxtx.getText() + "Plant ID: " + fenotypeMultiList.get(j).getPlant_id() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Fenotype ID: " + fenotypeMultiList.get(j).getFenotype_id() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "eigenschap " + fenotypeMultiList.get(j).getEigenschap() + "\r\n");
                //Maanden erbij?
            }
        }

        //Eigenschappen foto
        extrainfottxtx.setText(extrainfottxtx.getText() + "\r\n");
        extrainfottxtx.setText(extrainfottxtx.getText() + "Eigenschappen foto\r\n");
        for (int j = 0; j < fotoList.size(); j++) {
            if (fotoList.get(j).getPlant_id() == plant_id) {
                extrainfottxtx.setText(extrainfottxtx.getText() + "Plant ID: " + fotoList.get(j).getPlant_id() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Foto ID: " + fotoList.get(j).getFoto_id() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Eigenschap: " + fotoList.get(j).getEigenschap() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "URL: " + fotoList.get(j).getUrl() + "\r\n");
                extrainfottxtx.setText(extrainfottxtx.getText() + "Figuur: " + fotoList.get(j).getFiguur() + "\r\n");
            }
        }


    }

    public void ZetZoekinfo() {
        if (keuzenummer == 0) {
            zoekInfolabel.setText("Maak een keuze op wat je wilt zoeken.");
            getal = 0;
            database = "plant";
        }
        if (keuzenummer == 1) {
            zoekInfolabel.setText("Kies op naam van familie. Het hoeft niet volledig te zijn.");
            getal = 1;
            database = "plant";
        }
        if (keuzenummer == 2) {
            zoekInfolabel.setText("Kies op naam van type. Het hoeft niet volledig te zijn.");
            getal = 1;
            database = "plant";

        }
        if (keuzenummer == 3) {
            zoekInfolabel.setText("Kies op naam van geslacht. Het hoeft niet volledig te zijn.");
            getal = 1;
            database = "plant";

        }
        if (keuzenummer == 4) {
            zoekInfolabel.setText("Kies op naam van soort. Het hoeft niet volledig te zijn.");
            getal = 1;
            database = "plant";

        }
        if (keuzenummer == 5) {
            zoekInfolabel.setText("Kies op naam van variatie. Het hoeft niet volledig te zijn.");
            getal = 1;
            database = "plant";

        }
        if (keuzenummer == 6) {
            zoekInfolabel.setText("Geef een cijfer in en we zullen alles teruggeven wat erboven zit.");
            getal = 2;
            database = "plant";

        }
        if (keuzenummer == 7) {
            zoekInfolabel.setText("Geef een cijfer in en we zullen alles teruggeven wat eronder zit.");
            getal = 3;
            database = "plant";

        }
        if (keuzenummer == 8) {
            zoekInfolabel.setText("Kies op naam van het FGSV. Het hoeft niet volledig te zijn.");
            getal = 1;
            database = "plant";
        }

    }

    public int controleKeuzeZoekterm() {
        keuzenummer = 0;
        Keuze = "familie";
        if (familieradiobutton.isSelected()) {
            keuzenummer = 1;
            Keuze = "familie";
        }
        if (TypeRadiobutton.isSelected()) {
            keuzenummer = 2;
            Keuze = "type";
        }
        if (GeslcahtRadioButton.isSelected()) {
            keuzenummer = 3;
            Keuze = "geslacht";
        }
        if (SoortRadioButton.isSelected()) {
            keuzenummer = 4;
            Keuze = "soort";
        }
        if (variatieRadioButton.isSelected()) {
            keuzenummer = 5;
            Keuze = "variatie";
        }
        return keuzenummer;
    }

    public void zoekterm(MouseEvent mouseEvent) {
        getal = 0;
        controleKeuzeZoekterm();
        ZetZoekinfo();
    }
    //voor te zoeken met for lus alles doorlopen en die dat ni erbij horen verwijderen op basis van plantid bij alle lijsten mvg wout hostens xp
}
