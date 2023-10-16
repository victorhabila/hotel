package fr.isep.hotels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
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

    private List<recyclerview_list> recyclerview_lists;

    private RecyclerAdapter roomAdapter;
    private RecyclerView recyclerView;
    private EditText searchEditText;
    private List<recyclerview_list> filteredRoomList;


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
        recyclerview_lists = new ArrayList<>();

        recyclerview_lists.add(new recyclerview_list(R.drawable.one, "Paris"));
        recyclerview_lists.add(new recyclerview_list(R.drawable.two, "Creteil"));
        recyclerview_lists.add(new recyclerview_list(R.drawable.three, "Massy"));
        recyclerview_lists.add(new recyclerview_list(R.drawable.four, "Montreuil"));
        recyclerview_lists.add(new recyclerview_list(R.drawable.one, "Versailles"));
        recyclerview_lists.add(new recyclerview_list(R.drawable.two, "Saint-Denis"));
        recyclerview_lists.add(new recyclerview_list(R.drawable.three, "Orleans"));
        recyclerview_lists.add(new recyclerview_list(R.drawable.four, "Olivet"));
        recyclerview_lists.add(new recyclerview_list(R.drawable.one, "Checy"));
        recyclerview_lists.add(new recyclerview_list(R.drawable.two, "Nantes"));
        recyclerview_lists.add(new recyclerview_list(R.drawable.three, "Reze"));
        recyclerview_lists.add(new recyclerview_list(R.drawable.four, "Lyon"));

        filteredRoomList = new ArrayList<>(recyclerview_lists);

        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));


        roomAdapter = new RecyclerAdapter(this);
        roomAdapter.setRoomItemList(filteredRoomList);
        recyclerView.setAdapter(roomAdapter);

        searchEditText = findViewById(R.id.searchEditText);

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterRooms(s.toString());
            }


            @Override
            public void afterTextChanged(Editable s) { }
        });


        roomAdapter.setRoomItemList(recyclerview_lists);

        recyclerView.setAdapter(roomAdapter);


    }


    private void filterRooms(String query) {
        filteredRoomList.clear();

        for (recyclerview_list room : recyclerview_lists) {
            if (room.getAd_title().toLowerCase().contains(query.toLowerCase())) {
                filteredRoomList.add(room);
            }
        }

        roomAdapter.setRoomItemList(filteredRoomList); // Update the adapter with filtered data
        roomAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCardClicked(recyclerview_list room) {
        Intent intent = new Intent(MainActivity.this, RoomDetails.class);
        intent.putExtra("roomItem", room); // Change "rooItem" to "roomItem"
        startActivity(intent);
    }



}
