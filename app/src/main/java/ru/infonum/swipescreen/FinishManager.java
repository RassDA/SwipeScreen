package ru.infonum.swipescreen;
import android.app.Activity;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by d1i on 16.04.15.
 */

public class FinishManager {
    private static final Map<Class<? extends Activity>, Activity> list = new HashMap<Class<? extends Activity>, Activity>();

    public static void addActivity(Activity activity) {
        list.put(activity.getClass(), activity);
    }

    public static void finishActivity(Class<? extends Activity> clazz) {
        Activity activity = list.remove(clazz);
        if (activity != null && !activity.isFinishing()) {
            activity.finish();
        }
    }

}

//FinishManager.addActivity(this); // В активити, которую нужно закрыть:

//FinishManager.finishActivity(MyActivity.class); // Из активити, которая должна закрыть: