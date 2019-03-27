
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author koenenm and manjukl
 */
public class listPeopleFrame extends javax.swing.JInternalFrame {
    
    Department currentDept;
    /**
     * Creates new form listPeopleFrame
     */
    public listPeopleFrame(Department cDept) 
    {
        currentDept = cDept;
        initComponents();
        setTitle("List of People");
        setSize(500, 300);
        if (Department.count != 0)
            txtFld_List.setText(currentDept.persBag.toString());
        else
            JOptionPane.showConfirmDialog(null, "There aren't any people in this department!");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        txtFld_List = new javax.swing.JTextArea();

        setClosable(true);

        txtFld_List.setEditable(false);
        txtFld_List.setColumns(20);
        txtFld_List.setRows(5);
        jScrollPane2.setViewportView(txtFld_List);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtFld_List;
    // End of variables declaration//GEN-END:variables
}
