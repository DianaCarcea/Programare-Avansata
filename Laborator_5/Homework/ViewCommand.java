package org.example;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ViewCommand implements Command{
    private String path;
    private Catalog catalog;
    private Document document;

    public ViewCommand(Catalog catalog, Document document) {
        this.path = path;
        this.catalog = catalog;
        this.document = document;
    }

    @Override
    public void execute() throws InvalidCatalogException, URISyntaxException {
        Desktop desktop=Desktop.getDesktop();
        String location= document.getLocation();

        if(location.contains("http:") || location.contains("https:")) {
            try {
                URI uri = new URI(document.getLocation());
                desktop.browse(uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
        {
            try {
                File file=new File(document.getLocation());
                desktop.open(file);
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }
}
