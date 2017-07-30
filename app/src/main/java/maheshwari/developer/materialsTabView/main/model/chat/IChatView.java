package maheshwari.developer.materialsTabView.main.model.chat;

import java.util.List;

import maheshwari.developer.materialsTabView.model.Message;

public interface IChatView {

    void onError(String errorResponse);

    void onSuccess(List<Message> messages);
}
