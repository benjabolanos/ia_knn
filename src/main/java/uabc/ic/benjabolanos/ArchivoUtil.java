package uabc.ic.benjabolanos;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;

public class ArchivoUtil {

    private final ArrayList<Double[]> contenidoArchivo;
    private final String rutaArchivo;
    private final int cantidadColumnas;

    public ArchivoUtil(String rutaArchivo, int cantidadColumnas){
        contenidoArchivo = new ArrayList<>();
        this.rutaArchivo = rutaArchivo;
        this.cantidadColumnas = cantidadColumnas;
        lecturaArchivos();
    }

    private void lecturaArchivos(){
        try{
            CSVReader reader = new CSVReader(new FileReader(rutaArchivo));

            String[] contenidoLinea;

            while((contenidoLinea = reader.readNext()) != null){
                Double[] contenidoLineaF = new Double[cantidadColumnas];
                for(int i = 0; i <  cantidadColumnas ; i++){
                    contenidoLineaF[i] = Double.parseDouble(contenidoLinea[i]);
                }
                contenidoArchivo.add(contenidoLineaF);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Double[]> getContenidoArchivo(){
        return contenidoArchivo;
    }
}
