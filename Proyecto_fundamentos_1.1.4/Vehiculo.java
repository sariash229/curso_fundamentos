import java.util.ArrayList;
public class Vehiculo
{
    private int modelo;
    private String marca;
    private double ValorComercial;
    private String color;
    private int id;
    private ArrayList<Sensor> sensores = new ArrayList<Sensor>();
    public static ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    public static int idActual = 1;
    public Vehiculo()
    {
        this.id = Vehiculo.idActual;
        Vehiculo.vehiculos.add(this);
        Vehiculo.idActual = Vehiculo.idActual + 1;
    }

    public Vehiculo(int mo, String ma, double vc)
    {
        this(mo,ma,vc,"verde");
    }

    public Vehiculo(int mo, String ma, double vc, String co)
    {
        this.modelo = mo;
        this.marca = ma;
        this.ValorComercial = vc;
        this.color = co;
        this.id = Vehiculo.idActual;
        Vehiculo.vehiculos.add(this);
        Vehiculo.idActual = Vehiculo.idActual + 1;
    }

    public void setModelo(int mo)
    {
        this.modelo = mo;
    }

    public void setMarca(String ma)
    {
        this.marca = ma;
    }

    public void setValorComercial(double vc)
    {
        this.ValorComercial = vc;
    }

    public void setColor(String co)
    {
        this.color = co;
    }

    public void setSensores(ArrayList<Sensor> Sensores)
    {
        this.sensores = Sensores;
    }

    public ArrayList<Sensor> getSensores()
    {
        return this.sensores;
    }

    public int getModelo()
    {
        return this.modelo;
    }

    public String getMarca()
    {
        return this.marca;
    }

    public double getValorComercial()
    {
        return this.ValorComercial;
    }

    public int getID()
    {
        return this.id;
    }

    public String getColor()
    {
        return this.color;
    }

    public String toString()
    {
        String texto = "Id: "+ this.id+", Modelo: "+this.modelo+", Marca: "+this.marca+", Valor comercial: "+this.ValorComercial
            +", Color:"+this.color+" Sensores: ";
        for(int i = 0; i < this.sensores.size(); i++)
        {
            texto = texto + this.sensores.get(i).toString();
        }
        return texto;
    }

    public static String toStringVehiculosVerdes()
    {
        String texto = "";
        for(int i = 0; i < Vehiculo.vehiculos.size(); i++)
        {
            if(Vehiculo.vehiculos.get(i).color.equalsIgnoreCase("Verde") )
            {
                texto = texto + Vehiculo.vehiculos.get(i).toString();
            }
        }
        return texto;
    }

    public static String toStringVehiculos()
    {
        String texto = "";
        for(int i = 0; i < Vehiculo.vehiculos.size(); i++)
        {
            texto = texto + i+" vehiculo, "+vehiculos.get(i).toString();
        }
        return (texto);
    }

    public void anadirSensor(Sensor s)
    {
        this.sensores.add(s);
    }

    public static int cantidadVehiculos()
    {
        return Vehiculo.vehiculos.size();
    }

    public int cantidadSensores()
    {
        return this.sensores.size();
    }

    public static Vehiculo obtenerVehiculoPorId(int id)
    {
        Vehiculo tempVehiculo = new Vehiculo(); 
        for(int i = 0; i < Vehiculo.vehiculos.size(); i++)
        {
            if(Vehiculo.vehiculos.get(i).getID() == id)
            {
                tempVehiculo = Vehiculo.vehiculos.get(i);
            }
        }
        Vehiculo.idActual = Vehiculo.idActual - 1;
        return tempVehiculo;
    }

    public static String toStringSensoresTemperatura()
    {
        String texto = "";
        for(int i = 0; i < Vehiculo.vehiculos.size(); i++)
        {
            for(int j = 0; j < Vehiculo.vehiculos.get(i).getSensores().size(); j++)
            {
                if(Vehiculo.vehiculos.get(i).getSensores().get(j).getTipo().equalsIgnoreCase("Temperatura"))
                {
                    texto = Vehiculo.vehiculos.get(i).getSensores().get(j).toString()+" "+texto;
                }
            }
        }
        return texto;
    }

    public static String  sensoresMax(){
        int cant=0;
        String texto="";
        for(int i=0;i<Vehiculo.vehiculos.size();i++){
            if(cant<Vehiculo.vehiculos.get(i).getSensores().size()){
                cant=Vehiculo.vehiculos.get(i).getSensores().size();
                texto=Vehiculo.vehiculos.get(i).toString();
            }
        }
        return texto;
    }
    public static ArrayList<Sensor> caso666()
    {
        ArrayList<Sensor> caso666 = new ArrayList<Sensor>();
        Sensor temp;
        int pos_menor;
        for(int i = 0; i < Vehiculo.vehiculos.size(); i++)
        {
            for(int j = 0; j < Vehiculo.vehiculos.get(i).getSensores().size(); j++)
            {
                if(Vehiculo.vehiculos.get(i).getSensores().get(j).getTipo().equalsIgnoreCase("Temperatura"))
                {
                    caso666.add(Vehiculo.vehiculos.get(i).getSensores().get(j));
                }
            }
        }
        for(int i = 0; i < caso666.size()-1; i++)
        {
            pos_menor = i;
            for(int j = i+1; j < caso666.size(); j++)
            {
                if(caso666.get(j).getValor() > caso666.get(pos_menor).getValor())
                {
                    pos_menor = j;
                }
            }
            temp = caso666.get(i);
            caso666.set(i, caso666.get(pos_menor));
            caso666.set(pos_menor, temp);
        }
        return caso666;
    }
}