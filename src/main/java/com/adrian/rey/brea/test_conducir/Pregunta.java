/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrian.rey.brea.test_conducir;

import java.awt.Image;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 * Clase pregunta requiere de un parametro String pregunta
 * cuatro parametros preguntas
 * y la imagen del proyecto
 * @author adrir
 */
public class Pregunta implements Serializable{
    private String enlaceImg;
    private String pregunta;
    private Respuesta r1;
    private Respuesta r2;
    private Respuesta r3;
    private Respuesta r4;
    private int respuestaMarcada;
    public Pregunta() {}

    
    
    public Pregunta(String enlaceImg, String pregunta, Respuesta r1, Respuesta r2, Respuesta r3, Respuesta r4){
        respuestaMarcada = -1;
        this.enlaceImg = enlaceImg;
        this.pregunta = pregunta;
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
        this.r4 = r4;
    }
    
    public Pregunta(int respuestaMarcada, String enlaceImg, String pregunta, Respuesta r1, Respuesta r2, Respuesta r3, Respuesta r4) throws MalformedURLException, IOException {
        this.respuestaMarcada = respuestaMarcada;
        this.enlaceImg = enlaceImg;
        this.pregunta = pregunta;
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
        this.r4 = r4;
    }
    
    @Override
    public String toString() {
        return "Pregunta{" + "img=" + enlaceImg + ", pregunta=" + pregunta + ", r1=" + r1 + ", r2=" + r2 + ", r3=" + r3 + ", r4=" + r4 + '}';
    }

    

    

    
    
    //<editor-fold defaultstate="collapsed" desc="Getters">
    //Getters
    public String getPregunta() {
        return pregunta;
    }

    public Respuesta getR1() {
        return r1;
    }

    public Respuesta getR2() {
        return r2;
    }

    public Respuesta getR3() {
        return r3;
    }

    public Respuesta getR4() {
        return r4;
    }
    
    public String getEnlaceImg() {
        return enlaceImg;
    }
    
    public int getRespuestaMarcada() {
        return respuestaMarcada;
    }
    
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Setters">
    /* Setters 
    */
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public void setR1(Respuesta r1) {
        this.r1 = r1;
    }

    public void setR2(Respuesta r2) {
        this.r2 = r2;
    }

    public void setR3(Respuesta r3) {
        this.r3 = r3;
    }

    public void setR4(Respuesta r4) {
        this.r4 = r4;
    }

    public void setEnlaceImg(String enlaceImg) {
        this.enlaceImg = enlaceImg;
    }
    
    
    public void setRespuestaMarcada(int respuestaMarcada) {
        this.respuestaMarcada = respuestaMarcada;
    }
    //</editor-fold>
}
