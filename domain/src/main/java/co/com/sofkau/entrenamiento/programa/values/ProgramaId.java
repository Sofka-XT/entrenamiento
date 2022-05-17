package co.com.sofkau.entrenamiento.programa.values;

import co.com.sofka.domain.generic.Identity;

public class ProgramaId extends Identity {
    public ProgramaId(String id) {
        super(id);
    }

    public ProgramaId(){

    }

    public static ProgramaId of(String id){
        return new ProgramaId(id);
    }
}
