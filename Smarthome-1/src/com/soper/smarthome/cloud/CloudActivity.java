package com.soper.smarthome.cloud;

import com.soper.smarthome.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * @author 作者:soper E-mail: fxp.2008@163.com
 * @version 创建时间：2013-5-12 下午1:28:01 类说明 :
 */
public class CloudActivity extends Activity {
	ImageButton backButton, moreButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.cloud);
		initViews();
	}

	private void initViews() {
		backButton = (ImageButton) findViewById(R.id.button_cloud_back);
		backButton.setOnClickListener(onClickListener);
		moreButton = (ImageButton) findViewById(R.id.button_cloud_logout);
		moreButton.setOnClickListener(onClickListener);
	}

	private OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.button_cloud_back:
				finish();
				break;
			case R.id.button_cloud_logout:

				break;
			}
		}
	};

}
