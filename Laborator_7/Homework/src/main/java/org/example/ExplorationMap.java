package org.example;

import java.util.ArrayList;
import java.util.List;

public class ExplorationMap {
    private Cell[][] matrix;
    private SharedMemory memory;
    private int n;

    public ExplorationMap(int n,SharedMemory memory) {
        this.n = n;
        matrix=new Cell[n+1][n+1];
        List<Token> emptyListOfTokens=new ArrayList<>();

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
                matrix[i][j]= new Cell(emptyListOfTokens);
        }

        this.memory=memory;
    }

    public boolean occupiedCell(int row, int col)
    {
        synchronized (matrix[row][col]) {
            if (matrix[row][col].getListOfTokens().size() == 0) {
                return true;
            }
            return false;
        }
    }
    public List getEmptyCell()
    {
        List<Integer> position = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                if (matrix[i][j].getListOfTokens().size() == 0) {
                    position.add(i);
                    position.add(j);
                    return position;
                }
        }
        return null;
    }

    //vizitare concurenta
    //sincronizare pt o celula
    public void visit(int row, int col, Robot robot) {
        synchronized (matrix[row][col])
        {
//            System.out.println("Robotul: "+robot.getName()+" a vizitat celula: "+row+" "+col+ " cu"+" succes");
            robot.updateNumberOfTokensPlaced(n);

            List<Token> extracted = memory.extractTokens(n);
            matrix[row][col].setListOfTokens(extracted);
        }
    }
    public String toString() {

        String outputString="";
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                outputString=outputString+"Celula "+i+" "+j+":\n";
                for(Token token : matrix[i][j].getListOfTokens())
                {
                    outputString=outputString+token.getNumber()+' ';
                }
                outputString=outputString+"\n";
            }
        }

        return outputString;

    }
}