package br.com.criandojogosandroid.cap04ex01_paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class StyleActivity extends AppCompatActivity {

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
            drawPaint.setStrokeWidth(10);
            drawPaint.setAntiAlias(true);

            drawPaint.setStyle(Paint.Style.STROKE);
            canvas.drawText("Style.STROKE", 240, 50, textPaint);
            canvas.drawCircle(240, 150, 70, drawPaint);

            drawPaint.setStyle(Paint.Style.FILL);
            canvas.drawText("Style.FILL", 240, 300, textPaint);
            canvas.drawCircle(240, 400, 70, drawPaint);

            drawPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawText("Style.FILL_AND_STROKE", 240, 550, textPaint);
            canvas.drawCircle(240, 650, 70, drawPaint);
        }
    }
}
