/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modell;

/**
 *
 * @author vivcs
 */
public class NegyszogletuHasab extends Idom {
    
    private double a;
    private double b;
    private double m;

    public NegyszogletuHasab(double a, double b, double m) {
        this.a = a;
        this.b = b;
        this.m = m;
    }
    
    public double alapterulet(){
    return (a*b);}
    
    @Override
    public double terfogat() {
    return Math.round(alapterulet() * m * 100.0) / 100.0;
}
@Override
public String toString() {
    return "NegyszogletuHasab [a=" + a + ", b=" + b + ", m=" + m + "]";
}

    
    
    
    
    
}
