
package capture;


import util.conectoBanco;


public class registerperson extends javax.swing.JFrame {

   conectoBanco conecto = new conectoBanco();
     
    public registerperson() {
        initComponents();
        showIdUser();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txt_id_label = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txt_first_name = new javax.swing.JTextField();
        txt_last_name = new javax.swing.JTextField();
        txt_Office = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_Dob = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("security system - register person");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_id_label.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_id_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_id_label.setText("1");
        jPanel2.add(txt_id_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 250, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 50));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_first_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_first_nameActionPerformed(evt);
            }
        });
        jPanel3.add(txt_first_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 110, -1));

        txt_last_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_last_nameActionPerformed(evt);
            }
        });
        jPanel3.add(txt_last_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 100, -1));

        txt_Office.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_OfficeActionPerformed(evt);
            }
        });
        jPanel3.add(txt_Office, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 100, -1));

        jLabel2.setForeground(new java.awt.Color(100, 100, 100));
        jLabel2.setText("First name");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel3.setForeground(new java.awt.Color(100, 100, 100));
        jLabel3.setText("Last name");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        jLabel4.setForeground(new java.awt.Color(100, 100, 100));
        jLabel4.setText("Dob");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel5.setForeground(new java.awt.Color(100, 100, 100));
        jLabel5.setText("Office");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));

        try {
            txt_Dob.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel3.add(txt_Dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 280, 130));

        jButton1.setBackground(new java.awt.Color(51, 153, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("save");
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.W_RESIZE_CURSOR));
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 80, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 270));

        setBounds(0, 0, 291, 302);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_first_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_first_nameActionPerformed
       
    }//GEN-LAST:event_txt_first_nameActionPerformed

    private void txt_last_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_last_nameActionPerformed

        

    }//GEN-LAST:event_txt_last_nameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String fName = txt_first_name.getText();
        String lName = txt_last_name.getText();
        String dob = txt_Dob.getText();
        String office = txt_Office.getText();
        int id = Integer.parseInt(txt_id_label.getText().replace ("ID: ", " ") );
        
        new Capture(id, fName, lName, office, dob).setVisible(true);
        
    }
    public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            new registerperson().setVisible(true);
            
            }
    });
            
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_OfficeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_OfficeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_OfficeActionPerformed
    
    
            
       
        
             
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JFormattedTextField txt_Dob;
    private javax.swing.JTextField txt_Office;
    private javax.swing.JTextField txt_first_name;
    private javax.swing.JLabel txt_id_label;
    private javax.swing.JTextField txt_last_name;
    // End of variables declaration//GEN-END:variables

    private void showIdUser() {
        
      conecto.Conecxao();
      try {
        conecto.executeSQL("SELECT * FROM persn ORDER BY id DESC LIMIT 1");
        conecto.rs. first();
        txt_id_label.setText(String.valueOf(conecto.rs.getInt("id")));
        int id = Integer.parseInt(txt_id_label.getText());
        id ++;
        txt_id_label.setText(String.valueOf(id));
        
      }
      
    
    catch (Exception e) {
        
}
    }
}