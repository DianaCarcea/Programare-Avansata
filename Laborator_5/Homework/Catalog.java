package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable  {
    private String name;
    private String path;
    private List<Document> documents = new ArrayList<>();

    public Catalog(){}

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return  path;
    }

    public void add(Document doc) {
        documents.add(doc);
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

}