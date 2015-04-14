package infonum.ru.swipescreen;

import android.app.Activity;
import android.os.Bundle;


/**
 * Created by d1i on 11.04.15.
 */
public class Activity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);


    }

/*
    @Override
    protected void onResume(){
        super .onResume();

        final GestureDetector gestureDetector;

        gestureDetector = initGestureDetector();

        View view = findViewById(R.id.linearLayout2);

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
*/


}


