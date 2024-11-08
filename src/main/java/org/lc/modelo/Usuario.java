package org.lc.modelo;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Usuario {
      protected Long id;
      protected String nombre;
      protected String nomUsuario;
      protected String email;
      protected Date fechaNacimiento;
      protected String password;
      protected String animal;

    public Usuario(Long id, String nombre, String nomUsuario, String email, Date fechaNacimiento, String password, String animal) {
        this.id = id;
        this.nombre = nombre;
        this.nomUsuario = nomUsuario;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.password = password;
        this.animal = animal;

    }

    public Usuario() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
         return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }


}
