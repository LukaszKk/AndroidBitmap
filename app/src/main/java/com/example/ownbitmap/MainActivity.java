package com.example.ownbitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView image;
    private TextView txtInfo;
    private Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.imgBMP);
        txtInfo = findViewById(R.id.txtInfo);
    }

    public void onCreateBmp(View view) {
        bitmap = Bitmap.createBitmap(image.getWidth(), image.getHeight(), Bitmap.Config.ARGB_8888);

//        onErase(view);

        txtInfo.setText(String.format(getString(R.string.S_CREATE_INFO), bitmap.getWidth(), bitmap.getHeight()));

        findViewById(R.id.btnErase).setEnabled(true);
        findViewById(R.id.btnLines).setEnabled(true);
        findViewById(R.id.btnEllipses).setEnabled(true);
        findViewById(R.id.btnRects).setEnabled(true);

        findViewById(R.id.btnCreate).setEnabled(false);
    }

    public void onErase(View view) {
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);

        bitmap.eraseColor(getColor(R.color.gray));
        paint.setColor(Color.WHITE);

        canvas.drawRect(1, 1, image.getWidth() - 2, image.getHeight() - 2, paint);
        image.setImageBitmap(bitmap);

        txtInfo.setText(getString(R.string.S_CLEAR_INFO));

//        findViewById(R.id.btnErase).setEnabled(false);
//        findViewById(R.id.btnLines).setEnabled(false);
//        findViewById(R.id.btnEllipses).setEnabled(false);
//        findViewById(R.id.btnRects).setEnabled(false);
    }

    public void onLines(View view) {
        int linesCount = 200;
        int margin = 2;

        Random random = new Random();
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();

        paint.setStrokeWidth(3);

        for (int i = 0; i < linesCount; i++) {
            paint.setARGB(random.nextInt(256), random.nextInt(256), random.nextInt(256),
                    random.nextInt(256));

            int x1 = margin + random.nextInt(image.getWidth() - 2*margin);
            int x2 = margin + random.nextInt(image.getWidth() - 2*margin);
            int y1 = margin + random.nextInt(image.getWidth() - 2*margin);
            int y2 = margin + random.nextInt(image.getWidth() - 2*margin);

            canvas.drawLine(x1, y1, x2, y2, paint);
        }

        image.setImageBitmap(bitmap);
        txtInfo.setText(getString(R.string.S_DRAWLINES));
    }

    public void onRects(View view) {
        int rectsCount = 10;
        int margin = 2;

        Random random = new Random();
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();

        paint.setStrokeWidth(3);

        for (int i = 0; i < rectsCount; i++) {
            paint.setARGB(random.nextInt(256), random.nextInt(256), random.nextInt(256),
                    random.nextInt(256));

            int x1 = margin + random.nextInt(image.getWidth() - 2*margin);
            int x2 = margin + random.nextInt(image.getWidth() - 2*margin);
            int y1 = margin + random.nextInt(image.getWidth() - 2*margin);
            int y2 = margin + random.nextInt(image.getWidth() - 2*margin);

            canvas.drawRect(x1, y1, x2, y2, paint);
        }

        image.setImageBitmap(bitmap);
        txtInfo.setText(getString(R.string.S_DRAWRECTS));
    }

    public void onEllipses(View view) {
        int ellipseCount = 15;
        int margin = 2;

        Random random = new Random();
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();

        paint.setStrokeWidth(3);

        for (int i = 0; i < ellipseCount; i++) {
            paint.setARGB(random.nextInt(256), random.nextInt(256), random.nextInt(256),
                    random.nextInt(256));

            int x1 = margin + random.nextInt(image.getWidth() - 2*margin);
            int x2 = margin + random.nextInt(image.getWidth() - 2*margin);
            int y1 = margin + random.nextInt(image.getWidth() - 2*margin);
            int y2 = margin + random.nextInt(image.getWidth() - 2*margin);

            canvas.drawOval(x1, y1, x2, y2, paint);
        }

        image.setImageBitmap(bitmap);
        txtInfo.setText(getString(R.string.S_DRAWELLIPSES));
    }
}