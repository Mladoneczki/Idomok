/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modell;

import modell.Idom;

/**
 *
 * @author vivcs
 */
public class Gomb extends Idom {
    
    private double sugar;

    public Gomb(double sugar) {
        this.sugar = sugar;
    }

    public double getSugar() {
        return sugar;
    }

   
    
    @Override
  public double terfogat() {
    return Math.round((4.0 * Math.pow(sugar, 3) * Math.PI) / 3 * 100.0) / 100.0;
}

    @Override
public String toString() {
    return "Gomb [sugár=" + sugar + "]";
}

    
}
