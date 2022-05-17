package co.com.sofkau.entrenamento.curso;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.entrenamiento.curso.commands.AgregarMentoria;
import co.com.sofkau.entrenamiento.curso.events.CursoCreado;
import co.com.sofkau.entrenamiento.curso.events.MentoriaCreada;
import co.com.sofkau.entrenamiento.curso.values.CursoId;
import co.com.sofkau.entrenamiento.curso.values.Descripcion;
import co.com.sofkau.entrenamiento.programa.values.ProgramaId;
import co.com.sofkau.generic.values.Fecha;
import co.com.sofkau.generic.values.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AgregarMentoriaUseCaseTest {

    @InjectMocks
    private AgregarMentoriaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarUnaMentoriaHappyPass(){
        //arrange
        var coursoId = CursoId.of("ddddd");
        var nombre = new Nombre("Aprendiendo de casos de usos");
        var fecha = new Fecha(LocalDateTime.now(), LocalDate.now());
        var command = new AgregarMentoria( coursoId,  nombre,  fecha);

        when(repository.getEventsBy("ddddd")).thenReturn(history());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getCoursoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (MentoriaCreada)events.get(0);
        Assertions.assertEquals("Aprendiendo de casos de usos", event.getNombre().value());

    }

    private List<DomainEvent> history() {
        var nombre = new Nombre("DDD");
        var programaId = ProgramaId.of("dddd");
        var descripcion = new Descripcion("Curso complementario para el training");
        var event = new CursoCreado(
                nombre,
                descripcion,
                programaId);
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }

}