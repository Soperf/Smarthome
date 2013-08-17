package com.soper.smarthonme.homecontrolsystem;

import com.soper.smarthome.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ToggleButton;

/**
 * @author 作者:soper E-mail: fxp.2008@163.com
 * @version 创建时间：2013-5-9 下午7:37:15 类说明 :
 */
public class CookerActivity extends Activity {
	ToggleButton b1;
	Button  b2,b3;
	Boolean b=false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.homecontrolsystem_cooker);
		initViews();

	}

	private void initViews() {
		b1 = (ToggleButton) findViewById(R.id.cookerbutton1);
		b1.setOnClickListener(onClickListener);
		b2 = (Button) findViewById(R.id.cookerbutton2);
		b2.setOnClickListener(onClickListener);
		b3 = (Button) findViewById(R.id.cookerbutton3);
		b3.setOnClickListener(onClickListener);
		
	}

	private OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.cookerbutton1:
				 
				break;
			case R.id.cookerbutton2:
				if (b) {
					b2.setBackgroundResource(R.drawable.button_toggle_rice);
					b=false;
				}else {
					b2.setBackgroundResource(R.drawable.button_toggle_porridge);
					b=true;
				}
				break;
			case R.id.cookerbutton3:

				break;
			default:
				break;
			}
		}
	};
}
