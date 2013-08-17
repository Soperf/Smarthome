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
 * @version 创建时间：2013-5-9 上午10:28:30 
 * 类说明 :
 */
public class TvActivity extends Activity {
	ToggleButton b1;
	ImageButton b2,b3,b4,b5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.homecontrolsystem_tv);
		initView();
	}

	private void initView() {
		b1=(ToggleButton)findViewById(R.id.tbutton1);
		b1.setOnClickListener(onClickListener);
		b2=(ImageButton)findViewById(R.id.tbutton2);
		b3=(ImageButton)findViewById(R.id.tbutton3);
		b4=(ImageButton)findViewById(R.id.tbutton4);
		b5=(ImageButton)findViewById(R.id.tbutton5);
	}
	private OnClickListener onClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.tbutton1:
				 
				break;

			default:
				break;
			}
		}
	};
	
	
	
}
