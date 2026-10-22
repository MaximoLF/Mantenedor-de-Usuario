package com.lorca.maximo.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UsuariosDao {
    /* como se llama el archivo */
    public static final String NOMBRE_ARCHIVO = "usuarios.json";

    /* carpeta */
    private final Path archivo;
    public UsuariosDao() {
        String directorioUsuario = System.getProperty("user.dir");
        this.archivo = Paths.get(directorioUsuario, NOMBRE_ARCHIVO);
        System.out.println(this.archivo);
    }

    /* guardar algo */
    public void guardarNombre(String nombre) {
        try {
            Files.writeString(this.archivo, nombre);
        } catch (IOException ex) {
            System.out.println("No se puede guardar el nombre: " + nombre);
        }
    }
    public String leerNombre() {
        String resultado = "";
        if (!Files.exists(this.archivo)) {
            return "";
        }
        try {
            resultado = Files.readString(this.archivo);
        } catch (IOException ex) {
            System.out.println("No se pudo leer el nombre: ");
        }
        return resultado;
    }
}
