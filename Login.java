
//import clases.conectar;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.InputMap;
import javax.swing.KeyStroke;


import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Valerio
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        setSize(400, 518);//Tamaño de la ventana
        this.setLocationRelativeTo(null); //Centra la ventana en medio
        cerrarVentana();
        this.setResizable(false);//Bloqueo de Maximizacion de la ventana
        this.setTitle("INICIAR SESIÓN");//Título de la ventana
       
    }
   
 
    public void cerrarVentana(){//Método para cerrar la ventana
        try{
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter(){
               public void windowClosing(WindowEvent e){
               confirmarSalida();
               }
            });
            this.setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //Confirmación de la salida
    public void confirmarSalida(){
        int valor = JOptionPane.showConfirmDialog(this,"¿Seguro que quiere salir?","Advertencia",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(valor==JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null,"¡Hasta pronto!","Mensaje",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jButtonSesion = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 240, 250));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 60, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 90, 30));

        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyReleased(evt);
            }
        });
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 180, 30));

        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 180, 30));

        jButtonSesion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Login.png"))); // NOI18N
        jButtonSesion.setText("Iniciar Sesión");
        jButtonSesion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButtonSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSesionActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 200, 40));

        lblFondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Home.png"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSesionActionPerformed
        // TODO add your handling code here:
        String user, pass;
        user = txtUsuario.getText();
        pass = txtPassword.getText();
        if (user.equals("Admin")&& pass.equals("123")){
           Plantilla acceso  = new Plantilla();  //Nombre de la siguiente ventana
           acceso.setVisible(true);
           this.setVisible(false);
        }else{
           JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta");
       }    
        
        
        
        
        /*try{
        
        Connection reg = con.getConection();
        String user, pass, tipo_usuario;
        user = txtusuario.getText();
        pasword = txtPassword.getText();
        Statement st = reg.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM usuarios WHERE usuario ='" + user +"' AND contraseña='" + pasword+"'");
        if(rs.next()){
            tipo_usuario = rs.getString(4);
            Plantilla es = new Plantilla();
            es.setVisible(true);
            dispose();
            
           
        }else{
            JOptionPane.showMessageDialog(null, "Ingrese su contraseña y usuario correctamente", "Error", JOptionPane.ERROR_MESSAGE);
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: " +e, "Error Interno", JOptionPane.ERROR_MESSAGE);
             con.desconectar();
        }
       
       */
    }//GEN-LAST:event_jButtonSesionActionPerformed

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
        
    }//GEN-LAST:event_txtUsuarioKeyPressed

    private void txtUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyReleased
        // TODO add your handling code here:
        //evt.setSource((char) KeyEvent.VK_CLEAR);
        //txtPassword.requestFocus();//Al presionar posiciona al txtPassword
    }//GEN-LAST:event_txtUsuarioKeyReleased

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
