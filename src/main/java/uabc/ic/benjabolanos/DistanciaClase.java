package uabc.ic.benjabolanos;

public class DistanciaClase implements Comparable<DistanciaClase>{

    public Double distancia;
    public int clase;

    public DistanciaClase(Double distancia, int clase){
        this.distancia = distancia;
        this.clase = clase;
    }

    @Override
    public int compareTo(DistanciaClase o) {
        return Double.compare(this.distancia, o.distancia);
    }

    @Override
    public String toString() {
        return "Distancia: " + distancia + " Clase: " + clase;
    }
}
