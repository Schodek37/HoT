public class Galaktyka {

     static void rotate90(String[][] maze)
    {
        int M = maze.length;
        int N = maze[0].length;
        String[][] ret = new String[N][M];

            for (int r = 0; r < M; r++)
            {
                for (int c = 0; c < N; c++)
                {
                    ret[c][M-1-r] = maze[r][c];
                }
            }

        M = ret.length;
        N = ret[0].length;
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < M; row++)
        {
            for (int col = 0 ; col < N ; col++)
            {
                sb.append(ret[row][col]);
            }
            sb.append("\n");
        }
        String str = sb.toString();
        System.out.print(str);
    }

    static void rotate180(String maze[][])
    {
        final int M = maze.length;
        final int N = maze[0].length;
        StringBuilder sb = new StringBuilder();
        for (int row = M - 1; row >= 0; row--)
        {
            for (int col = N - 1; col >= 0; col--)
            {
                sb.append(maze[row][col]);
            }
            sb.append("\n");
        }

        String str = sb.toString();
        System.out.print(str);
    }

    static void rotate270(String maze[][])
    {
        int M = maze.length;
        int N = maze[0].length;
        String[][] rotated = new String[N][M];
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                rotated[N-j-1][i] = maze[i][j];
            }
        }

        M = rotated.length;
        N = rotated[0].length;
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < M; row++)
        {
            for (int col = 0 ; col < N ; col++)
            {
                sb.append(rotated[row][col]);
            }
            sb.append("\n");
        }
        String str = sb.toString();
        System.out.print(str);
    }

    static void printMatrix(String[][] maze)
    {
        final int M = maze.length;
        final int N = maze[0].length;
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < M; row++)
        {
            for (int col = 0 ; col < N ; col++)
            {
                sb.append(maze[row][col]);
            }
            sb.append("\n");
        }
        String str = sb.toString();
        System.out.print(str);
    }



    public static void main(String[] args) 
    {

        if(args.length!=1)
        {
            System.err.println("klops");
            System.exit(0);
        }

        String argument = args[0];        
        char last_letter = argument.charAt(argument.length()-1);
        switch(last_letter)
        {
            case 'W':
            break;
            case 'N':
            break;
            case 'S':
            break;
            case 'E':
            break;
            default:
            System.err.println("klops");
            System.exit(0);
        }      
        
        argument = argument.substring(0, argument.length()-1);
        
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

        Integer size = Integer.parseInt(argument);     
        if(size<1 || size > 10000)
        {
            System.err.println("klops");
            System.exit(0);
        }
        
        String direction = Character.toString(last_letter);
        String next_direction = "";
        Integer path_length = 0;
        
        String[][] maze = new String[size + 3][size + 2];
        maze[1][0] = " ";

        for (int i = 0; i < size+1; i++)
        {
            maze[1][i] = " ";
            path_length++;
        }
        next_direction = "S";
        Integer pos_x = size;
        Integer pos_y = 2;

        while (size > 0)
        {
            switch (next_direction)
            {
                case "W":
                    for (int i = pos_x; i < size + pos_x; i++)
                    {
                        maze[pos_y][i] = " ";
                        path_length++;
                    }
                    pos_x = pos_x + size - 1;
                    pos_y++;
                    size--;
                    next_direction = "S";
                    break;
                case "S":
                    for (int i = pos_y; i < size + pos_y; i++)
                    {
                        maze[i][pos_x] = " ";
                        path_length++;
                    }
                    pos_y = pos_y + size - 1;
                    pos_x--;
                    size--;
                    next_direction = "E";
                    break;
                case "E":
                    for (int i = pos_x; i > pos_x - size; i--)
                    {
                        maze[pos_y][i] = " ";
                        path_length++;
                    }
                    pos_x = pos_x - size + 1;
                    pos_y--;
                    size--;
                    next_direction = "N";
                    break;
                case "N":
                    for (int i = pos_y; i > pos_y - size; i--)
                    {
                        maze[i][pos_x] = " ";
                        path_length++;
                    }
                    pos_y = pos_y - size + 1;
                    pos_x++;
                    size--;
                    next_direction = "W";
                    break;
                default:
                    break;
            }
        }

        for (int row = 0; row < maze.length; row++)
        {
            for (int col = 0; col < maze[row].length; col++)
            {
                if (maze[row][col] == null) maze[row][col] = "*";
            }
        }


        switch (direction)
        {
            case "W":
                printMatrix(maze);
                break;
            case "E":
                rotate180(maze);
                break;
            case "S":
                rotate270(maze);
                break;
            case "N":
                rotate90(maze);
                break;
            default:
                break;
        }
        
        System.out.println(path_length);

    }

    }