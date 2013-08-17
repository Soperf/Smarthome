package com.soper.smarthonme.homecontrolsystem;

import com.soper.smarthome.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ToggleButton;

/**
 * @author 作者:soper E-mail: fxp.2008@163.com
 * @version 创建时间：2013-5-9 下午8:06:59 类说明 :
 */
public class AudioAvtivity extends Activity {
	ToggleButton b1;
	Button b2, b3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homecontrolsystem_audio);
		initViews();

	}

	private void initViews() {
		b1 = (ToggleButton) findViewById(R.id.audibutton1);
		b1.setOnClickListener(onClickListener);
		b2 = (Button) findViewById(R.id.audibutton2);
		b2.setOnClickListener(onClickListener);
		b3 = (Button) findViewById(R.id.audibutton3);
		b3.setOnClickListener(onClickListener);
	}

	private OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.audibutton1:
			 
				break;
			case R.id.audibutton2:

				break;
			case R.id.audibutton3:

				break;

			default:
				break;
			}
		}
	};

}
