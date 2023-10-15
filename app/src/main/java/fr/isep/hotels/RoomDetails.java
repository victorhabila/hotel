package fr.isep.hotels;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RoomDetails extends AppCompatActivity {

    private ImageView shoeImageView;
    private TextView title;

    private recyclerview_list room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_details);

        room = getIntent().getParcelableExtra("roomItem");

        initializeVariables();


        if (room != null) {
            setDataToWidgets();
        }


    }
    private void setDataToWidgets()
    {
        title.setText(room.getAd_title());
        shoeImageView.setImageResource(room.getPhoto_one());
    }

    private void initializeVariables() {


        shoeImageView = findViewById(R.id.eachRoom);
        title = findViewById(R.id.roomTitle);


    }
}