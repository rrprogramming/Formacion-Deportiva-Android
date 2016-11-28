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

public class TipoEjercicio {
    private long iId;
    private String sTipo;
    private String sMusculo;
    private int iIdFotoRT;

    public TipoEjercicio(String sTipo,String sMusculo, int iIdFotoRT) {
        this.sTipo = sTipo;
        this.iIdFotoRT = iIdFotoRT;
        this.sMusculo = sMusculo;
    }

    public long getId(){
        return this.iId;
    }

    public void setId(long iId){
        this.iId = iId;
    }

    public String getTipo() {
        return sTipo;
    }

    public void setTipo(String sTipo) {
        this.sTipo = sTipo;
    }

    public int getIdFotoRT() {
        return iIdFotoRT;
    }

    public void setIdFotoRT(int iIdFoto) {
        this.iIdFotoRT = iIdFoto;
    }

    public String getTMusculo() { return sMusculo;}

    public void setTMusculo(String sMusculo) {this.sMusculo = sMusculo;}
}