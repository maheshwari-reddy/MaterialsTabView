package maheshwari.developer.materialsTabView.utility.api_endpoint;

import maheshwari.developer.materialsTabView.model.Conversation;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Endpoint {

    @GET("test_data/")
    Call<Conversation> getConversationList(@Query("") String name);
}
