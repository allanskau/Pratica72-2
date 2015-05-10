/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.ct.dainf.if62c.pratica;

import java.io.Serializable;

/**
 *
 * @author allan
 */
public abstract class Elipse implements FiguraComEixos, Serializable {

    private double eixo_maior;
    private double eixo_menor;
    
    public Elipse() {
    }

    public Elipse(double eixo_maior, double eixo_menor) {
        this.eixo_maior = eixo_maior;
        this.eixo_menor = eixo_menor;
    }
    
    public double getEixoMaior(){
        
    }
    
}
