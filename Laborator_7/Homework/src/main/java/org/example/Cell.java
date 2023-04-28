package org.example;

import java.util.List;

public class Cell {
    private List<Token> listOfTokens;

    public Cell(List<Token> listOfTokens) {
        this.listOfTokens = listOfTokens;
    }

    public List<Token> getListOfTokens() {
        return listOfTokens;
    }

    public void setListOfTokens(List<Token> listOftokens) {
        this.listOfTokens = listOftokens;
    }
}
