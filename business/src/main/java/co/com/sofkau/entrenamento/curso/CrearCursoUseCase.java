package co.com.sofkau.entrenamento.curso;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.entrenamiento.curso.Curso;
import co.com.sofkau.entrenamiento.curso.commands.CrearCurso;

public class CrearCursoUseCase extends UseCase<RequestCommand<CrearCurso>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearCurso> crearCursoRequestCommand) {
        var command = crearCursoRequestCommand.getCommand();

        var curso = new Curso(command.getCoursoId(), command.getNombre(), command.getDescripcion());

        emit().onResponse(new ResponseEvents(curso.getUncommittedChanges()));
    }
}
