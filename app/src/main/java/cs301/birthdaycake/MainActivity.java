package cs301.birthdaycake;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

        Button blowOut = findViewById(R.id.blowOut);
        blowOut.setOnClickListener(cakeController);

        Switch onOffCandles = findViewById(R.id.CandlesSwitch);
        onOffCandles.setOnCheckedChangeListener(cakeController);
    }

}
