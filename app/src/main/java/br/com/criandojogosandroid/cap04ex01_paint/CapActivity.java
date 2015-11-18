package br.com.criandojogosandroid.cap04ex01_paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class CapActivity extends AppCompatActivity {

    private Tela tela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        tela = new Tela(this);
        setContentView(tela);
    }

    private static class Tela extends View {

        private Paint textPaint = new Paint();
        private Paint drawPaint = new Paint();

        public Tela(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.WHITE);

            textPaint.setColor(Color.BLACK);
            textPaint.setTextAlign(Paint.Align.CENTER);
            textPaint.setTextSize(30);
            textPaint.setFakeBoldText(true);

            drawPaint.setColor(Color.BLUE);
            drawPaint.setStrokeWidth(50);
            drawPaint.setAntiAlias(true);
            drawPaint.setStyle(Paint.Style.STROKE);

            drawPaint.setStrokeCap(Paint.Cap.BUTT);
            canvas.drawText("Cap.BUUT", 240, 140, textPaint);
            canvas.drawLine(80, 200, 400, 200, drawPaint);

            drawPaint.setStrokeCap(Paint.Cap.ROUND);
            canvas.drawText("Cap.ROUND", 240, 340, textPaint);
            canvas.drawLine(80, 400, 400, 400, drawPaint);

            drawPaint.setStrokeCap(Paint.Cap.SQUARE);
            canvas.drawText("Cap.SQUARE", 240, 540, textPaint);
            canvas.drawLine(80, 600, 400, 600, drawPaint);
        }
    }
}
