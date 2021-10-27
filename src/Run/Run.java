package Run;

import Controller.DbManager;
import View.*;
import java.sql.SQLException;

public class Run{
    
    // Main-klass. Initierar Swing GUI och databasen (h2, embedded databas) 
    public static void main(String[] args){
        
        try{
            DbManager dbm = new DbManager();
        } catch (SQLException ex){
            System.out.println("Error in the initialization of dbManager: " + ex.getMessage());
        }
        
        FrontEndView feView = new FrontEndView();
        feView.setLocationRelativeTo(null);
        feView.setTitle("Position Keeping");
        feView.pack();
        feView.setVisible(true);
    
    }
}
