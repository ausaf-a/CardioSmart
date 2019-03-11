package me.ausaf.cardiosmart;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Random;

/**
 * TODO: document your custom view class.
 */
public class HeartRateView extends View {


    private Paint paint;
    private int width = 100, height = 100;
    Bitmap frame;
    Canvas frameDrawer;
    Rect bounds;
    Random random;
    int i = 0;

    private void init(){
        paint = new Paint();
        random = new Random();
    }

    public HeartRateView(Context context) {
        super(context);
        init() ;

    }

    public HeartRateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HeartRateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private Point[] points;
    private int spacing = 40, maxHeight = 200, speed = 4;

    public int lineColor = Color.RED;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Log.d("onDraw", "w:" + width + ", h:" + height);

        if(i == 0){
            points = new Point[width/5];
            frame = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            frameDrawer = new Canvas(frame);
            bounds = new Rect(0, 0, width, height);

            for(int i = 0; i < points.length; i++){
                points[i] = new Point(i*spacing,height/2 + random.nextInt(2*maxHeight) - maxHeight);
            }
        }
        frame.eraseColor(Color.WHITE);
        //draw points
        paint.setColor(lineColor);
        paint.setStrokeWidth(8.0f);
        for(int i = 1; i < points.length; i++){
            Point p = points[i];
            Point l = points[i-1];
            frameDrawer.drawLine(l.x, l.y, p.x, p.y, paint);
        }

        //update points
        for(int i = 0; i < points.length; i++){
            points[i].x-=speed;
        }

        //remove points that have moved off the screen
        if(points[0].x < -10){
            for(int i = 0; i < points.length-1; i++){
                points[i] = points[i+1];
            }
            Point last = points[points.length - 1];
            points[points.length - 1] = new Point(last.x + spacing,height/2 + random.nextInt(2*maxHeight) - maxHeight);
        }



        // and then draw the bitmap on the view canvas
        canvas.drawBitmap(frame, null, bounds , null);


        i++;
        invalidate();


    }


    @Override
    protected void onSizeChanged(int xNew, int yNew, int xOld, int yOld){
        super.onSizeChanged(xNew, yNew, xOld, yOld);

        this.width = xNew;
        this.height = yNew;
    }


}
