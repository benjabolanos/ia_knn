package uabc.ic.benjabolanos;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String rutaArchivo = "src/main/resources/archivos/participate_y16_training.csv";
        ArchivoUtil au = new ArchivoUtil(rutaArchivo, 4);

        KNN knn = new KNN(au.getContenidoArchivo());
        ArrayList<Float[]> distancias = knn.calcularDistanciasDesde(0);
        for(int i = 0; i < 100; i++){
            System.out.println(Arrays.toString(distancias.get(i)));
        }
    }
}