package kr.ac.ssu.gamehighlevelwidgettest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    ViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flipper = findViewById(R.id.v_flip);
        flipper.setFlipInterval(1000);
        Button btn_prev = findViewById(R.id.btn_prev);
        Button btn_next = findViewById(R.id.btn_next);

        btn_prev.setOnClickListener(btnListener);
        btn_next.setOnClickListener(btnListener);

        flipper.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent e) {
                if(e.getAction() == MotionEvent.ACTION_DOWN) {
                    downX =  e.getX();
                    //Toast.makeText(getApplicationContext(), "downX: "+downX+", upX: "+upX, Toast.LENGTH_SHORT).show();
                }

                if(e.getAction() == MotionEvent.ACTION_UP){
                    upX = e.getX();
                    Toast.makeText(getApplicationContext(), "downX: "+downX+", upX: "+upX, Toast.LENGTH_SHORT).show();
                    if(downX > upX )
                        flipper.showNext();
                    else if(downX < upX)
                        flipper.showPrevious();
                }
                return false;
            }
        });

    }

    float downX, upX;

    View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent e) {



            return false;
        }
    };

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_prev:
                    flipper.startFlipping();
                    break;
                case R.id.btn_next:
                    flipper.stopFlipping();
                    break;
            }
        }
    };
}
