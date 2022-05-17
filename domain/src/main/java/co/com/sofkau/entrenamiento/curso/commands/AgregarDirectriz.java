package co.com.sofkau.entrenamiento.curso.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.entrenamiento.curso.values.CursoId;
import co.com.sofkau.entrenamiento.curso.values.Directriz;
import co.com.sofkau.entrenamiento.curso.values.MentoriaId;

public class AgregarDirectriz extends Command {
    private final CursoId coursoId;
    private final MentoriaId mentoriaId;
    private final Directriz directiz;


    public AgregarDirectriz(CursoId coursoId, MentoriaId mentoriaId, Directriz directiz) {
        this.coursoId = coursoId;
        this.mentoriaId = mentoriaId;
        this.directiz = directiz;
    }

    public Directriz getDirectiz() {
        return directiz;
    }

    public MentoriaId getMentoriaId() {
        return mentoriaId;
    }

    public CursoId getCoursoId() {
        return coursoId;
    }
}
