/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modell;

/**
 *
 * @author vivcs
 */
public abstract class Idom {
     double fajSuly=0.8;
     
     public abstract double terfogat();
     
     public double suly(){
         return terfogat() * fajSuly;
     }
    
}
