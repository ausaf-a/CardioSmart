package me.ausaf.cardiosmart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class HeartInfoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_info);


        plotHRVData();
    }

    public void handleBack(View view) {
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }

    public void handleStatusClick(View view){
        Intent myIntent = new Intent(this, DetailsActivity.class);
        startActivity(myIntent);
    }

    private void plotHRVData(){
        GraphView graph = (GraphView) findViewById(R.id.hrv_graph);

        DataPoint[] points = new DataPoint[50];

        for(int i = 0; i < points.length; i++){
            points[i] = new DataPoint(i, Math.sin(i));
        }


        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(points);
        graph.addSeries(series);
    }


}
