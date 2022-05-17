package co.com.sofkau.entrenamiento.curso.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Directriz implements ValueObject<String> {

    private final String value;

    public Directriz(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Directriz directiz = (Directriz) o;
        return Objects.equals(value, directiz.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
