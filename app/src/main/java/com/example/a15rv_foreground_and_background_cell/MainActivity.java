package com.example.a15rv_foreground_and_background_cell;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.a15rv_foreground_and_background_cell.adapter.CustomAdapter;
import com.example.a15rv_foreground_and_background_cell.helper.RecyclerItemTouchHelper;
import com.example.a15rv_foreground_and_background_cell.model.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        List<User> users = prepareUserList();
        refreshAdapter(users);
    }

    private List<User> prepareUserList() {
        List<User> users = new ArrayList<>();
        for (int i=1; i<31; i++){
            users.add(new User(i+" Android", i+"Californiya"));
        }
        return users;
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemTouchHelper(0,ItemTouchHelper.RIGHT, new RecyclerItemTouchHelper.RecyclerItemTouchHelperListener() {
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {

            }
        });
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);
    }

    public void refreshAdapter(List<User> users){
        CustomAdapter adapter = new CustomAdapter(context, users);
        recyclerView.setAdapter(adapter);
    }
}