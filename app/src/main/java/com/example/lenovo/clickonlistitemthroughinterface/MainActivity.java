package com.example.lenovo.clickonlistitemthroughinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MyRecyleViewAdapter adapter;
    ArrayList<ModelClass> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView =findViewById(R.id.recyleView);
        recyclerView.hasFixedSize();

        list = new ArrayList<>();
        list.add(new ModelClass("first",R.drawable.ic_launcher_foreground));
        list.add(new ModelClass("second",R.drawable.ic_launcher_foreground));

        adapter = new MyRecyleViewAdapter(this,list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);

        adapter.SetOnItemClickLisner(new MyRecyleViewAdapter.OnitemClickLisner() {
            @Override
            public void onItemClick(int position) {
                list.get(position).changeText("changed");
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onDeletItemClick(int position) {
                list.remove(position);
                adapter.notifyItemRemoved(position);
            }
        });

    }

}
