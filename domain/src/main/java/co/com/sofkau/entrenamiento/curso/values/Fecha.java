package co.com.sofkau.entrenamiento.curso.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Fecha implements ValueObject<Fecha.Pros> {
    private final LocalDateTime hora;
    private final LocalDate dia;

    public Fecha(LocalDateTime hora, LocalDate dia) {
        //TODO: agregar validaciones (fechas funturas, el dia debe ser de 24)
        this.hora = Objects.requireNonNull(hora);
        this.dia = Objects.requireNonNull(dia);
    }

    @Override
    public Pros value() {
        return new Pros() {
            @Override
            public LocalDateTime hora() {
                return hora;
            }

            @Override
            public LocalDate dia() {
                return dia;
            }
        };
    }

    public interface Pros {
        LocalDateTime hora();
        LocalDate dia();
    }
}
