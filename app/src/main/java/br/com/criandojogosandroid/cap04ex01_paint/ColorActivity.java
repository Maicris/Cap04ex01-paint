package br.com.criandojogosandroid.cap04ex01_paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ColorActivity extends AppCompatActivity {

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
            drawPaint.setStyle(Paint.Style.FILL);
            textPaint.setColor(Color.BLACK);
            textPaint.setTextAlign(Paint.Align.CENTER);
            textPaint.setTextSize(22);
            textPaint.setFakeBoldText(true);
            colors = new int[]{
                    Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN, Color.CYAN, Color.MAGENTA
            };
            texts = new String[] {
                    "Color.RED", "Color.YELLOW", "Color.BLUE", "Color.GREEN", "Color.CYAN", "Color.MAGENTA"
            };
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    drawPaint.setColor(colors[i * 3 + j]);
                    canvas.drawCircle(
                            i * (canvas.getWidth() / 2) + (canvas.getWidth() / 4),
                            j * (canvas.getHeight() / 3) + (canvas.getHeight() / 6 + 25),
                            80, drawPaint);
                    canvas.drawText(
                            texts[i * 3 + j],
                            i * (canvas.getWidth() / 2) + (canvas.getWidth() / 4),
                            j * (canvas.getHeight() / 3) + 40,
                            textPaint);
                }
            }
        }
    }
}
