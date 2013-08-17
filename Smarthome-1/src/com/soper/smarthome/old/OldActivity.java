package com.soper.smarthome.old;

import com.soper.smarthome.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

/** 
 * @author 作者:soper E-mail: fxp.2008@163.com
 * @version 创建时间：2013-5-12 下午3:09:09 
 * 类说明 :
 */
public class OldActivity extends Activity {
	ImageButton backButton,moreButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.old);
		initViews();
	}

	private void initViews() {
		backButton=(ImageButton)findViewById(R.id.button_old_back);
		backButton.setOnClickListener(onClickListener);
		moreButton=(ImageButton)findViewById(R.id.button_old_logout);
		moreButton.setOnClickListener(onClickListener);
	}
	
	private OnClickListener onClickListener= new OnClickListener() {
		
		@Override
		public void onClick(View v) {
				switch (v.getId()) {
				case R.id.button_old_back:
					finish();
					break;
				case R.id.button_old_logout:
					
					break;
				 
				}
		}
	};
	
}
