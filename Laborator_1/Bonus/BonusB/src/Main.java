public class Main {
    public static void main(String args[])
    {
        if(args.length!=2) {
            System.out.println("Insufficient number of arguments!");
            System.exit(-1);
        }

        ValidArgument(args[0],args[1]);

        int n=Integer.parseInt(args[0]);
        int d=Integer.parseInt(args[1]);

        int [][] A =new int[n+1][n+1];

        setAdjacencyMatrix(n,d,A);
        getMatrix(n,A);
        System.out.print("\n");
    }
    public static void ValidArgument(String n,String d){
        try {
            if (Integer.parseInt(n) <= 0) {
                System.out.println("The number of vertices must be greater than 0!");
                System.exit(-1);

            } else if(!(Integer.parseInt(n)>=Integer.parseInt(d)+1 && (Integer.parseInt(n)*Integer.parseInt(d)%2==0)))
            {
                System.out.println("You can't build a regular graph with these numbers!");
                System.exit(-1);
            }else
            {
                System.out.println("The number of degrees is: " + n);
                System.out.println("The number of vertices is: " + d);
            }

        }
        catch (NumberFormatException mes)
        {
            System.out.println("The number of degrees" + n + " is not an integer!");
            System.out.println("The number of vertices" + d + " is not an integer!");
            System.exit(-1);
        }
    }

    public static void setAdjacencyMatrix(int n, int d, int [][]mat) {
        for(int i=0;i<n;i++)
        {
            for(int j=1;j<=d/2;j++)
            {
                mat[i][(i+j)%n]=1;
                mat[(i+j)%n][i]=1;
            }
        }
        if(d%2!=0 && n%2==0)
        {
            for(int i=0;i<n;i++)
            {
                mat[i][(i+n/2)%n]=1;
                mat[(i+n/2)%n][i]=1;
            }
        }
    }


    public static void getMatrix(int n, int [][]mat) {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                System.out.print(mat[i][j]+" ");
            System.out.print("\n");
        }
    }
}
