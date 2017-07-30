package maheshwari.developer.materialsTabView.main.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import maheshwari.developer.materialsTabView.R;
import maheshwari.developer.materialsTabView.model.Message;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    private Context context;
    private List<Message> messages;
    private IChatAdapterCallback callback;
    private boolean flag = false;

    public ChatAdapter(Context context, List<Message> messages, IChatAdapterCallback callback) {
        this.context = context;
        this.messages = messages;
        this.callback = callback;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.name.setText(messages.get(position).getName());
        holder.message.setText(messages.get(position).getBody());
        holder.dateTime.setText(messages.get(position).getDateTime().replace("T", " "));
        Glide.with(context)
                .load(messages.get(position).getImage())
                .bitmapTransform(new CropCircleTransformation(context))
                .placeholder(R.mipmap.ic_launcher)
                .crossFade()
                .into(holder.img);
        holder.favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.favourite.setImageResource(R.drawable.unfavourite);
                if (!flag) {
                    flag = true;
                    holder.favourite.setImageResource(R.drawable.favourite);
                } else {
                    flag = false;
                    holder.favourite.setImageResource(R.drawable.unfavourite);
                }
                callback.addMessageToFavourite(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView name;
        TextView dateTime;
        TextView message;
        ImageView favourite;

        public ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img);
            name = (TextView) itemView.findViewById(R.id.name);
            dateTime = (TextView) itemView.findViewById(R.id.dateTime);
            message = (TextView) itemView.findViewById(R.id.message);
            favourite = (ImageView) itemView.findViewById(R.id.favourite);
        }
    }

    public interface IChatAdapterCallback {

        void addMessageToFavourite(int position);
    }
}
