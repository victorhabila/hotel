package fr.isep.hotels;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class pages extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pages);

        int pageId = getIntent().getIntExtra("id", 0);

        TextView textPageid = findViewById(R.id.textPageId);
        textPageid.setText("PAGE : " + pageId);

    }
}