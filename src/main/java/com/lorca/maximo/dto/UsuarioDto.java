package com.lorca.maximo.dto;
import java.time.LocalDateTime;

public class UsuarioDto {
    private String nombre;
    private String contrasena;
    private String correo;
    private Integer edad;
    private Integer id;
    private LocalDateTime fechaCreacion;


    public UsuarioDto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "UsuarioDto{" +
                ", nombre='" + nombre +
                ", contrasena='" + contrasena + '\'' +
                ", correo='" + correo + '\'' +
                ", edad='" + edad + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
