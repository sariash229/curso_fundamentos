import java.util.Random;
import java.util.Arrays;
public class Playboard{
    public static Random rand = new Random();
    public static Bicho[][] bichos = new Bicho[2][2];
    public static int saludes[] = new int[4];
    public static int numbic = rand.nextInt(4)+1;

    public static void typing(){
        int tally = 0;
        int i = 0;
        for(i = 0 ; i < 2 ; i++){
            for(int j = 0 ; j < 2 ; j++){
                int type = rand.nextInt(2);
                if(type == 0 && tally < numbic){
                    bichos[i][j] = new Common();
                }else if (tally < numbic){
                    bichos[i][j] = new Alien();
                }else{
                }
                tally = tally + 1;
            }
        }
    }

    public static void display(){
        if(bichos[0][1] == null){
            System.out.println("Un Bicho te mira amenazantemente!!!!");
            System.out.println("");
            System.out.println("Vida: "+bichos[0][0].getSalud());
            System.out.println(" |__/ "+"   "+"      ");
            System.out.println(" (oo) "+"   "+"      ");
            System.out.println("//||\\"+"    "+"      ");
            System.out.println("");
            System.out.println("      "+"   "+"      ");
            System.out.println("      "+"   "+"      ");
            System.out.println("      "+"    "+"      ");
            saludes[0] = bichos[0][0].getSalud();
            saludes[1] = 420;
            saludes[2] = 420;
            saludes[3] = 420;
        }else if(bichos[1][0] == null){
            System.out.println("Una pareja de bichos intenta atacarte!!!");
            System.out.println("");
            System.out.println("Vida: "+bichos[0][0].getSalud()+"  "+"Vida: "+bichos[0][1].getSalud());
            System.out.println(" |__/ "+"   "+" |__/ ");
            System.out.println(" (oo) "+"   "+" (oo) ");
            System.out.println("//||\\"+"    "+"//||\\");
            System.out.println("");
            System.out.println("      "+"   "+"      ");
            System.out.println("      "+"   "+"      ");
            System.out.println("      "+"    "+"      ");
            saludes[0] = bichos[0][0].getSalud();
            saludes[1] = bichos[0][1].getSalud();
            saludes[2] = 420;
            saludes[3] = 420;
        }else if(bichos[1][1] == null){
            System.out.println("Un trío de bichos bloquea tu camino!!!");
            System.out.println("");
            System.out.println("Vida: "+bichos[0][0].getSalud()+"  "+"Vida: "+bichos[0][1].getSalud());
            System.out.println(" |__/ "+"   "+" |__/ ");
            System.out.println(" (oo) "+"   "+" (oo) ");
            System.out.println("//||\\"+"    "+"//||\\");
            System.out.println("");
            System.out.println("Vida: "+bichos[1][0].getSalud());
            System.out.println(" |__/ "+"   "+"      ");
            System.out.println(" (oo) "+"   "+"      ");
            System.out.println("//||\\"+"    "+"      ");
            saludes[0] = bichos[0][0].getSalud();
            saludes[1] = bichos[0][1].getSalud();
            saludes[2] = bichos[1][0].getSalud();
            saludes[3] = 420;
        }else{
            System.out.println("Una pandilla de bichos te impide pasar!!!");
            System.out.println("");
            System.out.println("Vida: "+bichos[0][0].getSalud()+"  "+"Vida: "+bichos[0][1].getSalud());
            System.out.println(" |__/ "+"   "+" |__/ ");
            System.out.println(" (oo) "+"   "+" (oo) ");
            System.out.println("//||\\"+"    "+"//||\\");
            System.out.println("");
            System.out.println("Vida: "+bichos[1][0].getSalud()+"  "+"Vida: "+bichos[1][1].getSalud());
            System.out.println(" |__/ "+"   "+" |__/ ");
            System.out.println(" (oo) "+"   "+" (oo) ");
            System.out.println("//||\\"+"    "+"//||\\");
            saludes[0] = bichos[0][0].getSalud();
            saludes[1] = bichos[0][1].getSalud();
            saludes[2] = bichos[1][0].getSalud();
            saludes[3] = bichos[1][1].getSalud();
        }
    }
}
