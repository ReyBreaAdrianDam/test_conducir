/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrian.rey.brea.test_conducir;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adrir
 */
public class ConexionBDPreguntas {
    ArrayList<Pregunta> preguntas;
    public ConexionBDPreguntas(File file) throws ClassNotFoundException, SQLException{
        preguntas = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        Connection cn = DriverManager.getConnection("jdbc:sqlite:" + file.getAbsolutePath(), "", "");
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("SELECT pregunta, enlace, id_pregunta from Preguntas");
        while(rs.next()){
            String pregunta = rs.getString(1);
            String enlace = rs.getString(2);
            try {
                preguntas.add(new Pregunta(enlace, pregunta, null, null, null, null));
            } catch (IOException ex) {
                Logger.getLogger(ConexionBDPreguntas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        for (Pregunta pregunta : preguntas){
            ArrayList<Respuesta> respuestas = new ArrayList<>();
            String preg = pregunta.getPregunta();
            rs = st.executeQuery("SELECT respuesta, verdadera from preguntas,"
                    + " respuestas where preguntas.id_pregunta = respuestas.id_pregunta and preguntas.pregunta = '" + preg + "'");
            while(rs.next()){
                respuestas.add(new Respuesta(rs.getString(1), rs.getBoolean(2)));
            }
            Collections.shuffle(respuestas);
            try{
                pregunta.setR1(respuestas.get(0));
                pregunta.setR2(respuestas.get(1));
                pregunta.setR3(respuestas.get(2));
                pregunta.setR4(respuestas.get(3));
            }
            catch(IndexOutOfBoundsException ex){
//                int numerorespuesta = st.executeQuery("select count(*) from respuestas").getInt(1);
//                int numeropregunta = st.executeQuery(
//                        "select preguntas.id_pregunta from preguntas, respuestas"
//                        + " where preguntas.id_pregunta = respuestas.id_pregunta"
//                        + " group by preguntas.id_pregunta order by preguntas.id_pregunta desc limit 1").getInt(1) + 1;
//                System.out.println("Si estas aqui es porque la pregunta nº " + numeropregunta +
//                       " :" + pregunta.getPregunta() + " no tiene respuestas");
//                
//                Scanner sc = new Scanner(System.in);
//                
//                for(int i = 1; i <= 4; i++){
//                    numerorespuesta++;
//                    System.out.print("Introduce la respuesta: " + numerorespuesta + " >> ");
//                    String respuesta = sc.nextLine();
//                    System.out.print("¿Es verdadera? >> ");
//                    Boolean verdadera = Boolean.parseBoolean(sc.nextLine());
//                    st.execute(String.format("INSERT INTO respuestas values(%d, '%s', %b, %d)", numerorespuesta, respuesta, verdadera, numeropregunta));
//                    
//                }
//                pregunta.setR1(new Respuesta("true", true));
//                pregunta.setR2(new Respuesta("false", false));
//                pregunta.setR3(new Respuesta("false", false));
//                pregunta.setR4(new Respuesta("false", false));
            }
        }
    }

    public ArrayList<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(ArrayList<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }
}

