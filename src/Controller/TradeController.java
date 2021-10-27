package Controller;

import Model.TradesModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Klass med metoder som är relaterade till en trade
public class TradeController extends DbManager{
    
    // Prepared statements mot datasen
    private final PreparedStatement addTrade;
    private final PreparedStatement checkCounterpartyExistence;
    private final PreparedStatement addCounterparty;
    private final PreparedStatement getCounterpartyID;
    private final PreparedStatement checkPortfolioExistence;
    private final PreparedStatement addPortfolio;
    private final PreparedStatement getPortfolioID;
    private final PreparedStatement checkAcquirerExistence;
    private final PreparedStatement addAcquirer;
    private final PreparedStatement getAcquirerID;
    private final PreparedStatement checkMarketplaceExistence;
    private final PreparedStatement addMarketplace;
    private final PreparedStatement getMarketplaceID;
    private final PreparedStatement getTrades;
    private final PreparedStatement deleteTrade;
    
    private final String TRADE_ADDTRADE = "INSERT INTO Trades (quantity, price, counterpartyID, "
                + "portfolioID, instrumentID, acquirerID, marketplaceID) VALUES(?,?,?,?,?,?,?)";
    private final String COUNTERPARTY_CHECKEXISTENCE = "SELECT TOP 1 Counterparty.name FROM Counterparty WHERE Counterparty.name = ?";
    private final String COUNTERPARTY_ADDCOUNTERPARTY = "INSERT INTO Counterparty (name) VALUES(?)";
    private final String COUNTERPARTY_GETCOUNTERPARTYID = "SELECT counterpartyID FROM Counterparty WHERE name = ?";
    private final String PORTFOLIO_CHECKEXISTENCE = "SELECT TOP 1 Portfolio.type FROM Portfolio WHERE Portfolio.type = ?";
    private final String PORTFOLIO_ADDPORTFOLIO = "INSERT INTO Portfolio (type) VALUES(?)";
    private final String PORTFOLIO_GETPORTFOLIOID = "SELECT portfolioID FROM Portfolio WHERE type = ?";
    private final String ACQUIRER_CHECKEXISTENCE = "SELECT TOP 1 Acquirer.name FROM Acquirer WHERE Acquirer.name = ?";
    private final String ACQUIRER_ADDACQUIRER = "INSERT INTO Acquirer (name) VALUES(?)";
    private final String ACQUIRER_GETACQUIRERID = "SELECT acquirerID FROM Acquirer WHERE name = ?";
    private final String MARKETPLACE_CHECKEXISTENCE = "SELECT TOP 1 Marketplace.name FROM Marketplace WHERE Marketplace.name = ?";
    private final String MARKETPLACE_ADDMARKETPLACE = "INSERT INTO Marketplace (name) VALUES(?)";
    private final String MARKETPLACE_GETMARKETPLACEID = "SELECT marketplaceID FROM Marketplace WHERE name = ?";       
    private final String TRADES_GETTRADES = "SELECT * FROM Trades";
    private final String TRADES_DELETETRADE = "SET REFERENTIAL_INTEGRITY = FALSE; DELETE FROM Trades WHERE Trades.tradeID = ?";
    
    public TradeController() throws SQLException{
        
        connectToDb();
        
        addTrade = con.prepareStatement(TRADE_ADDTRADE);
        checkCounterpartyExistence = con.prepareStatement(COUNTERPARTY_CHECKEXISTENCE);
        addCounterparty = con.prepareStatement(COUNTERPARTY_ADDCOUNTERPARTY);
        getCounterpartyID = con.prepareStatement(COUNTERPARTY_GETCOUNTERPARTYID);
        checkPortfolioExistence = con.prepareStatement(PORTFOLIO_CHECKEXISTENCE);
        addPortfolio = con.prepareStatement(PORTFOLIO_ADDPORTFOLIO);
        getPortfolioID = con.prepareStatement(PORTFOLIO_GETPORTFOLIOID);
        checkAcquirerExistence = con.prepareStatement(ACQUIRER_CHECKEXISTENCE);
        addAcquirer = con.prepareStatement(ACQUIRER_ADDACQUIRER);
        getAcquirerID = con.prepareStatement(ACQUIRER_GETACQUIRERID);
        checkMarketplaceExistence = con.prepareStatement(MARKETPLACE_CHECKEXISTENCE);
        addMarketplace = con.prepareStatement(MARKETPLACE_ADDMARKETPLACE);
        getMarketplaceID = con.prepareStatement(MARKETPLACE_GETMARKETPLACEID);
        getTrades = con.prepareStatement(TRADES_GETTRADES);
        deleteTrade = con.prepareStatement(TRADES_DELETETRADE);
        
    }
    
    // Lägger till en trade i databasen
    // Lägger även till counterparty, portfolio etc. om dessa inte redan existerar
    public void addTrade(int quantity, float price, String counterpartyName, String portfolioName, int instrumentID, String acquirerName, String marketplaceName) throws SQLException{

        addTrade.setInt(1, quantity);
        addTrade.setFloat(2, price);
        addTrade.setInt(3, getID("counterparty", counterpartyName));
        addTrade.setInt(4, getID("portfolio", portfolioName));
        addTrade.setInt(5, instrumentID);
        addTrade.setInt(6, getID("acquirer", acquirerName));
        addTrade.setInt(7, getID("marketplace", marketplaceName));
        addTrade.executeUpdate();
        
        closeDbConnection();
    }
    
    // Hämtar alla trades från databasen
    public List<TradesModel> getTrades() throws SQLException{
        List<TradesModel> tradesList = new ArrayList<>();
        ResultSet rs = null;
        connectToDb();

        rs = getTrades.executeQuery();
        while(rs.next()){
            tradesList.add(new TradesModel(rs.getInt("tradeID"), rs.getFloat("price"),
            rs.getInt("quantity"), rs.getTimestamp("tradetime"), rs.getInt("counterpartyID"),
            rs.getInt("portfolioID"), rs.getInt("instrumentID"), rs.getInt("acquirerID"), rs.getInt("marketplaceID")));
        }
    
        closeDbConnection();
        return tradesList;
    }
    
    // Tar bort ett record från Trades
    public void deleteTrade(int tradeID) throws SQLException{
        connectToDb();
        deleteTrade.setInt(1, tradeID);
        deleteTrade.executeUpdate();
        closeDbConnection();
    }

    
    // Metod som kontrollerar om ett element existerar
    // Om det inte existerar => lägg till det
    // Returnera dess id i databasen
    private int getID(String tableName, String name) throws SQLException{
        String existence = null;
        ResultSet rs = null;
        connectToDb();
        int id = 0;
        
        switch(tableName){
            
            case "counterparty":
                checkCounterpartyExistence.setString(1, name);
                rs = checkCounterpartyExistence.executeQuery();
                while (rs.next()){
                    existence = rs.getString("name");
                }
                if(!(existence != null && !existence.isEmpty())){
                    addCounterparty.setString(1, name);
                    addCounterparty.executeUpdate();
                } 
                getCounterpartyID.setString(1, name);
                rs = getCounterpartyID.executeQuery();
                while (rs.next()){
                    id = rs.getInt("counterpartyID");
                }
                break;
            
            case "portfolio":
                checkPortfolioExistence.setString(1, name);
                rs = checkPortfolioExistence.executeQuery();
                while (rs.next()){
                    existence = rs.getString("type");
                }
                if(!(existence != null && !existence.isEmpty())){
                    addPortfolio.setString(1, name);
                    addPortfolio.executeUpdate();
                } 
                getPortfolioID.setString(1, name);
                rs = getPortfolioID.executeQuery();
                while (rs.next()){
                    id = rs.getInt("portfolioID");
                }                
                break;
            
            case "acquirer":
                checkAcquirerExistence.setString(1, name);
                rs = checkAcquirerExistence.executeQuery();
                while (rs.next()){
                    existence = rs.getString("name");
                }
                if(!(existence != null && !existence.isEmpty())){
                    addAcquirer.setString(1, name);
                    addAcquirer.executeUpdate();
                } 
                getAcquirerID.setString(1, name);
                rs = getAcquirerID.executeQuery();
                while (rs.next()){
                    id = rs.getInt("acquirerID");
                }                
                break;
            
            case "marketplace":
                checkMarketplaceExistence.setString(1, name);
                rs = checkMarketplaceExistence.executeQuery();
                while (rs.next()){
                    existence = rs.getString("name");
                }
                if(!(existence != null && !existence.isEmpty())){
                    addMarketplace.setString(1, name);
                    addMarketplace.executeUpdate();
                } 
                getMarketplaceID.setString(1, name);
                rs = getMarketplaceID.executeQuery();
                while (rs.next()){
                    id = rs.getInt("marketplaceID");
                }                
                break;
        }
        
        closeDbConnection();
        return id;
    }
    
}
