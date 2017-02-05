package com.example.android_custom_toast;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 自定义Toast工具类
 * @author Jack
 * @version 创建时间：2014年6月14日  下午2:51:54
 */
public class CustomToast extends Toast {

	/** 上下文对象 */
	private static Context mContext;
	/**  Toast对象 */
	private static CustomToast mToast;
	/**  Toast中显示的文本 */
	private static TextView mShow;
	
	/**
	 * 获得toast的单例实例，在Application初始化的时候使用
	 * @param context
	 */
	public synchronized static void getNewInstance(Context context){
		if(mToast == null){
			mContext = context;
			mToast = new CustomToast(mContext);
		}
	}
	
	/**
	 * 单例模式
	 * @param context
	 */
	private CustomToast(Context context) {
		super(context);
		initView();
	}
	
	/**
	 * 重新设置布局
	 * @param context
	 */
	private void initView(){
		DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
		int padding = ((int)displayMetrics.density * 10);
		mShow = new TextView(mContext);
		mShow.setBackgroundResource(R.drawable.bg_toast);
		//设置最小宽度
		mShow.setMinWidth((int)(displayMetrics.density * 200));
		//设置最大宽度
		mShow.setMaxWidth((int)(displayMetrics.widthPixels - displayMetrics.density * 100));
		//设置内边距
		mShow.setPadding(padding, padding, padding, padding);
		//设置对其方式
		mShow.setGravity(Gravity.CENTER);
		//设置字体颜色
		mShow.setTextColor(mContext.getResources().getColor(android.R.color.black));
		//设置新展示样式
		setView(mShow);
	}
	
	/**
	 * 显示toast
	 * @param message
	 * @param duruation 显示的时长
	 */
	public static void show(int messageId, int duruation){
		if(mShow == null){
			throw new NullPointerException("CustomToast is Null");
		}
		mShow.setText(messageId);
		mToast.setDuration(duruation);
		mToast.show();
	}
	
	/**
	 * 显示toast
	 * @param message
	 * @param duruation 显示的时长
	 */
	public static void show(String message, int duruation){
		if(mShow == null){
			throw new NullPointerException("CustomToast is Null");
		}
		mShow.setText(message);
		mToast.setDuration(duruation);
		mToast.show();
	}
}

