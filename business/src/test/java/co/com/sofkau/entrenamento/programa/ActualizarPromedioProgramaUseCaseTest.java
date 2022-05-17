package co.com.sofkau.entrenamento.programa;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.entrenamiento.curso.events.CursoCreado;
import co.com.sofkau.entrenamiento.curso.events.CursoFinalizado;
import co.com.sofkau.entrenamiento.curso.values.Descripcion;
import co.com.sofkau.entrenamiento.programa.events.ProgramaCreado;
import co.com.sofkau.entrenamiento.programa.events.PromedioActualizado;
import co.com.sofkau.entrenamiento.programa.values.ProgramaId;
import co.com.sofkau.generic.values.Fecha;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.generic.values.Promedio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarPromedioProgramaUseCaseTest {

    @Mock
    private DomainEventRepository repository;


    @InjectMocks
    private ActualizarPromedioProgramaUseCase useCase;

    @Test
    void actualizarPromedioDelPrograma(){
        var event = new CursoFinalizado(new Promedio(80D), ProgramaId.of("ddddd"));
        when(repository.getEventsBy("ddddd")).thenReturn(history());
        useCase.addRepository(repository);
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var promedioActualizado = (PromedioActualizado)events.get(0);
        Assertions.assertEquals(80D,promedioActualizado.getPromedio().value());
    }

    private List<DomainEvent> history() {
        var nombre = new Nombre("C2");
        var fecha = new Fecha(LocalDateTime.now(), LocalDate.now());
        var event = new ProgramaCreado(nombre,fecha);
        return List.of(event);
    }

}