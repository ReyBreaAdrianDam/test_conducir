/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test_conducir;

/**
 *
 * @author adrir
 */
class Respuesta {
    private String respuesta;
    private boolean correcta;
    
    public Respuesta(){
        
    }
    public Respuesta(String respuesta, boolean correcta){
        this.respuesta = respuesta;
        this.correcta = correcta;
    }
    //<editor-fold defaultstate="collapsed" desc="Getters">
    public String getRespuesta() {
        return respuesta;
    }

    public boolean isCorrecta() {
        return correcta;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Setters">
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public void setCorrecta(boolean correcta) {
        this.correcta = correcta;
    }
    //</editor-fold>
}
