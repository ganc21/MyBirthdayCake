package cs301.birthdaycake;


import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;

/*
- This class is strictly data-containing
- info on current state of the cake
- Lab3
 */
public class CakeController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, View.OnTouchListener,
        SeekBar.OnSeekBarChangeListener  {

    private CakeView cakeView = null;  // reference to the cakeview object
    private CakeModel cakeModel = null; //  reference to the CakeModel object

    public CakeController(CakeView cakeView) { // constructor
        this.cakeView = cakeView;
        cakeModel = this.cakeView.getModel(); // get's a reference to the CakeModel object created in CakeView
    }

    @Override // for the Buttons
    public void onClick(View v) {
        Log.d("blowOut", "Goodbye");

        /* To indicate that the candles are not lit */
        cakeModel.candleLit = false;
        cakeView.invalidate();
    }


    @Override // for the Switches
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Log.d("CandlesSwitch", "Candles");

        /* to switch off the view of candles */
        if (cakeModel.hasCandles == true) {
            cakeModel.hasCandles = false;
            cakeView.invalidate();
        } else {
            cakeModel.hasCandles = true;
            cakeView.invalidate();
        }

    }

    @Override // for the seekbar to determine num candles
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Log.d("candleNumSeekbar", "Sigbar");

        cakeModel.numCandles = progress;
        cakeView.invalidate();

    }

    @Override // don't care for this
    public void onStartTrackingTouch(SeekBar seekBar) {
    }
    @Override // don't care for this
    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    public boolean onTouch(View v, MotionEvent event){
        cakeModel.xLocation = event.getX();
        cakeModel.yLocation = event.getY();

        cakeView.invalidate();
        cakeModel.isTouched = true;

        return false;
    }
}
