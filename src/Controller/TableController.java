package Controller;

import Model.GenericDataModel;
import Model.TableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Controller-klass för funktionalitet relaterad till tabeller i programmet
public class TableController extends DbManager{
    
    // Predefined queries mot databasen
    private final PreparedStatement getTableModelList;
    private final PreparedStatement getCounterparty;
    private final PreparedStatement getMarketplace;
    private final PreparedStatement getPortfolio;
    private final PreparedStatement getAcquirer;
    private final PreparedStatement deleteCounterparty;
    private final PreparedStatement deleteMarketplace;
    private final PreparedStatement deletePortfolio;
    private final PreparedStatement deleteAcquirer;
    
    private final String TABLEINFO_GETTABLEMODELLIST = "SELECT Trades.price, Trades.quantity, Instrument.name, Instrument.currency "
        + "FROM Trades LEFT JOIN Instrument ON Trades.instrumentID = Instrument.instrumentID "
        + "WHERE Trades.instrumentID LIKE ? AND Trades.counterpartyID LIKE ? AND Trades.acquirerID LIKE ? AND Trades.portfolioID LIKE ?";        
    
    private final String COUNTERPARTY_GETCOUNTERPARTY = "SELECT * FROM Counterparty";
    private final String MARKETPLACE_GETMARKETPLACE = "SELECT * FROM Marketplace";
    private final String PORTFOLIO_GETPORTFOLIO = "SELECT * FROM Portfolio";
    private final String ACQUIRER_GETACQUIRER = "SELECT * FROM Acquirer";
    private final String COUNTERPARTY_DELETECOUNTERPARTY = "SET REFERENTIAL_INTEGRITY = FALSE; DELETE FROM Counterparty WHERE counterpartyID = ?";
    private final String MARKETPLACE_DELETEMARKETPLACE = "SET REFERENTIAL_INTEGRITY = FALSE; DELETE FROM Marketplace WHERE marketplaceID = ?";
    private final String PORTFOLIO_DELETEPORTFOLIO = "SET REFERENTIAL_INTEGRITY = FALSE; DELETE FROM Portfolio WHERE portfolioID = ?";
    private final String ACQUIRER_DELETEACQUIRER = "SET REFERENTIAL_INTEGRITY = FALSE; DELETE FROM Acquirer WHERE acquirerID = ?";
     
    public TableController() throws SQLException{
        
        connectToDb();
        
        getTableModelList = con.prepareStatement(TABLEINFO_GETTABLEMODELLIST);
        getCounterparty = con.prepareStatement(COUNTERPARTY_GETCOUNTERPARTY);
        getMarketplace = con.prepareStatement(MARKETPLACE_GETMARKETPLACE);
        getPortfolio = con.prepareStatement(PORTFOLIO_GETPORTFOLIO);
        getAcquirer = con.prepareStatement(ACQUIRER_GETACQUIRER);
        deleteCounterparty = con.prepareStatement(COUNTERPARTY_DELETECOUNTERPARTY);
        deleteMarketplace = con.prepareStatement(MARKETPLACE_DELETEMARKETPLACE);
        deletePortfolio = con.prepareStatement(PORTFOLIO_DELETEPORTFOLIO);
        deleteAcquirer = con.prepareStatement(ACQUIRER_DELETEACQUIRER);
    }

    // Metod som returnerar en lista med information som skrivs ut i tabellen på View Trades
    // Testar olika cases för att kontrollera vilka filter / grupperingar användaren har gjort. Oavsett gruppering används samma sql-anrop
    public List<TableModel> getTableModelList(Integer instrumentID, Integer acquirerID, Integer counterpartyID, Integer portfolioID) throws SQLException{
        List<TableModel> tbModelList = new ArrayList<>();
        ResultSet rs = null;
        connectToDb();
        
        if(instrumentID == null){
            getTableModelList.setString(1, "%");
        }else{
            getTableModelList.setInt(1, instrumentID);           
        }

        if(counterpartyID == null){
            getTableModelList.setString(2, "%");
        }else{
            getTableModelList.setInt(2, counterpartyID);         
        }

        if(acquirerID == null){
            getTableModelList.setString(3, "%");
        }else{
            getTableModelList.setInt(3, acquirerID);          
        }
       
        if(portfolioID == null){
            getTableModelList.setString(4, "%");
        }else{
            getTableModelList.setInt(4, portfolioID);          
        }        

        rs = getTableModelList.executeQuery();
        
        while(rs.next()){
            tbModelList.add(new TableModel(rs.getString("name"), rs.getString("currency"),
            rs.getInt("quantity"), rs.getFloat("price")));
        }
        
        closeDbConnection();
        return tbModelList;
    }
    
    // Metod för att hämta en generisk datamodell. Är generisk då flera tabeller endast (i nuvarande utförande) har id och namn
    public List<GenericDataModel> getGenericDataList(String table) throws SQLException{
        List<GenericDataModel> genericDataModelList = new ArrayList<>();
        ResultSet rs = null;
        connectToDb();
        
        switch(table){
            case "Portfolio":
                rs = getPortfolio.executeQuery();
                break;
            
            case "Marketplace":
                rs = getMarketplace.executeQuery();
                break;
            
            case "Counterparty":
                rs = getCounterparty.executeQuery();
                break;
                
            case "Acquirer":
                rs = getAcquirer.executeQuery();
                break;     
        }

        while(rs.next()){
            genericDataModelList.add(new GenericDataModel(rs.getInt(1), rs.getString(2)));
        }       

        closeDbConnection();
        return genericDataModelList;
    }
    
    // Tar bort ett record i databasen
    public void deleteDataGeneric(String table, int id) throws SQLException{
        
        connectToDb();
        
        switch(table){
            case "Portfolio":
                deletePortfolio.setInt(1, id);
                deletePortfolio.executeUpdate();
                break;
            
            case "Marketplace":
                deleteMarketplace.setInt(1, id);
                deleteMarketplace.executeUpdate();
                break;
            
            case "Counterparty":
                deleteCounterparty.setInt(1, id);
                deleteCounterparty.executeUpdate();
                break;
                
            case "Acquirer":
                deleteAcquirer.setInt(1, id);
                deleteAcquirer.executeUpdate();
                break;     
        }
        closeDbConnection();
    }
}
