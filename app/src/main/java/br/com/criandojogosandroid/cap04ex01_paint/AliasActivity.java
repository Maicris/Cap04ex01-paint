package br.com.criandojogosandroid.cap04ex01_paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class AliasActivity extends AppCompatActivity {

    private Tela tela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        tela = new Tela(this);
        setContentView(tela);
    }

    private class Tela extends View {

        private Paint textPaint = new Paint();
        private Paint drawPaint = new Paint();

        public Tela(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawColor(Color.WHITE);

            textPaint.setColor(Color.BLACK);
            textPaint.setTextAlign(Paint.Align.CENTER);
            textPaint.setTextSize(30);
            textPaint.setFakeBoldText(true);

            drawPaint.setColor(Color.BLUE);
            drawPaint.setStrokeWidth(3);
            drawPaint.setAntiAlias(false);
            drawPaint.setStyle(Paint.Style.STROKE);

            canvas.drawText("Sem AntiAlias", 240, 100, textPaint);
            canvas.drawCircle(240, 220, 100, drawPaint);

            drawPaint.setAntiAlias(true);
            canvas.drawText("Com AntiAlias", 240, 400, textPaint);
            canvas.drawCircle(240, 520, 100, drawPaint);
        }
    }

}
