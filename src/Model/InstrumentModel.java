package Model;

// Klass med data kopplat till ett instrument
public class InstrumentModel {
    
    private int instrumentID;
    private String instrumentName;
    private String currency;
    private String issuerName;
    private int issuerID;
    
    public InstrumentModel(int instrumentID, String instrumentName, String currency, String issuerName, int issuerID){
        
        setInstrumentID(instrumentID);
        setInstrumentName(instrumentName);
        setCurrency(currency);
        setIssuerName(issuerName);
        setIssuerID(issuerID);      
        
    }

    public int getIssuerID() {
        return issuerID;
    }

    public void setIssuerID(int issuerID) {
        this.issuerID = issuerID;
    }

    public int getInstrumentID() {
        return instrumentID;
    }

    public void setInstrumentID(int instrumentID) {
        this.instrumentID = instrumentID;
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

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }
    
}
