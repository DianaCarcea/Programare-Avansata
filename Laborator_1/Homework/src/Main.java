public class Main {
    public static void main(String args[])
    {
        long t_start=System.nanoTime();
        if(args.length==0) {
            System.out.println("Insufficient number of arguments!");
            System.exit(-1);
        }

        ValidArgument(args[0]);

        int n=Integer.parseInt(args[0]);
        int mat [][]=new int[n+1][n+1];

        setLatinSquare(n,mat);

        if(n<30000) {
            getMatrix(n,mat);
            getLinesAndColumns(n,mat);
        }

        long t_stop=System.nanoTime();
        long t_final=t_stop-t_start;
        System.out.print("Running time of the application is: " + t_final);

    }
    public static void ValidArgument(String n){
        try {
            if (Integer.parseInt(n) <= 0) {
                System.out.println("The number n must be greater than 0!");
                System.exit(-1);
            } else
                System.out.println("The number is: " + n);
        }
        catch (NumberFormatException mes)
        {
            System.out.println("The number " + n + " is not an integer!");
            System.exit(-1);
        }
    }

    public static void setLatinSquare(int n,int[][] mat){
        for(int i=0;i<n;i++)
        {
            int nr_line=i+1;
            for(int j=0;j<n;j++) {
                if (nr_line % (n+1) == 0) {
                    nr_line++;
                }
                //cand dau de o valoare care se divide la (n+1) cresc inca o data linia
                mat[i][j] = (nr_line++) % (n+1);
            }
        }
    }

    public static void getLinesAndColumns(int n,int[][] mat){
        String line,column;
        for(int i=0;i<n;i++)
        {
            line=new String();
            column=new String();
            for (int j = 0; j < n; j++)
            {
                line=line+Integer.toString(mat[i][j])+" ";
                column=column+Integer.toString(mat[j][i])+" ";
            }
            System.out.print("Line_"+ i + " : " + line);
            System.out.print("\n");
            System.out.print("Column_"+ i + " : " + column);
            System.out.print("\n");
        }
    }

    public static void getMatrix(int n,int[][] mat){
        for(int i=0;i<n;i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print(mat[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
