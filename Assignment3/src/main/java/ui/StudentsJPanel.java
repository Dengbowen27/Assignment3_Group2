/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import Persona.EmploymentHistory.EmploymentHistory;
import Persona.StudentDirectory;
import Persona.StudentProfile;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 主子
 */
public class StudentsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form StudentsDirectoryJPanel
     */
    StudentDirectory studentDirectory;
    JPanel workarea;
    public StudentsJPanel(StudentDirectory studentDirectory,JPanel workarea) {
        this.studentDirectory=studentDirectory;
        this.workarea=workarea;
        initComponents();
        refreshTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblSupplierName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentCatalog = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnSearchProduct = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnView1 = new javax.swing.JButton();
        btnView2 = new javax.swing.JButton();

        lblSupplierName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSupplierName.setText("Student Directory");

        studentCatalog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "StudentID", "StudentName"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(studentCatalog);

        btnSearchProduct.setText("Search Student");
        btnSearchProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchStudentActionPerformed(evt);
            }
        });

        btnView.setText("View Academic Performance");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcademicActionPerformed(evt);
            }
        });

        btnView1.setText("View Job Performance");
        btnView1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJobPerformancePerformed(evt);
            }
        });

        btnView2.setText("View Total Performance");
        btnView2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalPerformanceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnView)
                        .addGap(18, 18, 18)
                        .addComponent(btnView1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnView2))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(93, 93, 93)
                            .addComponent(lblSupplierName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnSearchProduct))))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSupplierName)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnView)
                    .addComponent(btnView1)
                    .addComponent(btnView2))
                .addContainerGap(272, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 769, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTotalPerformanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalPerformanceActionPerformed
        // TODO add your handling code here:
        TotalPerformanceJPanel totalPerformanceJPanel=new TotalPerformanceJPanel(studentDirectory,workarea);
        workarea.add("StudentsJPanel",totalPerformanceJPanel);
        CardLayout layout = (CardLayout)workarea.getLayout();
        layout.next(workarea);
    }//GEN-LAST:event_btnTotalPerformanceActionPerformed

    private void btnJobPerformancePerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJobPerformancePerformed
        // TODO add your handling code here:
        int row = studentCatalog.getSelectedRow();
        if(row<0){
                JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
        }
        StudentProfile sp = (StudentProfile)studentCatalog.getValueAt(row,0);
        JobJPanel jobJPanel=new JobJPanel(sp,workarea);
        workarea.add("JobJPanel",jobJPanel);
        CardLayout layout = (CardLayout)workarea.getLayout();
        layout.next(workarea);
    }//GEN-LAST:event_btnJobPerformancePerformed

    private void btnAcademicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcademicActionPerformed

        int row = studentCatalog.getSelectedRow();
        if(row<0){
                JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
        StudentProfile sp = (StudentProfile)studentCatalog.getValueAt(row,0);
        AcademicJPanel aj = new AcademicJPanel(sp,workarea);
        workarea.add("ViewAcademicPerformance", aj);
        CardLayout layout = (CardLayout) workarea.getLayout();
        layout.next(workarea);
    }//GEN-LAST:event_btnAcademicActionPerformed

    private void btnSearchStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchStudentActionPerformed
        String studentId=txtSearch.getText();
        for(int rowNum=0;rowNum<studentCatalog.getRowCount();rowNum++){
            if(studentId.equals(studentCatalog.getValueAt(rowNum,0).toString())){
                studentCatalog.setRowSelectionInterval(rowNum, rowNum);
                break;
            }
        }
        
        //click search and have one row selected which has the student id selected
    }//GEN-LAST:event_btnSearchStudentActionPerformed

    public void refreshTable() {
        int rowCount = studentCatalog.getRowCount();
        DefaultTableModel model = (DefaultTableModel) studentCatalog.getModel();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        for (StudentProfile sp : studentDirectory.getStudentlist()) {
            Object row[] = new Object[2];
            row[0] = sp;
            row[1] = sp.getPerson().getName();
            model.addRow(row);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearchProduct;
    private javax.swing.JButton btnView;
    private javax.swing.JButton btnView1;
    private javax.swing.JButton btnView2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSupplierName;
    private javax.swing.JTable studentCatalog;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
