package maheshwari.developer.materialsTabView.main.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import maheshwari.developer.materialsTabView.R;
import maheshwari.developer.materialsTabView.custom_view.HistoryButtonView;
import maheshwari.developer.materialsTabView.main.model.history.HistoryPresenter;
import maheshwari.developer.materialsTabView.main.model.history.IHistoryView;

public class HistoryFragment extends Fragment implements IHistoryView{

    HistoryButtonView btnView;
    int count = 1;
    private HistoryPresenter presenter;

    public HistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        presenter = new HistoryPresenter(this);
        presenter.getFilteredData();
        btnView = (HistoryButtonView)view.findViewById(R.id.btnView);
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count % 2 == 0)
                    btnView.reset();
                else
                    btnView.startAnimation();
                count++;
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onError(String errorResponse) {
        Toast.makeText(getActivity(),errorResponse,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(String nameOccurrences, int totalFavourite) {

    }
}
