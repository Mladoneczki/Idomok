/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package idomok;

import modell.Gomb;
import modell.Idom;
import modell.NegyszogletuHasab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vivcs
 */
public class Idomok {

    private ArrayList<Idom> idomok = new ArrayList();

    public void addIdom(Idom idom) {
        idomok.add(idom);
    }

    public double osszSuly(List<? extends Idom> lista) {
        double suly = 0;
        for (Idom idom : lista) {
            suly += idom.suly();
        }
        return suly;
    }

    private <T> ArrayList<T> idomKivalogat(Class<T> tipus) {
        ArrayList<T> kivalogatott = new ArrayList<>();
        for (Idom idom : idomok) {
            if (tipus.isInstance(idom)) {
                kivalogatott.add(tipus.cast(idom));
            }
        }
        return kivalogatott;
    }

    public double gombokSulya() {
        return osszSuly(idomKivalogat(Gomb.class));
    }

    public void legnagyobbTerfogat() {
        Idom legnagyobb = idomok.get(0);
        for (Idom idom : idomok) {
            if (legnagyobb.terfogat() < idom.terfogat()) {
                legnagyobb = idom;
            }

        }
        System.out.println("Legnagyobb térfogatú idom: " + legnagyobb.toString() + ", térfogata: " + legnagyobb.terfogat());

    }

    public void legkisebbTerfogat() {
        Idom legkisebb = idomok.get(0);
        for (Idom idom : idomok) {
            if (legkisebb.terfogat() > idom.terfogat()) {
                legkisebb = idom;
            }

        }
        System.out.println("Legkisebb térfogatú idom: " + legkisebb.toString() + ", térfogata: " + legkisebb.terfogat());
    }

    public void gombokSugarSzerint() {
        ArrayList<Double> sugarak = new ArrayList<>();
        for (Gomb gomb : idomKivalogat(Gomb.class)) {
            if (!sugarak.contains(gomb.getSugar())) {
                sugarak.add(gomb.getSugar());
            }
        }
        System.out.println("A különböző sugarak száma: " + sugarak.size() + "; A sugarak: " + sugarak.toString());
    }

    public void hasabAlapteruletSzerint() {
        Map<Double, Integer> alapteruletCsoportok = new HashMap<>();

        for (NegyszogletuHasab hasab : idomKivalogat(NegyszogletuHasab.class)) {
            double alapterulet = Math.round(hasab.alapterulet() * 100.0) / 100.0;
            alapteruletCsoportok.put(alapterulet, alapteruletCsoportok.getOrDefault(alapterulet, 0) + 1);
        }

        for (Map.Entry<Double, Integer> entry : alapteruletCsoportok.entrySet()) {
            System.out.println("T:" + entry.getKey() + " -> " + entry.getValue() + " db");
        }
    }

    public void kiIr(Idom idom) {
       System.out.println(idom.toString());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Idomok idomKezelo = new Idomok();

        Gomb gomb1 = new Gomb(3);
        Gomb gomb2 = new Gomb(4);
        Gomb gomb3 = new Gomb(3);

        NegyszogletuHasab hasab1 = new NegyszogletuHasab(2, 3, 4);
        NegyszogletuHasab hasab2 = new NegyszogletuHasab(4, 1.5, 6);
        NegyszogletuHasab hasab3 = new NegyszogletuHasab(2.2, 3.2, 4);
        NegyszogletuHasab hasab4 = new NegyszogletuHasab(2, 3, 6);
        NegyszogletuHasab hasab5 = new NegyszogletuHasab(2, 3, 2);
        NegyszogletuHasab hasab6 = new NegyszogletuHasab(4, 1.5, 12);

        idomKezelo.addIdom(gomb1);
        idomKezelo.addIdom(gomb2);
        idomKezelo.addIdom(gomb3);
        idomKezelo.addIdom(hasab1);
        idomKezelo.addIdom(hasab2);
        idomKezelo.addIdom(hasab3);
        idomKezelo.addIdom(hasab4);
        idomKezelo.addIdom(hasab5);
        idomKezelo.addIdom(hasab6);

        System.out.println("Gombok összsúlya: " + idomKezelo.gombokSulya());

        idomKezelo.legkisebbTerfogat();
        idomKezelo.legnagyobbTerfogat();

        idomKezelo.gombokSugarSzerint();

        idomKezelo.hasabAlapteruletSzerint();
        
        idomKezelo.kiIr(hasab3);
    }
}
