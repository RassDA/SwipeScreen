package infonum.ru.swipescreen;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import static infonum.ru.swipescreen.SwipeDetector.*;


public class MainActivity extends ActionBarActivity {

    static Context context;
    static View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        view = findViewById(R.id.LinearLayout1);

        //Intent intent = new Intent(context,Activity2.class);
        Intent intent = new Intent("ru.infonum.swipescreen.shownext");
        context.startActivity(intent);


/*
        final GestureDetector gestureDetector;

        gestureDetector = initGestureDetector();

        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
            }
        });

*/

    }


}
