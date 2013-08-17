package com.soper.smarthonme.homecontrolsystem;

import com.soper.smarthome.R;

import android.app.Activity;
import android.app.ActivityGroup;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
 * @version 创建时间：2013-5-7 下午9:38:24 
 * 类说明 :
 */
public class HomecontrolsAvtivity extends ActivityGroup {
	//标题栏
	private ImageButton tback,tlogout;
	private TextView title;
	
	private ViewFlipper mViewFlipper;
	private GridView menuGridView;
	//底部菜单的名字
	private String []menuGridViewNames = null;
	//未选择时 显示的图片资源id
	private int []menuGridViewUnSelectedImgs = null;
	//选择时 显示的图片资源id
	private int []menuGridViewSelectedImgs = null;
	//上次点击的位置，当前点击的位置
	private int lastClickPosition,clickPosition;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.homecontrolsystem);
		
		initRes();
        findViews();
        setValues();
        setListeners();
		
	}
	
	
	//设置底部菜单内容
	private void initRes() {
		menuGridViewNames = new String[4];
    	menuGridViewNames[0] = this.getString(R.string.tab_1);
    	menuGridViewNames[1] = this.getString(R.string.tab_2);
    	menuGridViewNames[2] = this.getString(R.string.app_3);
    	menuGridViewNames[3] = this.getString(R.string.app_4);
    	
    	menuGridViewUnSelectedImgs = new int[4];
    	menuGridViewUnSelectedImgs[0] = R.drawable.mode1;
    	menuGridViewUnSelectedImgs[1] = R.drawable.light;
    	menuGridViewUnSelectedImgs[2] = R.drawable.wind;
    	menuGridViewUnSelectedImgs[3] = R.drawable.tv1;
    	
    	menuGridViewSelectedImgs = new int[4];
    	menuGridViewSelectedImgs[0] = R.drawable.mode;
    	menuGridViewSelectedImgs[1] = R.drawable.light1;
    	menuGridViewSelectedImgs[2] = R.drawable.wind1;
    	menuGridViewSelectedImgs[3] = R.drawable.tv;
    	
	}
	
	//找到控件
	private void findViews() {
		tback =(ImageButton)findViewById(R.id.button_homecontrol_back);
		tback.setOnClickListener(onClickListener);
		tlogout=(ImageButton)findViewById(R.id.button_homecontrol_logout);
		tlogout.setOnClickListener(onClickListener);
		
		title=(TextView)findViewById(R.id.title_homecontrol);
		
		menuGridView = (GridView)this.findViewById(R.id.gridview);
    	mViewFlipper = (ViewFlipper)this.findViewById(R.id.content);
    	
    	
	}
	private OnClickListener onClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.button_homecontrol_back:
				finish();
				break;
			case R.id.button_homecontrol_logout:
				
				break;
				

			default:
				break;
			}
		}
	};
	
	//设置菜单栏
	private void setValues() {
		// TODO Auto-generated method stub
		menuGridView.setAdapter(new BottomMenuGridView(this));
    	menuGridView.setNumColumns(4);
    	//menuGridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
    	menuGridView.setGravity(Gravity.CENTER);
    	
    	switchActivity(AppConstants.INDEX_ACTIVITY_INDEX);
    	
	}
	
	private void setListeners() {
		menuGridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				//Log.i(TAG, "arg2="+arg2+"; arg3="+arg3);
				lastClickPosition = clickPosition;
				clickPosition = arg2;
				if(lastClickPosition == clickPosition) return; //防止重复点击同一个菜单
				
				RelativeLayout temp = (RelativeLayout)menuGridView.getChildAt(arg2);
				//temp.setBackgroundResource(R.drawable.product_title_bg);
				temp.getChildAt(0).setBackgroundResource(menuGridViewSelectedImgs[arg2]);
				
				for(int i=0; i<menuGridViewNames.length; i++) {
					if(i != arg2) {
						RelativeLayout temp2 = (RelativeLayout)menuGridView.getChildAt(i);
						temp2.setBackgroundDrawable(null);
						temp2.getChildAt(0).setBackgroundResource(menuGridViewUnSelectedImgs[i]);
					}
				}
				
				switchActivity(arg2);
				
			}
    		
		});
	}
	
	private void switchActivity(int index) {
		 String activityId = null;
		 Intent intent = null;
		 
		 switch(index) {
		 case AppConstants.INDEX_ACTIVITY_INDEX:
			 intent = new Intent(this,EnvironmentalChoiceActivity.class);
			 activityId = AppConstants.INDEX_ACTIVITY;
			 title.setText("环境快捷选择");
			 break;
			 
		 case AppConstants.TYPE_ACTIVITY_INDEX:
			 intent = new Intent(this,Light.class);
			 activityId = AppConstants.TYPE_ACTIVITY;
			 title.setText("灯光控制");
			 break;
			 
		 case AppConstants.RANK_ACTIVITY_INDEX:
			 intent = new Intent(this,CurtainActivity.class);
			 activityId = AppConstants.RANK_ACTIVITY;
			 title.setText("窗帘控制");
			 break;
		 case AppConstants.LOCAL_MANAGER_ACTIVITY_INDEX:
			 intent = new Intent(this,ApplianceActivity.class);
			 activityId = AppConstants.LOCAL_MANAGER_ACTIVITY;
			 title.setText("家电控制");
			 break;
		 }
		 
		 if(activityId != null) {
			 toActivity(activityId, intent);
		 }
		
	 }
	
	/**
	  *  切换到指定activity
	  * @param activityId
	  * @param intent
	  */
	 public void toActivity(String activityId,Intent intent) {
	    	intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	    	View view = getLocalActivityManager().startActivity(activityId, intent).getDecorView();
	    
	    	mViewFlipper.removeAllViews();
	    	mViewFlipper.addView(view);
	    	mViewFlipper.showNext();
	    }
	
	
	private class BottomMenuGridView extends BaseAdapter {

    	private LayoutInflater mInflater;
    	
    	public BottomMenuGridView(Context ctx) {
    		this.mInflater = LayoutInflater.from(ctx);
    	}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
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
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			MenuViewHolder viewHolder;
			if(convertView == null) {
				convertView = mInflater.inflate(R.layout.homecontrolsystem_item_tab, null);
				viewHolder = new MenuViewHolder();
				viewHolder.imageView = (ImageView)convertView.findViewById(R.id.image_item);
				//viewHolder.textView = (TextView)convertView.findViewById(R.id.text_item);
				convertView.setTag(viewHolder);
			}else {
				viewHolder = (MenuViewHolder)convertView.getTag();
			}
			viewHolder.imageView.setBackgroundResource(menuGridViewUnSelectedImgs[position]);
			//viewHolder.textView.setText(menuGridViewNames[position]);
			
			return convertView;
		}
    	
    }
    
    private final class MenuViewHolder {
    	public ImageView imageView;
    	public TextView textView;
    }
    
	
	
	
}




