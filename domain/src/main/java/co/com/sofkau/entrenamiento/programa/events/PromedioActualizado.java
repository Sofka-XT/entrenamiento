package co.com.sofkau.entrenamiento.programa.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.generic.values.Promedio;

public class PromedioActualizado extends DomainEvent {
    private final Promedio promedio;

    public PromedioActualizado(Promedio promedio) {
        super("co.com.sofkau.entrenamiento.PromedioActualizado");
        this.promedio = promedio;
    }

    public Promedio getPromedio() {
        return promedio;
    }
}
