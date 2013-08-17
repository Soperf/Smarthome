package com.soper.smarthome.register;

import com.soper.smarthome.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

/**
 * @author 作者:soper E-mail: fxp.2008@163.com
 * @version 创建时间：2013-5-10 下午4:31:53 类说明 :
 */
public class RegisterActivity extends Activity {
	ImageButton backButton, moreButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.register);
		initViews();
	}

	private void initViews() {
		backButton = (ImageButton) findViewById(R.id.register_back);
		backButton.setOnClickListener(onClickListener);
		moreButton = (ImageButton) findViewById(R.id.register_more);
		moreButton.setOnClickListener(onClickListener);
	}

	private OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.register_back:
				finish();
				break;
			case R.id.register_more:

				break;
			default:
				break;
			}
		}
	};

}
