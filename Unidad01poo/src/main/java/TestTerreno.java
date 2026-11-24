
package unidad01poo;


import java.util.Scanner;
public class TestTerreno {

   
    public static void main(String[] args) {
        // declarar variables y objetos
        Terreno terreno = new Terreno();
        Scanner in = new Scanner(System.in);
        int opcion = 0;
        
        do{
            //menu
            System.out.println("1. Capturar informacion");
            System.out.println("2. Imprimir el perimetro");
            System.out.println("3. Imprimir el area");
            System.out.println("4. Imprimir informacion");
            System.out.println("5. Salir");
            System.out.println("dame la opcion 1-5");
             opcion = in.nextInt();
             
             switch (opcion){
                 case 1: //capturar la informacion
                     System.out.println("Dame el Num. terreno");
                     terreno.setNumTerreno(in.next());
                     System.out.println("Dame lo ancho del terreno");
                     terreno.setAncho(in.nextFloat());
                     System.out.println("Dame lo largo del terreno");
                     terreno.setLargo(in.nextFloat());
                     break;
                 
                 case 2: // imprimir perimetro
                     System.out.println("El perimetro es" + terreno.calcularPerimetro());
                     break;
                 
                 case 3: //imprimir area
                     System.out.println("El area es " + terreno.calcularArea());
                     break;
                 
                 case 4: //imprimir informacion
                     terreno.imprimir();
                     break;
                     
                 case 5: //salir
                     System.out.println("Salir");
                     break;
                     
                 default: //casos no existentes
                     System.out.println(opcion + "No es una opcion valida");
                     break;
             }
        }while(opcion!=5);
    }
    
}