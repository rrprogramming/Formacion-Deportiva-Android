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
    private long id;
    private String tipo;
    private String musculo;
    private int idFotoRT;

    public TipoEjercicio() {
        this.id = -1;
        this.tipo = null;
        this.musculo = null;
        this.idFotoRT = -1;
    }

    public TipoEjercicio(String tipo,String musculo, int idFotoRT) {
        this.tipo = tipo;
        this.idFotoRT = idFotoRT;
        this.musculo = musculo;
    }

    public TipoEjercicio(long id, String tipo,String musculo, int idFotoRT) {
        this.id = id;
        this.tipo = tipo;
        this.idFotoRT = idFotoRT;
        this.musculo = musculo;
    }

    public long getId(){
        return this.id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdFotoRT() {
        return idFotoRT;
    }

    public void setIdFotoRT(int idFoto) {
        this.idFotoRT = idFoto;
    }

    public String getTMusculo() { return musculo;}

    public void setTMusculo(String musculo) {this.musculo = musculo;}
}