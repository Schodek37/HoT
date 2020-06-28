import java.util.ArrayList;

public class Kosmolot {

   
    public static void main(String[] args) {
    
    if(args.length!=2)
    {
        System.err.println("klops");
        System.exit(0);
     }

    try{
        Integer.parseInt(args[0]);
    }catch(NumberFormatException e){
        System.err.println("klops");
        System.exit(0);
    }

    if(Integer.parseInt(args[0]) < 1 || Integer.parseInt(args[0]) > 75)
    {
        System.err.println("klops");
        System.exit(0);
    }

    String rozmiar = args[0];
    String pancerz = args[1];
    String line = "";
    String middle = "";   
    ArrayList<String> lines = new ArrayList<String>();
	Integer size = Integer.parseInt(rozmiar);
    Integer temp = 1;

    switch(pancerz){
        case "N":
             //tworzenie polowy rakiety
            for(int i = 1; i <= size ; i++)
            {
                temp = i;
                for(int j = 1 ; j <= Math.pow(size,2)  ; j++)
                {       
                    if(i>=j)
                        line=line+"*";
                    else
                        line=line+" ";
        
                    if(j%size == 0 ) i += size;
                }
                i=temp;
                lines.add(line);
                line="";
                if(lines.size() > size -1 ) break;
            }
            
            //narysowanie pierwszej polowy rakiety
            for(int i = 0 ; i<size;i++)
            {
                System.out.print(lines.get(i) + "\n");
            }
            
            //narysowanie drugiej polowy rakiety
            for(int i = size-2 ; i>=0;i--)
            {
                System.out.print(lines.get(i) + "\n");
            }
    
        break;

        case "Y":
            //tworzenie polowy rakiety
            for(int i = 1 ; i <= size-1 ; i++ )
            {
                for(int j = 1 ; j <= Math.pow(size,2) ; j++ )
                {
                    if(j%size==0 || i<(j%size))
                    {
                        line+=" ";
                        continue;
                    }
                    if(i==(j%size))
                    {
                        line+="\\";
                        continue;
                    }
                    if(i>(j%size)){
                        line+="*";
                        continue;
                    }
                }
                lines.add(line);
                line = "";
            }
        
            //zamiana pierwszej kolumny na silniki jonowe
            String temp_line = "";
            for(int i = 0 ; i<lines.size();i++)
            {
                temp_line = lines.get(i);
                temp_line = temp_line.substring(0,0)+'>'+temp_line.substring(1);
                lines.set(i,temp_line);
            }
            
            //stworzenie srodkowej czesci rakiety
            for(int i = 1 ; i <= Math.pow(size,2) ; i++)
            {
                if(i==1 || i==Math.pow(size,2))
                {
                    middle+=">";
                }
                else
                {
                    middle+="*";
                }
            }
        
            lines.add(middle);

            //rysowanie pierwszej polowy silnika
            for(int i = 0 ; i<size;i++)
            {
                System.out.print(lines.get(i)  + "\n");
            }

            //rysowanie drugiej polowy silnika
            for(int i = size-2 ; i>=0;i--)
            {
                temp_line=lines.get(i);
                temp_line=temp_line.replace("\\","/");
                System.out.print(temp_line  + "\n");
            }
        break;

        default:
            System.err.println("klops");
            System.exit(0);
        break;
    }
	
    }

    }

