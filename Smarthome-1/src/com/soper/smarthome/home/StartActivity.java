package com.soper.smarthome.home;

import com.soper.smarthome.R;
import com.soper.smarthome.maininterface.MaininterfaceActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

/** 
 * @author ����:soper E-mail: fxp.2008@163.com
 * @version ����ʱ�䣺2013-5-12 ����9:47:44 
 * ��˵�� :
 */
public class StartActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.startl);
		
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				startActivity(new Intent(StartActivity.this,HomeActivity.class));
				StartActivity.this.finish();
			}
		}, 3000);
	}

}
