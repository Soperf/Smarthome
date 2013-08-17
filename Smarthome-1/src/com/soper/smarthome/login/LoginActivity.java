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
		//��ÿؼ�
		initViews();
	}
	
	//��ÿؼ�	
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

	//�ؼ�������
	private OnClickListener onClickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
		switch (v.getId()) {
		//�����¼��ť
		case R.id.login_btn:
			Handler handler = new Handler();
			handler.post(checkThread);
			break;
		 
		//����һ�����	
		case R.id.login_findpassword:
			
			break;
		//�����¼����		
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
			//��¼����
			Login();
		}
	};
	
	//��¼
	private void Login(){
		if (isUserInfo()) {
			System.out.println(isUserInfo());
			startActivity(new Intent(LoginActivity.this,MaininterfaceActivity.class));
			Toast.makeText(LoginActivity.this, username+"����¼�ɹ�", Toast.LENGTH_SHORT).show();
			
		}else {
			return ;
		}
		
	}
	
	
	
	
	//ȡ���û��������룬���ж���Ϸ���
	private Boolean isUserInfo(){
		username=usernameEditText.getText().toString();
		password=passwordEditText.getText().toString();
	
		if (username.equals("")) {
			Toast.makeText(LoginActivity.this, "�û�������Ϊ��", Toast.LENGTH_SHORT).show();
			return false;
		}else if (password.equals("")) {
			Toast.makeText(LoginActivity.this, "���벻��Ϊ��", Toast.LENGTH_SHORT).show();
			return false;
		}
		
		//��ʾ������
		showdlog();
		//��õ�¼���
		String result=query(username,password);
		if (result!=null && result.equals("0") ){
			Toast.makeText(LoginActivity.this, "�û������������", Toast.LENGTH_SHORT).show();
			Handler handler = new Handler();
			handler.post(new Runnable() {
				@Override
				public void run() {
					//dialog��ʧ
					dialog.dismiss();
				}
			});
			
			return false;
		}else if (result==null) {
			Toast.makeText(LoginActivity.this, "���ӷ������쳣", Toast.LENGTH_SHORT).show();
			Handler handler = new Handler();
			handler.post(new Runnable() {
				@Override
				public void run() {
					//dialog��ʧ
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
					//dialog��ʧ
					dialog.dismiss();
					LoginActivity.this.finish();
				}
			});
			return true;
		}
	}

	private String query(String username, String password) {
		// ��ѯ����
		String queryString = "type=user"+"&username="+username+"&password="+password;
		// url
		String url = VariablesOfUrl.APP_BASE_URL+"LoginServlet?"+queryString;
		// ��ѯ���ؽ��
		return  com.soper.util.HttpUtil.queryStringForGet(url);
	}
	
	//��ʾ������
	private void showdlog(){
		dialog = new  ProgressDialog(this);
		dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		dialog.setMessage("������֤�˻������룬���Ե�");
		dialog.show();
		
	}

}
