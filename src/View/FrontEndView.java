package View;

import Controller.DbManager;
import Controller.InstrumentController;
import Controller.TableController;
import Controller.TradeController;
import Model.GenericDataModel;
import Model.InstrumentModel;
import Model.TableModel;
import Model.TradesModel;
import java.awt.CardLayout;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

// All kod kopplad till databasens GUI
public class FrontEndView extends javax.swing.JFrame {

    private DbManager dbm;
    private InstrumentController ic;
    private TradeController tc;
    private TableController tbc;
    
    public FrontEndView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        mainMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        addInstrumentMain_button = new javax.swing.JButton();
        tradeInstrument_mainMenu = new javax.swing.JButton();
        viewTrades_mainMenu = new javax.swing.JButton();
        manageData_mainMenu = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        addInstrument = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        instrumentName_field = new javax.swing.JFormattedTextField();
        issuerName_field = new javax.swing.JFormattedTextField();
        instrumentCurrency_field = new javax.swing.JFormattedTextField();
        add_addInstrument = new javax.swing.JButton();
        mainMenu_addInstrument = new javax.swing.JButton();
        addTrade = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        price_field = new javax.swing.JFormattedTextField();
        portfolio_field = new javax.swing.JFormattedTextField();
        quantity_field = new javax.swing.JFormattedTextField();
        counterparty_field = new javax.swing.JFormattedTextField();
        marketplace_field = new javax.swing.JFormattedTextField();
        acquirer_field = new javax.swing.JFormattedTextField();
        mainMenu_addTrade = new javax.swing.JButton();
        executeTrade_addTrade = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        instrumentList_table = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        viewTrades = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        portfolioField_viewTrades = new javax.swing.JFormattedTextField();
        instrumentField_viewTrades = new javax.swing.JFormattedTextField();
        counterpartyField_viewTrades = new javax.swing.JFormattedTextField();
        groupButton_viewTrades = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        positionTable = new javax.swing.JTable();
        mainMenu_viewTrades = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        acquirerField_viewTrades = new javax.swing.JFormattedTextField();
        manageData = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        tablesCombobox_manageData = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        genericTable_manageData = new javax.swing.JTable();
        deleteRow_manageData = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        changeTable_manageData = new javax.swing.JButton();
        mainMenu_manageData = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        clearDB_manageData = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setLayout(new java.awt.CardLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel1.setText("Position Keeping Application");

        addInstrumentMain_button.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        addInstrumentMain_button.setText("Add Instrument");
        addInstrumentMain_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addInstrumentMain_buttonActionPerformed(evt);
            }
        });

        tradeInstrument_mainMenu.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tradeInstrument_mainMenu.setText("Trade Instrument");
        tradeInstrument_mainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tradeInstrument_mainMenuActionPerformed(evt);
            }
        });

        viewTrades_mainMenu.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        viewTrades_mainMenu.setText("View Trades");
        viewTrades_mainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewTrades_mainMenuActionPerformed(evt);
            }
        });

        manageData_mainMenu.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        manageData_mainMenu.setText("Manage Data");
        manageData_mainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageData_mainMenuActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Welcome!\n\nAn introduction to the program´s functionality follows:\n\nAdd Instrument: add an instrument with corresponding\ncurrency and issuer. The issuer is created if not already\nexisting.\n\nTrade Instrument: execute a trade with\nsome existing instrument. Corresponding \ndata (portfolio, marketplace etc.)\nnot already existing is created.\n\nView Trades: view some information\nregarding the trade such as the total amount of \neach position.\nThe trades can be grouped on the id´s of the\ninstrument, portfolio, counterparty and acquirer.\n\nManage Data: enables the user to see and delete\nrecords from all tables in the database. \n");
        jScrollPane4.setViewportView(jTextArea1);

        javax.swing.GroupLayout mainMenuLayout = new javax.swing.GroupLayout(mainMenu);
        mainMenu.setLayout(mainMenuLayout);
        mainMenuLayout.setHorizontalGroup(
            mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainMenuLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainMenuLayout.createSequentialGroup()
                        .addGroup(mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addInstrumentMain_button, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(viewTrades_mainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(manageData_mainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tradeInstrument_mainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainMenuLayout.setVerticalGroup(
            mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainMenuLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125)
                .addGroup(mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addInstrumentMain_button, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tradeInstrument_mainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manageData_mainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewTrades_mainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainMenuLayout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );

        mainPanel.add(mainMenu, "mainMenu");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel2.setText("Add Instrument");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setText("Instrument name");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setText("Issuer name");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setText("Instrument currency");

        instrumentName_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instrumentName_fieldActionPerformed(evt);
            }
        });

        add_addInstrument.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        add_addInstrument.setText("Add");
        add_addInstrument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_addInstrumentActionPerformed(evt);
            }
        });

        mainMenu_addInstrument.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mainMenu_addInstrument.setText("Main Menu");
        mainMenu_addInstrument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenu_addInstrumentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addInstrumentLayout = new javax.swing.GroupLayout(addInstrument);
        addInstrument.setLayout(addInstrumentLayout);
        addInstrumentLayout.setHorizontalGroup(
            addInstrumentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addInstrumentLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(addInstrumentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addInstrumentLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(addInstrumentLayout.createSequentialGroup()
                        .addGroup(addInstrumentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(instrumentName_field, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addGroup(addInstrumentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(instrumentCurrency_field, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addGroup(addInstrumentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addInstrumentLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addInstrumentLayout.createSequentialGroup()
                                .addGroup(addInstrumentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(add_addInstrument, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(issuerName_field, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(59, 59, 59))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addInstrumentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainMenu_addInstrument, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        addInstrumentLayout.setVerticalGroup(
            addInstrumentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addInstrumentLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addGroup(addInstrumentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addInstrumentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(instrumentName_field, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(issuerName_field, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(instrumentCurrency_field, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(add_addInstrument, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(mainMenu_addInstrument, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mainPanel.add(addInstrument, "addInstrument");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setText("Marketplace name");

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setText("Counterparty name");

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel10.setText("Price");

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel11.setText("Acquirer name");

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel12.setText("Portfolio name");

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel13.setText("Quantity");

        price_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                price_fieldActionPerformed(evt);
            }
        });

        portfolio_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portfolio_fieldActionPerformed(evt);
            }
        });

        quantity_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantity_fieldActionPerformed(evt);
            }
        });

        counterparty_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                counterparty_fieldActionPerformed(evt);
            }
        });

        marketplace_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marketplace_fieldActionPerformed(evt);
            }
        });

        acquirer_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acquirer_fieldActionPerformed(evt);
            }
        });

        mainMenu_addTrade.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mainMenu_addTrade.setText("Main Menu");
        mainMenu_addTrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenu_addTradeActionPerformed(evt);
            }
        });

        executeTrade_addTrade.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        executeTrade_addTrade.setText("Execute Trade");
        executeTrade_addTrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executeTrade_addTradeActionPerformed(evt);
            }
        });

        instrumentList_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Instrument ID", "Instrument Name", "Currency", "Issuer"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(instrumentList_table);

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel6.setText("Trade Instrument");

        jLabel19.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel19.setText("Select instrument to trade");

        javax.swing.GroupLayout addTradeLayout = new javax.swing.GroupLayout(addTrade);
        addTrade.setLayout(addTradeLayout);
        addTradeLayout.setHorizontalGroup(
            addTradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addTradeLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(addTradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(addTradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addTradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(executeTrade_addTrade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(addTradeLayout.createSequentialGroup()
                            .addComponent(price_field, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(portfolio_field, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(addTradeLayout.createSequentialGroup()
                            .addGroup(addTradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(quantity_field, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(counterparty_field, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(addTradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(addTradeLayout.createSequentialGroup()
                                    .addGap(109, 109, 109)
                                    .addGroup(addTradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 48, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addTradeLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(addTradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(acquirer_field, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(marketplace_field, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8))))))
                    .addComponent(mainMenu_addTrade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        addTradeLayout.setVerticalGroup(
            addTradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addTradeLayout.createSequentialGroup()
                .addGroup(addTradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addTradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(addTradeLayout.createSequentialGroup()
                            .addGap(59, 59, 59)
                            .addComponent(jLabel12))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addTradeLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel6)))
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addTradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(price_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(portfolio_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(addTradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addTradeLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(addTradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addTradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quantity_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(acquirer_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(addTradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addTradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(counterparty_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(marketplace_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(executeTrade_addTrade, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mainMenu_addTrade, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addTradeLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
        );

        mainPanel.add(addTrade, "addTrade");

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel14.setText("Group On");

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel15.setText("Portfolio ID");

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel16.setText("Counterparty ID");

        jLabel17.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel17.setText("Instrument ID");

        portfolioField_viewTrades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portfolioField_viewTradesActionPerformed(evt);
            }
        });

        instrumentField_viewTrades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instrumentField_viewTradesActionPerformed(evt);
            }
        });

        counterpartyField_viewTrades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                counterpartyField_viewTradesActionPerformed(evt);
            }
        });

        groupButton_viewTrades.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        groupButton_viewTrades.setText("Group");
        groupButton_viewTrades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupButton_viewTradesActionPerformed(evt);
            }
        });

        jLabel18.setText("Leave blank for no filter");

        positionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Instrument Name", "Currency", "Traded Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(positionTable);

        mainMenu_viewTrades.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mainMenu_viewTrades.setText("Main Menu");
        mainMenu_viewTrades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenu_viewTradesActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel20.setText("Acquirer ID");

        acquirerField_viewTrades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acquirerField_viewTradesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout viewTradesLayout = new javax.swing.GroupLayout(viewTrades);
        viewTrades.setLayout(viewTradesLayout);
        viewTradesLayout.setHorizontalGroup(
            viewTradesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewTradesLayout.createSequentialGroup()
                .addGroup(viewTradesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewTradesLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(viewTradesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewTradesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel16)
                                .addComponent(counterpartyField_viewTrades, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17)
                                .addComponent(instrumentField_viewTrades, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15)
                                .addComponent(portfolioField_viewTrades, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(groupButton_viewTrades, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(acquirerField_viewTrades, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(viewTradesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mainMenu_viewTrades)))
                .addContainerGap())
            .addGroup(viewTradesLayout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE))
        );
        viewTradesLayout.setVerticalGroup(
            viewTradesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewTradesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(instrumentField_viewTrades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(counterpartyField_viewTrades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(portfolioField_viewTrades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(acquirerField_viewTrades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(groupButton_viewTrades)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addContainerGap())
            .addGroup(viewTradesLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainMenu_viewTrades, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        mainPanel.add(viewTrades, "viewTrades");

        jLabel21.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel21.setText("Manage Data");

        jLabel22.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel22.setText("Select table to display");

        tablesCombobox_manageData.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Counterparty", "Portfolio", "Acquirer", "Marketplace", "Instrument", "Trades" }));
        tablesCombobox_manageData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tablesCombobox_manageDataActionPerformed(evt);
            }
        });

        genericTable_manageData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ));
        jScrollPane3.setViewportView(genericTable_manageData);

        deleteRow_manageData.setText("Delete selected row");
        deleteRow_manageData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRow_manageDataActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel23.setText("Delete selected row");

        changeTable_manageData.setText("Change table");
        changeTable_manageData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeTable_manageDataActionPerformed(evt);
            }
        });

        mainMenu_manageData.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mainMenu_manageData.setText("Main Menu");
        mainMenu_manageData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenu_manageDataActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel25.setText("Clear entire database");

        clearDB_manageData.setText("Clear database");
        clearDB_manageData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearDB_manageDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout manageDataLayout = new javax.swing.GroupLayout(manageData);
        manageData.setLayout(manageDataLayout);
        manageDataLayout.setHorizontalGroup(
            manageDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageDataLayout.createSequentialGroup()
                .addGroup(manageDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(manageDataLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(manageDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(manageDataLayout.createSequentialGroup()
                                .addGroup(manageDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel25)
                                    .addComponent(tablesCombobox_manageData, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(manageDataLayout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageDataLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(manageDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(deleteRow_manageData)
                            .addComponent(changeTable_manageData, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearDB_manageData, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageDataLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainMenu_manageData)
                .addContainerGap())
        );
        manageDataLayout.setVerticalGroup(
            manageDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageDataLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(mainMenu_manageData, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addGap(46, 46, 46)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(manageDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tablesCombobox_manageData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeTable_manageData))
                .addGap(40, 40, 40)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteRow_manageData)
                .addGap(153, 153, 153)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clearDB_manageData)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(manageData, "manageData");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Metoder för att initiera controller-klasserna
    public void initDbController(){
        try{
            dbm = new DbManager();
        } catch (SQLException ex){
            System.out.println("Error in the initialization of dbManager: " + ex.getMessage());
        }
    }
    
    public void initInstrumentController(){
        try{
            ic = new InstrumentController();
        } catch (SQLException ex){
            System.out.println("Error in the initialization of InstrumentController: " + ex.getMessage());
        }
    }
    
    public void initTradeController(){
        try{
            tc = new TradeController();
        } catch (SQLException ex){
            System.out.println("Error in the initialization of Tradecontroller: " + ex.getMessage());
        } 
    }
    
    public void initTableController(){
        try{
            tbc = new TableController();
        } catch (SQLException ex){
            System.out.println("Error in the initialization of Tablecontroller: " + ex.getMessage());
        }   
    }
    
    // Knapp i main menu
    // Byter till Add Instrument-sidan
    private void addInstrumentMain_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInstrumentMain_buttonActionPerformed
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "addInstrument");
    }//GEN-LAST:event_addInstrumentMain_buttonActionPerformed

    // Knapp på Add Instrument-sidan
    // Initerar att ett instrument läggs till i databasen
    private void add_addInstrumentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_addInstrumentActionPerformed
        initInstrumentController();
        String instrumentName = instrumentName_field.getText();
        String instrumentCurrency = instrumentCurrency_field.getText();
        String issuerName = issuerName_field.getText();
        
        try {
            ic.addInstrument(instrumentName, instrumentCurrency, issuerName);
        } catch (SQLException ex) {
            System.out.println("Error when adding instrument: " + ex.getMessage());
        }
    }//GEN-LAST:event_add_addInstrumentActionPerformed

    // Knapp på Add instrument-sidan
    // Byter sida till Main Menu
    private void mainMenu_addInstrumentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenu_addInstrumentActionPerformed
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "mainMenu");
    }//GEN-LAST:event_mainMenu_addInstrumentActionPerformed

    private void price_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_price_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_price_fieldActionPerformed

    private void portfolio_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portfolio_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_portfolio_fieldActionPerformed

    private void quantity_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantity_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantity_fieldActionPerformed

    private void counterparty_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_counterparty_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_counterparty_fieldActionPerformed

    private void marketplace_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marketplace_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_marketplace_fieldActionPerformed

    private void acquirer_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acquirer_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_acquirer_fieldActionPerformed

    // Knapp på Add Trade-sidan
    // Byter till Main Menu
    private void mainMenu_addTradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenu_addTradeActionPerformed
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "mainMenu");
    }//GEN-LAST:event_mainMenu_addTradeActionPerformed

    // Knapp på Main Menu-sidan
    // Byter till Add Trade och fyller instrument-tabellen med data
    private void tradeInstrument_mainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tradeInstrument_mainMenuActionPerformed
        // Byt sida
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "addTrade");
        
        List<InstrumentModel> instrumentList = new ArrayList<>();
        initInstrumentController();
        
        // Hämta samtliga instrument från databasen
        try {
            instrumentList = ic.getInstruments();
        } catch (SQLException ex) {
            System.out.println("Error when fetching instrumentList: " + ex.getMessage());
        }

        // Fyll upp instrument-tabellen
        int row = 0;
        int rows = instrumentList.size();
        Object[][] data = new Object[rows][4];
        
        for(InstrumentModel im : instrumentList){
            data[row][0] = im.getInstrumentID();
            data[row][1] = im.getInstrumentName();
            data[row][2] = im.getCurrency();
            data[row++][3] = im.getIssuerName();
        }
        
        String[] cols = {"Instrument ID", "Instrument Name", "Currency", "Issuer"};
        DefaultTableModel instrumentInfo = new DefaultTableModel(data, cols);
        
        instrumentList_table.setModel(instrumentInfo);
        instrumentList_table.setShowGrid(true);       
        
    }//GEN-LAST:event_tradeInstrument_mainMenuActionPerformed

    // Knapp på Add Trade-sidan
    // Initierar en trade som läggs till i databasen
    private void executeTrade_addTradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executeTrade_addTradeActionPerformed
        initTradeController();
        
        // Hämtar data från en selectad rad i instrument-tabellen
        int row = instrumentList_table.getSelectedRow();
        int instrumentID = tryIntParse(instrumentList_table.getModel().getValueAt(row, 0).toString()); 
        
        int quantity = tryIntParse(quantity_field.getText());
        float price = tryFloatParse(price_field.getText());
        String portfolio = portfolio_field.getText();
        String counterparty = counterparty_field.getText();
        String marketplace = marketplace_field.getText();
        String acquirer = acquirer_field.getText();
                
        try {
            tc.addTrade(quantity, price, counterparty, portfolio, instrumentID, acquirer, marketplace);
        } catch (SQLException ex) {
            System.out.println("Error when adding trade: " + ex.getMessage());
        }
    }//GEN-LAST:event_executeTrade_addTradeActionPerformed

    private void portfolioField_viewTradesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portfolioField_viewTradesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_portfolioField_viewTradesActionPerformed

    private void counterpartyField_viewTradesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_counterpartyField_viewTradesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_counterpartyField_viewTradesActionPerformed

    // Knapp i View Trades
    // Byter till Main Menu
    private void mainMenu_viewTradesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenu_viewTradesActionPerformed
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "mainMenu");
    }//GEN-LAST:event_mainMenu_viewTradesActionPerformed

    // Knapp i Main Menu
    // Byter till View Trades, fyller upp tabellen med alla trades
    private void viewTrades_mainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewTrades_mainMenuActionPerformed
        // Byt sida
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "viewTrades");
        
        List<TableModel> tbModelList = new ArrayList<>();
        initTableController();
        
        // Hämta samtliga trades (inga filter)
        try {
            tbModelList = tbc.getTableModelList(null,null,null,null);
        } catch (SQLException ex) {
            System.out.println("Fel vid hämtning av data till tableModelList: " + ex.getMessage());
        }
        
        // Fyll upp tabellen med alla trades
        int row = 0;
        int rows = tbModelList.size();
        Object[][] data = new Object[rows][3];
        
        for(TableModel tb : tbModelList){
            data[row][0] = tb.getInstrumentName();
            data[row][1] = tb.getCurrency();
            data[row++][2] = Math.round(tb.getQuantity() * tb.getPrice() * 100)/100.0f;
        }
        
        String[] cols = {"Instrument Name", "Currency", "Traded Amount"};
        DefaultTableModel tradeInfo = new DefaultTableModel(data, cols);
        
        positionTable.setModel(tradeInfo);
        positionTable.setShowGrid(true);
        
    }//GEN-LAST:event_viewTrades_mainMenuActionPerformed

    private void acquirerField_viewTradesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acquirerField_viewTradesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_acquirerField_viewTradesActionPerformed

    private void instrumentField_viewTradesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instrumentField_viewTradesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_instrumentField_viewTradesActionPerformed

    // Knapp i View Trades
    // Ger användaren möjlighet att gruppera efter Instrument, Counterparty, Acquirer och Portfolio 
    // Alla permutationer av ovanstående fungerar
    private void groupButton_viewTradesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupButton_viewTradesActionPerformed
        List<TableModel> tbModelList = new ArrayList<>();
        initTableController();
        DecimalFormat f = new DecimalFormat("#0.00");
        // Hämtar alla filtreringar
        Integer instrumentID = tryIntParse(instrumentField_viewTrades.getText()); 
        Integer counterpartyID = tryIntParse(counterpartyField_viewTrades.getText()); 
        Integer acquirerID = tryIntParse(acquirerField_viewTrades.getText()); 
        Integer portfolioID = tryIntParse(portfolioField_viewTrades.getText()); 
        
        // Hämtar alla trades med filtreringar från databasen
        try {
            tbModelList = tbc.getTableModelList(instrumentID, acquirerID, counterpartyID, portfolioID);
        } catch (SQLException ex) {
            System.out.println("Fel vid hämtning av data till tableModelList: " + ex.getMessage());
        }
        
        // Fyller upp tabellen
        int row = 0;
        int rows = tbModelList.size();
        Object[][] data = new Object[rows][3];
        
        for(TableModel tb : tbModelList){
            data[row][0] = tb.getInstrumentName();
            data[row][1] = tb.getCurrency();
            data[row++][2] = Math.round(tb.getQuantity() * tb.getPrice() * 100)/100.0f;
        }
        
        String[] cols = {"Instrument Name", "Currency", "Traded Amount"};
        DefaultTableModel tradeInfo = new DefaultTableModel(data, cols);
        
        positionTable.setModel(tradeInfo);
        positionTable.setShowGrid(true);
    }//GEN-LAST:event_groupButton_viewTradesActionPerformed

    private void tablesCombobox_manageDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tablesCombobox_manageDataActionPerformed
        
    }//GEN-LAST:event_tablesCombobox_manageDataActionPerformed

    // Knapp i Main Menu
    // Byter till Manage Data samt fyller upp tabellen default
    private void manageData_mainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageData_mainMenuActionPerformed
        // Byter sida
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "manageData");
        
        List<GenericDataModel> genericDataModelList = new ArrayList<>();
        initTableController();
        
        // Counterparty som default
        String table = "Counterparty";
        
        try {
            genericDataModelList = tbc.getGenericDataList(table);
        } catch (SQLException ex) {
            System.out.println("Error when fetching data to genericDataModelList: " + ex.getMessage());
        }
        
        int row = 0;
        int rows = genericDataModelList.size();
        Object[][] data = new Object[rows][2];
        
        for(GenericDataModel gdm : genericDataModelList){
            data[row][0] = gdm.getId();
            data[row++][1] = gdm.getName();
        }
        
        String[] cols = {"ID", "Name"};
        DefaultTableModel manageDataTable = new DefaultTableModel(data, cols);
        
        genericTable_manageData.setModel(manageDataTable);
        genericTable_manageData.setShowGrid(true);
        
    }//GEN-LAST:event_manageData_mainMenuActionPerformed

    // Knapp i Manage Data
    // Byter till Main Menu
    private void mainMenu_manageDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenu_manageDataActionPerformed
        CardLayout card = (CardLayout) mainPanel.getLayout();
        card.show(mainPanel, "mainMenu");
    }//GEN-LAST:event_mainMenu_manageDataActionPerformed

    // Knapp i Manage Data
    // Tar bort en selectad rad
    private void deleteRow_manageDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRow_manageDataActionPerformed
 
        int row = genericTable_manageData.getSelectedRow();
        int id = tryIntParse(genericTable_manageData.getModel().getValueAt(row, 0).toString());
        // Hämtar tabell från comboboxen
        String table = tablesCombobox_manageData.getSelectedItem().toString();
        
        switch(table){
            case "Trades":
                initTradeController();
                try {
                    tc.deleteTrade(id);
                } catch (SQLException ex) {
                    System.out.println("Error when deleting a trade: " + ex.getMessage());
                }
                initTradeController();
                List<TradesModel> dataModelList = new ArrayList<>();
                // Hämta all data
                try {
                    dataModelList = tc.getTrades();
                } catch (SQLException ex) {
                    System.out.println("Error when fetching data from trades: " + ex.getMessage());
                }       
                row = 0;
                int rows = dataModelList.size();
                Object[][] data = new Object[rows][9];
                // Skriv ut all data i tabellen
                for(TradesModel tm : dataModelList){
                    data[row][0] = tm.getTradeID();
                    data[row][1] = tm.getQuantity();
                    data[row][2] = tm.getPrice();
                    data[row][3] = tm.getTradetime();
                    data[row][4] = tm.getCounterpartyID();
                    data[row][5] = tm.getPortfolioID();
                    data[row][6] = tm.getInstrumentID();
                    data[row][7] = tm.getAcquirerID();
                    data[row++][8] = tm.getMarketplaceID();
                }       
                // Definiera kolumner
                String[] cols = {"Trade ID", "Quantity", "Price", "Tradetime", "Counterparty ID", "Portfolio ID", "Instrument ID", "Acquirer ID", "Marketplace ID"};
                DefaultTableModel manageDataTable = new DefaultTableModel(data, cols);
                genericTable_manageData.setModel(manageDataTable);
                genericTable_manageData.setShowGrid(true);
                break;         
            
            case "Instrument":
                initInstrumentController();
                try {
                    ic.deleteInstrument(id);
                } catch (SQLException ex) {
                    System.out.println("Error when deleting an instrument: " + ex.getMessage());
                }
                initInstrumentController();
                List<InstrumentModel> dataModelList2 = new ArrayList<>();
                try {
                    dataModelList2 = ic.getInstruments();
                } catch (SQLException ex) {
                    System.out.println("Error when fetching data from instrument: " + ex.getMessage());
                }       
                row = 0;
                rows = dataModelList2.size();
                data = new Object[rows][4];
                for(InstrumentModel tm : dataModelList2){
                    data[row][0] = tm.getInstrumentID();
                    data[row][1] = tm.getInstrumentName();
                    data[row][2] = tm.getCurrency();
                    data[row++][3] = tm.getIssuerID();
                }       
                String[] cols2 = {"Instrument ID", "Instrument Name", "Currency", "Issuer ID"};
                manageDataTable = new DefaultTableModel(data, cols2);
                genericTable_manageData.setModel(manageDataTable);
                genericTable_manageData.setShowGrid(true);
                    
                break;                
            
            default:
                initTableController();
                try {
                    tbc.deleteDataGeneric(table, id);
                } catch (SQLException ex) {
                    System.out.println("Error when deleting generic data: " + ex.getMessage());
                }
                
                // Uppdaterar tabellen
                List<GenericDataModel> genericDataModelList = new ArrayList<>();
                initTableController();

                try {
                    genericDataModelList = tbc.getGenericDataList(table);
                } catch (SQLException ex) {
                    System.out.println("Error when fetching data to genericDataModelList: " + ex.getMessage());
                }

                row = 0;
                rows = genericDataModelList.size();
                data = new Object[rows][2];

                for(GenericDataModel gdm : genericDataModelList){
                    data[row][0] = gdm.getId();
                    data[row++][1] = gdm.getName();
                }

                String[] cols3 = {"ID", "Name"};
                manageDataTable = new DefaultTableModel(data, cols3);

                genericTable_manageData.setModel(manageDataTable);
                genericTable_manageData.setShowGrid(true);
                break;
        }

    }//GEN-LAST:event_deleteRow_manageDataActionPerformed

    // Knapp i Manage Data
    // Byter databastabell som visas på sidan baserat på valet i comboboxen
    private void changeTable_manageDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeTable_manageDataActionPerformed
        // Få användarens val i comboboxen
        String table = tablesCombobox_manageData.getSelectedItem().toString();
        
        // Case baserat på tabellen
        switch (table) {
            case "Trades":
                {
                    //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    initTradeController();
                    List<TradesModel> dataModelList = new ArrayList<>();
                    // Hämta all data
                    try {
                        dataModelList = tc.getTrades();
                    } catch (SQLException ex) {
                        System.out.println("Error when fetching data from trades: " + ex.getMessage());
                    }       
                    int row = 0;
                    int rows = dataModelList.size();
                    Object[][] data = new Object[rows][9];
                    // Skriv ut all data i tabellen
                    for(TradesModel tm : dataModelList){
                        data[row][0] = tm.getTradeID();
                        data[row][1] = tm.getQuantity();
                        data[row][2] = tm.getPrice();
                        data[row][3] = tm.getTradetime();
                        data[row][4] = tm.getCounterpartyID();
                        data[row][5] = tm.getPortfolioID();
                        data[row][6] = tm.getInstrumentID();
                        data[row][7] = tm.getAcquirerID();
                        data[row++][8] = tm.getMarketplaceID();
                    }       
                    // Definiera kolumner
                    String[] cols = {"Trade ID", "Quantity", "Price", "Tradetime", "Counterparty ID", "Portfolio ID", "Instrument ID", "Acquirer ID", "Marketplace ID"};
                    DefaultTableModel manageDataTable = new DefaultTableModel(data, cols);
                    genericTable_manageData.setModel(manageDataTable);
                    genericTable_manageData.setShowGrid(true);
                    break;
                }
            case "Instrument":
                {
                    initInstrumentController();
                    List<InstrumentModel> dataModelList = new ArrayList<>();
                    try {
                        dataModelList = ic.getInstruments();
                    } catch (SQLException ex) {
                        System.out.println("Error when fetching data from instrument: " + ex.getMessage());
                    }       
                    int row = 0;
                    int rows = dataModelList.size();
                    Object[][] data = new Object[rows][4];
                    for(InstrumentModel tm : dataModelList){
                        data[row][0] = tm.getInstrumentID();
                        data[row][1] = tm.getInstrumentName();
                        data[row][2] = tm.getCurrency();
                        data[row++][3] = tm.getIssuerID();
                    }       
                    String[] cols = {"Instrument ID", "Instrument Name", "Currency", "Issuer ID"};
                    DefaultTableModel manageDataTable = new DefaultTableModel(data, cols);
                    genericTable_manageData.setModel(manageDataTable);
                    genericTable_manageData.setShowGrid(true);
                    break;
                }
            default:
                {
                    initTableController();
                    List<GenericDataModel> dataModelList = new ArrayList<>();
                    try {
                        dataModelList = tbc.getGenericDataList(table);
                    } catch (SQLException ex) {
                        System.out.println("Error when fetching data to genericDataModelList: " + ex.getMessage());
                    }       
                    int row = 0;
                    int rows = dataModelList.size();
                    Object[][] data = new Object[rows][2];
                    for(GenericDataModel gdm : dataModelList){
                        data[row][0] = gdm.getId();
                        data[row++][1] = gdm.getName();
                    }       
                    String[] cols = {"ID", "Name"};
                    DefaultTableModel manageDataTable = new DefaultTableModel(data, cols);
                    genericTable_manageData.setModel(manageDataTable);
                    genericTable_manageData.setShowGrid(true);
                    break;
                }
        }
    }//GEN-LAST:event_changeTable_manageDataActionPerformed

    // Knapp i Manage Data
    // Tar bort all data samt alla tabeller i databasen
    private void clearDB_manageDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearDB_manageDataActionPerformed
        initDbController();
        try {
            dbm.resetDb();
        } catch (SQLException ex) {
            System.out.println("Error when clearing database: " + ex.getMessage());
        }
        initTableController();
        List<GenericDataModel> dataModelList = new ArrayList<>();
        String table = "Counterparty";
        try {
            dataModelList = tbc.getGenericDataList(table);
        } catch (SQLException ex) {
            System.out.println("Error when fetching data to genericDataModelList: " + ex.getMessage());
        }       
        int row = 0;
        int rows = dataModelList.size();
        Object[][] data = new Object[rows][2];
        for(GenericDataModel gdm : dataModelList){
            data[row][0] = gdm.getId();
            data[row++][1] = gdm.getName();
        }       
        String[] cols = {"ID", "Name"};
        DefaultTableModel manageDataTable = new DefaultTableModel(data, cols);
        genericTable_manageData.setModel(manageDataTable);
        genericTable_manageData.setShowGrid(true);
    }//GEN-LAST:event_clearDB_manageDataActionPerformed

    private void instrumentName_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instrumentName_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_instrumentName_fieldActionPerformed
    
    //Metod för felhantering av Integer.parseInt
    public Integer tryIntParse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }
    //Metod för felhantering av Float.parseFloat
    public Float tryFloatParse(String text) {
        try {
            return Float.parseFloat(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrontEndView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrontEndView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrontEndView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrontEndView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrontEndView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField acquirerField_viewTrades;
    private javax.swing.JFormattedTextField acquirer_field;
    private javax.swing.JPanel addInstrument;
    private javax.swing.JButton addInstrumentMain_button;
    private javax.swing.JPanel addTrade;
    private javax.swing.JButton add_addInstrument;
    private javax.swing.JButton changeTable_manageData;
    private javax.swing.JButton clearDB_manageData;
    private javax.swing.JFormattedTextField counterpartyField_viewTrades;
    private javax.swing.JFormattedTextField counterparty_field;
    private javax.swing.JButton deleteRow_manageData;
    private javax.swing.JButton executeTrade_addTrade;
    private javax.swing.JTable genericTable_manageData;
    private javax.swing.JButton groupButton_viewTrades;
    private javax.swing.JFormattedTextField instrumentCurrency_field;
    private javax.swing.JFormattedTextField instrumentField_viewTrades;
    private javax.swing.JTable instrumentList_table;
    private javax.swing.JFormattedTextField instrumentName_field;
    private javax.swing.JFormattedTextField issuerName_field;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel mainMenu;
    private javax.swing.JButton mainMenu_addInstrument;
    private javax.swing.JButton mainMenu_addTrade;
    private javax.swing.JButton mainMenu_manageData;
    private javax.swing.JButton mainMenu_viewTrades;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel manageData;
    private javax.swing.JButton manageData_mainMenu;
    private javax.swing.JFormattedTextField marketplace_field;
    private javax.swing.JFormattedTextField portfolioField_viewTrades;
    private javax.swing.JFormattedTextField portfolio_field;
    private javax.swing.JTable positionTable;
    private javax.swing.JFormattedTextField price_field;
    private javax.swing.JFormattedTextField quantity_field;
    private javax.swing.JComboBox<String> tablesCombobox_manageData;
    private javax.swing.JButton tradeInstrument_mainMenu;
    private javax.swing.JPanel viewTrades;
    private javax.swing.JButton viewTrades_mainMenu;
    // End of variables declaration//GEN-END:variables
}
