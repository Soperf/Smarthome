package com.soper.smarthome.baby;

import com.soper.smarthome.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/** 
 * @author ����:soper E-mail: fxp.2008@163.com
 * @version ����ʱ�䣺2013-5-12 ����2:05:59 
 * ��˵�� :
 */
public class ChildActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.baby_child);
	}
}
