package com.soper.smarthonme.homecontrolsystem;

import com.soper.smarthome.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.Window;
import android.widget.*;

/**
 * @author 作者:soper E-mail: fxp.2008@163.com
 * @version 创建时间：2013-5-8 下午5:00:11 类说明 :
 */
public class CurtainActivity extends Activity {
	ToggleButton b1, b2, b3, b4, b5, b6;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.homecontrolsystem_curtain);

		initViews();

	}

	private void initViews() {
		b1 = (ToggleButton) findViewById(R.id.curtain_b1);
		b1.setOnClickListener(onClickListener);
		b2 = (ToggleButton) findViewById(R.id.curtain_b2);
		b2.setOnClickListener(onClickListener);
		b3 = (ToggleButton) findViewById(R.id.curtain_b3);
		b3.setOnClickListener(onClickListener);
		b4 = (ToggleButton) findViewById(R.id.curtain_b4);
		b4.setOnClickListener(onClickListener);
		b5 = (ToggleButton) findViewById(R.id.curtain_b5);
		b5.setOnClickListener(onClickListener);
		b6 = (ToggleButton) findViewById(R.id.curtain_b6);
		b6.setOnClickListener(onClickListener);
	}

	private OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.curtain_b1:
				 
				break;
			case R.id.curtain_b2:
				 
				break;
			case R.id.curtain_b3:
				 
				break;
			case R.id.curtain_b4:
				 
				break;
			case R.id.curtain_b5:
				
				break;
			case R.id.curtain_b6:
				 
				break;
			default:
				break;
			}
		}
	};

}
