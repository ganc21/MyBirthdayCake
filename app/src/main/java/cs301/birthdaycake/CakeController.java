package cs301.birthdaycake;


import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;

/*
- This class is strictly data-containing
- info on current state of the cake
- Lab3
 */
public class CakeController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener  {

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
        Log.d("CandlesSwitch", "No Candles");

        /* to switch off the view of candles */
        if (cakeModel.hasCandles == true) {
            cakeModel.hasCandles = false;
            cakeView.invalidate();
        } else {
            cakeModel.hasCandles = true;
            cakeView.invalidate();
        }

    }
}
