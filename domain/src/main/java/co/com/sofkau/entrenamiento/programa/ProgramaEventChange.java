package co.com.sofkau.entrenamiento.programa;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.entrenamiento.programa.events.ProgramaCreado;
import co.com.sofkau.entrenamiento.programa.events.PromedioActualizado;
import co.com.sofkau.generic.values.Promedio;

public class ProgramaEventChange extends EventChange {
    public ProgramaEventChange(Programa programa) {
        apply((ProgramaCreado event) -> {
            programa.fecha = event.getFecha();
            programa.nombre = event.getNombre();
            programa.promedio = new Promedio(0D);
        });

        apply((PromedioActualizado event) -> {
            programa.promedio = event.getPromedio();
        });
    }
}
