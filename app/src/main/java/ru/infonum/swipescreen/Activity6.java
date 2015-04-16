package ru.infonum.swipescreen;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by d1i on 16.04.15.
 */
public class Activity6 {

    public class Activity2 extends Activity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.layout6);

            Listeners.listen(findViewById(R.id.textView6));
        }

    }
}
