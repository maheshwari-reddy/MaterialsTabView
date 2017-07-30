package maheshwari.developer.materialsTabView.main.model.history;

public interface IHistoryView {

    void onError(String errorResponse);

    void onSuccess(String nameOccurrences, int totalFavourite);
}
