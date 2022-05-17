package co.com.sofkau.entrenamiento.curso;

import co.com.sofkau.entrenamiento.curso.values.Directriz;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DirectricesFactory {

    private final Set<Directriz> directrices;

    private DirectricesFactory(){
        this.directrices = new HashSet<>();
    }
    public DirectricesFactory agregarDirectriz(Directriz directriz){
        directrices.add(directriz);
        return this;
    }

    public static DirectricesFactory builder(){
        return new DirectricesFactory();
    }


    public Set<Directriz> directrices() {
        return directrices;
    }
}
