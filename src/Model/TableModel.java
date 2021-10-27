package Model;

// Model-klass för att skriva ut data i tabellen under View Trades
public class TableModel {
    
    private String instrumentName;
    private String currency;
    private int quantity;
    private float price;
    
    public TableModel(String instrumentName, String currency, int quantity, float price){
        
        setInstrumentName(instrumentName);
        setCurrency(currency);
        setQuantity(quantity);
        setPrice(price);
        
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
}
