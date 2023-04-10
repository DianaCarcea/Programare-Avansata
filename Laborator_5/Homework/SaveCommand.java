package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class SaveCommand implements Command {
    private String path;
    private Catalog catalog;

    public SaveCommand(String path, Catalog catalog) {
        this.path = path;
        this.catalog = catalog;
    }


    @Override
    public void execute() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(path), catalog);
        }
        catch (IOException e)
        {
            throw new InvalidCatalogException(e);
        }
    }
}
