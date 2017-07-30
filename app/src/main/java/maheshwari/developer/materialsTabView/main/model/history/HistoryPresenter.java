package maheshwari.developer.materialsTabView.main.model.history;

public class HistoryPresenter implements IHistoryPresenter, IHistoryResponseListener {

    private IHistoryView view;
    private HistoryInteractor interactor;

    public HistoryPresenter(IHistoryView view) {
        this.view = view;
        this.interactor = new HistoryInteractor();
    }

    @Override
    public void getFilteredData() {
        interactor.getFilteredData(this);
    }

    @Override
    public void onError(String errorResponse) {
        view.onError(errorResponse);
    }

    @Override
    public void onSuccess(String nameOccurrences, int totalFavourite) {
        view.onSuccess(nameOccurrences, totalFavourite);
    }
}
