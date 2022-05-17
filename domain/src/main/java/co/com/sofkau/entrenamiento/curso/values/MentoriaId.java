package co.com.sofkau.entrenamiento.curso.values;

import co.com.sofka.domain.generic.Identity;

public class MentoriaId extends Identity {
    public MentoriaId(String value) {
        super(value);
    }

    public MentoriaId(){

    }

    public static MentoriaId of(String value) {
        return new MentoriaId(value);
    }
}
