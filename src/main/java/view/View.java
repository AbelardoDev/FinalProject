package view;

import lombok.Getter;

@Getter
public class View extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(View.class.getName());

    public View() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        waitingTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnAddClient = new javax.swing.JButton();
        btnAttendClient = new javax.swing.JButton();
        btnRemoveClient = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        attendTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAttend = new javax.swing.JTextArea();
        btnEndAttend = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnSearchClient = new javax.swing.JButton();
        cbxRequestType = new javax.swing.JComboBox<>();
        tflId = new javax.swing.JTextField();
        jToggleButton = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblWaiting = new javax.swing.JLabel();
        lblAttend = new javax.swing.JLabel();
        lblAverageTime = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnUndo = new javax.swing.JButton();
        btnHistory = new javax.swing.JButton();
        btnSimulation = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simulador de Atención al Cliente");
        setResizable(false);

        waitingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Solicitud", "Prioridad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(waitingTable);
        if (waitingTable.getColumnModel().getColumnCount() > 0) {
            waitingTable.getColumnModel().getColumn(0).setResizable(false);
            waitingTable.getColumnModel().getColumn(1).setResizable(false);
            waitingTable.getColumnModel().getColumn(2).setResizable(false);
            waitingTable.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 16)); // NOI18N
        jLabel1.setText("COLA DE CLIENTES EN ESPERA");

        btnAddClient.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 14)); // NOI18N
        btnAddClient.setText("Agregar Cliente");
        btnAddClient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnAttendClient.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 14)); // NOI18N
        btnAttendClient.setText("Atender Cliente");
        btnAttendClient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnRemoveClient.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 14)); // NOI18N
        btnRemoveClient.setText("Eliminar Cliente");
        btnRemoveClient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 16)); // NOI18N
        jLabel2.setText("LISTA DE CLIENTES ATENDIDOS");

        attendTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Solicitud", "Prioridad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(attendTable);
        if (attendTable.getColumnModel().getColumnCount() > 0) {
            attendTable.getColumnModel().getColumn(0).setResizable(false);
            attendTable.getColumnModel().getColumn(1).setResizable(false);
            attendTable.getColumnModel().getColumn(2).setResizable(false);
            attendTable.getColumnModel().getColumn(3).setResizable(false);
        }

        txtAttend.setEditable(false);
        txtAttend.setColumns(20);
        txtAttend.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 14)); // NOI18N
        txtAttend.setRows(5);
        txtAttend.setText("Actualmente ningún cliente está siendo atendido. ");
        jScrollPane3.setViewportView(txtAttend);

        btnEndAttend.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 14)); // NOI18N
        btnEndAttend.setText("Finalizar Atención");
        btnEndAttend.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnSearchClient.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 14)); // NOI18N
        btnSearchClient.setText("Buscar Cliente");
        btnSearchClient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cbxRequestType.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 14)); // NOI18N
        cbxRequestType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Soporte", "Mantenimiento", "Reclamo" }));

        tflId.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 14)); // NOI18N

        jToggleButton.setText("Solicitud/Id");
        jToggleButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jToggleButton.setRequestFocusEnabled(false);
        jToggleButton.setRolloverEnabled(false);
        jToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 14)); // NOI18N
        jLabel3.setText("Id:");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        lblWaiting.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 12)); // NOI18N
        lblWaiting.setText("Clientes en espera: 0");

        lblAttend.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 12)); // NOI18N
        lblAttend.setText("Clientes atendidos: 0");

        lblAverageTime.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 12)); // NOI18N
        lblAverageTime.setText("Tiempo promedio de atención: ");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnUndo.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 14)); // NOI18N
        btnUndo.setText("Deshacer");
        btnUndo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnHistory.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 14)); // NOI18N
        btnHistory.setText("Historial");
        btnHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAverageTime)
                    .addComponent(lblWaiting)
                    .addComponent(lblAttend))
                .addGap(64, 64, 64)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUndo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lblWaiting)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblAttend)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblAverageTime))
                        .addComponent(jSeparator2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnUndo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHistory)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSimulation.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 14)); // NOI18N
        btnSimulation.setText("Iniciar Simulación");
        btnSimulation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(btnEndAttend))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1)
                            .addComponent(jScrollPane3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAddClient)
                                .addGap(36, 36, 36)
                                .addComponent(btnAttendClient)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRemoveClient))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(jLabel2))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnSearchClient)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbxRequestType, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tflId, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jToggleButton))))
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSimulation)
                        .addGap(196, 196, 196))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddClient, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoveClient, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAttendClient, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton)
                    .addComponent(btnSearchClient, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tflId)
                    .addComponent(jLabel3)
                    .addComponent(cbxRequestType, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEndAttend, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSimulation, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable attendTable;
    private javax.swing.JButton btnAddClient;
    private javax.swing.JButton btnAttendClient;
    private javax.swing.JButton btnEndAttend;
    private javax.swing.JButton btnHistory;
    private javax.swing.JButton btnRemoveClient;
    private javax.swing.JButton btnSearchClient;
    private javax.swing.JButton btnSimulation;
    private javax.swing.JButton btnUndo;
    private javax.swing.JComboBox<String> cbxRequestType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToggleButton jToggleButton;
    private javax.swing.JLabel lblAttend;
    private javax.swing.JLabel lblAverageTime;
    private javax.swing.JLabel lblWaiting;
    private javax.swing.JTextField tflId;
    private javax.swing.JTextArea txtAttend;
    private javax.swing.JTable waitingTable;
    // End of variables declaration//GEN-END:variables
}
