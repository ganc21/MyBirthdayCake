package cs301.birthdaycake;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);


        /* Lab3 */
        CakeView cakeView = findViewById(R.id.cakeview);
        CakeController cakeController = new CakeController(cakeView);

        //public void goodbye(View button) {
          //Log.i("button", "Goodbye");
        //}

        // to blow out the candles
        Button blowOut = findViewById(R.id.blowOut);
        blowOut.setOnClickListener(cakeController);

        // to draw the candles or not
        Switch onOffCandles = findViewById(R.id.CandlesSwitch);
        onOffCandles.setOnCheckedChangeListener(cakeController);

        // to draw the number of candles
        SeekBar numCandles = findViewById(R.id.candleNumSeekBar);
        numCandles.setOnSeekBarChangeListener(cakeController);

        // listener object for touch touch events
        //MotionEvent touchHere =
        cakeView.setOnTouchListener(cakeController);


    }

}
