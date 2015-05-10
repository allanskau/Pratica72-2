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
public class Elipse implements FiguraComEixos, Serializable {

    private double eixo_a;
    private double eixo_b;
    
    public Elipse() {
    }

    public Elipse(double eixo_a, double eixo_b) {
        this.eixo_a = eixo_a;
        this.eixo_b = eixo_b;
    }

    public double getEixo_a() {
        return eixo_a;
    }

    public void setEixo_a(double eixo_a) {
        this.eixo_a = eixo_a;
    }

    public double getEixo_b() {
        return eixo_b;
    }

    public void setEixo_b(double eixo_b) {
        this.eixo_b = eixo_b;
    }
///////////////// implementacoes da interface FiguraComEixos ///////////////////      
    @Override
    public double getEixoMaior(){
        if(getEixo_a() > getEixo_b()){
            return getEixo_a();
        }else{
            return getEixo_b();
        }
    }
    
    @Override
    public double getEixoMenor(){
        if(getEixo_a() > getEixo_b()){
            return getEixo_b();
        }else{
            return getEixo_a();
        }
    }
////////////////////////////////////////////////////////////////////////////////
    
//////////////////// implementacoes da interface Figura ////////////////////////
    @Override
    public String getNome() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return getNome();
    }
    
    @Override
    public double getArea() {
        return Math.PI * getEixo_a() * getEixo_b();
    }
    
    @Override
    public double getPerimetro() {
        return Math.PI * ( 3*(getEixo_a()+getEixo_b())
             - Math.sqrt((3*getEixo_a()+getEixo_b())*(getEixo_a()+3*getEixo_b())));
    }
////////////////////////////////////////////////////////////////////////////////
}
    