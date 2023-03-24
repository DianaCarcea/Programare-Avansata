package Compulsory5;

import java.io.*;

public class CatalogUtil {
    public static void save(Catalog catalog) throws IOException {

        //decorator care stie sa tranforme continutul in mod binar
        try (var objectOutputStream = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))) {
            objectOutputStream.writeObject(catalog);
        }
    }

    public static Catalog load(String path) throws InvalidCatalogException {
        Object catalog;

        try (var objectInputStream = new ObjectInputStream(new FileInputStream(path))) {

            catalog = objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException exception) {
            throw new InvalidCatalogException(exception);
        }

        return (Catalog) catalog;
    }

}