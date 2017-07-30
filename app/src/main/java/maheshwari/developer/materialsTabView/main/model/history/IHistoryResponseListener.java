package maheshwari.developer.materialsTabView.main.model.history;

public interface IHistoryResponseListener {

    void onError(String errorResponse);

    void onSuccess(String nameOccurrences, int totalFavourite);
}
