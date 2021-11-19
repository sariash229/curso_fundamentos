import java.util.Arrays;
public class Sensor {
    private String tipo;
    private double valor;

    public Sensor() 
    {
    }

    public Sensor(String t, double v) 
    {
        this.tipo = t;
        this.valor = v;

    }

    public String getTipo() {
        return this.tipo;
    }

    public double getValor() {
        return this.valor;
    }

    public void setTipo(String t) {
        t = this.tipo;
    }

    public void setValor(double v) {
        v = this.valor;
    }

    public String toString() 
    {
        return this.tipo+" "+this.valor;
    }
}