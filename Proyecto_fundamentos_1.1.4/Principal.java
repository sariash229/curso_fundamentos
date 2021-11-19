import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class Principal
{
    public static void main(String[] args)
    { 
        Principal Usuario= new Principal ();
        Usuario.mostrarMenu();
    }

    public void mostrarMenu(){
        int loop=1;
        while(loop==1){
            System.out.println("Hola usuario, ingrese un número para acceder a alguna de las opciones.");
            System.out.println("#0 para detener la ejecución del programa.");
            System.out.println("#1 para crear un nuevo vehículo.");
            System.out.println("#2 para ver toda la información los vehículos almacenados hasta el momento.");
            System.out.println("#3 para ver el numero de vehículos creados hasta el momento.");
            System.out.println("#4 para ver la información sobre los vehículos con color verde.  ");
            System.out.println("#5 para ver la información de un vehiculo ingresando su id");
            System.out.println("#6 para crear y añadir sensores a un vehiculo ingresando su id .");
            System.out.println("#7 para ver la información de los sensores de un vehiculo ingresando su id ");
            System.out.println("#8 para ver la información sobre los sensores de temperatura.");
            System.out.println("#9 para ver la información del vehículo que tiene mas sensores.");
            System.out.println("#10 para añadir los vehículos imaginarios a la lista");
            System.out.println("#666 para ver los sensores de temperatura ordenados por valor (menor a mayor). ");

            Scanner sc = new Scanner(System.in);
            int opcion =sc.nextInt();
            switch(opcion){
                case 0 :
                    break;
                case 1:
                    boolean ver=true;
                    while(ver==true)
                    {
                        System.out.println("Por favor ingrese los datos del carro (modelo,marca,valorcomercial)");
                        int modelo = 0;
                        String marca = "";
                        double valorcomercial = 0;
                        String color = "";
                        try{
                            modelo=sc.nextInt();
                            marca=sc.next();
                            valorcomercial=sc.nextDouble();
                        }catch(Exception e){
                            System.out.println("Datos incongruentes, por favor vuelva a intentarlo\n");
                            mostrarMenu();
                            break;
                        }    
                        System.out.println("¿Desea escribir el color? Recuerde que quedara verde por defecto sino lo hace.Presione 1 para agregarlo o cualquier otro numero para continuar");
                        int desicion=sc.nextInt();
                        if(desicion==1){
                            System.out.println("Porfavor escriba el color.");
                            try{
                                color=sc.next();
                            }catch(Exception e){
                                break;
                            }
                            Vehiculo v =new Vehiculo(modelo,marca,valorcomercial,color);
                        }else{
                            Vehiculo v =new Vehiculo(modelo,marca,valorcomercial);
                        }
                        System.out.println("Para crear otro vehiculo escriba 1 sino escriba cualquier otro numero para volver al menú");
                        int regresar=sc.nextInt();
                        if(regresar==1){
                            ver=true;
                        }else {
                            ver=false;
                            mostrarMenu();
                        }
                    }
                    break;
                case 2 :
                    ver=true;
                    while(ver==true){
                        System.out.println(Vehiculo.toStringVehiculos());

                        System.out.println("Para repetir la información escriba 1 sino escriba cualquier otro numero para volver al menú");
                        int regresar=sc.nextInt();
                        if(regresar==1){
                            ver=true;

                        }else {
                            ver=false;
                            mostrarMenu();

                        }

                    }
                    break;
                case 3 :
                    ver=true;
                    while(ver==true){
                        System.out.println("Se han creado "+Vehiculo.cantidadVehiculos()+ " vehículos");
                        System.out.println("Para repetir la información escriba 1 sino escriba cualquier otro numero para volver al menú");
                        int regresar=sc.nextInt();
                        if(regresar==1){
                            ver=true;
                        }else {
                            ver=false;
                            mostrarMenu();
                        }
                    }
                    break;
                case 4 :
                    ver=true;
                    while(ver==true){
                        System.out.println(Vehiculo.toStringVehiculosVerdes());
                        System.out.println("Para repetir la información escriba 1 sino escriba cualquier otro numero para volver al menú");
                        int regresar=sc.nextInt();
                        if(regresar==1){
                            ver=true;

                        }else {
                            ver=false;
                            mostrarMenu();

                        }

                    }
                    break;
                case 5 :
                    ver=true;
                    while(ver==true){
                        System.out.println("Por favor digite el id del vehiculo");
                        int id = 0;
                        try{
                            id = sc.nextInt();
                        }catch(Exception e){
                            System.out.println("Las ID solo contienen números, por favor vuelva a intentarlo\n");
                            mostrarMenu();
                            break; 
                        }
                        if(id>Vehiculo.vehiculos.size()){
                            System.out.println("No existe el id introducido");
                        }else{
                            System.out.println("El vehiculo buscado es: "+Vehiculo.obtenerVehiculoPorId(id).toString());
                            System.out.println("Para repetir la información escriba 1 sino escriba cualquier otro numero para volver al menú");
                        }
                        int regresar=sc.nextInt();
                        if(regresar==1){
                            ver=true;
                        }else 
                        {
                            ver=false;
                            mostrarMenu();
                        }
                    }

                    break;
                case 6 :
                    ver=true;
                    while(ver==true){
                        System.out.println("Por favor digite el id del vehiculo");
                        int id = 0;
                        try{
                            id = sc.nextInt();
                        }catch(Exception e){
                            System.out.println("Las ID solo contienen números, por favor vuelva a intentarlo\n");
                            mostrarMenu();
                            break;
                        }
                        if(id>Vehiculo.vehiculos.size()){
                            System.out.println("No existe el id introducido");
                        }else{
                            Vehiculo temp = Vehiculo.obtenerVehiculoPorId(id);
                            System.out.println("Por favor ingrese datos de un sensor");
                            System.out.println("El tipo:");
                            String tipo = sc.next();
                            System.out.println("El valor");
                            int valor = 0;
                            try{
                            valor = sc.nextInt();
                        }catch(Exception e){
                            System.out.println("El valor solo puede ser numérico, vuelva a intentarlo\n");
                            mostrarMenu();
                            break;
                        }
                            Sensor sensor1 = new Sensor(tipo, valor);
                            temp.anadirSensor(sensor1);
                            System.out.println("Para crear otro sensor escriba 1 sino escriba cualquier otro numero para volver al menú");
                        }
                        int regresar=sc.nextInt();
                        if(regresar==1){
                            ver=true;
                        }else 
                        {
                            ver=false;
                            mostrarMenu();
                        }
                    }

                    break;
                case 7 :
                    ver=true;
                    while(ver==true){
                        System.out.println("Por favor digite el id del vehiculo");
                        int id = 0;
                        try{
                            id = sc.nextInt();
                        }catch(Exception e){
                            System.out.println("Las ID solo contienen números, por favor vuelva a intentarlo\n");
                            mostrarMenu();
                            break;
                        }
                        if(id>Vehiculo.vehiculos.size()){
                            System.out.println("No existe el id introducido");
                        }else{
                            Vehiculo temp = Vehiculo.obtenerVehiculoPorId(id);
                            System.out.println("La informacion de los sensores de este vehiculo es");
                            for(int i = 0; i < temp.getSensores().size(); i++)
                            {
                                System.out.println(temp.getSensores().get(i).toString());
                            }
                            System.out.println("Para repetir la información escriba 1 sino escriba cualquier otro numero para volver al menú");
                        }
                        int regresar=sc.nextInt();
                        if(regresar==1){
                            ver=true;
                        }else 
                        {
                            ver=false;
                            mostrarMenu();
                        }
                    }

                    break;

                case 8 :
                    ver=true;
                    while(ver==true){
                        System.out.println("La información de los sensores de temperatura es: ");
                        System.out.println(Vehiculo.toStringSensoresTemperatura());
                        System.out.println("Para repetir la información escriba 1 sino escriba cualquier otro numero para volver al menú");
                        int regresar=sc.nextInt();
                        if(regresar==1){
                            ver=true;

                        }else {
                            ver=false;
                            mostrarMenu();

                        }

                    }
                    break;
                case 9 :
                    ver=true;
                    while(ver==true){

                        System.out.println("El vehiculo que mas tiene sensores es: "+Vehiculo.sensoresMax());

                        System.out.println("Para repetir la información escriba 1 sino escriba cualquier otro numero para volver al menú");
                        int regresar=sc.nextInt();
                        if(regresar==1){
                            ver=true;

                        }else {
                            ver=false;
                            mostrarMenu();

                        }

                    }
                    break;
                case 10:
                    System.out.println("Se han añadido los vehículos ficticios a la lista\n");
                    ver=true;
                    String vehiFic = "";
                    while(ver==true){
                        try {
                            File myObj = new File("vehiculosFic.txt");
                            Scanner myReader = new Scanner(myObj);
                            while (myReader.hasNextLine()) {
                                vehiFic = myReader.nextLine();
                            }
                            myReader.close();
                        }catch (FileNotFoundException bruh) {
                            System.out.println("An error occurred.");
                            bruh.printStackTrace();
                        }
                        int tempInt = 0;
                        double tempDou = 0;
                        String tempMarc = "";
                        String tempCol = "";
                        String[] res = vehiFic.split("[-]", 0);
                        int i = 0;
                        for(String myStr: res) {
                            String[] ross = res[i].split("[,]", 0);
                            for(String meinStr: ross) {
                                if(meinStr.contains("0")){
                                    tempInt = Integer.valueOf(meinStr);
                                }else if(meinStr.contains("9")){
                                    tempDou = Double.valueOf(meinStr);
                                }else if(meinStr.contains("a")){
                                    tempMarc = meinStr;
                                }else{
                                    tempCol = meinStr;
                                }
                            }
                            i++;
                            Vehiculo vehiculoFic = new Vehiculo(tempInt,tempMarc,tempDou,tempCol);
                        }
                        ver=false;
                        mostrarMenu();
                    }
                    break;
                default:
                    System.out.println("Ese número no es válido, por favor ingrese otro");
                    mostrarMenu();
                    break;
                    
                case 666 :
                    ver=true;
                    while(ver==true){
                        ArrayList<Sensor> caso666 = Vehiculo.caso666();
                        String texto = "";
                        for(int i = 0; i < caso666.size(); i++)
                        {
                            texto = caso666.get(i).toString()+" "+ texto;
                        }
                        System.out.println("La informacion solicitada es esta: ");
                        System.out.println(texto);
                        System.out.println("Para repetir la información escriba 1 sino escriba cualquier otro numero para volver al menú");
                        int regresar=sc.nextInt();
                        if(regresar==1){
                            ver=true;

                        }else {
                            ver=false;
                            mostrarMenu();

                        }
                    }
                    break;
            }
            break;
        }
    }
}
