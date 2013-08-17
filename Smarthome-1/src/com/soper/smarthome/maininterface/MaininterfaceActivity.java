package com.soper.smarthome.maininterface;

import com.soper.smarthome.R;
import com.soper.smarthome.baby.BabyActivity;
import com.soper.smarthome.cloud.CloudActivity;
import com.soper.smarthome.energy.EnergyActivity;
import com.soper.smarthome.old.OldActivity;
import com.soper.smarthome.secure.SecureActivity;
import com.soper.smarthonme.homecontrolsystem.HomecontrolsAvtivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * @author 作者:soper E-mail: fxp.2008@163.com
 * @version 创建时间：2013-5-7 下午7:55:43 类说明 :
 */
public class MaininterfaceActivity extends Activity {
	LinearLayout homecontrol, homesecure, energy, cloud, baby, old;
	RelativeLayout mainView;
	GestureDetector mGestureDetector;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.maininterface);
		initViews();
		mGestureDetector = new GestureDetector(onGestureListener);

	}

	private void initViews() {
		// TODO Auto-generated method stub
		homecontrol = (LinearLayout) findViewById(R.id.homecontrols_linear);
		homecontrol.setOnClickListener(onClickListener);
		homesecure = (LinearLayout) findViewById(R.id.homesecure_linear);
		homesecure.setOnClickListener(onClickListener);
		energy = (LinearLayout) findViewById(R.id.energy_linear);
		energy.setOnClickListener(onClickListener);
		cloud = (LinearLayout) findViewById(R.id.cloud_linear);
		cloud.setOnClickListener(onClickListener);
		baby = (LinearLayout) findViewById(R.id.baby_linear);
		baby.setOnClickListener(onClickListener);
		old = (LinearLayout) findViewById(R.id.old_linear);
		old.setOnClickListener(onClickListener);

		mainView = (RelativeLayout) findViewById(R.id.mainView);
		mainView.setOnTouchListener(onTouchListener);
		mainView.setLongClickable(true);

	}

	private OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.homecontrols_linear:
				startActivity(new Intent(MaininterfaceActivity.this,
						HomecontrolsAvtivity.class));
				break;
			case R.id.homesecure_linear:
				startActivity(new Intent(MaininterfaceActivity.this,
						SecureActivity.class));
				break;
			case R.id.energy_linear:
				startActivity(new Intent(MaininterfaceActivity.this,
						EnergyActivity.class));
				break;
			case R.id.cloud_linear:
				startActivity(new Intent(MaininterfaceActivity.this,
						CloudActivity.class));
				break;
			case R.id.baby_linear:
				startActivity(new Intent(MaininterfaceActivity.this,
						BabyActivity.class));
				break;
			case R.id.old_linear:
				startActivity(new Intent(MaininterfaceActivity.this,
						OldActivity.class));
				break;
			default:
				break;
			}
		}
	};

	private OnGestureListener onGestureListener = new OnGestureListener() {

		@Override
		public boolean onSingleTapUp(MotionEvent e) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void onShowPress(MotionEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean onScroll(MotionEvent e1, MotionEvent e2,
				float distanceX, float distanceY) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void onLongPress(MotionEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			// TODO Auto-generated method stub
			if (e1.getX() - e2.getX() > 10 && Math.abs(velocityX) >0) {
				// 切换Activity
				Intent intent = new Intent(MaininterfaceActivity.this,HomecontrolsAvtivity.class);
				startActivity(intent);

			} else if (e2.getX() - e1.getX() > 10 && Math.abs(velocityX) > 0) {
				// 切换Activity
				finish();

			}

			return false;
		}

		@Override
		public boolean onDown(MotionEvent e) {
			// TODO Auto-generated method stub
			return false;
		}
	};

	private OnTouchListener onTouchListener = new OnTouchListener() {

		@Override
		public boolean onTouch(View v, MotionEvent event) {
			// TODO Auto-generated method stub
			return mGestureDetector.onTouchEvent(event);
		}
	};

}
