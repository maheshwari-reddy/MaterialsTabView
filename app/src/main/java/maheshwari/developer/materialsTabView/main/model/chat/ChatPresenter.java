package maheshwari.developer.materialsTabView.main.model.chat;

import java.util.List;

import maheshwari.developer.materialsTabView.model.Message;

public class ChatPresenter implements IChatPresenter, IChatResponseListener {

    private IChatView view;
    private ChatInteractor interactor;

    public ChatPresenter(IChatView view) {
        this.view = view;
        this.interactor = new ChatInteractor();
    }

    @Override
    public void getConversationList() {
        interactor.getConversationList(this);
    }

    @Override
    public void onError(String errorResponse) {
        view.onError(errorResponse);
    }

    @Override
    public void onSuccess(List<Message> messages) {
        view.onSuccess(messages);
    }
}
