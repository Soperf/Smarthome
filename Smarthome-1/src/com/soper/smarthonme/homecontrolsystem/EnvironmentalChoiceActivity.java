package com.soper.smarthonme.homecontrolsystem;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

import com.soper.smarthome.R;
import com.soper.util.ClientThread;
import com.soper.util.VariablesOfUrl;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.widget.*;
import android.widget.CompoundButton.OnCheckedChangeListener;

/**
 * @author 作者:soper E-mail: fxp.2008@163.com
 * @version 创建时间：2013-5-8 上午10:13:38 类说明 :环境快速选择
 */
public class EnvironmentalChoiceActivity extends Activity {
	ToggleButton upButton, backButton, customButton;
	OutputStream os;
	Handler handler;
	Socket s;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.homecontrolsystem_envchoice);
		initViews();

		handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				// 如果消息来自于子线程
				if (msg.what == 0x123) {
					// 将读取的内容追加显示在文本框中
					String stateMsg=msg.obj.toString();
					if (stateMsg.equals("ec_up_button_up")) {
						upButton.setChecked(true);
					}else if(stateMsg.equals("ec_up_button_down")){
						upButton.setChecked(false);
					}
					if (stateMsg.equals("ec_back_button_up")) {
						backButton.setChecked(true);
					}else if (stateMsg.equals("ec_back_button_down")) {
						backButton.setChecked(false);
					}
					if (stateMsg.equals("ec_custom_button_up")) {
						customButton.setChecked(true);
					}else if (stateMsg.equals("ec_custom_button_down")) {
						customButton.setChecked(false);
					}
				}
			}
		};
		try {
			s = new Socket(VariablesOfUrl.SERVICE_IP,
					VariablesOfUrl.SERVICE_PORT);
			// 客户端启动ClientThread线程不断读取来自服务器的数据
			new Thread(new ClientThread(s, handler)).start();
			os = s.getOutputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void initViews() {
		// TODO Auto-generated method stub
		upButton = (ToggleButton) findViewById(R.id.ec_up_button);
		upButton.setOnCheckedChangeListener(onlistener);
		backButton = (ToggleButton) findViewById(R.id.ec_back_button);
		backButton.setOnCheckedChangeListener(onlistener);
		customButton = (ToggleButton) findViewById(R.id.ec_custom_button);
		customButton.setOnCheckedChangeListener(onlistener);

	}

	private OnCheckedChangeListener onlistener = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			switch (buttonView.getId()) {
			// 起床模式按钮
			case R.id.ec_up_button:
				upButton.setChecked(isChecked);
				sendMsg(isChecked ? "ec_up_button_up" : "ec_up_button_off");
				break;
			// 回家模式按钮
			case R.id.ec_back_button:
				upButton.setChecked(isChecked);
				sendMsg(isChecked ? "ec_back_button_up" : "ec_back_button_off");
				break;
			// 回家模式按钮
			case R.id.ec_custom_button:
				upButton.setChecked(isChecked);
				sendMsg(isChecked ? "ec_custom_button_up" : "ec_custom_button_off");
				break;

			default:
				break;
			}
		}
	};

	// 将按钮信息写到输出流中
	private void sendMsg(String string) {
		try {
			os.write(string.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
