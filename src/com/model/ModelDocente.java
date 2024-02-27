
package com.model;

/**
 *
 * @author elote
 */
public class ModelDocente {

    /**
     * @return the cuenta
     */
    public String getCuenta() {
        return cuenta;
    }

    /**
     * @param cuenta the cuenta to set
     */
    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ModelDocente() {
    }

    public ModelDocente(String cuenta, String nombre, String genero, int edad) {
        this.cuenta = cuenta;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
    }
    
    
    
    private String cuenta;
    private String nombre;
    private String genero;
    private int edad;
}
