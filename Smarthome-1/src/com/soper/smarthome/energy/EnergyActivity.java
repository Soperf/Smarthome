package com.soper.smarthome.energy;

import com.soper.smarthome.R;

import android.app.ActivityGroup;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import android.widget.AdapterView.OnItemClickListener;

/** 
 * @author 作者:soper E-mail: fxp.2008@163.com
 * @version 创建时间：2013-5-12 上午1:34:03 
 * 类说明 :
 */
public class EnergyActivity extends ActivityGroup {
	// 标题栏
		private ImageButton tback, tlogout;
		private TextView title;

		private ViewFlipper mViewFlipper;
		private GridView menuGridView;
		// 底部菜单的名字
		private String[] menuGridViewNames = null;
		// 未选择时 显示的图片资源id
		private int[] menuGridViewUnSelectedImgs = null;
		// 选择时 显示的图片资源id
		private int[] menuGridViewSelectedImgs = null;
		// 上次点击的位置，当前点击的位置
		private int lastClickPosition, clickPosition;

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			requestWindowFeature(Window.FEATURE_NO_TITLE);
			setContentView(R.layout.energy);

			initRes();

			initViews();

			setValues();

			setListeners();
		}

		// 设置底部菜单栏
		private void initRes() {
			menuGridViewUnSelectedImgs = new int[4];
			menuGridViewUnSelectedImgs[0] = R.drawable.mode1;
			menuGridViewUnSelectedImgs[1] = R.drawable.mode1;
			menuGridViewUnSelectedImgs[2] = R.drawable.mode1;
			menuGridViewUnSelectedImgs[3] = R.drawable.mode1;

			menuGridViewSelectedImgs = new int[4];
			menuGridViewSelectedImgs[0] = R.drawable.mode;
			menuGridViewSelectedImgs[1] = R.drawable.mode;
			menuGridViewSelectedImgs[2] = R.drawable.mode;
			menuGridViewSelectedImgs[3] = R.drawable.mode;

		}

		// 找到控件
		private void initViews() {
			tback = (ImageButton) findViewById(R.id.button_energy_back);
			tback.setOnClickListener(onClickListener);
			tlogout = (ImageButton) findViewById(R.id.button_energy_logout);
			tlogout.setOnClickListener(onClickListener);

			title = (TextView) findViewById(R.id.text_energy_title);

			menuGridView = (GridView) this.findViewById(R.id.energy_gridview);
			mViewFlipper = (ViewFlipper) this.findViewById(R.id.energy_content);

		}

		private OnClickListener onClickListener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				switch (v.getId()) {
				case R.id.button_energy_back:
					finish();
					break;
				case R.id.button_energy_logout:

					break;

				default:
					break;
				}
			}
		};

		// 设置菜单栏
		private void setValues() {
			// TODO Auto-generated method stub
			menuGridView.setAdapter(new BottomMenuGridView(this));
			menuGridView.setNumColumns(4);
			// menuGridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
			menuGridView.setGravity(Gravity.CENTER);

			switchActivity(AppConstantsOfEnergy.SOCKET_ACTIVITY_INDEX);

		}

		private void setListeners() {
			menuGridView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					lastClickPosition = clickPosition;
					clickPosition = position;
					if (lastClickPosition == clickPosition)
						return; // 防止重复点击同一个菜单
					RelativeLayout tmp = (RelativeLayout) menuGridView
							.getChildAt(position);
					tmp.getChildAt(0).setBackgroundResource(
							menuGridViewSelectedImgs[position]);
					for (int i = 0; i < menuGridViewUnSelectedImgs.length; i++) {
						if (i != position) {
							RelativeLayout temp2 = (RelativeLayout) menuGridView
									.getChildAt(i);
							temp2.setBackgroundDrawable(null);
							temp2.getChildAt(0).setBackgroundResource(
									menuGridViewUnSelectedImgs[i]);
						}
					}
					switchActivity(position);

				}
			});

		}

		private void switchActivity(int position) {
			String activityId = null;
			Intent intent = null;
			switch (position) {
			case AppConstantsOfEnergy.SOCKET_ACTIVITY_INDEX:
				intent = new Intent(this,SoceketActivity.class);
				activityId = AppConstantsOfEnergy.SOCKET_ACTIVITY;
				title.setText("智能电插座");
				 
				break;
			case AppConstantsOfEnergy.DETECTION_ACTIVITY_INDEX:
				intent = new Intent(this, DetectionActivity.class);
				activityId = AppConstantsOfEnergy.DETECTION_ACTIVITY;
				title.setText("电能实时监测");
				break;
			case AppConstantsOfEnergy.ELECTRIC_ACTIVITY_INDEX:
				intent = new Intent(this, ElectricActivity.class);
				activityId = AppConstantsOfEnergy.ELECTRIC_ACTIVITY;
				title.setText("电能优化");
				break;
			case AppConstantsOfEnergy.ELECTROVALEBCE_ACTIVITY_INDEX:
				intent = new Intent(this, ElectrovalenceActivity.class);
				activityId = AppConstantsOfEnergy.ELECTROVALEBCE_ACTIVITY;
				title.setText("电价优化");
				break;
			 

			}

			if (activityId != null) {
				toActivity(activityId, intent);
			}
		}

		private void toActivity(String activityId, Intent intent) {
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			View view = getLocalActivityManager().startActivity(activityId, intent)
					.getDecorView();

			mViewFlipper.removeAllViews();
			mViewFlipper.addView(view);
			mViewFlipper.showNext();
		}

		private class BottomMenuGridView extends BaseAdapter {
			private LayoutInflater mInflater;

			public BottomMenuGridView(Context context) {
				this.mInflater = LayoutInflater.from(context);
			}

			@Override
			public int getCount() {
				return menuGridViewUnSelectedImgs.length;
			}

			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				MenuViewHolder viewHolder;
				if (convertView == null) {
					convertView = mInflater.inflate(R.layout.energy_item_tab, null);
					viewHolder = new MenuViewHolder();
					viewHolder.imageView = (ImageView) convertView
							.findViewById(R.id.image_energy_item);
					convertView.setTag(viewHolder);
				} else {
					viewHolder = (MenuViewHolder) convertView.getTag();
				}
				viewHolder.imageView
						.setBackgroundResource(menuGridViewUnSelectedImgs[position]);

				return convertView;
			}

		}

		private final class MenuViewHolder {
			public ImageView imageView;
			// public TextView textView;
		}
}
