package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Innehåller funktioner för att skapa själva databasen (om den inte redan existerar), ansluta
// samt för att resetta databasen.
public class DbManager {

    // Predefined queries mot databasen
    private final PreparedStatement createAcquirer;
    private final PreparedStatement createMarketplace;
    private final PreparedStatement createCounterparty;
    private final PreparedStatement createIssuer;
    private final PreparedStatement createPortfolio;
    private final PreparedStatement createInstrument;
    private final PreparedStatement createTrades;
    private final PreparedStatement clearDB;
    
    private final String ACQUIRER_CREATEACQUIRER = "CREATE TABLE IF NOT EXISTS Acquirer ("
            + "acquirerID int NOT NULL auto_increment, name varchar(20), "
            + "PRIMARY KEY (acquirerID))";
    private final String MARKETPLACE_CREATEMARKETPLACE = "CREATE TABLE IF NOT EXISTS Marketplace ("
            + "marketplaceID int not null auto_increment, name varchar(20),"
            + "PRIMARY KEY (marketplaceID))";
    private final String COUNTERPARTY_CREATECOUNTERPARTY = "CREATE TABLE IF NOT EXISTS Counterparty ("
            + "counterpartyID int not null auto_increment, name varchar(20),"
            + "PRIMARY KEY (counterpartyID))";
    private final String PORTFOLIO_CREATEPORTFOLIO = "CREATE TABLE IF NOT EXISTS Portfolio ("
            + "portfolioID int not null auto_increment, type varchar(20),"
            + "PRIMARY KEY (portfolioID))";
    private final String ISSUER_CREATEISSUER = "CREATE TABLE IF NOT EXISTS Issuer ("
            + "issuerID int not null auto_increment, name varchar(20),"
            + "PRIMARY KEY (issuerID))";
    private final String INSTRUMENT_CREATEINSTRUMENT = "CREATE TABLE IF NOT EXISTS Instrument ("
            + "instrumentID int not null auto_increment, name varchar(20), currency varchar(20), issuerID int,"
            + "PRIMARY KEY (instrumentID), FOREIGN KEY (issuerID) REFERENCES Issuer(issuerID))";
    private final String TRADES_CREATETRADES = "CREATE TABLE IF NOT EXISTS Trades ("
            + "tradeID int not null auto_increment, quantity int, price float, tradetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"
            + "counterpartyID int, portfolioID int, instrumentID int, acquirerID int, marketplaceID int,"
            + "PRIMARY KEY (tradeID), FOREIGN KEY (counterpartyID) REFERENCES Counterparty(counterpartyID), "
            + "FOREIGN KEY (marketplaceID) REFERENCES Marketplace(marketplaceID), FOREIGN KEY (portfolioID) REFERENCES Portfolio(portfolioID),"
            + "FOREIGN KEY (instrumentID) REFERENCES Instrument(instrumentID), FOREIGN KEY (acquirerID) REFERENCES Acquirer(acquirerID))";
    private final String DB_CLEARDB = "SET REFERENTIAL_INTEGRITY = FALSE; DROP TABLE Counterparty cascade; DROP TABLE Instrument cascade; DROP TABLE Marketplace cascade;"
            + "DROP TABLE Acquirer cascade; DROP TABLE Issuer cascade; DROP TABLE Portfolio cascade; DROP TABLE Trades cascade";
    
    // Skapar en h2-databas under C:\Users
    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/FIS";
    private static final String DB_USERNAME = "test";
    private static final String DB_PASSWORD = "";
    
    protected Connection con  = null;
    
    public DbManager() throws SQLException{
        connectToDb();
        
        createAcquirer = con.prepareStatement(ACQUIRER_CREATEACQUIRER);
        createMarketplace = con.prepareStatement(MARKETPLACE_CREATEMARKETPLACE);
        createCounterparty = con.prepareStatement(COUNTERPARTY_CREATECOUNTERPARTY);
        createIssuer = con.prepareStatement(ISSUER_CREATEISSUER);
        createPortfolio = con.prepareStatement(PORTFOLIO_CREATEPORTFOLIO);
        createInstrument = con.prepareStatement(INSTRUMENT_CREATEINSTRUMENT);
        createTrades = con.prepareStatement(TRADES_CREATETRADES);
        clearDB = con.prepareStatement(DB_CLEARDB);
        
        initializeDb();
    }
    
    public void resetDb() throws SQLException{
        clearDb();
        initializeDb();
    }
    
    // Skapar databasen från grunden om den inte redan existerar
    protected void initializeDb() throws SQLException{
        try {
            
            createIssuer.execute();
            createInstrument.execute();
            createAcquirer.execute();
            createMarketplace.execute();
            createCounterparty.execute();
            createPortfolio.execute();
            createTrades.execute();
            
        } catch (Exception ex) {  
            System.out.println("Error when creating database: " + ex.getMessage());  
        }
    }
    
    protected void connectToDb() throws SQLException{
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
         
        } catch (Exception ex) {
            System.out.println("Error when connecting to database: " + ex.getMessage());  
        }
        
    }
    
    protected void clearDb() throws SQLException{
        connectToDb();
        clearDB.execute();
    }
    
    protected void closeDbConnection() throws SQLException{
        con.close();
    }

}

