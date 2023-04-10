package org.example;

import java.awt.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import java.io.IOException;
import java.io.PrintWriter;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class ReportCommand implements Command{

    private Catalog catalog;
    private Path path;

    public ReportCommand(Catalog catalog,String path) {
        this.catalog=catalog;
        this.path = Path.of(path);
    }

    public void execute() throws Exception {

        Template template;
        Configuration config = new Configuration(Configuration.VERSION_2_3_31);

        try {
            config.setDirectoryForTemplateLoading(new File("C:\\Users\\Mihaela\\Desktop\\FISIERE\\DocJson"));
            template = config.getTemplate("myTemplate.ftl");
        }
        catch (IOException exception)
        {
            throw new InvalidCatalogException(exception);
        }

        Map<String,Object> allData=new HashMap<>();

        List<Document> documents=catalog.getDocuments().stream()
                .collect(Collectors.toList());

        Path htmlFile = path.resolve("myReport.html");

        allData.put("documents",documents);

        try {
            PrintWriter writer = new PrintWriter(Files.newBufferedWriter(htmlFile));
            template.process(allData,writer);
            writer.flush();
        }
        catch (IOException exception)
        {
            throw new InvalidCatalogException(exception);
        }
        catch (TemplateException exception)
        {
            throw new InvalidCatalogException(exception);
        }

        Desktop desktop = Desktop.getDesktop();
        String location = String.valueOf(path);
        location=location+"/myReport.html";

        try {
            File file = new File(location);
            desktop.open(file);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}