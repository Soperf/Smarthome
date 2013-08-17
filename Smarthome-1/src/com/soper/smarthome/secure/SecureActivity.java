package com.soper.smarthome.secure;

import com.soper.smarthome.R;

import android.app.Activity;
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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

/**
 * @author ����:soper E-mail: fxp.2008@163.com
 * @version ����ʱ�䣺2013-5-11 ����10:38:58 ��˵�� :
 */
public class SecureActivity extends ActivityGroup {

	// ������
	private ImageButton tback, tlogout;
	private TextView title;

	private ViewFlipper mViewFlipper;
	private GridView menuGridView;
	// �ײ��˵�������
	private String[] menuGridViewNames = null;
	// δѡ��ʱ ��ʾ��ͼƬ��Դid
	private int[] menuGridViewUnSelectedImgs = null;
	// ѡ��ʱ ��ʾ��ͼƬ��Դid
	private int[] menuGridViewSelectedImgs = null;
	// �ϴε����λ�ã���ǰ�����λ��
	private int lastClickPosition, clickPosition;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.secure);

		initRes();

		initViews();

		setValues();

		setListeners();
	}

	// ���õײ��˵���
	private void initRes() {
		menuGridViewUnSelectedImgs = new int[5];
		menuGridViewUnSelectedImgs[0] = R.drawable.mode1;
		menuGridViewUnSelectedImgs[1] = R.drawable.mode1;
		menuGridViewUnSelectedImgs[2] = R.drawable.mode1;
		menuGridViewUnSelectedImgs[3] = R.drawable.mode1;
		menuGridViewUnSelectedImgs[4] = R.drawable.mode1;

		menuGridViewSelectedImgs = new int[5];
		menuGridViewSelectedImgs[0] = R.drawable.mode;
		menuGridViewSelectedImgs[1] = R.drawable.mode;
		menuGridViewSelectedImgs[2] = R.drawable.mode;
		menuGridViewSelectedImgs[3] = R.drawable.mode;
		menuGridViewSelectedImgs[4] = R.drawable.mode;

	}

	// �ҵ��ؼ�
	private void initViews() {
		tback = (ImageButton) findViewById(R.id.button_secure_back);
		tback.setOnClickListener(onClickListener);
		tlogout = (ImageButton) findViewById(R.id.button_secure_logout);
		tlogout.setOnClickListener(onClickListener);

		title = (TextView) findViewById(R.id.text_secure_title);

		menuGridView = (GridView) this.findViewById(R.id.secure_gridview);
		mViewFlipper = (ViewFlipper) this.findViewById(R.id.secure_content);

	}

	private OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.button_secure_back:
				finish();
				break;
			case R.id.button_secure_logout:

				break;

			default:
				break;
			}
		}
	};

	// ���ò˵���
	private void setValues() {
		// TODO Auto-generated method stub
		menuGridView.setAdapter(new BottomMenuGridView(this));
		menuGridView.setNumColumns(5);
		// menuGridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
		menuGridView.setGravity(Gravity.CENTER);

		switchActivity(AppConstantsOfSecure.VIDEO_ACTIVITY_INDEX);

	}

	private void setListeners() {
		menuGridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				lastClickPosition = clickPosition;
				clickPosition = position;
				if (lastClickPosition == clickPosition)
					return; // ��ֹ�ظ����ͬһ���˵�
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
		case AppConstantsOfSecure.VIDEO_ACTIVITY_INDEX:
			intent = new Intent(this, VideoActivity.class);
			activityId = AppConstantsOfSecure.VIDEO_ACTIVITY;
			title.setText("��Ƶ���");

			break;
		case AppConstantsOfSecure.FIRE_ACTIVITY_INDEX:
			intent = new Intent(this, FireActivity.class);
			activityId = AppConstantsOfSecure.FIRE_ACTIVITY;
			title.setText("����ϵͳ");
			break;
		case AppConstantsOfSecure.STEAL_ACTIVITY_INDEX:
			intent = new Intent(this, StealActivity.class);
			activityId = AppConstantsOfSecure.STEAL_ACTIVITY;
			title.setText("����ϵͳ");
			break;
		case AppConstantsOfSecure.GAS_ACTIVITY_INDEX:
			intent = new Intent(this, GasActivity.class);
			activityId = AppConstantsOfSecure.GAS_ACTIVITY;
			title.setText("ú�����ϵͳ");
			break;
		case AppConstantsOfSecure.SOS_ACTIVITY_INDEX:
			intent = new Intent(this, SosActivity.class);
			activityId = AppConstantsOfSecure.SOS_ACTIVITY;
			title.setText("����ϵͳ");
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
				convertView = mInflater.inflate(R.layout.secure_item_tab, null);
				viewHolder = new MenuViewHolder();
				viewHolder.imageView = (ImageView) convertView
						.findViewById(R.id.image_secure_item);
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
