/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrian.rey.brea.test_conducir;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;

/**
 *
 * @author adrir
 */
public class PantallaTest extends javax.swing.JFrame {
    ImageIcon imageIcon;
    ArrayList<Pregunta> preguntas;
    int numeroPregunta = 0;
    Pregunta preguntaActual;
    File ficheroTest;
    boolean online;
    /**
     * Creates new form Pantalla_principal
     * @param ficheroTest
     * @param online
     */
    
    public PantallaTest(File ficheroTest, boolean online) throws com.mysql.cj.jdbc.exceptions.CommunicationsException, SQLException , ClassNotFoundException {
        this.online = online;
        this.ficheroTest = ficheroTest;
        preguntas = new ArrayList<>();
        generarPreguntas();
        initComponents();
        mostrarPregunta(numeroPregunta);
        this.dispose();
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //this.setUndecorated(true);
        this.setVisible(true);
    }
    public void mostrarPregunta(int num){
        preguntaPanel.setVisible(false);
        anterior.setEnabled(true);
        labelPreguntasResp.setText("Pregunta: " + (num + 1) + "/" + preguntas.size());
        //Nueva pregunta
        preguntaActual = preguntas.get(num);
        imageIcon = new ImageIcon(preguntaActual.getImg());
        imagenLabel.setIcon(imageIcon);
        preguntaLabel.setText("<html>"+preguntaActual.getPregunta()+"</html>");
        opcionA.setText("<html>"+preguntaActual.getR1().getRespuesta()+"</html>");
        opcionB.setText("<html>"+preguntaActual.getR2().getRespuesta()+"</html>");
        opcionC.setText("<html>"+preguntaActual.getR3().getRespuesta()+"</html>");
        opcionD.setText("<html>"+preguntaActual.getR4().getRespuesta()+"</html>");
        switch(preguntaActual.getRespuestaMarcada()){
            case 1:
                opcionA.setSelected(true);
                break;
            case 2:
                opcionB.setSelected(true);
                break;
            case 3:
                opcionC.setSelected(true);
                break;
            case 4:
                opcionD.setSelected(true);
                break;
            default:  
                opciones.clearSelection();
                break;
        }
        //Borrar despues
//        if(preguntaActual.getR1().isCorrecta())
//            opcionA.setSelected(true);
//        else if(preguntaActual.getR2().isCorrecta())
//            opcionB.setSelected(true);
//        else if(preguntaActual.getR3().isCorrecta())
//            opcionC.setSelected(true);
//        else if(preguntaActual.getR4().isCorrecta())
//            opcionD.setSelected(true);
        if(numeroPregunta == 29 || numeroPregunta + 1 == preguntas.size())
            siguiente.setText("Finalizar");
        else if(numeroPregunta == 0)
            anterior.setEnabled(false);
        else siguiente.setText("Siguiente");
        preguntaPanel.setVisible(true);
    }
    public void generarPreguntas() throws com.mysql.cj.jdbc.exceptions.CommunicationsException, SQLException , ClassNotFoundException{
        
        ConexionBDPreguntas gen = new ConexionBDPreguntas(ficheroTest, online);
        preguntas = gen.getPreguntas();
        Collections.shuffle(preguntas);
    }
    public void mostrarResultados(){
        int respuestas_bien = 0;
        int nPregunta = 1;
        for(Pregunta pregunta: preguntas){
            System.out.println("\n" + nPregunta + "º " + (pregunta.getPregunta()));
            Respuesta rMarcada = null;
            switch(pregunta.getRespuestaMarcada()){
                case 1:
                    if(pregunta.getR1().isCorrecta())
                        respuestas_bien++;
                    rMarcada = pregunta.getR1();
                    break;
                case 2:
                    if(pregunta.getR2().isCorrecta())
                        respuestas_bien++;
                    rMarcada = pregunta.getR2();
                    break;
                case 3:
                    if(pregunta.getR3().isCorrecta())
                        respuestas_bien++;
                    rMarcada = pregunta.getR3();
                    break;
                case 4:
                    if(pregunta.getR4().isCorrecta())
                        respuestas_bien++;
                    rMarcada = pregunta.getR4();
                    break;
                default:
                    rMarcada = new Respuesta("No has marcado nada", false);
            }
            System.out.println(rMarcada.getRespuesta());
            if(rMarcada.isCorrecta())
                System.out.println("la acertaste");
            else
                System.out.println("la fallaste");
            nPregunta++;
        }
        System.out.println(respuestas_bien);
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        opciones = new javax.swing.ButtonGroup();
        dialogoSalida = new javax.swing.JDialog();
        jTextSalir = new javax.swing.JLabel();
        confirmarSalida = new javax.swing.JButton();
        rechazarSalida = new javax.swing.JButton();
        dialogoResultados = new javax.swing.JDialog();
        preguntaPanel = new javax.swing.JPanel();
        imagenLabel = new javax.swing.JLabel(imageIcon);
        preguntaLabel = new javax.swing.JLabel();
        respuestasPanel = new javax.swing.JPanel();
        opcionA = new javax.swing.JRadioButton();
        opcionB = new javax.swing.JRadioButton();
        opcionC = new javax.swing.JRadioButton();
        opcionD = new javax.swing.JRadioButton();
        labelOnline = new javax.swing.JLabel();
        siguiente = new javax.swing.JButton();
        anterior = new javax.swing.JButton();
        botonSalida = new javax.swing.JButton();
        labelPreguntasResp = new javax.swing.JLabel();

        dialogoSalida.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        dialogoSalida.setMinimumSize(new java.awt.Dimension(400, 300));
        dialogoSalida.setUndecorated(true);
        dialogoSalida.setResizable(false);
        dialogoSalida.setSize(new java.awt.Dimension(0, 0));
        dialogoSalida.setType(java.awt.Window.Type.POPUP);
        dialogoSalida.setLocationRelativeTo(this);

        jTextSalir.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTextSalir.setText("¿Desea realmente salir del test?");
        jTextSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        confirmarSalida.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        confirmarSalida.setText("Si");
        confirmarSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarSalidaActionPerformed(evt);
            }
        });

        rechazarSalida.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rechazarSalida.setText("No");
        rechazarSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechazarSalidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogoSalidaLayout = new javax.swing.GroupLayout(dialogoSalida.getContentPane());
        dialogoSalida.getContentPane().setLayout(dialogoSalidaLayout);
        dialogoSalidaLayout.setHorizontalGroup(
            dialogoSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogoSalidaLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(rechazarSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(confirmarSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        dialogoSalidaLayout.setVerticalGroup(
            dialogoSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogoSalidaLayout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addComponent(jTextSalir)
                .addGap(40, 40, 40)
                .addGroup(dialogoSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmarSalida)
                    .addComponent(rechazarSalida))
                .addGap(77, 77, 77))
        );

        javax.swing.GroupLayout dialogoResultadosLayout = new javax.swing.GroupLayout(dialogoResultados.getContentPane());
        dialogoResultados.getContentPane().setLayout(dialogoResultadosLayout);
        dialogoResultadosLayout.setHorizontalGroup(
            dialogoResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 983, Short.MAX_VALUE)
        );
        dialogoResultadosLayout.setVerticalGroup(
            dialogoResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Test conducción");
        setMinimumSize(new java.awt.Dimension(1600, 900));

        imagenLabel.setBounds(30,30,100,100);

        preguntaLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        preguntaLabel.setText("Esto es una pregunta, respondeme");
        preguntaLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        respuestasPanel.setLayout(new java.awt.GridLayout(4, 1));

        opcionA.setFont(new java.awt.Font("Segoe UI Light", 0, 32)); // NOI18N
        opcionA.setText("opcionA");
        opciones.add(opcionA);
        opcionA.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                opcionAStateChanged(evt);
            }
        });
        respuestasPanel.add(opcionA);

        opcionB.setFont(new java.awt.Font("Segoe UI Light", 0, 32)); // NOI18N
        opcionB.setText("opcionB");
        opciones.add(opcionB);
        opcionB.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                opcionBStateChanged(evt);
            }
        });
        respuestasPanel.add(opcionB);

        opcionC.setFont(new java.awt.Font("Segoe UI Light", 0, 32)); // NOI18N
        opcionC.setText("opcionC");
        opciones.add(opcionC);
        opcionC.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                opcionCStateChanged(evt);
            }
        });
        respuestasPanel.add(opcionC);

        opcionD.setFont(new java.awt.Font("Segoe UI Light", 0, 32)); // NOI18N
        opcionD.setText("opcionD");
        opciones.add(opcionD);
        opcionD.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                opcionDStateChanged(evt);
            }
        });
        respuestasPanel.add(opcionD);

        labelOnline.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelOnline.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        String modo;
        if(online)
        modo = "Online";
        else
        modo = "Offline";
        labelOnline.setText(modo);

        javax.swing.GroupLayout preguntaPanelLayout = new javax.swing.GroupLayout(preguntaPanel);
        preguntaPanel.setLayout(preguntaPanelLayout);
        preguntaPanelLayout.setHorizontalGroup(
            preguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, preguntaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(preguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(preguntaPanelLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(preguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(preguntaPanelLayout.createSequentialGroup()
                                .addComponent(respuestasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 49, Short.MAX_VALUE))
                            .addComponent(preguntaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(preguntaPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelOnline, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        preguntaPanelLayout.setVerticalGroup(
            preguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(preguntaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(preguntaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(preguntaPanelLayout.createSequentialGroup()
                        .addComponent(labelOnline, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(preguntaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(respuestasPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE))
                    .addGroup(preguntaPanelLayout.createSequentialGroup()
                        .addComponent(imagenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        siguiente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        siguiente.setText("Siguiente");
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });

        anterior.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        anterior.setText("Anterior");
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });

        botonSalida.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonSalida.setText("Salir");
        botonSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalidaActionPerformed(evt);
            }
        });

        labelPreguntasResp.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelPreguntasResp.setText("Pregunta: 0/30");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(preguntaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1214, Short.MAX_VALUE)
                                .addComponent(labelPreguntasResp, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(preguntaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(33, 33, 33)
                .addComponent(siguiente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(anterior)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonSalida)
                    .addComponent(labelPreguntasResp))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
        // TODO add your handling code here:

        if(siguiente.getText().equals("Siguiente")){
            numeroPregunta++;
            mostrarPregunta(numeroPregunta);
        }
        else{
            dialogoSalida.setVisible(true);
            this.setEnabled(false);
        }
        
        
    }//GEN-LAST:event_siguienteActionPerformed

    private void rechazarSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechazarSalidaActionPerformed
        // TODO add your handling code here:
        this.setEnabled(true);
        dialogoSalida.dispose();
    }//GEN-LAST:event_rechazarSalidaActionPerformed

    private void botonSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalidaActionPerformed
        // TODO add your handling code here:
        dialogoSalida.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_botonSalidaActionPerformed

    private void confirmarSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarSalidaActionPerformed
        // TODO add your handling code here:
        dialogoSalida.dispose();
        this.dispose();
        mostrarResultados();
    }//GEN-LAST:event_confirmarSalidaActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        if(numeroPregunta > 0){
            numeroPregunta--;
            mostrarPregunta(numeroPregunta);
            
        }
    }//GEN-LAST:event_anteriorActionPerformed

    private void opcionAStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_opcionAStateChanged
        if(opcionA.isSelected())
                preguntaActual.setRespuestaMarcada(1);
    }//GEN-LAST:event_opcionAStateChanged

    private void opcionBStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_opcionBStateChanged
        if(opcionB.isSelected())
                preguntaActual.setRespuestaMarcada(2);
        
    }//GEN-LAST:event_opcionBStateChanged

    private void opcionCStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_opcionCStateChanged
        if(opcionC.isSelected())
                preguntaActual.setRespuestaMarcada(3);
        
    }//GEN-LAST:event_opcionCStateChanged

    private void opcionDStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_opcionDStateChanged
        if(opcionD.isSelected())
                preguntaActual.setRespuestaMarcada(4);
        
    }//GEN-LAST:event_opcionDStateChanged

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]){
//        
//       
//        try {
//            UIManager.setLookAndFeel(new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubContrastIJTheme());
//            //</editor-fold>
//        } catch (UnsupportedLookAndFeelException ex) {
//            Logger.getLogger(Pantalla_principal.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new Pantalla_principal().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anterior;
    private javax.swing.JButton botonSalida;
    private javax.swing.JButton confirmarSalida;
    private javax.swing.JDialog dialogoResultados;
    private javax.swing.JDialog dialogoSalida;
    private javax.swing.JLabel imagenLabel;
    private javax.swing.JLabel jTextSalir;
    private javax.swing.JLabel labelOnline;
    private javax.swing.JLabel labelPreguntasResp;
    private javax.swing.JRadioButton opcionA;
    private javax.swing.JRadioButton opcionB;
    private javax.swing.JRadioButton opcionC;
    private javax.swing.JRadioButton opcionD;
    private javax.swing.ButtonGroup opciones;
    private javax.swing.JLabel preguntaLabel;
    private javax.swing.JPanel preguntaPanel;
    private javax.swing.JButton rechazarSalida;
    private javax.swing.JPanel respuestasPanel;
    private javax.swing.JButton siguiente;
    // End of variables declaration//GEN-END:variables
}
