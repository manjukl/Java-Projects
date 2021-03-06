/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author koenenm and manjukl
 */
public class addCourseFrame extends javax.swing.JInternalFrame {
    
    Department dept;
    /**
     * Creates new form addCourseFrame
     */
    public addCourseFrame(Department department) 
    {
        this.dept = department;
        initComponents();
        setSize(200, 165);
        setTitle("Add Course");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_addCourseId = new javax.swing.JLabel();
        lbl_addCourseTitle = new javax.swing.JLabel();
        txt_addCourseId = new javax.swing.JTextField();
        txt_addCourseTitle = new javax.swing.JTextField();
        btn_addCourseAdd = new javax.swing.JButton();

        setClosable(true);

        lbl_addCourseId.setText("Course Id");

        lbl_addCourseTitle.setText("Course Title");

        btn_addCourseAdd.setText("Add");
        btn_addCourseAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addCourseAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_addCourseTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_addCourseId, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_addCourseTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_addCourseAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbl_addCourseId, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_addCourseId)
                    .addComponent(txt_addCourseId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_addCourseTitle)
                    .addComponent(txt_addCourseTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_addCourseAdd)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addCourseAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addCourseAddActionPerformed
        // TODO add your handling code here:
      String cId = txt_addCourseId.getText();
      String title = txt_addCourseTitle.getText();
      dept.addCourse(title, cId);
    }//GEN-LAST:event_btn_addCourseAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addCourseAdd;
    private javax.swing.JLabel lbl_addCourseId;
    private javax.swing.JLabel lbl_addCourseTitle;
    private javax.swing.JTextField txt_addCourseId;
    private javax.swing.JTextField txt_addCourseTitle;
    // End of variables declaration//GEN-END:variables
}
