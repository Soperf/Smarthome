package com.soper.smarthome.secure;

import com.soper.smarthome.R;
import com.soper.smarthome.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/** 
 * @author ����:soper E-mail: fxp.2008@163.com
 * @version ����ʱ�䣺2013-5-11 ����12:31:00 
 * ��˵�� :
 */
public class FireActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.secure_fire);
	}
}
