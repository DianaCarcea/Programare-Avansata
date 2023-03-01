public class Main {
    public static void main(String args[])
    {
        if(args.length==0) {
            System.out.println("Insufficient number of arguments!");
            System.exit(-1);
        }

        ValidArgument(args[0]);

        int n=Integer.parseInt(args[0]);
        int [][] A =new int[n+1][n+1];

        setAdjacencyMatrix(n,A);
        getMatrix(n,A);
        System.out.print("\n");

        int [][] powersA =new int[n+1][n+1];
        setAdjacencyMatrix(n,powersA);

        for(int k=2;k<=n;k++)
        {
            powersA=setPowersA(n,powersA,A);
            getMatrix(n,powersA);
            System.out.print("\n");
        }
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

    public static void setAdjacencyMatrix(int n, int [][]mat) {
        for(int i=0;i<n;i++)
        {
            mat[i][i+1]=1;
            mat[i+1][i]=1;
        }
        mat[0][n-1]=1;
        mat[n-1][0]=1;
    }

    public static int[][] setPowersA(int n, int [][]previousResult,int [][]InitA) {
        int[][] resultMul= new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int s = 0; s < n; s++) {
                    resultMul[i][j] +=  previousResult[i][s] * InitA[s][j];
                }
            }
        }
        return resultMul;
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
