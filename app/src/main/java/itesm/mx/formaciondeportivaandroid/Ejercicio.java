package itesm.mx.formaciondeportivaandroid;

import java.util.ArrayList;

/**
 * Created by armando on 23/10/2016.
 */
public class Ejercicio {
    private String sNombreEjer;
    private int iSeries;
    private int iRepeticiones;
    private int idFotoE;

    public Ejercicio(String sNombreEjer, int iSeries, int iRepeticiones, int idFotoE) {
        this.sNombreEjer = sNombreEjer;
        this.iSeries = iSeries;
        this.iRepeticiones = iRepeticiones;
        this.idFotoE = idFotoE;
    }

    public String getsNombreEjer() {
        return sNombreEjer;
    }

    public void setsNombreEjer(String sNombreEjer) {
        this.sNombreEjer = sNombreEjer;
    }

    public int getiSeries() {
        return iSeries;
    }

    public void setiSeries(int iSeries) {
        this.iSeries = iSeries;
    }

    public int getiRepeticiones() {
        return iRepeticiones;
    }

    public void setiRepeticiones(int iRepeticiones) {
        this.iRepeticiones = iRepeticiones;
    }

    public int getIdFotoE() {
        return idFotoE;
    }

    public void setIdFotoE(int idFotoE) {
        this.idFotoE = idFotoE;
    }
}