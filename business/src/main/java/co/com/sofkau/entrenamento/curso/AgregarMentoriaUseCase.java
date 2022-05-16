package co.com.sofkau.entrenamento.curso;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.entrenamiento.curso.Curso;
import co.com.sofkau.entrenamiento.curso.commands.AgregarMentoria;

public class AgregarMentoriaUseCase  extends UseCase<RequestCommand<AgregarMentoria>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarMentoria> agregarMentoriaRequestCommand) {
        var command = agregarMentoriaRequestCommand.getCommand();
        var curso = Curso.from(
                command.getCoursoId(), repository().getEventsBy(command.getCoursoId().value())
        );
        curso.agregarMentoria(command.getNombre(), command.getFecha());

        emit().onResponse(new ResponseEvents(curso.getUncommittedChanges()));

    }
}
