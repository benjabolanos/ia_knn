package uabc.ic.benjabolanos;

import java.util.ArrayList;

public class KNN {

    private final ArrayList<Float[]> contenido;

    public KNN(ArrayList<Float[]> contenido){
        this.contenido = contenido;
    }

    public ArrayList<Float[]> calcularDistanciasDesde(int pos){
        Float[] inicios = contenido.get(pos);
        ArrayList<Float[]> distancias = new ArrayList<>();

        for(Float[] punto: contenido){
            Float[] resultado = new Float[punto.length];
            for(int i = 0; i < punto.length; i++){
                resultado[i] = inicios[i] - punto[i];
            }
            distancias.add(resultado);
        }

        return distancias;
    }
}


