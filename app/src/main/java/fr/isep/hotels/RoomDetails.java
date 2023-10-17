package fr.isep.hotels;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RoomDetails extends AppCompatActivity {

    private ImageView shoeImageView;
    private TextView title;

    private recyclerview_list room;

    private TextView price;
    private TextView description;
    private TextView Location;

    private TextView rating;
    private TextView bookingSite;

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
        price.setText(room.getPrice());
        description.setText(room.getDescription());
        Location.setText(room.getLocation());
        rating.setText(room.getRating());

    }

    private void initializeVariables() {

        title = findViewById(R.id.roomTitle);
        shoeImageView = findViewById(R.id.eachRoom);
        price = findViewById(R.id.roomPrice);
        description = findViewById(R.id.roomDescription);
        Location = findViewById(R.id.roomLocation);
        rating = findViewById(R.id.roomRating);





    }
}