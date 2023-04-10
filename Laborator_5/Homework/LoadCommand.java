package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class LoadCommand implements Command {

    private String path;
    private Catalog catalog;

    public LoadCommand(String path, Catalog catalog) {
        this.path = path;
        this.catalog = catalog;
    }

    @Override
    public void execute() throws Exception {
        Catalog catalog;
        ObjectMapper objectMapper = new ObjectMapper();

        try{
            catalog = objectMapper.readValue(new File(path),Catalog.class);

        } catch (IOException e) {
            throw new InvalidCatalogException(e);
        }
        catalog.setName(catalog.getName());
        catalog.setPath(catalog.getPath());
        catalog.setDocuments(catalog.getDocuments());
    }
}
