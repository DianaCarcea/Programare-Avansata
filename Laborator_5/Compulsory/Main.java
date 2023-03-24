package Compulsory5;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Main app = new Main();

        try {
            app.testCreateSave();
            app.testLoadView();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void testCreateSave() {
        Catalog catalog = new Catalog("catalog", "C:/Users/Mihaela/Desktop/DocJson/mydoc.json");

        var book = new Document("book1", "Romeo and Juliet","https://ro.wikipedia.org/wiki/Romeo_%C8%99i_Julieta");
        var document = new Document("article1", "Femei care au scris istorie", "file:///C:/Users/Mihaela/Desktop/LICEU/Subiecte%20atestat/Femei%20care%20au%20scris%20istorie/index.html");

        book.addTag("author", " William Shakespeare");
        document.addTag("own page", "html page");

        catalog.add(book);
        catalog.add(document);

        try {
            CatalogUtil.save(catalog);
        }
        catch (IOException exception) {

            exception.printStackTrace();
        }
    }

    private void testLoadView() {
        try {
            Catalog catalog = CatalogUtil.load("C:/Users/Mihaela/Desktop/DocJson/mydoc.json");

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}