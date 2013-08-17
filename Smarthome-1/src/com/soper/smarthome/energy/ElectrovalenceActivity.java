package com.soper.smarthome.energy;

import com.soper.smarthome.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/** 
 * @author 作者:soper E-mail: fxp.2008@163.com
 * @version 创建时间：2013-5-12 上午1:43:03 
 * 类说明 :
 */
public class ElectrovalenceActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.energy_electrovalence);
	  }
}
