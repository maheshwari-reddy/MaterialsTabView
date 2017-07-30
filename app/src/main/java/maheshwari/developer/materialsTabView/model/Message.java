package maheshwari.developer.materialsTabView.model;

import com.google.gson.annotations.SerializedName;

public class Message {

    @SerializedName("body")
    private String body;
    @SerializedName("username")
    private String username;
    @SerializedName("Name")
    private String name;
    @SerializedName("image-url")
    private String image;
    @SerializedName("message-time")
    private String dateTime;
    @SerializedName("favourite")
    private int favourite;

    public Message(String body, String username, String name, String image, String dateTime, int favourite) {
        this.body = body;
        this.username = username;
        this.name = name;
        this.image = image;
        this.dateTime = dateTime;
        this.favourite = favourite;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getFavourite() {
        return favourite;
    }

    public void setFavourite(int favourite) {
        this.favourite = favourite;
    }
}
