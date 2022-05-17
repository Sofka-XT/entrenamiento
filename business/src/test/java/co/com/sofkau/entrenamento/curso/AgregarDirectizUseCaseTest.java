package co.com.sofkau.entrenamento.curso;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.entrenamiento.curso.commands.AgregarDirectriz;
import co.com.sofkau.entrenamiento.curso.events.CursoCreado;
import co.com.sofkau.entrenamiento.curso.events.DirectriceAgregadaAMentoria;
import co.com.sofkau.entrenamiento.curso.events.DirectrizAgregadasAMentoria;
import co.com.sofkau.entrenamiento.curso.events.MentoriaCreada;
import co.com.sofkau.entrenamiento.curso.values.*;
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
class AgregarDirectizUseCaseTest {

    @InjectMocks
    private AgregarDirectizUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarDirectrizHappyPass() {
        CursoId cursoId = CursoId.of("asdasd");
        MentoriaId mentoriaId = MentoriaId.of("asdasd");
        Directriz directiz = new Directriz("Trabajar en equipo");
        var command = new AgregarDirectriz(cursoId, mentoriaId, directiz);

        when(repository.getEventsBy("asdasd")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        var event = (DirectrizAgregadasAMentoria) events.get(0);
        Assertions.assertEquals(1, event.getDirectricesFactory().directrices().size());
    }


    @Test
    void agregarDirectrizSadPass() {
        CursoId cursoId = CursoId.of("asdasd");
        MentoriaId mentoriaId = MentoriaId.of("asdasd");
        Directriz directiz = new Directriz("Trabajar en equipo");
        var command = new AgregarDirectriz(cursoId, mentoriaId, directiz);

        when(repository.getEventsBy("asdasd")).thenReturn(history2());
        useCase.addRepository(repository);

        var messnage = Assertions.assertThrows(BusinessException.class, () -> {
           UseCaseHandler.getInstance()
                    .syncExecutor(useCase, new RequestCommand<>(command))
                    .orElseThrow()
                    .getDomainEvents();
        });

        Assertions.assertEquals( "No puede tener mas de 4 directrices", messnage.getMessage());

    }

    private List<DomainEvent> history() {
        Nombre nombre = new Nombre("DDD");
        ProgramaId programaId = ProgramaId.of("ffff");
        Descripcion descripcion = new Descripcion("Curso complementario para el training");
        return List.of(new CursoCreado(
                nombre,
                descripcion,
                programaId), new MentoriaCreada(
                MentoriaId.of("asdasd"),
                new Nombre("Practica de DDD"),
                new Fecha(LocalDateTime.now(), LocalDate.now())
        ));
    }

    private List<DomainEvent> history2() {
        Nombre nombre = new Nombre("DDD");
        ProgramaId programaId = ProgramaId.of("ffff");
        Descripcion descripcion = new Descripcion("Curso complementario para el training");
        return List.of(new CursoCreado(
                        nombre,
                        descripcion,
                        programaId), new MentoriaCreada(
                        MentoriaId.of("asdasd"),
                        new Nombre("Practica de DDD"),
                        new Fecha(LocalDateTime.now(), LocalDate.now())
                ), new DirectriceAgregadaAMentoria(
                        MentoriaId.of("asdasd"),
                        new Directriz("Practica de DDD # 1")
                ),
                new DirectriceAgregadaAMentoria(
                        MentoriaId.of("asdasd"),
                        new Directriz("Practica de DDD # 2")
                ), new DirectriceAgregadaAMentoria(
                        MentoriaId.of("asdasd"),
                        new Directriz("Practica de DDD # 3")
                ), new DirectriceAgregadaAMentoria(
                        MentoriaId.of("asdasd"),
                        new Directriz("Practica de DDD # 4")
                ));
    }

}