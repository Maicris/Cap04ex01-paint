package br.com.criandojogosandroid.cap04ex01_paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class StrokeWidthActivity extends AppCompatActivity {

    private Tela tela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        tela = new Tela(this);
        setContentView(tela);
    }

    private class Tela extends View {

        private Paint drawPaint = new Paint();
        private Paint textPaint = new Paint();
        private int colors[];
        private String texts[];

        public Tela(Context context) {
            super(context);
            drawPaint.setStyle(Paint.Style.STROKE);
            drawPaint.setColor(Color.BLUE);
            drawPaint.setAntiAlias(true);
            textPaint.setColor(Color.BLACK);
            textPaint.setTextAlign(Paint.Align.CENTER);
            textPaint.setTextSize(22);
            textPaint.setFakeBoldText(true);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            float raio = canvas.getWidth() / 11.0f;
            for (int i = 1; i < 9; i++) {
                drawPaint.setStrokeWidth(i * 2.5f);
                Path circle = new Path();
                circle.moveTo(canvas.getWidth() / 2, canvas.getHeight() / 2);
                circle.addCircle(canvas.getWidth() / 2, canvas.getHeight() / 2, i * raio, Path.Direction.CW);
                canvas.drawPath(circle, drawPaint);
                canvas.drawTextOnPath("" + i * 2.5f, circle, (float) ((i * raio) * (Math.PI / 2)), 20 + i * 1.25f, textPaint);
            }
        }
    }
}
