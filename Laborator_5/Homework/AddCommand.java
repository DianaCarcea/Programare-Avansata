package org.example;

public class AddCommand implements Command {

    private Document document;
    private Catalog catalog;

    public AddCommand(Document document, Catalog catalog) {
        this.document = document;
        this.catalog = catalog;
    }

    @Override
    public void execute() throws Exception {
        try{
            catalog.getDocuments().add(document);
        }catch (Exception e){
            System.err.println("Eroare la adaugarea unui document in catalog!");
            e.printStackTrace();
        }

    }
}
