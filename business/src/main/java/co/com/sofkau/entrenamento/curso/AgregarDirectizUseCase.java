package co.com.sofkau.entrenamento.curso;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.entrenamiento.curso.Curso;
import co.com.sofkau.entrenamiento.curso.DirectricesFactory;
import co.com.sofkau.entrenamiento.curso.commands.AgregarDirectriz;
import co.com.sofkau.entrenamiento.curso.values.Directriz;

public class AgregarDirectizUseCase extends UseCase<RequestCommand<AgregarDirectriz>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarDirectriz> agregarDirectizRequestCommand) {
        var command = agregarDirectizRequestCommand.getCommand();
        var curso = Curso.from(
                command.getCoursoId(), repository().getEventsBy(command.getCoursoId().value())
        );

        if(curso.mentorias().get(command.getMentoriaId()).directrices().size() >=3){
            throw new BusinessException(
                    command.getCoursoId().value(),
                    "No puede tener mas de 4 directrices"
            );
        }


        DirectricesFactory factory = DirectricesFactory.builder()
                .agregarDirectriz(command.getDirectiz());
        curso.agregarDirectricesDeMentoria(command.getMentoriaId(), factory);

        emit().onResponse(new ResponseEvents(curso.getUncommittedChanges()));

    }
}
