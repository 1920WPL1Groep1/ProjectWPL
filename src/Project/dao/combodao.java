package Project.dao;
import Project.klasse.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class combodao {
    private static  String getallkeuze = "SELECT * FROM plant";

    private Connection dbConnection;
    private PreparedStatement stmkeuzecombo;

    private List<combo> comboList = new ArrayList<>();

    public combodao(Connection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;
    }

    public List<combo>  getcombo(String welkecombo) throws SQLException {
        getallkeuze="SELECT * from " + welkecombo;
        if(welkecombo=="habitus")
        {
            getallkeuze="select waarde from habitus ";
        }
        if(welkecombo=="beheer")
        {
            getallkeuze="select beheerdaad from beheer";
        }
        if(welkecombo=="habitat")
        {
            getallkeuze="select waarde from habitat";
        }
        try {
            stmkeuzecombo = dbConnection.prepareStatement(getallkeuze);
            ResultSet resultaat = stmkeuzecombo.executeQuery();

            while (resultaat.next()) {
                combo combo = new combo(resultaat.getString("waarde"));
                comboList.add(combo);
            }
        }
        catch (SQLException ex){
            System.out.println("in de catch");
            Logger.getLogger(plantdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comboList;
    }
}
