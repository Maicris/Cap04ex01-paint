package br.com.criandojogosandroid.cap04ex01_paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class JoinActivity extends AppCompatActivity {

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
            canvas.drawColor(Color.WHITE);

            textPaint.setColor(Color.BLACK);
            textPaint.setTextAlign(Paint.Align.CENTER);
            textPaint.setTextSize(30);
            textPaint.setFakeBoldText(true);

            drawPaint.setColor(Color.BLUE);
            drawPaint.setStrokeWidth(50);
            drawPaint.setAntiAlias(true);
            drawPaint.setStyle(Paint.Style.STROKE);

            Path path = new Path();
            path.moveTo(80, 50);
            path.lineTo(240, 200);
            path.lineTo(400, 50);
            drawPaint.setStrokeJoin(Paint.Join.MITER);
            canvas.drawPath(path, drawPaint);
            canvas.drawText("Join.Miter", 240, 60, textPaint);
            Path path1 = new Path();
            path1.moveTo(80, 300);
            path1.lineTo(240, 450);
            path1.lineTo(400, 300);
            drawPaint.setStrokeJoin(Paint.Join.ROUND);
            canvas.drawPath(path1, drawPaint);
            canvas.drawText("Join.Round", 240, 310, textPaint);
            Path path2 = new Path();
            path2.moveTo(80, 550);
            path2.lineTo(240, 700);
            path2.lineTo(400, 550);
            drawPaint.setStrokeJoin(Paint.Join.BEVEL);
            canvas.drawPath(path2, drawPaint);
            canvas.drawText("Join.Bevel", 240, 560, textPaint);
        }
    }
}
