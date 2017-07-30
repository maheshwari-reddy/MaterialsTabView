package maheshwari.developer.materialsTabView.main.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import maheshwari.developer.materialsTabView.R;
import maheshwari.developer.materialsTabView.main.model.chat.ChatPresenter;
import maheshwari.developer.materialsTabView.main.model.chat.IChatView;
import maheshwari.developer.materialsTabView.main.view.adapter.ChatAdapter;
import maheshwari.developer.materialsTabView.model.Message;

public class ChatFragment extends Fragment implements IChatView, ChatAdapter.IChatAdapterCallback {

    RecyclerView list;
    private List<Message> messageList;
    private ChatPresenter presenter;
    private ChatAdapter adapter;

    public ChatFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        list = (RecyclerView) view.findViewById(R.id.list);
        messageList = new ArrayList<>();
        presenter = new ChatPresenter(this);
        presenter.getConversationList();
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
        Toast.makeText(getActivity(), errorResponse, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(List<Message> messages) {
        messageList.clear();
        messageList.addAll(messages);
        list.setHasFixedSize(true);
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        if (messageList.size() > 0) {
            adapter = new ChatAdapter(getActivity(), messageList, this);
            this.list.setAdapter(adapter);
        } else {
            Toast.makeText(getActivity(), "No conversations found.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void addMessageToFavourite(int position) {
        // TODO
    }
}