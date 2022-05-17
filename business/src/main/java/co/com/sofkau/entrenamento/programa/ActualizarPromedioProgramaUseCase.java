package co.com.sofkau.entrenamento.programa;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofkau.entrenamiento.curso.events.CursoFinalizado;
import co.com.sofkau.entrenamiento.programa.Programa;

public class ActualizarPromedioProgramaUseCase extends UseCase<TriggeredEvent<CursoFinalizado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<CursoFinalizado> cursoFinalizadoTriggeredEvent) {
        var event = cursoFinalizadoTriggeredEvent.getDomainEvent();
        var programa = Programa.from(
                event.getProgramaId(),
                repository().getEventsBy(event.getProgramaId().value())
        );

        programa.actualizarPromedio(event.getPromedio());

        emit().onResponse(new ResponseEvents(programa.getUncommittedChanges()));
    }
}
