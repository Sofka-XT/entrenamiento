package co.com.sofkau.entrenamiento.curso.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.entrenamiento.curso.values.Descripcion;
import co.com.sofkau.entrenamiento.curso.values.Nombre;

public class CursoCreado extends DomainEvent {
    private final Nombre nombre;
    private final Descripcion descripcion;

    public CursoCreado(Nombre nombre, Descripcion descripcion) {
        super("co.com.sofkau.entrenamiento.CursoCreado");
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
