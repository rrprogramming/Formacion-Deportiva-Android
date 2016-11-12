package itesm.mx.formaciondeportivaandroid;

/*
* Copyright (c) 2016, Instituto Tecnológico y de Estudios Superiores de Monterrey, México. Derechos reservados.
* DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see <http://www.gnu.org/licenses.
*/

public class Ejercicio {
    private long id;
    private long idRutina;
    private String sNombreEjer;
    private String sTipoEjer;
    private String sMusculo;
    private int iSeries;
    private int iRepeticiones;
    private int idFotoE;
    private String diaFin;

    public Ejercicio() {
        this.sNombreEjer = null;
        this.sTipoEjer = null;
        this.sMusculo = null;
        this.iSeries = 0;
        this.iRepeticiones = 0;
        this.idFotoE = -1;
        this.diaFin = null;
        this.idRutina = -1;
    }

    public Ejercicio(long idRutina, String sNombreEjer, String sTipoEjer, String sMusculo, int iSeries, int iRepeticiones, int idFotoE, String diaFin) {
        this.idRutina = idRutina;
        this.sNombreEjer = sNombreEjer;
        this.sTipoEjer = sTipoEjer;
        this.sMusculo = sMusculo;
        this.iSeries = iSeries;
        this.iRepeticiones = iRepeticiones;
        this.idFotoE = idFotoE;
        this.diaFin = diaFin;
    }

    public Ejercicio(long id, long idRutina, String sNombreEjer, String sTipoEjer, String sMusculo, int iSeries, int iRepeticiones, int idFotoE, String diaFin) {
        this.id = id;
        this.idRutina = idRutina;
        this.sNombreEjer = sNombreEjer;
        this.sTipoEjer = sTipoEjer;
        this.sMusculo = sMusculo;
        this.iSeries = iSeries;
        this.iRepeticiones = iRepeticiones;
        this.idFotoE = idFotoE;
        this.diaFin = diaFin;
    }

    public long getId(){
        return this.id;
    }

    public void setId(long id){
        this.id = id;
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

    public String getsTipoEjer(){
        return this.sTipoEjer;
    }

    public void setsTipoEjer(String tipoEjer){
        this.sTipoEjer = tipoEjer;
    }

    public String getsMusculo(){
        return this.sMusculo;
    }

    public void setsMusculo(String sMusculo){
        this.sMusculo = sMusculo;
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

    public String getDiaFin(){
        return this.diaFin;
    }

    public void setDiaFin(String diaFin){
        this.diaFin = diaFin;
    }

    public long getIdRutina(){
        return this.idRutina;
    }

    public void setIdRutina(long idRutina){
        this.idRutina = idRutina;
    }

}