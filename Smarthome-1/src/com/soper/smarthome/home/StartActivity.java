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
 * @author 作者:soper E-mail: fxp.2008@163.com
 * @version 创建时间：2013-5-12 下午9:47:44 
 * 类说明 :
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
