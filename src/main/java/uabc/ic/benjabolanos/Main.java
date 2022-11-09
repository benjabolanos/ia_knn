package uabc.ic.benjabolanos;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String rutaArchivo = "src/main/resources/archivos/participate_y16_training.csv";
        ArchivoUtil au = new ArchivoUtil(rutaArchivo, 5);
        KNN knn = new KNN(au.getContenidoArchivo(), 13);
        Estadisticas stats = new Estadisticas();

        knn.crearDatasets(0.3F);

        List<Double[]> datasetTest = knn.getDatasetTest();

        for(Double[] punto: datasetTest){
            ArrayList<DistanciaClase> distancias = knn.calcularDistanciasDesde(punto);
            List<DistanciaClase> vecinosCercanos = knn.encontrarKnn(distancias);
            int claseCalculada = knn.calcularModa(vecinosCercanos);
            if(claseCalculada == punto[4]){
                stats.TP += 1;
                stats.TN += 4;
            } else {
                stats.TN += 3;
                stats.FN += 1;
                stats.FP += 1;
            }
        }

        System.out.println("Resultados:");
        System.out.println("Exactitud: " + stats.calcularExactitud());
        System.out.println("Presicion: " + stats.calcularPresicion());
        System.out.println("Recall: " + stats.calcularRecall());
        System.out.println("fScore: " + stats.calcularFScore());
        System.out.println("ToString: " + stats);
    }
}