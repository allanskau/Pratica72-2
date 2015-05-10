
import utfpr.ct.dainf.if62c.pratica.Circulo;
import utfpr.ct.dainf.if62c.pratica.Elipse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author allan
 */
public class Pratica42 {
    public static void main(String[] args) {
        Elipse elipse_a = new Elipse(10, 4);
        System.out.println("Area de " + elipse_a + " = " + elipse_a.getArea());
        System.out.println("Perimetor de " + elipse_a + " = " + elipse_a.getPerimetro());
        System.out.println("Eixo maior de " + elipse_a + " = " + elipse_a.getEixoMaior());
        System.out.println("Eixo menor de " + elipse_a + " = " + elipse_a.getEixoMenor());
        
        Circulo circ = new Circulo(9.0);
        System.out.println("Area de " + circ + " = " + circ.getArea());
        System.out.println("Perimetor de " + circ + " = " + circ.getPerimetro());
        System.out.println("Eixo maior de " + circ + " = " + circ.getEixoMaior());
        System.out.println("Eixo menor de " + circ + " = " + circ.getEixoMenor());
    }
}
