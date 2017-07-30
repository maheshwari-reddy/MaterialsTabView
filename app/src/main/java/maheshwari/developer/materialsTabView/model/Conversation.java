package maheshwari.developer.materialsTabView.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Conversation {

    @SerializedName("count")
    private int count;
    @SerializedName("messages")
    private  List<Message> messages;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}

