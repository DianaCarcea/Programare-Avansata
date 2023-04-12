package org.example;

import java.util.*;

public class SharedMemory {
    private final List<Token> listOfTokens=new ArrayList<>();
    public SharedMemory(int n) {
        List<Integer> number = new ArrayList<>();
        n=n+1;
        for(int i=0;i<=n*n*n;i++)
        {
            number.add(i);
        }

        Collections.shuffle(number);

        for (Integer integer : number) {
            listOfTokens.add(new Token(integer));
        }

    }
    //sunt sincronizate extragerile
    public synchronized List<Token> extractTokens(int howMany) {
        List<Token> extracted = new ArrayList<>();
        for (int i = 0; i <howMany; i++) {
            if (listOfTokens.isEmpty()) {
                break;
            }
            extracted.add(listOfTokens.get(i));
            listOfTokens.remove(listOfTokens.get(i));

        }
        return extracted;
    }

}
