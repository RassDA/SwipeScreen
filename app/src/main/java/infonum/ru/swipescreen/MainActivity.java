package infonum.ru.swipescreen;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import static infonum.ru.swipescreen.SwipeDetector.*;


public class MainActivity extends ActionBarActivity {

    static Context context;
    static TextView view;
    static TextView view2;
    static int lastActivity = 1;
    static int swipeDirection = 0;
    final static int LEFT = 1;
    final static int RIGHT = 2;
    final static int UP = 3;
    final static int DOWN = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        view = (TextView) findViewById(R.id.textView);
        view2 = (TextView) findViewById(R.id.textView2);
        view.setText(context.getString(R.string.activity2_action_name));


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

    }


}
