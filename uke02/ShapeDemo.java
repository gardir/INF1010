import java.util.Scanner;

public class ShapeDemo<T extends Shape & Comparable<T>>{
    public void commandLoop(T c1, T c2){
        Scanner userInput = new Scanner(System.in);
        String command;

        System.out.println("***Meny***");
        System.out.println("1: Print areal");
        System.out.println("2: Print omkrets");
        System.out.println("3: Sammenlign c1 og c2");
        System.out.println("h: Help");
        System.out.println("q: Quit");
        System.out.println("*****************");

        while(userInput.hasNext()){
            command = userInput.next();
            
            if(command.equals("1")){
                System.out.println("Arealet er:" + c1.area());
            }else if(command.equals("2")){
                System.out.println("Omkretsen er: " + c1.perimeter());
            }else if(command.equals("3")){
                System.out.println("Sammenligning: " + c1.compareTo(c2));
            }else if(command.equals("h")){
                System.out.println("***Gyldige valg er:***");
                System.out.println("1: Print areal");
                System.out.println("2: Print omkrets");
                System.out.println("h: Help");
                System.out.println("q: Quit");
                System.out.println("*****************");

            }else if(command.equals("q")){
                return;
            }else{
                System.out.println("Ugyldig kommando - prov paa nytt");
            }
        }
    }

}