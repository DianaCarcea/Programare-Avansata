package Compulsory5;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable  {
    private String name;
    private String path;
    private List<Document> documents = new ArrayList<>();

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public void add(Document doc) {
        documents.add(doc);
    }
    public Document findById(String id) {
        return documents.stream().filter(document -> document.getId().equals(id)).findFirst().orElse(null);
    }

    public String getPath() {
        return  path;
    }
}