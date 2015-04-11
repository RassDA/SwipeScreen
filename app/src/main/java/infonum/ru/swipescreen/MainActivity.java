package infonum.ru.swipescreen;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final GestureDetector gestureDetector;

        gestureDetector = initGestureDetector();

        View view = findViewById(R.id.LinearLayout1);
        //view.setEnabled(false);

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




    private GestureDetector initGestureDetector() {
        return new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {

        private SwipeDetector detector = new SwipeDetector();

        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {
            try {
                if (detector.isSwipeDown(e1, e2, velocityY)) {
                    showToast("Down Swipe"); //не должно быть такого движения - конкурирует с открытием извещений
                    return false;

                } else if (detector.isSwipeUp(e1, e2, velocityY)) {
                    showToast("Up Swipe");

                }else if (detector.isSwipeLeft(e1, e2, velocityX)) {

                    showToast("Left Swipe");

                    //nextScreen("Left Swipe");
                    Intent intent = new Intent(getApplicationContext(), Activity2. class );
                    startActivity(intent);

                } else if (detector.isSwipeRight(e1, e2, velocityX)) {

                    showToast("Right Swipe");

                    //prevScreen("Right Swipe");
                    //Intent intent = new Intent(getApplicationContext(), MainActivity. class );
                    //startActivity(intent);
                }
            } catch (Exception e) {} //for now, ignore
            return false;
        }

        private void showToast(String phrase){
            Toast.makeText(getApplicationContext(), phrase, Toast.LENGTH_SHORT).show();
        }
    });











}































































    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
