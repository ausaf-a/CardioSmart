package me.ausaf.cardiosmart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class HeartInfoActivity extends AppCompatActivity {

    boolean cDeath = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_info);

    }

    public void handleBack(View view) {
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }

    public void handleStatusClick(View view){

    }


    public void handleSimClick(View view) {
        cDeath = !cDeath;
    }

    public void showTips(View view) {
    }
}
