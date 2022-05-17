package co.com.sofkau.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Promedio implements ValueObject<Double> {
    private final Double value;

    public Promedio(Double value) {
        this.value = Objects.requireNonNull(value);
        if(this.value < 0){
            throw new IllegalArgumentException("No puede ser un valor negativo");
        }

        if(this.value > 100){
            throw new IllegalArgumentException("No es un promedio valido");
        }
    }

    @Override
    public Double value() {
        return value;
    }
}
