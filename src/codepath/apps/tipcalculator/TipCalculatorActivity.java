package codepath.apps.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class TipCalculatorActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
		
		EditText etTotalAmount = (EditText) findViewById(R.id.etTotalAmount);
		etTotalAmount.addTextChangedListener(new TextWatcher() {

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// no op
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// no op
			}

			@Override
			public void afterTextChanged(Editable s) {
				getController().updateView(TipCalculatorActivity.this);
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calculator, menu);
		return true;
	}
	
	public void onClickTipButton(View v) {		
		getController().updateView(this);
	}
	
	private TipCalculatorController getController() {
		return TipCalculatorController.instance;
	}
	
}
