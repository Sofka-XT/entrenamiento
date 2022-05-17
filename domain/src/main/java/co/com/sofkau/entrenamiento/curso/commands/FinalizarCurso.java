package co.com.sofkau.entrenamiento.curso.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.entrenamiento.curso.values.CursoId;
import co.com.sofkau.entrenamiento.programa.values.ProgramaId;

public class FinalizarCurso extends Command {
    private final CursoId cursoId;
    private final ProgramaId programaId;

    public FinalizarCurso(CursoId cursoId, ProgramaId programaId) {
        this.cursoId = cursoId;
        this.programaId = programaId;
    }

    public CursoId getCursoId() {
        return cursoId;
    }

    public ProgramaId getProgramaId() {
        return programaId;
    }
}
