package in.nadavatisiva.app;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;



public class MainActivity extends Activity {

    private ImageView image1;
    private int[] imageArray;
    private int currentIndex;
    private int startIndex;
    private int endIndex;
    AnimatorSet setRightOut,setLeftIn,setTopOut,setBottonIn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image1 = (ImageView) findViewById(R.id.img);
        imageArray = new int[4];
        imageArray[0] = R.drawable.stethoscope;
        imageArray[1] = R.drawable.kcmdrkonqi;
        imageArray[2] = R.drawable.mic;
        imageArray[3] = R.drawable.movies;
        startIndex = 0;
        endIndex = 3;
        nextImage();
    }
    public void nextImage() {
        image1.setImageResource(imageArray[currentIndex]);
        setRightOut = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.flip1);
        setLeftIn = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.flip2);
        setTopOut = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.flip3);
        setBottonIn = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.flip4);
        setRightOut.setTarget(image1);
        setLeftIn.setTarget(image1);
        setTopOut.setTarget(image1);
        setBottonIn.setTarget(image1);
        setRightOut.start();
        setLeftIn.start();
        setTopOut.start();
        setBottonIn.start();
        currentIndex++;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (currentIndex > endIndex) {
                    currentIndex--;
                    previousImage();
                } else {
                    nextImage();
                }

            }
        }, 1000); // here 1000(1 second) interval to change from current  to next image

    }

    public void previousImage() {
        image1.setImageResource(imageArray[currentIndex]);
        setRightOut = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.flip1);
        setLeftIn = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.flip2);
        setTopOut = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.flip3);
        setBottonIn = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.flip4);
        setRightOut.setTarget(image1);
        setLeftIn.setTarget(image1);
        setTopOut.setTarget(image1);
        setBottonIn.setTarget(image1);
        setRightOut.start();
        setLeftIn.start();
        setTopOut.start();
        setBottonIn.start();
        currentIndex--;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (currentIndex < startIndex) {
                    currentIndex++;
                    nextImage();
                } else {
                    previousImage(); // here 1000(1 second) interval to change from current  to previous image
                }
            }
        }, 1000);

    }
}
