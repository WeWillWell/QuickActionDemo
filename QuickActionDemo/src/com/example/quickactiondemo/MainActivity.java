package com.example.quickactiondemo;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Rect;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	QuickActionWindow quWindow;
	Button test;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		test=(Button) findViewById(R.id.show_qa);
		test.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				showActions(view);
			}
		});
	}

	public void showActions(final View view) {
		int[] xy = new int[2];
		// fills the array with the computed coordinates
		view.getLocationInWindow(xy);
		// rectangle holding the clicked view area
		Rect rect = new Rect(xy[0], xy[1], xy[0] + view.getWidth(), xy[1]
				+ view.getHeight());

		// a new QuickActionWindow object
		quWindow = new QuickActionWindow(this, view, rect);
		quWindow.addItem(0, R.drawable.ic_quickaction_sms, R.string.send_sms,
				myListener);
		quWindow.addItem(1, R.drawable.ic_quickaction_email,
				R.string.send_email, myListener);
		quWindow.addItem(1, R.drawable.ic_quickaction_share, R.string.share,
				myListener);
		quWindow.show();
	}

	private View.OnClickListener myListener = new View.OnClickListener() {
		public void onClick(View v) {
			switch (v.getId()) {
			case 0: {
				quWindow.dismiss();
				/*do something (add your codes)*/
				break;
			}
			case 1: {
				quWindow.dismiss();
				/*do something (add your codes)*/
				break;
			}
			case 2: {
				quWindow.dismiss();
				/*do something (add your codes)*/
				break;
			}
			default: {
				quWindow.dismiss();
				break;
			}
			}
		}
	};

}
