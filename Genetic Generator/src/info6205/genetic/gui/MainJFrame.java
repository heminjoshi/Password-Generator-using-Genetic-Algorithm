/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info6205.genetic.gui;

import info6205.genetic.main.Genetic;
import info6205.genetic.main.Salt;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author aditya
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    
    
    String randomPassword;
    
    //Juhi
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9][A-Za-z0-9_]+@(.+)$";
    /*
    1) A-Z characters allowed
    2) a-z characters allowed
    3) 0-9 numbers allowed
    4) Additionally email may contain only an underscore(_)
    5) Rest all characters are not allowed
    */
    
    private static final String DOB_PATTERN = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";
    
    private Pattern pattern;
    private Matcher matcher;
    
    public MainJFrame() {
        initComponents();
        randomPasswordTextArea.setEditable(false);
        passwordLengthComboBox.removeAllItems();
        passwordLengthComboBox.addItem("8");
        passwordLengthComboBox.addItem("12");
        passwordLengthComboBox.addItem("16");
        
        passwordLengthComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    String randomPasswordLength = generateRandomPasswordLength(randomPassword);
                    randomPasswordTextArea.setText(randomPasswordLength);
                }
            }
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        fNameTF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lNameTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dobTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        emailTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        phoneNoTF = new javax.swing.JTextField();
        generatePasswordButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        randomPasswordLabel = new java.awt.Label();
        randomPasswordTextArea = new java.awt.TextArea();
        passwordLengthJLabel = new java.awt.Label();
        passwordLengthComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("First Name");

        jLabel3.setText("Last Name");

        jLabel4.setText("DOB (mm/dd/yyyy)");

        jLabel5.setText("Email");

        jLabel6.setText("Phone");

        generatePasswordButton.setText("Generate Random Password");
        generatePasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generatePasswordButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lNameTF)
                    .addComponent(dobTF)
                    .addComponent(emailTF)
                    .addComponent(phoneNoTF)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(generatePasswordButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fNameTF))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(fNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(1, 1, 1)
                .addComponent(lNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(1, 1, 1)
                .addComponent(dobTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(1, 1, 1)
                .addComponent(emailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(1, 1, 1)
                .addComponent(phoneNoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(generatePasswordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        randomPasswordLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        randomPasswordLabel.setText("Random Password");

        passwordLengthJLabel.setText("Password length");

        passwordLengthComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordLengthJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(randomPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(randomPasswordTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLengthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(randomPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordLengthJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordLengthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(randomPasswordTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );

        jSplitPane1.setRightComponent(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generatePasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generatePasswordButtonActionPerformed
        try {
            // TODO add your handling code here:
            String fName = fNameTF.getText();
            String lName = lNameTF.getText();
            String dob = dobTF.getText();
            String email = emailTF.getText();
            String phoneNo = phoneNoTF.getText();
            
            
            //Juhi start
            if(checkEmptyOrNull(fName) || checkEmptyOrNull(lName) || checkEmptyOrNull(dob) || checkEmptyOrNull(email) || checkEmptyOrNull(phoneNo))
            {
                JOptionPane.showMessageDialog(null, "Field cannot be empty");
                return;
            }
            if(!emailValidator(email))
            {
                JOptionPane.showMessageDialog(null,"Please enter valid email!!!!");
                return;
            }
            if(!dateValidator(dob))
            {
                JOptionPane.showMessageDialog(null,"Please enter date of birth in proper format!!!!");
                return;
            }
            
            if(phoneNo.length()!=10 || !phoneNo.matches("[0-9]+"))
            {
                JOptionPane.showMessageDialog(null,"Please enter valid phone number!!!!");
                return;
            }
            //Juhi end
            
            
            Salt salt = new Salt();
            randomPassword = salt.generateRandomPassword(fName, lName, dob, email, phoneNo);
            //Juhi
            String randomPasswordLength = generateRandomPasswordLength(randomPassword);
            randomPasswordTextArea.setText(randomPasswordLength);
            randomPasswordTextArea.setEditable(false);
        } catch (Exception ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_generatePasswordButtonActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dobTF;
    private javax.swing.JTextField emailTF;
    private javax.swing.JTextField fNameTF;
    private javax.swing.JButton generatePasswordButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextField lNameTF;
    private javax.swing.JComboBox<String> passwordLengthComboBox;
    private java.awt.Label passwordLengthJLabel;
    private javax.swing.JTextField phoneNoTF;
    private java.awt.Label randomPasswordLabel;
    private java.awt.TextArea randomPasswordTextArea;
    // End of variables declaration//GEN-END:variables

    
    //Juhi
    private String generateRandomPasswordLength(String randomPassword) {
        
        if(randomPassword!=null)
        {
            int desiredPassLength =  Integer.parseInt(passwordLengthComboBox.getSelectedItem().toString());
            int randomPasswordLength = randomPassword.length();
            StringBuilder randomPasswordLengthStr = new StringBuilder();

            for(int i = 0 ; i < desiredPassLength ; i++)
            {
                int randomIndex = new Random().nextInt(randomPasswordLength);
                if(i%4==0 && i!=0)
                {
                    randomPasswordLengthStr.append("-");
                }
                randomPasswordLengthStr.append(randomPassword.charAt(randomIndex));
            }
            return randomPasswordLengthStr.toString();
        }
        else
        {
            return null;
        }
    }

    //Juhi
    private boolean checkEmptyOrNull(String str) {
        if(str==null || str.equalsIgnoreCase(""))
            return true;
        return false;
    }
    
    //Juhi
    public boolean validate(final String stringToValidate){  
        matcher = pattern.matcher(stringToValidate);
	return matcher.matches(); 	    
    }

    //Juhi
    private boolean emailValidator(String email) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        return validate(email);
    }

    //Juhi
    private boolean dateValidator(String dob) {
        pattern = Pattern.compile(DOB_PATTERN);
        return validate(dob);
    }
    
    
    
}
