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

public class Perfil {
    private long id;
    private String nombre;
    private String matricula;
    private String fechaNacimiento;
    private String genero;
    private byte[] foto;

    public Perfil(){
        this.id = -1;
        this.nombre = null;
        this.matricula = null;
        this.fechaNacimiento = null;
        this.genero = null;
        this.foto = null;
    }

    public Perfil(String nombre, String matricula, String fechaNacimiento, String genero, byte[] foto){
        this.nombre = nombre;
        this.matricula = matricula;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.foto = foto;
    }
    
    public Perfil(long id, String nombre, String matricula, String fechaNacimiento, String genero, byte[] foto){
        this.id = id;
        this.nombre = nombre;
        this.matricula = matricula;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.foto = foto;
    }

    public void setId(long id){
        this.id = id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public void setFechaNacimiento(String fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public void setFoto(byte[] foto){
        this.foto = foto;
    }

    public long getId(){
        return this.id;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getMatricula(){
        return this.matricula;
    }

    public String getFechaNacimiento(){
        return this.fechaNacimiento;
    }

    public String getGenero(){
        return this.genero;
    }

    public byte[] getFoto(){
        return this.foto;
    }

}
