package view;

import lombok.Getter;

@Getter
public class TaskHistoryView extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TaskHistoryView.class.getName());

    public TaskHistoryView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TaskTable = new javax.swing.JTable();
        btnInfoClient = new javax.swing.JButton();
        btnUndo = new javax.swing.JButton();

        setTitle("Task History");
        setResizable(false);

        TaskTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tipo de Acción", "Cliente", "Fecha y hora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TaskTable);
        if (TaskTable.getColumnModel().getColumnCount() > 0) {
            TaskTable.getColumnModel().getColumn(0).setResizable(false);
            TaskTable.getColumnModel().getColumn(1).setResizable(false);
            TaskTable.getColumnModel().getColumn(2).setResizable(false);
        }

        btnInfoClient.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 14)); // NOI18N
        btnInfoClient.setText("Info cliente");
        btnInfoClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoClientActionPerformed(evt);
            }
        });

        btnUndo.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 14)); // NOI18N
        btnUndo.setText("Deshacer");
        btnUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUndoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(btnInfoClient)
                .addGap(86, 86, 86)
                .addComponent(btnUndo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUndo)
                    .addComponent(btnInfoClient))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInfoClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoClientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInfoClientActionPerformed

    private void btnUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUndoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUndoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TaskTable;
    private javax.swing.JButton btnInfoClient;
    private javax.swing.JButton btnUndo;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
