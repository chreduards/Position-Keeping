
package Model;

import java.sql.Timestamp;


// Model-klass för all ett objeckts data från trades-tabellen
public class TradesModel {

    private int tradeID;
    private float price;
    private int quantity;
    private Timestamp tradetime;
    private int counterpartyID;
    private int portfolioID;
    private int instrumentID;
    private int acquirerID;
    private int marketplaceID;
    
    public TradesModel(int tradeID, float price, int quantity, Timestamp tradetime, int counterpartyID,
            int portfolioID, int instrumentID, int acquirerID, int marketplaceID){
        
        setTradeID(tradeID);
        setPrice(price);
        setQuantity(quantity);
        setTradetime(tradetime);
        setCounterpartyID(counterpartyID);
        setPortfolioID(portfolioID);
        setInstrumentID(instrumentID);
        setAcquirerID(acquirerID);
        setMarketplaceID(marketplaceID);
        
    }

    public int getTradeID() {
        return tradeID;
    }

    public void setTradeID(int tradeID) {
        this.tradeID = tradeID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Timestamp getTradetime() {
        return tradetime;
    }

    public void setTradetime(Timestamp tradetime) {
        this.tradetime = tradetime;
    }

    public int getCounterpartyID() {
        return counterpartyID;
    }

    public void setCounterpartyID(int counterpartyID) {
        this.counterpartyID = counterpartyID;
    }

    public int getPortfolioID() {
        return portfolioID;
    }

    public void setPortfolioID(int portfolioID) {
        this.portfolioID = portfolioID;
    }

    public int getInstrumentID() {
        return instrumentID;
    }

    public void setInstrumentID(int instrumentID) {
        this.instrumentID = instrumentID;
    }

    public int getAcquirerID() {
        return acquirerID;
    }

    public void setAcquirerID(int acquirerID) {
        this.acquirerID = acquirerID;
    }

    public int getMarketplaceID() {
        return marketplaceID;
    }

    public void setMarketplaceID(int marketplaceID) {
        this.marketplaceID = marketplaceID;
    }
    

}
