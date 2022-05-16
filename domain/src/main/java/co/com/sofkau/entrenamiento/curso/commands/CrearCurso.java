package co.com.sofkau.entrenamiento.curso.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.entrenamiento.curso.values.CursoId;
import co.com.sofkau.entrenamiento.curso.values.Descripcion;
import co.com.sofkau.entrenamiento.curso.values.Nombre;

public class CrearCurso extends Command {
    private final CursoId coursoId;
    private final Nombre nombre;
    private final Descripcion descripcion;


    public CrearCurso(CursoId coursoId, Nombre nombre, Descripcion descripcion) {
        this.coursoId = coursoId;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public CursoId getCoursoId() {
        return coursoId;
    }
}
