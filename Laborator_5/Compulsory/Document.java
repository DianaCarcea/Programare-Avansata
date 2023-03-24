package Compulsory5;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Document  implements Serializable {

    private String id;
    private String title;
    private String location; //file name or Web page
    private Map<String, Object> tags = new HashMap<>();

    public Document(String id, String title, String location) {
        this.id = id;
        this.title = title;
        this.location = location;
    }
    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", tags=" + tags +
                '}';
    }
}