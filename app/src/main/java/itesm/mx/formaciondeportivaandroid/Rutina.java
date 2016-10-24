package itesm.mx.formaciondeportivaandroid;

import java.util.ArrayList;

/**
 * Created by armando on 22/10/2016.
 */
public class Rutina {
    private String sNombre;
    private ArrayList<Ejercicio> sEjercicio;
    private int idFotoR;

    public Rutina(String sNombre, ArrayList<Ejercicio> sEjercicio, int idFotoR) {
        this.sNombre = sNombre;
        this.sEjercicio = sEjercicio;
        this.idFotoR = idFotoR;
    }

    public String getsNombre() {
        return sNombre;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public ArrayList<Ejercicio> getsEjercicio() {
        return sEjercicio;
    }

    public void setsEjercicio(ArrayList<Ejercicio> sEjercicio) {
        this.sEjercicio = sEjercicio;
    }

    public int getIdFotoR() {
        return idFotoR;
    }

    public void setIdFotoR(int idFotoR) {
        this.idFotoR = idFotoR;
    }
}