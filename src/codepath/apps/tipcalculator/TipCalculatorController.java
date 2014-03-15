package codepath.apps.tipcalculator;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.logging.Logger;

import android.app.Activity;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class TipCalculatorController {

	public static TipCalculatorController instance = new TipCalculatorController();
	
	private double[] tipPerc = new double[]{ 10, 15, 20 };
	
	private TipCalculatorController() {
		
	}
	
	/**
	 * @param activity
	 */
	public void updateView(Activity activity) {
		Number currentTotalAmount = getCurrentTotalAmount(activity);
		Number currentTip = getCurrentTip(activity);
		Number tipAmount = currentTotalAmount.doubleValue() * currentTip.doubleValue() / 100;
		NumberFormat currFormat = NumberFormat.getCurrencyInstance();
		TextView tvTipAmount = (TextView) activity.findViewById(R.id.tvTipAmount);
		tvTipAmount.setText(currFormat.format(tipAmount));		
	}
	
	/**
	 * @param activity
	 * @return total amount
	 */
	private Number getCurrentTotalAmount(Activity activity) {
		EditText etTotalAmount = (EditText) activity.findViewById(R.id.etTotalAmount);
		NumberFormat numberFormat = NumberFormat.getNumberInstance();
		Number totalAmount = 0.0;
		try {
			totalAmount = numberFormat.parse(etTotalAmount.getText().toString());
		} catch(ParseException e) {
			Logger logger = Logger.getLogger(activity.getLocalClassName());
			logger.info(etTotalAmount.getText().toString() + " is not a valid number");
		}	
		return totalAmount;
	}
	
	/**
	 * @param activity
	 * @return current tip or 0 if no tip button selected
	 */
	private Number getCurrentTip(Activity activity) {
		RadioGroup rgTipGroup = (RadioGroup) activity.findViewById(R.id.rgTipGroup);
		RadioButton btnTip = (RadioButton) activity.findViewById(rgTipGroup.getCheckedRadioButtonId());
		if (btnTip != null) {
			int idx = rgTipGroup.indexOfChild(btnTip);
			if (idx != -1) {
				return tipPerc[idx];
			}
		}
		return 0;
	}
	

	
}
