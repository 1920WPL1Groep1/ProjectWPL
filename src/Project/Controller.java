package Project;

import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import main.java.dao.Database;
import main.java.model.plant;
import test.dao.plantdao;

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
    public TextArea resultatentxt;
    public TabPane tabpane;
    public Tab fentotyptab;
    public Tab abiotischetab;
    public Tab commensalimsetab;
    public Tab beheertab;
    public Tab extratab;
    public Tab resultaatab;
    private Connection dbConnection;
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
        for (plant plant : planten) {
            getal++;
            if (getal==1)
            {
                resultatentxt.setText(plant.getFgsv());
            }
            else
            {
                resultatentxt.setText(resultatentxt.getText() + "\r\n" + plant.getFgsv());
            }
            System.out.println(plant.toString());
        }
        System.out.println();
    }
    /**
     * @param plantdao
     * @throws SQLException
     */
    private void showByName(plantdao plantdao) throws SQLException {
        while (true) {
            String zoekterm = zoekenTxt.getText();
            System.out.println(zoekterm);
            if(zoekterm== null)
            {
                break;
            }
            List<plant> plantenlijst = plantdao.getplantbykeuze("fgsv",zoekterm,1,"plant");
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
}