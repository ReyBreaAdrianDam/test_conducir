/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrian.rey.brea.test_conducir;

import com.sun.tools.javac.Main;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author adrir
 */
public class PantallaPrincipal extends javax.swing.JFrame {

    private boolean oscuro;
    Image iconoApp;

    /**
     * Creates new form PantallaPrincipal
     */
    public PantallaPrincipal() {
        oscuro = false;
        this.iconoApp = getIconImage();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        elegirBBDD = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        testOnline = new javax.swing.JButton();
        modoOscuro = new javax.swing.JButton();
        verOtros = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(iconoApp);
        setUndecorated(true);
        setResizable(false);

        elegirBBDD.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        elegirBBDD.setText("Elegir");
        elegirBBDD.setMaximumSize(new java.awt.Dimension(85, 60));
        elegirBBDD.setMinimumSize(new java.awt.Dimension(85, 60));
        try{
            URL url = new URL("https://www.dropbox.com/s/evle7hxuw5br9cw/play.png?raw=1");
            Image img = java.awt.Toolkit.getDefaultToolkit().createImage(url);
            elegirBBDD.setIcon(new ImageIcon(img));
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        elegirBBDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elegirBBDDActionPerformed(evt);
            }
        });

        salir.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        try{
            URL url = new URL("https://www.dropbox.com/s/iyegq1j56pdiio7/exit.png?raw=1");
            Image img = java.awt.Toolkit.getDefaultToolkit().createImage(url);
            salir.setIcon(new ImageIcon(img));
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        testOnline.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        testOnline.setText("Test Online");
        testOnline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testOnlineActionPerformed(evt);
            }
        });

        modoOscuro.putClientProperty("JButton.buttonType", "roundRect");
        modoOscuro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modoOscuroActionPerformed(evt);
            }
        });

        verOtros.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        verOtros.setText("Ver Tests anteriores");
        verOtros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verOtrosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(salir)
                    .addComponent(elegirBBDD, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(200, 200, 200))
            .addGroup(layout.createSequentialGroup()
                .addComponent(testOnline)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(modoOscuro))
            .addComponent(verOtros, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {elegirBBDD, salir});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(testOnline)
                    .addComponent(modoOscuro))
                .addGap(116, 116, 116)
                .addComponent(elegirBBDD, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116)
                .addComponent(verOtros))
        );

        try{
            URL url = new URL("https://www.dropbox.com/s/aywzylrqwn9a2nd/moon.png?raw=1");
            Image img = java.awt.Toolkit.getDefaultToolkit().createImage(url);//ImageIO.read(url);
            modoOscuro.setIcon(new ImageIcon(img));
        }
        catch(Exception ex){
            ex.printStackTrace();
            modoOscuro.setText("Modo oscuro");
        }

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Metodo que devuelve el icono de la aplicación, cada constructor de jframes requiere del icono, sacado de esta clase
     * @return 
     */
    @Override
    public Image getIconImage() {
        URL imageResource = Main.class.getClassLoader().getResource("icono.png");
        Image retValue = Toolkit.getDefaultToolkit().getImage(imageResource);
        return retValue;
    }
    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void elegirBBDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elegirBBDDActionPerformed
        try {
            JFileChooser fc = new JFileChooser();
            fc.setFileFilter(new FileNameExtensionFilter("Test de conducir *.tdc", "tdc"));
            int returnVal = fc.showOpenDialog(PantallaPrincipal.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                lanzarTest(file, false);
            }
        } catch (HeadlessException ex) {
            System.out.println("Revisa la conexion a internet");
        }

    }//GEN-LAST:event_elegirBBDDActionPerformed

    private void testOnlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testOnlineActionPerformed
        File fil = null;
        lanzarTest(fil, true);

    }//GEN-LAST:event_testOnlineActionPerformed
    /**
     * Pone la aplicación en modo oscuro, ideal para tus ojitos por la noche
     */
    public void modoOscuro() {
        oscuro = !oscuro;
        try {
            if (oscuro) {
                UIManager.setLookAndFeel(new com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme());
            } else {
                UIManager.setLookAndFeel(new com.formdev.flatlaf.intellijthemes.FlatArcDarkOrangeIJTheme());
            }
            SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void modoOscuroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modoOscuroActionPerformed
        modoOscuro();
    }//GEN-LAST:event_modoOscuroActionPerformed

    private void verOtrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verOtrosActionPerformed
        JFileChooser fc = new JFileChooser();
        JFrame.setDefaultLookAndFeelDecorated(true);
        fc.setFileFilter(new FileNameExtensionFilter("Fin de test *.fdt", "fdt"));
        int returnVal = fc.showOpenDialog(PantallaPrincipal.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            PantallaResultados pr = new PantallaResultados(file, iconoApp);
            pr.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_verOtrosActionPerformed
    
    /**
     * Metodo que lanza el test
     * @param file si tiene fichero es offline
     * @param online si esta online, conecta a una base de datos
     */
    public void lanzarTest(File file, boolean online) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        try {
            PantallaTest test = new PantallaTest(file, online, iconoApp);
            test.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede acceder a la base de datos. Quizas esten los puertos cerrados", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PantallaPrincipal pantallaPrincipal = new PantallaPrincipal();
                pantallaPrincipal.setVisible(true);
                pantallaPrincipal.modoOscuro();

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton elegirBBDD;
    private javax.swing.JButton modoOscuro;
    private javax.swing.JButton salir;
    private javax.swing.JButton testOnline;
    private javax.swing.JButton verOtros;
    // End of variables declaration//GEN-END:variables
}
