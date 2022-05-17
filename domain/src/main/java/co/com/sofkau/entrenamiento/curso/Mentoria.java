package co.com.sofkau.entrenamiento.curso;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.entrenamiento.curso.values.Directriz;
import co.com.sofkau.generic.values.Fecha;
import co.com.sofkau.entrenamiento.curso.values.MentoriaId;
import co.com.sofkau.generic.values.Nombre;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class Mentoria extends Entity<MentoriaId> {

    protected Nombre nombre;
    protected Set<Directriz> directrices;
    protected Fecha fecha;

    public Mentoria(MentoriaId entityId, Nombre nombre, Fecha fecha) {
        super(entityId);
        this.nombre = nombre;
        this.fecha = fecha;
        this.directrices = new HashSet<>();
    }

    public void agregarDirectriz(Directriz directiz){
        //TODO: validaciones
        this.directrices.add(directiz);
    }

    public void agregarDirectrices(DirectricesFactory factory){
        factory.directrices().forEach(this::agregarDirectriz);
    }

    public Set<Directriz> directrices(){
        return directrices;
    }




}
