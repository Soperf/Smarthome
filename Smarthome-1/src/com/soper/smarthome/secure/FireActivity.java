package com.soper.smarthome.secure;

import com.soper.smarthome.R;
import com.soper.smarthome.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/** 
 * @author 作者:soper E-mail: fxp.2008@163.com
 * @version 创建时间：2013-5-11 下午12:31:00 
 * 类说明 :
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
