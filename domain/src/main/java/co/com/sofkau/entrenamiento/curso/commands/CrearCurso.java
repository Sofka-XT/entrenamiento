package co.com.sofkau.entrenamiento.curso.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.entrenamiento.curso.values.CursoId;
import co.com.sofkau.entrenamiento.curso.values.Descripcion;
import co.com.sofkau.entrenamiento.programa.values.ProgramaId;
import co.com.sofkau.generic.values.Nombre;

public class CrearCurso extends Command {
    private final CursoId coursoId;
    private final ProgramaId programaId;
    private final Nombre nombre;
    private final Descripcion descripcion;


    public CrearCurso(CursoId coursoId, ProgramaId programaId, Nombre nombre, Descripcion descripcion) {
        this.coursoId = coursoId;
        this.programaId = programaId;
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

    public ProgramaId getProgramaId() {
        return programaId;
    }
}
