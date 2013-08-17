package com.soper.smarthome.home;

import com.soper.smarthome.R;
import com.soper.smarthome.login.LoginActivity;
import com.soper.smarthome.maininterface.MaininterfaceActivity;
import com.soper.smarthome.register.RegisterActivity;

import android.R.anim;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Toast;

/** 
 * @author 作者:soper E-mail: fxp.2008@163.com
 * @version 创建时间：2013-5-10 下午3:20:20 
 * 类说明 :
 */
public class HomeActivity extends Activity {
	LinearLayout loginlinear,registerlinear,intolinear;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.home);
		initViews();
		//检查网络是否打开，打开，则可以跳到下一步，否则，设置打开网络
		if (!isConn(getApplicationContext())) {
			Handler handler = new Handler();
			handler.post(showDialogThread);
		}
		System.out.println(isConn(getApplicationContext()));
		
	}
	
	private void initViews() {
		loginlinear=(LinearLayout)findViewById(R.id.login_home_linear);
		loginlinear.setOnClickListener(onClickListener);
		registerlinear=(LinearLayout)findViewById(R.id.register_home_linear);
		registerlinear.setOnClickListener(onClickListener);
		intolinear=(LinearLayout)findViewById(R.id.into_home_linear);
		intolinear.setOnClickListener(onClickListener);
	}
	
	//线程run方法
		Runnable showDialogThread = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				setNetwork();
			}
		};
	
	private OnClickListener onClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.login_home_linear:
				if (!isConn(getApplicationContext())) {
					setNetwork();
				}else {
					startActivity(new Intent(HomeActivity.this,LoginActivity.class));
				}
				
				break;
			case R.id.register_home_linear:
				if (!isConn(getApplicationContext())) {
					setNetwork();
				}else {
				startActivity(new Intent(HomeActivity.this,RegisterActivity.class));
				}
				break;
			case R.id.into_home_linear:
				if (!isConn(getApplicationContext())) {
					setNetwork();
				}else {
				startActivity(new Intent(HomeActivity.this,MaininterfaceActivity.class));
				}
				break;
			default:
				break;
			}
		}
	};
	
	//真正的判断网络 是否打开
	private boolean isConn(Context context){
		ConnectivityManager connManager = (ConnectivityManager) context.getSystemService
				(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connManager.getActiveNetworkInfo();
		if (networkInfo!=null) {
			return connManager.getActiveNetworkInfo().isAvailable();
		}
		return false;
	}
	
	//打开设置网络界面
	private void setNetwork(){
		System.out.println("----------->");
		AlertDialog.Builder builder = new Builder(this);
		builder.setTitle("网络设置提示").setMessage("网络连接不可用，是否进行设置？").setPositiveButton("设置",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Intent intent = new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
						startActivity(intent);
					}
				}).setNegativeButton("取消",new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				}).create();
		 builder.show();
	}
	
}
