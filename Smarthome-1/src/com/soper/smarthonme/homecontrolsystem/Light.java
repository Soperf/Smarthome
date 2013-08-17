package com.soper.smarthonme.homecontrolsystem;

import com.soper.smarthome.R;

import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

/**
 * @author ����:soper E-mail: fxp.2008@163.com
 * @version ����ʱ�䣺2013-5-8 ����11:41:14 ��˵�� :
 */
public class Light extends Activity {
	ToggleButton bedroombutton1, bedroombutton2, bedroombutton3, cookbutton,
			parlourbutton, restaurantbutton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homecontrolsystem_light);
		initViews();
	}

	private void initViews() {
		// TODO Auto-generated method stub
		bedroombutton1 = (ToggleButton) findViewById(R.id.lt_bedroombutton1);
		bedroombutton1.setOnClickListener(onClickListener);
		bedroombutton2 = (ToggleButton) findViewById(R.id.lt_bedroombutton2);
		bedroombutton2.setOnClickListener(onClickListener);
		bedroombutton3 = (ToggleButton) findViewById(R.id.lt_bedroombutton3);
		bedroombutton3.setOnClickListener(onClickListener);
		cookbutton = (ToggleButton) findViewById(R.id.lt_cookbutton);
		cookbutton.setOnClickListener(onClickListener);
		parlourbutton = (ToggleButton) findViewById(R.id.lt_parlourbutton);
		parlourbutton.setOnClickListener(onClickListener);
		restaurantbutton = (ToggleButton) findViewById(R.id.lt_restaurantbutton);
		restaurantbutton.setOnClickListener(onClickListener);

	}

	private OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.lt_parlourbutton:
				
				 
				break;
			case R.id.lt_restaurantbutton:
				 
				break;
			case R.id.lt_cookbutton:
				 
				break;
			case R.id.lt_bedroombutton1:
				 
				break;
			case R.id.lt_bedroombutton2:
				 
				break;
			case R.id.lt_bedroombutton3:
				 
				break;
			default:
				break;
			}
		}
	};

}
