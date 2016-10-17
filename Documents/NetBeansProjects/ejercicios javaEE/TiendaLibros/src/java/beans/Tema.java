/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author USUARIO
 */
public class Tema {
    private int idtema;
    private String tema;

    public Tema(int idtema, String tema) {
        this.idtema = idtema;
        this.tema = tema;
    }

    public int getIdtema() {
        return idtema;
    }


    public String getTema() {
        return tema;
    }   
    
}
