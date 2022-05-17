package co.com.sofkau.entrenamiento.curso.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class EstadoDeCurso implements ValueObject<EstadoDeCurso.Estados> {

    private final Estados value;

    public EstadoDeCurso(Estados value) {
        this.value = Objects.requireNonNull(value);
    }


    @Override
    public Estados value() {
        return value;
    }

    public enum Estados {
        INICIADO, FINALIZADO, POR_INICIAR
    }
}
