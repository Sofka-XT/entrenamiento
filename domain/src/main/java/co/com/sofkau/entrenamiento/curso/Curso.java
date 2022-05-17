package co.com.sofkau.entrenamiento.curso;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.entrenamiento.curso.events.*;
import co.com.sofkau.entrenamiento.curso.values.*;
import co.com.sofkau.entrenamiento.programa.values.ProgramaId;
import co.com.sofkau.generic.values.Fecha;
import co.com.sofkau.generic.values.Nombre;
import co.com.sofkau.generic.values.Promedio;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Curso extends AggregateEvent<CursoId> {
    protected ProgramaId programaId;
    protected Nombre nombre;
    protected Descripcion descripcion;
    protected Coach coach;
    protected Set<Contenido> contenidos;
    protected Map<MentoriaId, Mentoria> mentorias;
    protected EstadoDeCurso estadoDeCurso;
    protected Promedio promedio;

    public Curso(CursoId entityId, ProgramaId programaId, Nombre nombre, Descripcion descripcion) {
        super(entityId);
        appendChange(new CursoCreado(nombre, descripcion, programaId)).apply();
        subscribe(new CursoEventChange(this));
    }

    private Curso(CursoId entityId){
        super(entityId);
        subscribe(new CursoEventChange(this));
    }


    public static Curso from(CursoId entityId, List<DomainEvent> events){
        var curso = new Curso(entityId);
        events.forEach(curso::applyEvent);
        return curso;
    }

    public void agregarMentoria( Nombre nombre, Fecha fecha){
        var mentoriaId = new MentoriaId();
        appendChange(new MentoriaCreada(mentoriaId, nombre, fecha)).apply();
    }

    public void agregarDirectrizDeMentoria(MentoriaId mentoriaId, Directriz directriz){
        appendChange(new DirectriceAgregadaAMentoria(mentoriaId, directriz)).apply();
    }

    public void agregarDirectricesDeMentoria(MentoriaId mentoriaId, DirectricesFactory factory){
        appendChange(new DirectrizAgregadasAMentoria(mentoriaId, factory)).apply();
    }

    public void finalizarElCurso(Promedio promedio){
        appendChange(new CursoFinalizado(promedio, programaId)).apply();
    }

    public Nombre nombre() {
        return nombre;
    }

    public Descripcion descripcion(){
        return descripcion;
    }

    public Coach coach(){
        return coach;
    }

    public Map<MentoriaId, Mentoria> mentorias(){
        return mentorias;
    }
}
