package co.com.sofkau.entrenamento.curso;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.entrenamento.curso.services.ConsultarPromedioDeCurso;
import co.com.sofkau.entrenamiento.curso.events.CursoFinalizado;
import co.com.sofkau.entrenamiento.curso.commands.FinalizarCurso;
import co.com.sofkau.entrenamiento.curso.events.CursoCreado;
import co.com.sofkau.entrenamiento.curso.values.CursoId;
import co.com.sofkau.entrenamiento.curso.values.Descripcion;
import co.com.sofkau.entrenamiento.programa.values.ProgramaId;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.generic.values.Promedio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FinalizarCursoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Mock
    private ConsultarPromedioDeCurso service;

    @InjectMocks
    private FinalizarCursoUseCase useCase;

    @Test
    void finalizarCurso(){
        var programaId = ProgramaId.of("dddd");
        var command = new FinalizarCurso(CursoId.of("wwwww"), programaId);
        when(repository.getEventsBy("wwwww")).thenReturn(history());
        when(service.consultarPorCursoId(any(CursoId.class))).thenReturn(new Promedio(75D));
        useCase.addRepository(repository);
        useCase.addServiceBuilder(new ServiceBuilder().addService(service));

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (CursoFinalizado)events.get(0);
        Assertions.assertEquals(75D, event.getPromedio().value());
    }

    private List<DomainEvent> history() {
        var nombre = new Nombre("DDD");
        var programaId = ProgramaId.of("dddd");
        var descripcion = new Descripcion("Curso complementario para el training");
        var event = new CursoCreado(
                nombre,
                descripcion,
                programaId);
        return List.of(event);
    }
}