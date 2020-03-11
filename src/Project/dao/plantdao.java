package Project.dao;
import Project.klasse.*;
import main.java.dao.StudentDao;
import main.java.model.plant;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class plantdao {
    private static final String GETALLPLANTEN ="SELECT * FROM plant";
    private static final String GETPLANTBYID ="SELECT * FROM plant WHERE plant_id = ?";
    private static final String INSERTPLANT ="INSERT INTO plant (type, familie,geslacht,soort,variatie,plantdichtheid_min,plantdichtheid_max,fgsv) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATEPLANT ="UPDATE plant SET  type=? ,familie = ?, geslacht = ?, soort = ?, variatie = ?, plantdichtheid_min = ?, plantdichtheid_max = ?, fgsv = ? WHERE plant_id = ?";
    private static final String DELETEPLANT ="DELETE FROM plant WHERE plant_id = ?";
    private static final String GETPLANTBYNAME ="SELECT * FROM plant WHERE familie LIKE ?";
    private static String GetplantKeuze ="SELECT * FROM plant WHERE ? LIKE ?";
    private Connection dbConnection;
    private PreparedStatement stmtSelectById;
    private PreparedStatement stmSelectAll;
    private PreparedStatement stmtInsert;
    private PreparedStatement stmtUpdate;
    private PreparedStatement stmtDelete;
    private PreparedStatement stmgetbyname;
    private PreparedStatement stmGetplantkeuze;
    public plantdao(Connection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;
        stmtSelectById = dbConnection.prepareStatement(GETPLANTBYID);
        stmSelectAll = dbConnection.prepareStatement(GETALLPLANTEN);
        stmtInsert =   dbConnection.prepareStatement(INSERTPLANT,
                Statement.RETURN_GENERATED_KEYS);
        stmtUpdate     = dbConnection.prepareStatement(UPDATEPLANT);
        stmtDelete     = dbConnection.prepareStatement(DELETEPLANT);
        stmgetbyname = dbConnection.prepareStatement(GETPLANTBYNAME);
    }
    public List<plant> getAllPlant() {
        List<plant> plantenlijst = new ArrayList<>();
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(GETALLPLANTEN);
            while (rs.next()) {
                plant plant =
                        new plant(rs.getInt("plant_id"),
                                rs.getString("type"),
                                rs.getString("familie"),
                                rs.getString("geslacht"),
                                rs.getString("soort"),
                                rs.getString("variatie"),
                                rs.getInt("plantdichtheid_min"),
                                rs.getInt("plantdichtheid_max"),
                                rs.getString("fgsv"));
                plantenlijst.add(plant);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("in de catch");
        }
        return plantenlijst;
    }
    public plant getplantById(Integer plant_id) throws SQLException {
        plant plant = null;
         stmtSelectById.setInt(1, plant_id);
        ResultSet rs = stmtSelectById.executeQuery();
        if (rs.next()) {
            plant = new plant(rs.getInt("plant_id"),
                    rs.getString("type"),
                    rs.getString("familie"),
                    rs.getString("geslacht"),
                    rs.getString("soort"),
                    rs.getString("variatie"),
                    rs.getInt("plantdichtheid_min"),
                    rs.getInt("plantdichtheid_max"),
                    rs.getString("fgsv"));
        }
        return plant;
    }
    public void createPlant(plant plant) throws SQLException {
//       stmtInsert.setInt(1, 60); // hulp vragen bij functie om max id te vragen...
        stmtInsert.setString(1, plant.getType());
        stmtInsert.setString(2,plant.getFamilie());
        stmtInsert.setString(3,plant.getGeslacht());
        stmtInsert.setString(4,plant.getSoort());
        stmtInsert.setString(5,plant.getVariatie());
        stmtInsert.setInt(6,plant.getPlantdichtheid_min());
        stmtInsert.setInt(7,plant.getPlantdichtheid_max());
        stmtInsert.setString(8,plant.getFgsv());
        stmtInsert.executeUpdate();
        System.out.println("gelukt");
    }
    public Integer updateplant(plant plant) throws SQLException {
        stmtUpdate.setString(1, plant.getType());
        stmtUpdate.setString(2,plant.getFamilie());
        stmtUpdate.setString(3,plant.getGeslacht());
        stmtUpdate.setString(4,plant.getSoort());
        stmtUpdate.setString(5,plant.getVariatie());
        stmtUpdate.setInt(6,plant.getPlantdichtheid_min());
        stmtUpdate.setInt(7,plant.getPlantdichtheid_max());
        stmtUpdate.setString(8,plant.getFgsv());
        stmtUpdate.setInt(9,plant.getPlant_id());
        return stmtUpdate.executeUpdate();
    }
    public Integer deleteplant(Integer plant_ID) throws SQLException {
        stmtDelete.setInt(1, plant_ID);
        return stmtDelete.executeUpdate(); //Aantal gewist.
    }
    public List<plant> getplantbyname(String naam) throws SQLException {
        List<plant> plantenlijst = new ArrayList<>();
//TODO 4 : Vervolledig de methode getStudentByNaam(String naam) en gebruik de query GETSTUDENTBYNAAM
//WHERE naam LIKE ?
//=> Zorg ervoor dat als de parameter naam bijvoorbeeld "der" is,
//dat de parameter "*der*" wordt, zodat de gebruiker niet zelf de * moet ingeven
        naam = "%" + naam + "%";
        try {
            System.out.println("in de try");
            System.out.println(naam);
            stmgetbyname.setString(1,naam);
            ResultSet rss = stmgetbyname.executeQuery();
            while (rss.next()) {
                plant plant =
                        new plant(rss.getInt("plant_id"),
                                rss.getString("type"),
                                rss.getString("familie"),
                                rss.getString("geslacht"),
                                rss.getString("soort"),
                                rss.getString("variatie"),
                                rss.getInt("plantdichtheid_min"),
                                rss.getInt("plantdichtheid_max"),
                                rss.getString("fgsv"));
                plantenlijst.add(plant);

            }
        } catch (SQLException ex) {
            System.out.println("in de catch");
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("in de catch");
        }

        return plantenlijst;
    }
    public List<plant> getplantbykeuze(String keuze , String naam, int getal,String database) throws SQLException {
        List<plant> plantenlijst = new ArrayList<>();
        System.out.println(getal+"test");
        if(getal==0)
        {
            keuze="familie";
            naam = "'"+"%" + naam + "%"+"'";
            GetplantKeuze = "SELECT * FROM plant WHERE fgsv LIKE" +naam;
            System.out.println(GetplantKeuze+"test");
        }
        if(getal ==1)
        {
            naam = "'"+"%" + naam + "%"+"'";
            GetplantKeuze = "SELECT * FROM "+ database +" WHERE "+keuze +" LIKE " +naam;
        }
        if(getal==2)
        {
            GetplantKeuze = "SELECT * FROM "+ database+ " WHERE "+keuze +" < " +naam;
        }
        if(getal==3)
        {
            GetplantKeuze = "SELECT * FROM "+ database+ " WHERE "+keuze +" > " +naam;
        }
        try {
            System.out.println("in de try");
            System.out.println(naam);
            System.out.println(keuze);
            stmGetplantkeuze = dbConnection.prepareStatement(GetplantKeuze);
//            stmGetplantkeuze.setString(1,keuze);
//            stmGetplantkeuze.setString(2,naam);
            System.out.println(GetplantKeuze);
            ResultSet resultaat = stmGetplantkeuze.executeQuery();
            while (resultaat.next()) {
                plant plant = new plant(resultaat.getInt("plant_id"),
                        resultaat.getString("type"),
                        resultaat.getString("familie"),
                        resultaat.getString("geslacht"),
                        resultaat.getString("soort"),
                        resultaat.getString("variatie"),
                        resultaat.getInt("plantdichtheid_min"),
                        resultaat.getInt("plantdichtheid_max"),
                        resultaat.getString("fgsv"));
                plantenlijst.add(plant);
                Beheertoevoegen(plant);
                extraToevoegen(plant);
                abiotischefactorentoevoegen(plant);
                abiotischeMultistoevoegeb(plant);
                fenotypeToevoegen(plant);
                fenotype_multiToevoegen(plant);
                fotoToevoegen(plant);
                commensialismestoevoegen(plant);
                commensialisme_multitoevoegen(plant);
            }
        } catch (SQLException ex) {
            System.out.println("in de catch");
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("in de catch");
        }
        System.out.println(plantenlijst.size());
        return plantenlijst;
    }
    private List<beheer> Beheertoevoegen(plant plantje) throws SQLException {
        List<beheer> beheerlijst = new ArrayList<>();
        GetplantKeuze = "SELECT * FROM "+ "beheer" +" WHERE "+ "plant_id" +" LIKE " +plantje.getPlant_id();

        try {
            stmGetplantkeuze = dbConnection.prepareStatement(GetplantKeuze);
            ResultSet resultaat = stmGetplantkeuze.executeQuery();
            while (resultaat.next()) {
                beheer beheertje = new beheer(resultaat.getInt("beheer_id"),
                        resultaat.getInt("plant_id"),
                        resultaat.getString("beheerdaad"),
                        resultaat.getString("opmerking"),
                        resultaat.getString("maand"),
                        resultaat.getInt("frequentie_jaar"));
                beheerlijst.add(beheertje);
                System.out.println(beheertje.getBeheer_id()+ " " +beheertje.getPlant_id()+ "  beheer");
            }
        } catch (SQLException ex) {
            System.out.println("in de catch");
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("in de catch");
        }
        return beheerlijst;

    }
    private List<abiotische_factoren> abiotischefactorentoevoegen(plant plantje) throws SQLException {
        List<abiotische_factoren> abiotischeFactorenList = new ArrayList<>();
        GetplantKeuze = "SELECT * FROM "+ "abiotische_factoren" +" WHERE "+ "plant_id" +" LIKE " +plantje.getPlant_id();

        try {
            stmGetplantkeuze = dbConnection.prepareStatement(GetplantKeuze);
            ResultSet resultaat = stmGetplantkeuze.executeQuery();
            while (resultaat.next()) {
                abiotische_factoren abiotische_factoren = new abiotische_factoren(resultaat.getInt("abiotische_id"),
                        resultaat.getInt("plant_id"),
                        resultaat.getString("bezonning"),
                        resultaat.getString("grondsoort"),
                        resultaat.getString("vochtbehoefte"),
                        resultaat.getString("voedingbehoefte"),
                        resultaat.getString("reactie_antagonistische_omg"));
                abiotischeFactorenList.add(abiotische_factoren);
                System.out.println(abiotische_factoren.getAbiotische_id()+ " " +abiotische_factoren.getPlant_id()+ "  abiotische_factoren");
            }
        } catch (SQLException ex) {
            System.out.println("in de catch");
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("in de catch");
        }
        return abiotischeFactorenList;
    }
    private List<abiotische_multi> abiotischeMultistoevoegeb(plant plantje) throws SQLException {
        List<abiotische_multi> abiotische_multiList = new ArrayList<>();
        GetplantKeuze = "SELECT * FROM "+ "abiotisch_multi" +" WHERE "+ "plant_id" +" LIKE " +plantje.getPlant_id();
        try {
            stmGetplantkeuze = dbConnection.prepareStatement(GetplantKeuze);
            ResultSet resultaat = stmGetplantkeuze.executeQuery();
            while (resultaat.next()) {
                abiotische_multi abiotische_multi = new abiotische_multi(resultaat.getInt("abiotische_id"),
                        resultaat.getInt("plant_id"),
                        resultaat.getString("eigenschap"),
                        resultaat.getInt("waarde"));
                abiotische_multiList.add(abiotische_multi);
                System.out.println(abiotische_multi.getAbiotische_id()+ " " +abiotische_multi.getPlant_id()+ "  abiotische_multi");
            }
        } catch (SQLException ex) {
            System.out.println("in de catch");
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("in de catch");
        }
        return abiotische_multiList;
    }
    private List<extra> extraToevoegen(plant plant) throws SQLException {
        List<extra> extraLijst = new ArrayList<>();
        GetplantKeuze = "SELECT * FROM "+ "extra" +" WHERE "+ "plant_id" +" LIKE " +plant.getPlant_id();

        try {
            stmGetplantkeuze = dbConnection.prepareStatement(GetplantKeuze);
            ResultSet resultaat = stmGetplantkeuze.executeQuery();
            while (resultaat.next()) {
                extra extraObject = new extra(resultaat.getInt("extra_id"),
                        resultaat.getInt("plant_id"),
                        resultaat.getString("nectarwaarde"),
                        resultaat.getString("pollenwaarde"),
                        resultaat.getString("bijvriendelijk"),
                        resultaat.getString("eetbaar_kruidgebruik"),
                        resultaat.getString("geurend"),
                        resultaat.getString("vorstgevoelig"));
                extraLijst.add(extraObject);
                System.out.println(extraObject.getExtra_id()+ " " +extraObject.getPlant_id()+ "  extra");
            }
        } catch (SQLException ex) {
            System.out.println("in de catch");
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("in de catch");
        }
        return extraLijst;

    }
    private List<fenotype> fenotypeToevoegen(plant plant) throws SQLException {
        List<fenotype> fenotypeLijst = new ArrayList<>();
        GetplantKeuze = "SELECT * FROM "+ "fenotype" +" WHERE "+ "plant_id" +" LIKE " +plant.getPlant_id();

        try {
            stmGetplantkeuze = dbConnection.prepareStatement(GetplantKeuze);
            ResultSet resultaat = stmGetplantkeuze.executeQuery();
            while (resultaat.next()) {
                fenotype fenotypeObject = new fenotype(resultaat.getInt("fenotype_id"),
                        resultaat.getInt("plant_id"),
                        resultaat.getString("bladvorm"),
                        resultaat.getInt("levensvorm"),
                        resultaat.getString("habitus"),
                        resultaat.getString("bloeiwijze"),
                        resultaat.getInt("bladgrootte"),
                        resultaat.getString("ratio_bloei_blad"),
                        resultaat.getString("spruitfenelogie"));
                fenotypeLijst.add(fenotypeObject);
                System.out.println(fenotypeObject.getFenotype_id()+ " " +fenotypeObject.getPlant_id()+ "  fenotype");
            }
        } catch (SQLException ex) {
            System.out.println("in de catch");
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("in de catch");
        }
        return fenotypeLijst;

    }
    private List<fenotype_multi> fenotype_multiToevoegen(plant plant) throws SQLException {
        List<fenotype_multi> fenotype_multiLijst = new ArrayList<>();
        GetplantKeuze = "SELECT * FROM "+ "fenotype_multi" +" WHERE "+ "plant_id" +" LIKE " +plant.getPlant_id();

        try {
            stmGetplantkeuze = dbConnection.prepareStatement(GetplantKeuze);
            ResultSet resultaat = stmGetplantkeuze.executeQuery();
            while (resultaat.next()) {
                fenotype_multi fenotype_multiObject = new fenotype_multi(resultaat.getInt("fenotype_id"),
                        resultaat.getInt("plant_id"),
                        resultaat.getString("eigenschap"),
                        resultaat.getString("jan"),
                        resultaat.getString("feb"),
                        resultaat.getString("maa"),
                        resultaat.getString("apr"),
                        resultaat.getString("mei"),
                        resultaat.getString("jun"),
                        resultaat.getString("jul"),
                        resultaat.getString("aug"),
                        resultaat.getString("sep"),
                        resultaat.getString("okt"),
                        resultaat.getString("nov"),
                        resultaat.getString("dec"));
                fenotype_multiLijst.add(fenotype_multiObject);
                System.out.println(fenotype_multiObject.getFenotype_id()+ " " +fenotype_multiObject.getPlant_id()+ "  fenotype_multi");
            }
        } catch (SQLException ex) {
            System.out.println("in de catch");
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("in de catch");
        }
        return fenotype_multiLijst;

    }
    private List<foto> fotoToevoegen(plant plant) throws SQLException {
        List<foto> fotoList = new ArrayList<>();
        GetplantKeuze = "SELECT * FROM "+ "foto" +" WHERE "+ "plant_id" +" LIKE " +plant.getPlant_id();
        try {
            stmGetplantkeuze = dbConnection.prepareStatement(GetplantKeuze);
            ResultSet resultaat = stmGetplantkeuze.executeQuery();
            while (resultaat.next()) {
                foto foto = new foto(resultaat.getInt("foto_id"),
                        resultaat.getInt("plant_id"),
                        resultaat.getString("eigenschap"),
                        resultaat.getString("url"),
                        (Image) resultaat.getBlob("figuur"));
                fotoList.add(foto);
                System.out.println(foto.getFoto_id()+ " " +foto.getPlant_id()+ "  foto");
            }
        } catch (SQLException ex) {
            System.out.println("in de catch");
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("in de catch");
        }
        return fotoList;
    }
    private List<commensialisme> commensialismestoevoegen(plant plantje) throws SQLException {
        List<commensialisme> commensialismeslijst = new ArrayList<>();
        GetplantKeuze = "SELECT * FROM " + "commensialisme" + " WHERE " + "plant_id" + " LIKE " + plantje.getPlant_id();

        try {
            stmGetplantkeuze = dbConnection.prepareStatement(GetplantKeuze);
            ResultSet resultaat = stmGetplantkeuze.executeQuery();
            while (resultaat.next()) {
                commensialisme commensialisme = new commensialisme(resultaat.getInt("commensialisme_id"),
                        resultaat.getInt("plant_id"),
                        resultaat.getString("strategie"),
                        resultaat.getString("ontwikkelingssnelheid"));
                commensialismeslijst.add(commensialisme);
                System.out.println(commensialisme.getCommensialisme_id() + " " + commensialisme.getPlant_id() + "  beheer");
            }
        } catch (SQLException ex) {
            System.out.println("in de catch");
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("in de catch");
        }
        return commensialismeslijst;
    }
    private List<commensialisme_multi> commensialisme_multitoevoegen(plant plantje) throws SQLException {
            List<commensialisme_multi> commensialsime_multilijst = new ArrayList<>();
            GetplantKeuze = "SELECT * FROM " + "commensialisme_multi" + " WHERE " + "plant_id" + " LIKE " + plantje.getPlant_id();

            try {
                stmGetplantkeuze = dbConnection.prepareStatement(GetplantKeuze);
                ResultSet resultaat = stmGetplantkeuze.executeQuery();
                while (resultaat.next()) {
                    commensialisme_multi commensialisme_multi = new commensialisme_multi(resultaat.getInt("commensialisme_id"),
                            resultaat.getInt("plant_id"),
                            resultaat.getString("eigenschap"),
                            resultaat.getString("waarde"));
                    commensialsime_multilijst.add(commensialisme_multi);
                    System.out.println(commensialisme_multi.getCommensialisme_id() + " " + commensialisme_multi.getPlant_id() + "  beheer");
                }
            } catch (SQLException ex) {
                System.out.println("in de catch");
                Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("in de catch");
            }
            return commensialsime_multilijst;
        }
}
