package me.ausaf.cardiosmart;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handleSubmit(View v){
        Intent myIntent = new Intent(MainActivity.this, HeartInfoActivity.class);
        startActivity(myIntent);
    }

}
