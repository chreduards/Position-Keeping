package Controller;

import Model.InstrumentModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Controller-klass för funktioner kopplade till instrumenten
public class InstrumentController extends DbManager{
    
    private final PreparedStatement addInstrument;
    private final PreparedStatement checkIssuerExistence;
    private final PreparedStatement addIssuer;
    private final PreparedStatement getIssuerID;
    private final PreparedStatement getInstruments;
    private final PreparedStatement deleteInstrument;
    
    private final String INSTRUMENT_ADDINSTRUMENT = "INSERT INTO Instrument (name, currency, issuerID) VALUES(?,?,?)";
    private final String INSTRUMENT_CHECKISSUEREXISTENCE = "SELECT TOP 1 Issuer.name FROM Issuer WHERE Issuer.name = ?";
    private final String ISSUER_ADDISSUER = "INSERT INTO Issuer (name) VALUES(?)";
    private final String ISSUER_GETISSUERID = "SELECT issuerID FROM Issuer WHERE name = ?";
    private final String INSTRUMENT_GETINSTRUMENTS = "SELECT Instrument.instrumentID, Instrument.name, Instrument.currency, Issuer.name, Instrument.issuerID "
        + "FROM Instrument LEFT JOIN Issuer ON Instrument.issuerID = Issuer.issuerID";
    private final String INSTRUMENT_DELETEINSTRUMENT = "DELETE FROM Instrument WHERE Instrument.instrumentID = ?";
    
    public InstrumentController() throws SQLException{
        
        // Fördefinierade databasanrop
        addInstrument = con.prepareStatement(INSTRUMENT_ADDINSTRUMENT);
        checkIssuerExistence = con.prepareStatement(INSTRUMENT_CHECKISSUEREXISTENCE);
        addIssuer = con.prepareStatement(ISSUER_ADDISSUER);
        getIssuerID = con.prepareStatement(ISSUER_GETISSUERID);
        getInstruments = con.prepareStatement(INSTRUMENT_GETINSTRUMENTS);
        deleteInstrument = con.prepareStatement(INSTRUMENT_DELETEINSTRUMENT);
        
    }
    
    // Lägger till ett instrument i Instrument-tabellen
    public void addInstrument(String instrumentName, String instrumentCurrency, String issuerName) throws SQLException{
        ResultSet rs = null;
        connectToDb();
        String issuerExistence = null;
        int issuerID = 0;
        
        // Kontrollera om Issuer existerar
        checkIssuerExistence.setString(1, issuerName);
        rs = checkIssuerExistence.executeQuery();
        while (rs.next()){
            issuerExistence = rs.getString("name");
        }
        // Lägg till Issuer om den inte redan existerar       
        if(!(issuerExistence != null && !issuerExistence.isEmpty())){
            addIssuer.setString(1, issuerName);
            addIssuer.executeUpdate();
        } 
        // Hämta issuerID som motsvarar ett visst issuerName
        getIssuerID.setString(1, issuerName);
        rs = getIssuerID.executeQuery();
        while (rs.next()){
            issuerID = rs.getInt("issuerID");
        }
        // Lägg till instrumentet
        addInstrument.setString(1, instrumentName);
        addInstrument.setString(2, instrumentCurrency);
        addInstrument.setInt(3, issuerID);
        addInstrument.executeUpdate();
        
        closeDbConnection();
        
    }
    
    // Returnerar en lista med samtliga instrument i databasen
    public List<InstrumentModel> getInstruments() throws SQLException{
        List<InstrumentModel> instrumentList = new ArrayList<>();
        ResultSet rs = null;
        connectToDb();
        
        rs = getInstruments.executeQuery();
        
        while(rs.next()){
            instrumentList.add(new InstrumentModel(rs.getInt(1), rs.getString(2),
            rs.getString(3), rs.getString(4), rs.getInt(5)));  
        }
        
        closeDbConnection();
        return instrumentList;
    }
    
    // Tar bort ett record från Instrument
    public void deleteInstrument(int instrumentID) throws SQLException{
        connectToDb();
        deleteInstrument.setInt(1, instrumentID);
        deleteInstrument.executeUpdate();
        closeDbConnection();
    }
}
