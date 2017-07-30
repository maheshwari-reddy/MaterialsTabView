package maheshwari.developer.materialsTabView.main.model.history;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import maheshwari.developer.materialsTabView.model.Conversation;
import maheshwari.developer.materialsTabView.model.Message;
import maheshwari.developer.materialsTabView.utility.api_endpoint.Client;
import maheshwari.developer.materialsTabView.utility.api_endpoint.Endpoint;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryInteractor implements IHistoryInteractor {

    @Override
    public void getFilteredData(final IHistoryResponseListener listener) {
        try {

            Endpoint endpoint = Client.getClient().create(Endpoint.class);
            Call<Conversation> call = endpoint.getConversationList("");
            call.enqueue(new Callback<Conversation>() {
                @Override
                public void onResponse(Call<Conversation> call, Response<Conversation> response) {
                    List<Message> messageList = response.body().getMessages();
                    ArrayList<String> names = new ArrayList<String>();
                    for (int i = 0; i < messageList.size(); i++) {
                        names.add(messageList.get(i).getName());
                    }
                    Set<String> uniqueSet = new HashSet<String>(names);
                    for (String temp : uniqueSet) {
                        listener.onSuccess(temp, 1);
                    }
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
