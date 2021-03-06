/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import Persona.EmploymentHistory.Employment;
import Persona.EmploymentHistory.EmploymentHistory;
import Persona.StudentDirectory;
import Persona.StudentProfile;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dengbowen
 */
public class JobJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewJPanel
     */
    EmploymentHistory employmentHistory;
    JPanel workarea;
    StudentProfile studentProfile;
    public JobJPanel(StudentProfile studentProfile,JPanel workarea) {
        this.studentProfile=studentProfile;
        this.workarea=workarea;
        this.employmentHistory=studentProfile.getEmploymenthistory();
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JobTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtTotalScore = new javax.swing.JTextField();
        btnBack1 = new javax.swing.JButton();
        txtStudentID = new javax.swing.JTextField();
        btnViewRelativeCourses = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Student Job Performance");

        JobTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", null, null, null},
                {"2", null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "EmploymentID", "Employer", "Job", "Score"
            }
        ));
        jScrollPane1.setViewportView(JobTable);

        jLabel2.setText("StudentID");

        jLabel4.setText("Total Score");

        txtname.setEditable(false);
        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        txtTotalScore.setEditable(false);

        btnBack1.setText("<< Back");
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });

        txtStudentID.setEditable(false);
        txtStudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentIDActionPerformed(evt);
            }
        });

        btnViewRelativeCourses.setText("View Relative Courses");
        btnViewRelativeCourses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewRelativeCoursesActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 14)); // NOI18N
        jLabel3.setText("total score = avg(sum(job))+ employergrade");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtname, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addComponent(btnBack1))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnViewRelativeCourses)
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtTotalScore, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack1)
                    .addComponent(txtStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTotalScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewRelativeCourses))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addContainerGap(93, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        // TODO add your handling code here:
        workarea.remove(this);
        CardLayout layout = (CardLayout) workarea.getLayout();
        layout.previous(workarea);
    }//GEN-LAST:event_btnBack1ActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void txtStudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentIDActionPerformed

    private void btnViewRelativeCoursesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewRelativeCoursesActionPerformed
        // TODO add your handling code here:
                int row = JobTable.getSelectedRow();
        if(row<0){
                JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
        }
        Employment employment = (Employment)JobTable.getValueAt(row,1);
        RelativeCoursesJPanel jobJPanel=new RelativeCoursesJPanel(employment,workarea);
        workarea.add("JobJPanel",jobJPanel);
        CardLayout layout = (CardLayout)workarea.getLayout();
        layout.next(workarea);
    }//GEN-LAST:event_btnViewRelativeCoursesActionPerformed
    public void refreshTable() {
        int rowCount = JobTable.getRowCount();
        DefaultTableModel model = (DefaultTableModel) JobTable.getModel();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        int count=0;
        for (Employment employment : employmentHistory.getEmployments()) {
            Object row[] = new Object[4];
            row[0] = ++count;
            row[1] = employment;
            row[2] =employment.getJob();
            row[3] =employment.getEmploymentGrade();
            model.addRow(row);
        }
        txtStudentID.setText(studentProfile.getPerson().getId());
        txtname.setText(studentProfile.getPerson().getName());
        txtTotalScore.setText(""+employmentHistory.getEmploymentGrade());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JobTable;
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnViewRelativeCourses;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtStudentID;
    private javax.swing.JTextField txtTotalScore;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables
}
