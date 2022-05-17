package co.com.sofkau.entrenamento.curso;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.entrenamento.curso.services.ConsultarPromedioDeCurso;
import co.com.sofkau.entrenamiento.curso.Curso;
import co.com.sofkau.entrenamiento.curso.commands.FinalizarCurso;

public class FinalizarCursoUseCase extends UseCase<RequestCommand<FinalizarCurso>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<FinalizarCurso> finalizarCursoRequestCommand) {
        var command = finalizarCursoRequestCommand.getCommand();
        var promedioService = getService(ConsultarPromedioDeCurso.class).orElseThrow();
        var curso = Curso.from(
                command.getCursoId(), repository().getEventsBy(command.getCursoId().value())
        );


        curso.finalizarElCurso(promedioService.consultarPorCursoId(command.getCursoId()));

        emit().onResponse(new ResponseEvents(curso.getUncommittedChanges()));
    }
}
