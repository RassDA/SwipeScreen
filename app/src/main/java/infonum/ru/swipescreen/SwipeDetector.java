package infonum.ru.swipescreen;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

import static infonum.ru.swipescreen.Intents.*;
import static infonum.ru.swipescreen.Intents.nextScreen;
import static infonum.ru.swipescreen.MainActivity.context;

/**
 * Created by d1i on 11.04.15.
 */
public class SwipeDetector {

    private int swipe_distance;
    private int swipe_velocity;
    private static final int SWIPE_MIN_DISTANCE = 100; //120
    private static final int SWIPE_THRESHOLD_VELOCITY = 100; //200

    public SwipeDetector(int distance, int velocity) {
        super();
        this.swipe_distance = distance;
        this.swipe_velocity = velocity;
    }

    public SwipeDetector() {
        super();
        this.swipe_distance = SWIPE_MIN_DISTANCE;
        this.swipe_velocity = SWIPE_THRESHOLD_VELOCITY;
    }

    public boolean isSwipeDown(MotionEvent e1, MotionEvent e2, float velocityY) {
        return isSwipe(e2.getY(), e1.getY(), velocityY);
    }

    public boolean isSwipeUp(MotionEvent e1, MotionEvent e2, float velocityY) {
        return isSwipe(e1.getY(), e2.getY(), velocityY);
    }

    public boolean isSwipeLeft(MotionEvent e1, MotionEvent e2, float velocityX) {
        return isSwipe(e1.getX(), e2.getX(), velocityX);
    }

    public boolean isSwipeRight(MotionEvent e1, MotionEvent e2, float velocityX) {
        return isSwipe(e2.getX(), e1.getX(), velocityX);
    }

    private boolean isSwipeDistance(float coordinateA, float coordinateB) {
        return (coordinateA - coordinateB) > this.swipe_distance;
    }

    private boolean isSwipeSpeed(float velocity) {
        return Math.abs(velocity) > this.swipe_velocity;
    }

    private boolean isSwipe(float coordinateA, float coordinateB, float velocity) {
        return isSwipeDistance(coordinateA, coordinateB)
                && isSwipeSpeed(velocity);
    }

    public static GestureDetector initGestureDetector() {
        return new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {

            private SwipeDetector detector = new SwipeDetector();

            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                                   float velocityY) {
                try {
                    if (detector.isSwipeDown(e1, e2, velocityY)) {
                        showToast("Down Swipe"); //не должно быть такого движения - конкурирует с открытием извещений
                        upScreen();

                        return false;

                    } else if (detector.isSwipeUp(e1, e2, velocityY)) {
                        showToast("Up Swipe");
                        downScreen();


                    } else if (detector.isSwipeLeft(e1, e2, velocityX)) {

                        showToast("Left Swipe");

                        nextScreen();


                    } else if (detector.isSwipeRight(e1, e2, velocityX)) {

                        showToast("Right Swipe");

                        prevScreen();
                    }
                } catch (Exception e) {
                } //for now, ignore
                return false;
            }

            private void showToast(String phrase) {
                Toast.makeText(context, phrase, Toast.LENGTH_SHORT).show();
            }
        });

    }

    }


