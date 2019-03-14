package me.ausaf.cardiosmart;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class HeartInfoActivity extends AppCompatActivity {

    boolean cDeath = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_info);
        showHealthy();



    }

    public void handleBack(View view) {
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }

    public void handleStatusClick(View view){

    }


    public void handleSimClick(View view) {
        cDeath = !cDeath;
        if(cDeath){
            showAlert();
        }else{
            showHealthy();
        }

    }

    private void showHealthy(){
        HeartRateView hrv = (HeartRateView) findViewById(R.id.ppg);
        hrv.lineColor = getColor(R.color.colorHealthy);
        ImageView heart = (ImageView) findViewById(R.id.statusHeart);
        ImageView smallHeart = (ImageView) findViewById(R.id.smallHeart);
        Drawable icon = getDrawable(R.drawable.ic_heart_green);
        TextView status = (TextView) findViewById(R.id.riskStatus);
        RelativeLayout bg = (RelativeLayout) findViewById(R.id.backdrop);
        status.setText("Healthy");
        status.setTextColor(getColor(R.color.colorHealthy));
        heart.setImageDrawable(icon);
        bg.setBackgroundColor(getColor(R.color.colorHealthy));
        smallHeart.setImageDrawable(getDrawable(R.drawable.ic_heartbeat_green));


        Button sim = (Button) findViewById(R.id.simulate);

        sim.setTextColor(getColor(R.color.colorHealthy));
    }

    private void showAlert(){
        HeartRateView hrv = (HeartRateView) findViewById(R.id.ppg);
        hrv.lineColor = getColor(R.color.colorPrimary);

        ImageView heart = (ImageView) findViewById(R.id.statusHeart);
        ImageView smallHeart = (ImageView) findViewById(R.id.smallHeart);


        Drawable icon = getDrawable(R.drawable.ic_heart_red);
        RelativeLayout bg = (RelativeLayout) findViewById(R.id.backdrop);
        TextView status = (TextView) findViewById(R.id.riskStatus);

        status.setText("Seek Medical Attention!");
        status.setTextColor(getColor(R.color.colorPrimary));
        heart.setImageDrawable(icon);
        bg.setBackgroundColor(getColor(R.color.colorPrimary));
        smallHeart.setImageDrawable(getDrawable(R.drawable.ic_heartbeat));
    
        Button sim = (Button) findViewById(R.id.simulate);

        sim.setTextColor(getColor(R.color.colorPrimary));
    }

    public void showTips(View view) {
    }










}
