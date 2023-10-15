package fr.isep.hotels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.RoomClickedListeners {

    private
    ArrayList<recyclerview_list> recyclerview_lists;

    private RecyclerAdapter roomAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        recyclerView = findViewById(R.id.my_recycler_view);


        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        roomAdapter = new RecyclerAdapter(this);

        recyclerview_lists= new ArrayList<recyclerview_list>();

        recyclerview_lists.add(new recyclerview_list(R.drawable.one, "Room1"));
        recyclerview_lists.add(new recyclerview_list(R.drawable.two, "Room2"));
        recyclerview_lists.add(new recyclerview_list(R.drawable.three, "Room3"));
        recyclerview_lists.add(new recyclerview_list(R.drawable.four, "Room4"));
        recyclerview_lists.add(new recyclerview_list(R.drawable.one, "Room1"));
        recyclerview_lists.add(new recyclerview_list(R.drawable.two, "Room2"));
        recyclerview_lists.add(new recyclerview_list(R.drawable.three, "Room3"));
        recyclerview_lists.add(new recyclerview_list(R.drawable.four, "Room4"));
        recyclerview_lists.add(new recyclerview_list(R.drawable.one, "Room1"));
        recyclerview_lists.add(new recyclerview_list(R.drawable.two, "Room2"));
        recyclerview_lists.add(new recyclerview_list(R.drawable.three, "Room3"));
        recyclerview_lists.add(new recyclerview_list(R.drawable.four, "Room4"));


        roomAdapter.setRoomItemList(recyclerview_lists);

        recyclerView.setAdapter(roomAdapter);


    }


    @Override
    public void onCardClicked(recyclerview_list room) {
        Intent intent = new Intent(MainActivity.this, RoomDetails.class);
        intent.putExtra("roomItem", room); // Change "rooItem" to "roomItem"
        startActivity(intent);
    }



}
