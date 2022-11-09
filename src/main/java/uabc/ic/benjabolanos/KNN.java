package uabc.ic.benjabolanos;

import java.util.*;

public class KNN {

    private final List<Double[]> dataset;
    private List<Double[]> datasetEntrenamiento;
    private List<Double[]> datasetTest;
    private final int K;

    public KNN(ArrayList<Double[]> dataset, int K){
        this.dataset = dataset;
        this.K = K;
    }

    public void crearDatasets(float porcentajeEntrenamiento){
        int rand = new Random().nextInt();

        Collections.shuffle(dataset, new Random(1));

        int cantidadElementosDatasetEntrenamiento = Math.round(dataset.size() * porcentajeEntrenamiento);

        datasetEntrenamiento = dataset.subList(0, cantidadElementosDatasetEntrenamiento);
        datasetTest = dataset.subList(cantidadElementosDatasetEntrenamiento, dataset.size());
    }

    public ArrayList<DistanciaClase> calcularDistanciasDesde(Double[] puntoDesde){
        ArrayList<DistanciaClase> distancias = new ArrayList<>();

        for(Double[] puntoHasta: datasetEntrenamiento){
            double sumatoria = 0;
            for(int i = 0; i < 4; i ++){
                sumatoria += Math.pow((puntoDesde[i] - puntoHasta[i]), 2);
            }
            distancias.add(new DistanciaClase(Math.sqrt(sumatoria), (int) Math.round(puntoHasta[4])));
        }
        return distancias;
    }

    public List<DistanciaClase> encontrarKnn(ArrayList<DistanciaClase> distancias){
        Collections.sort(distancias);
        return distancias.subList(0, K);
    }

    public int calcularModa(List<DistanciaClase> vecinosCercanos){
        int[] contadorClases = new int[5];

        for(DistanciaClase vecino: vecinosCercanos){
            contadorClases[vecino.clase]++;
        }

        int claseModa = 0;
        for(int i = 1; i < contadorClases.length; i++){
            if(contadorClases[claseModa] < contadorClases[i]){
                claseModa = i;
            }
        }

        return claseModa;
    }

    public List<Double[]> getDatasetTest() {
        return datasetTest;
    }
}