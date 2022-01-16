package com.example.a15rv_foreground_and_background_cell.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a15rv_foreground_and_background_cell.R;
import com.example.a15rv_foreground_and_background_cell.model.User;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<User> users;

    public CustomAdapter(Context context, List<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_view,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        User user = users.get(position);
        if (holder instanceof CustomViewHolder){
            TextView name = ((CustomViewHolder)holder).name;
            TextView location = ((CustomViewHolder)holder).location;

            name.setText(user.getName());
            location.setText(user.getLocation());
        }
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public TextView name,location;
        public RelativeLayout view_foreground, view_background;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;

            name = view.findViewById(R.id.name);
            location = view.findViewById(R.id.location);

            view_foreground = view.findViewById(R.id.view_foreground);
            view_background = view.findViewById(R.id.view_background);
        }
    }
}
