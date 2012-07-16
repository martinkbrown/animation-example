package co.martinbrown.example.animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;

public class AnimationExample extends Activity {

    RelativeLayout layout;
    Button moveButton;
    Button rotateButton;
    Button scaleButton;
    Button fadeButton;
    Button allButton;

    TranslateAnimation mover;
    RotateAnimation rotator;
    ScaleAnimation scaler;
    AlphaAnimation fader;

    public void doTranslate() {

        moveButton.startAnimation(mover);
    }

    public void doRotate() {

        rotateButton.startAnimation(rotator);
    }

    public void doScale() {

        scaleButton.startAnimation(scaler);
    }

    public void doFade() {

        fadeButton.startAnimation(fader);
    }

    public void doAll() {
        AnimationSet animSet = new AnimationSet(true);

        moveButton.setAnimation(mover);
        rotateButton.setAnimation(rotator);
        scaleButton.setAnimation(scaler);
        fadeButton.setAnimation(fader);

        animSet.addAnimation(rotator);
        animSet.addAnimation(scaler);
        animSet.addAnimation(fader);
        animSet.addAnimation(mover);


        animSet.setDuration(3000);
        animSet.startNow();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        layout = (RelativeLayout) findViewById(R.id.RelativeLayout1);
        moveButton = (Button) findViewById(R.id.moveButton);
        rotateButton = (Button) findViewById(R.id.rotateButton);
        scaleButton = (Button) findViewById(R.id.scaleButton);
        fadeButton = (Button) findViewById(R.id.fadeButton);
        allButton = (Button) findViewById(R.id.allButton);



        scaler = new ScaleAnimation(1,
                4,
                1,
                1);
        scaler.setDuration(3000);

        fader = new AlphaAnimation(fadeButton.getAlpha(), 0);
        fader.setDuration(3000);

        rotator = new RotateAnimation(0, 720*2/*,
                Animation.ABSOLUTE,
                rotateButton.getLeft() + rotateButton.getWidth() / 2,
                Animation.ABSOLUTE,
                rotateButton.getTop() + rotateButton.getHeight() / 2*/);
        rotator.setDuration(3000);

        mover = new TranslateAnimation(0.0f, 0.0f, 0.0f, layout.getHeight()/* - (2 * moveButton.getHeight())*/);
        mover.setDuration(3000);

        moveButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                doTranslate();
            }
        });

        rotateButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                doRotate();
            }
        });

        scaleButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                doScale();
            }
        });

        fadeButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                doFade();
            }
        });

        allButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                doAll();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}