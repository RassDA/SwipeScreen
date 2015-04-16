package ru.infonum.swipescreen;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by d1i on 16.04.15.
 */
public class Activity1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);

        Listeners.listen(findViewById(R.id.textView1));
        //Listeners.listen(viewList.get(1));
    }
}
