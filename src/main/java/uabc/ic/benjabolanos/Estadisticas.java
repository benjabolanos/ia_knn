package uabc.ic.benjabolanos;

public class Estadisticas {

    float TP = 0;
    float TN = 0;
    float FP = 0;
    float FN = 0;

    public float calcularExactitud(){
        return (TP + TN)/(TP+TN+FP+FN);
    }

    public float calcularPresicion(){
        return TP / (TP+FP);
    }

    public float calcularRecall(){
        return TP/(TP+FN);
    }

    public float calcularFScore(){
        return (2*calcularPresicion()*calcularRecall())/(calcularPresicion()+calcularRecall());
    }

    @Override
    public String toString() {
        return "Estadisticas{" +
                "TP=" + TP +
                ", TN=" + TN +
                ", FP=" + FP +
                ", FN=" + FN +
                '}';
    }
}
