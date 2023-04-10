package org.example;

public class ListCommand implements Command{

    private Catalog catalog;

    public ListCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void execute() throws Exception {

        String display;
        display="The "+catalog.getName()+" catalog contains the documents: "+ '\n';
        for (Document doc:catalog.getDocuments())
        {
            display=display+doc+'\n';
        }
        System.out.println(display);
    }
}
