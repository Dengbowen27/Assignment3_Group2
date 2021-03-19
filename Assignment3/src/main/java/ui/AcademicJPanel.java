/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import CourseSchedule.CourseLoad;
import CourseSchedule.SeatAssignment;
import Persona.StudentDirectory;
import Persona.StudentProfile;
import java.awt.CardLayout;
import java.text.DecimalFormat;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dengbowen
 */
public class AcademicJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AcedamicJPanel
     */
    StudentProfile currentStudent;
    JPanel workarea;
    public AcademicJPanel(StudentProfile currentStudent,JPanel workarea) {
        this.workarea=workarea;
        this.currentStudent=currentStudent;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        AcademicTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTotalGpa = new javax.swing.JTextField();
        txtStudentID = new javax.swing.JTextField();
        btnBack1 = new javax.swing.JButton();
        txtStudentName = new javax.swing.JTextField();

        AcademicTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CourseID", "CreditHour", "Score", "Price"
            }
        ));
        jScrollPane1.setViewportView(AcademicTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Student Acedamic Performence");

        jLabel2.setText("StudentID");

        jLabel4.setText("TotalGPA");

        txtTotalGpa.setEditable(false);

        txtStudentID.setEditable(false);

        btnBack1.setText("<< Back");
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });

        txtStudentName.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtStudentName, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(105, 105, 105)
                                .addComponent(btnBack1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(186, 186, 186)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtTotalGpa, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack1)
                    .addComponent(txtStudentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTotalGpa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(97, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        // TODO add your handling code here:
        workarea.remove(this);
        CardLayout layout = (CardLayout) workarea.getLayout();
        layout.previous(workarea);
    }//GEN-LAST:event_btnBack1ActionPerformed

    public void refreshTable() {
        int rowCount = AcademicTable.getRowCount();
        DefaultTableModel model = (DefaultTableModel) AcademicTable.getModel();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        for(CourseLoad courseLoad:currentStudent.getTranscript().getCourseloadlist().values()){
            Object row[] = new Object[4];
            for(SeatAssignment seatAssignment:courseLoad.getSeatAssignments()){
                row[0]=seatAssignment.getCourse().getNumber();
                row[1]=seatAssignment.getCreditHours();
                row[2]=seatAssignment.getGrade();
                row[3]=seatAssignment.getCourse().getCoursePrice();
                model.addRow(row);
            }
        }
        txtStudentID.setText(currentStudent.getPerson().getPersonId());
        txtStudentName.setText(currentStudent.getPerson().getName());
        
        //remain two digit and transform to string
        DecimalFormat df = new DecimalFormat("0.00");
        String gpa=df.format(currentStudent.getTranscript().getCurrentGpa());
        txtTotalGpa.setText(gpa);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AcademicTable;
    private javax.swing.JButton btnBack1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtStudentID;
    private javax.swing.JTextField txtStudentName;
    private javax.swing.JTextField txtTotalGpa;
    // End of variables declaration//GEN-END:variables
}
