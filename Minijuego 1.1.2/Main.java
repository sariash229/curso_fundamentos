import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
public class Main{

    public static void atk(int f, int c){
        try{
            if(Playboard.bichos[f][c].getSalud() > 0){
                Playboard.bichos[f][c].setSalud(Playboard.bichos[f][c].getSalud()-5);
                System.out.println("BOOM! daño inflingido: 5 puntos\n");
            }else{
                System.out.println("ese bicho ya está muerto\n");
            }
        }catch(Exception e){
            System.out.println("Ahi no hay nadie!\n");
        }
    }

    public static void nuke(){
        try{
            Random rand = new Random();
            int f = rand.nextInt(2);
            int c = rand.nextInt(2);
            Playboard.bichos[f][c].setSalud(0);
        }catch(Exception e){
            System.out.println("oops, no le diste a nadie\n");
        }
    }

    public static void mutate(){
        Arrays.sort(Playboard.saludes);
        int scrimblo = 0;
        for(int i = 0 ; i < 2 ; i++){
            for(int j = 0 ; j < 2 ; j++){
                if(Playboard.saludes[scrimblo] == 0){
                    scrimblo++;
                }
                try{
                    if(Playboard.saludes[scrimblo] == Playboard.bichos[i][j].getSalud()){
                        Playboard.bichos[i][j].setSalud(Playboard.bichos[i][j].getSalud()*2);
                    }
                }catch(Exception e){

                }
            }
        }
    }

    public static void main(String[] args){
        Scanner data = new Scanner(System.in);
        System.out.println("Estas en un apocalipsis de bichos, pasas por un callejón oscuro para buscar comida, cuando de repente");
        System.out.println("");
        Playboard.typing();
        Playboard.display();
        System.out.println("Que haras ahora!!!");
        boolean truth = true;
        while(truth == true){
            System.out.println("Presiona [1] para disparar a un bicho\nPresiona [2] para lanzar una bomba nuclear\nPresiona [3] para convertir al bicho más debil en mutante\nPresiona [4] para ver la frase de la abuela");
            try{
                int choice = data.nextInt();
                switch(choice){
                    case 1:
                        System.out.println("especifica la fila del bicho al quieres disparar");
                        int c = data.nextInt()-1;
                        System.out.println("Especifica la columna del bicho al que quieres disparar");
                        int f = data.nextInt()-1;
                        Main.atk(c,f);
                        Playboard.display();
                        break;
                    case 2:
                        System.out.println("Ha caido una bomba nuclear en una de las 4 casillas, le diste a alguien?");
                        Main.nuke();
                        Playboard.display();
                        break;
                    case 3:
                        Main.mutate();
                        System.out.println("Uno de los bichos ha mutado! Ahora tiene el doble de vida\n");
                        Playboard.display();
                        break;
                    case 4:
                        System.out.println("La Abuela te dice: ");
                        System.out.println("La duda es el mayor de los enemigos");
                        break;
                }
            }catch(Exception e){
                System.out.println("Esa tecla no está disponible, sube de nivel primero");
            }
            try{
                if(Playboard.bichos[0][0].getSalud()+Playboard.bichos[0][1].getSalud()+Playboard.bichos[1][0].getSalud()+Playboard.bichos[1][1].getSalud() == 0){
                    System.out.println("VICTORIA!!!!!!!!!!!!!!!!!!\nTodos los bichos han muerto, puedes seguir con tu camino");
                    truth = false;
                    break;
                }
            }catch(Exception e){
            }
            try{
                if(Playboard.bichos[0][0].getSalud()+Playboard.bichos[0][1].getSalud()+Playboard.bichos[1][0].getSalud() == 0 && Playboard.bichos[1][1] == null){
                    System.out.println("VICTORIA!!!!!!!!!!!!!!!!!!\nTodos los bichos han muerto, puedes seguir con tu camino"); 
                    truth = false;
                    break;
                }
            }catch(Exception f){
            }
            try{
                if(Playboard.bichos[0][0].getSalud()+Playboard.bichos[0][1].getSalud() == 0){
                    System.out.println("VICTORIA!!!!!!!!!!!!!!!!!!\nTodos los bichos han muerto, puedes seguir con tu camino");
                    truth = false;
                    break;
                }
            }catch(Exception g){
            }
            if(Playboard.bichos[0][0].getSalud() == 0 && Playboard.bichos[0][1] == null){
                System.out.println("VICTORIA!!!!!!!!!!!!!!!!!!\nTodos los bichos han muerto, puedes seguir con tu camino");
                truth = false;
            }
        }
    }
}