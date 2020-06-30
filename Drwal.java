import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Drwal {

    public static void display(char[][] myArray)
    {
        for(int i = 0 ; i < myArray.length ; i++)
        {
            for ( int j = 0 ; j<myArray[0].length ; j++)
            {
                System.out.print(myArray[i][j]);
            }
            System.out.println();
        }
    }

    public static char[][] fillContour(int xStart , int yStart, char[][] myArray, char kolor ) {

        int x, y;
        Queue<Point> stack = new ArrayDeque<>();
        stack.add(new Point(xStart, yStart));
        myArray[xStart][yStart] = kolor;

        while(stack.peek() != null)
        {
            Point p = stack.peek();
            x = (int) p.getX();
            y = (int) p.getY();
            if(myArray[x][y+1] == ' ')
            {
                myArray[x][y+1] = kolor;
                stack.add(new Point(x,y+1));
            }
            if(myArray[x][y-1] == ' ')
            {
                myArray[x][y-1] = kolor;
                stack.add(new Point(x,y-1));
            }
            if(myArray[x+1][y] == ' ')
            {
                myArray[x+1][y] = kolor;
                stack.add(new Point(x+1,y));
            }
            if(myArray[x-1][y] == ' ')
            {
                myArray[x-1][y] = kolor;
                stack.add(new Point(x-1,y));
            }

        stack.remove();

        }



        return myArray;
    }

    public static void main(String[] args) throws IOException {
        
        if(args.length != 5)
        {
            System.err.println("klops");
            System.exit(0);
        }
        for( int i = 0 ; i < 5 ; i++)
        {
            if(i==2) continue;
            String argument = args[i];
            //dla przypadku gdy zero występuje na początku tj 0100
            if(argument.substring(0, 1).equals("0"))
            {
                System.err.println("klops");
                System.exit(0);
            }
            try{
                Integer.parseInt(argument);
            }catch(NumberFormatException e){
                System.err.println("klops");
                System.exit(0);
            }
        }

        if(Integer.parseInt(args[3]) > 50 || Integer.parseInt(args[4]) > 50)
        {
            System.err.println("klops");
            System.exit(0);
        }
        if(args[2].length() > 1)
        {
            System.err.println("klops");
            System.exit(0);
        }

        char kolor = args[2].toCharArray()[0];      
        int xStart = Integer.parseInt(args[0]); //kolumna
        int yStart = Integer.parseInt(args[1]); // wiersz
        int szerokosc = Integer.parseInt(args[3]); // liczba kolumn
        int wysokosc = Integer.parseInt(args[4]); //liczba wierszy

        if(xStart > szerokosc || yStart > wysokosc)
        {   
            System.err.println("klops");
            System.exit(0); 
        }    


        char[][] myArray = new char[wysokosc][szerokosc];        
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int i = 0 ;
        int zakres = 0;
        String line = "";
        while((line = bufferedReader.readLine()) != null) {

            if(line.length() < szerokosc)
                zakres=line.length();
            else
                zakres=szerokosc;

             for (int j=0; j<zakres; j++)
            {
                myArray[i][j] = line.charAt(j);
            }

            i++;
            if(i>wysokosc-1) break;
        }
        bufferedReader.close();

        myArray =  fillContour(yStart-1, xStart-1, myArray, kolor);
        display(myArray);
    }
}