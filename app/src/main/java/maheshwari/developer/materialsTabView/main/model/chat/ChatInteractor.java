package maheshwari.developer.materialsTabView.main.model.chat;

import android.util.Log;

import java.util.List;

import maheshwari.developer.materialsTabView.model.Conversation;
import maheshwari.developer.materialsTabView.model.Message;
import maheshwari.developer.materialsTabView.utility.api_endpoint.Client;
import maheshwari.developer.materialsTabView.utility.api_endpoint.Endpoint;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChatInteractor implements IChatInteractor {

    @Override
    public void getConversationList(final IChatResponseListener listener) {
        try {
            Endpoint endpoint = Client.getClient().create(Endpoint.class);
            Call<Conversation> call = endpoint.getConversationList("");
            call.enqueue(new Callback<Conversation>() {
                @Override
                public void onResponse(Call<Conversation> call, Response<Conversation> response) {
                    List<Message> messageList = response.body().getMessages();
                    for (int i = 0; i < messageList.size(); i++) {
                        Log.i("TAG : ", "name  : " + messageList.get(i).getName());
                    }
                    listener.onSuccess(messageList);
                }

                @Override
                public void onFailure(Call<Conversation> call, Throwable t) {
                    t.printStackTrace();
                    listener.onError("Sorry! An error occurred");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            listener.onError("Sorry! An error occurred");
        }
    }
}
