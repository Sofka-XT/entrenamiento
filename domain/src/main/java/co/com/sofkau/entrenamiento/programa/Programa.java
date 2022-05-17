package co.com.sofkau.entrenamiento.programa;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.entrenamiento.programa.events.ProgramaCreado;
import co.com.sofkau.entrenamiento.programa.events.PromedioActualizado;
import co.com.sofkau.entrenamiento.programa.values.ProgramaId;
import co.com.sofkau.generic.values.Fecha;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.generic.values.Promedio;

import java.util.List;

public class Programa extends AggregateEvent<ProgramaId> {
    protected Nombre nombre;
    protected Fecha fecha;
    protected Promedio promedio;
    public Programa(ProgramaId id, Nombre nombre, Fecha fecha) {
        super(id);
        appendChange(new ProgramaCreado(nombre, fecha)).apply();
    }

    private Programa(ProgramaId entityId){
        super(entityId);
        subscribe(new ProgramaEventChange(this));
    }


    public static Programa from(ProgramaId entityId, List<DomainEvent> events){
        var programa = new Programa(entityId);
        events.forEach(programa::applyEvent);
        return programa;
    }


    public void actualizarPromedio(Promedio promedio){
        appendChange(new PromedioActualizado(promedio)).apply();
    }


}
