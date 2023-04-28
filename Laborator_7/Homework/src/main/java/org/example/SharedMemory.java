package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    //sincronizare extrageri
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
