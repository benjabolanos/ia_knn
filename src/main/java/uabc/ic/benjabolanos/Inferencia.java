package uabc.ic.benjabolanos;

public class Inferencia {

    public enum ESTATUS{
        VERDADERO_POSITIVO,
        FALSO_POSITIVO,
        VERDADERO_NEGATIVO,
        FALSO_NEGATIVO
    }

    Float[] punto;
    int claseCalculada;
    ESTATUS resultado;

    public Inferencia(Float[] punto, int claseCalculada){
        this.punto = punto;
        this.claseCalculada = claseCalculada;

    }

}
