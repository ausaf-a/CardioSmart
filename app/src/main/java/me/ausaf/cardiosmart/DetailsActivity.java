package me.ausaf.cardiosmart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


    }

    public void handleBack(View view) {
        Intent myIntent = new Intent(this, HeartInfoActivity.class);
        startActivity(myIntent);
    }
}
