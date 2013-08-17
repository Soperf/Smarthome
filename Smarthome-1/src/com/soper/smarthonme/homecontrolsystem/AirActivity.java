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
 * @version 创建时间：2013-5-9 上午10:59:07 
 * 类说明 :
 */
public class AirActivity extends Activity {
	ToggleButton b1;
	ImageButton b2,b3,b4,b5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.homecontrolsystem_air);
		
		
		initViews();
		
	}

	private void initViews() {
		b1=(ToggleButton)findViewById(R.id.air_button1);
		b1.setOnClickListener(onClickListener);
		b2=(ImageButton)findViewById(R.id.air_button2);
		
		b3=(ImageButton)findViewById(R.id.air_button3);
		
		b4=(ImageButton)findViewById(R.id.air_button4);
		
		b5=(ImageButton)findViewById(R.id.air_button5);
		
	}
	
	
	
	private OnClickListener onClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.air_button1:
				 
				break;

			default:
				break;
			}
		}
	};
	
}
