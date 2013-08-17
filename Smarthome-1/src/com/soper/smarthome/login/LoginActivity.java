package com.soper.smarthome.login;

import com.soper.smarthome.maininterface.MaininterfaceActivity;
import com.soper.smarthome.R;
import com.soper.util.VariablesOfUrl;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {

	//Layout Views
	EditText usernameEditText,passwordEditText;	
	 
	TextView findpasswd,loginsetting,loginButton;
	
	ImageButton backbutton,morebuttom;
	
	String username,password;
	
	ProgressDialog dialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);
		//获得控件
		initViews();
	}
	
	//获得控件	
	private void initViews() {
		
		usernameEditText=(EditText)findViewById(R.id.lgoin_accounts);
		passwordEditText=(EditText)findViewById(R.id.login_password);
		
		loginButton=(TextView)findViewById(R.id.login_btn);
		loginButton.setOnClickListener(onClickListener);
		
		findpasswd=(TextView)findViewById(R.id.login_findpassword);
		findpasswd.setOnClickListener(onClickListener);
		loginsetting=(TextView)findViewById(R.id.login_settings);
		loginsetting.setOnClickListener(onClickListener);
		
		backbutton=(ImageButton)findViewById(R.id.login_backbutton);
		backbutton.setOnClickListener(onClickListener);
		morebuttom=(ImageButton)findViewById(R.id.login_morebutton);
		morebuttom.setOnClickListener(onClickListener);
	}

	//控件监听器
	private OnClickListener onClickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
		switch (v.getId()) {
		//点击登录按钮
		case R.id.login_btn:
			Handler handler = new Handler();
			handler.post(checkThread);
			break;
		 
		//点击找回密码	
		case R.id.login_findpassword:
			
			break;
		//点击登录设置		
		case R.id.login_settings:
		
			break;
		case R.id.login_backbutton:
			finish();
			break;
		case R.id.login_morebutton:
			
			break;
		default:
			break;
		}	
		}
	};

	Runnable checkThread = new Runnable() {
		@Override
		public void run() {
			//登录方法
			Login();
		}
	};
	
	//登录
	private void Login(){
		if (isUserInfo()) {
			System.out.println(isUserInfo());
			startActivity(new Intent(LoginActivity.this,MaininterfaceActivity.class));
			Toast.makeText(LoginActivity.this, username+"，登录成功", Toast.LENGTH_SHORT).show();
			
		}else {
			return ;
		}
		
	}
	
	
	
	
	//取得用户名和密码，并判断其合法性
	private Boolean isUserInfo(){
		username=usernameEditText.getText().toString();
		password=passwordEditText.getText().toString();
	
		if (username.equals("")) {
			Toast.makeText(LoginActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
			return false;
		}else if (password.equals("")) {
			Toast.makeText(LoginActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
			return false;
		}
		
		//显示进度条
		showdlog();
		//获得登录结果
		String result=query(username,password);
		if (result!=null && result.equals("0") ){
			Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
			Handler handler = new Handler();
			handler.post(new Runnable() {
				@Override
				public void run() {
					//dialog消失
					dialog.dismiss();
				}
			});
			
			return false;
		}else if (result==null) {
			Toast.makeText(LoginActivity.this, "连接服务器异常", Toast.LENGTH_SHORT).show();
			Handler handler = new Handler();
			handler.post(new Runnable() {
				@Override
				public void run() {
					//dialog消失
					dialog.dismiss();
				}
			});
			return false;
		} 
		else {
			Handler handler = new Handler();
			handler.post(new Runnable() {
				@Override
				public void run() {
					//dialog消失
					dialog.dismiss();
					LoginActivity.this.finish();
				}
			});
			return true;
		}
	}

	private String query(String username, String password) {
		// 查询参数
		String queryString = "type=user"+"&username="+username+"&password="+password;
		// url
		String url = VariablesOfUrl.APP_BASE_URL+"LoginServlet?"+queryString;
		// 查询返回结果
		return  com.soper.util.HttpUtil.queryStringForGet(url);
	}
	
	//显示进度条
	private void showdlog(){
		dialog = new  ProgressDialog(this);
		dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		dialog.setMessage("正在验证账户和密码，请稍等");
		dialog.show();
		
	}

}
