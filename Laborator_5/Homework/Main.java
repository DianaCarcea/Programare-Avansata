package org.example;

public class Main {
    public static void main(String[] args) throws Exception {

        Catalog catalog1=new Catalog("objects","C:\\Users\\Mihaela\\Desktop\\FISIERE\\DocJson\\mydoc.json");
        var book = new Document("book1", "Romeo and Juliet","https://ro.wikipedia.org/wiki/Romeo_%C8%99i_Julieta");
        var document = new Document("article1", "Alpaca page", "https://ro.wikipedia.org/wiki/Alpaca");

        Command commandForAdd1=new AddCommand(book, catalog1);
        Command commandForAdd2=new AddCommand(document, catalog1);
        commandForAdd1.execute();
        commandForAdd2.execute();

        Command commandForList=new ListCommand(catalog1);
        commandForList.execute();

        Command commandForView=new ViewCommand(catalog1,document);
        commandForView.execute();

        Command commandForSave=new SaveCommand("C:\\Users\\Mihaela\\Desktop\\FISIERE\\DocJson\\mydoc.json",catalog1);
        commandForSave.execute();

        Catalog loadCatalog1=new Catalog();
        Command commandForLoad=new LoadCommand("C:\\Users\\Mihaela\\Desktop\\FISIERE\\DocJson\\mydoc.json",loadCatalog1);
        commandForLoad.execute();

        Command commandForReport=new ReportCommand(catalog1,"C:\\Users\\Mihaela\\Desktop\\FISIERE\\DocJson");
        commandForReport.execute();

    }
}