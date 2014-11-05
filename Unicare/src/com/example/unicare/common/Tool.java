package com.example.unicare.common;

import java.text.DecimalFormat;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

public class Tool {
	
	/**
	 * Toast显示消息
	 * 
	 * @param context
	 * @param msg
	 */
	public static void ShowMessage(Context context, String msg) {
		Toast toast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
	}

//	/**
//	 * 仿iphone的ProgressDialog
//	 * 
//	 * @param context
//	 * @param titile
//	 * @param msg
//	 * @return
//	 */
//	public static Dialog getProDialog(Context context) {
//		View view = View.inflate(context, R.layout.loading, null);
//		Dialog dialog = new Dialog(context, R.style.LoadingDilaog);
//		dialog.setContentView(view);
//		// 开启刷新动画
//		ImageView iv_refresh = (ImageView) view.findViewById(R.id.iv_refresh);
//		AnimationDrawable ad = (AnimationDrawable) iv_refresh.getDrawable();
//		ad.start();
//		// dialog.setCancelable(false);// 按返回键或点击activity对话框不关闭
//		return dialog;
//	}


	/**
	 * 两个字符串时间计算时间间隔
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static String interval(String startTime, String endTime) {
		float inter;

		String[] s1 = startTime.split(":");
		String[] s2 = endTime.split(":");

		int sh, sm, eh, em;
		// s1
		if (s1[0].charAt(0) == '0')
			sh = s1[0].charAt(1) - '0';
		else
			sh = Integer.parseInt(s1[0]);
		if (s1[1].charAt(0) == '0')
			sm = s1[1].charAt(0) - '0';
		else
			sm = Integer.parseInt(s1[1]);
		// s2
		if (s2[0].charAt(0) == '0')
			eh = s2[0].charAt(1) - '0';
		else
			eh = Integer.parseInt(s2[0]);
		if (s2[1].charAt(0) == '0')
			em = s2[1].charAt(0) - '0';
		else
			em = Integer.parseInt(s2[1]);
		System.out.println("sm,em:" + sm + "," + em);
		// 判断startTime和endTime的大小
		if (eh - sh > 0 || (eh - sh == 0 && em - sm >= 0)) {
			inter = (float) (eh - sh + (em - sm) / 60.0);
			System.out.println(eh - sh + (em - sm) / 60);
		} else {
			inter = (float) (24 - (sh - eh + (sm - em) / 60.0));

		}
		return fnum.format(inter);
	}

	static DecimalFormat fnum = new DecimalFormat("##0.0");

	/**
	 * 两个字符串时间计算时间间隔
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
//	public static String interval2(String startTime, String endTime) {
//		float inter;
//		String[] str1 = startTime.split(" ");
//		String[] str2 = endTime.split(" ");
//		String[] s1 = str1[1].split(":");
//		String[] s2 = str2[1].split(":");
//		if (str1[0].equals("下午"))
//			s1[0] = String.valueOf(Integer.parseInt(s1[0]) + 12);
//		if (str2[0].equals("下午"))
//			s2[0] = String.valueOf(Integer.parseInt(s2[0]) + 12);
//		int sh, sm, eh, em;
//		// s1
//		if (s1[0].charAt(0) == '0')
//			sh = s1[0].charAt(0) - '0';
//		else
//			sh = Integer.parseInt(s1[0]);
//		if (s1[1].charAt(0) == '0')
//			sm = s1[1].charAt(0) - '0';
//		else
//			sm = Integer.parseInt(s1[1]);
//		// s2
//		if (s2[0].charAt(0) == '0')
//			eh = s2[0].charAt(0) - '0';
//		else
//			eh = Integer.parseInt(s2[0]);
//		if (s2[1].charAt(0) == '0')
//			em = s2[1].charAt(0) - '0';
//		else
//			em = Integer.parseInt(s2[1]);
//		System.out.println("sm,em:" + sm + "," + em);
//		// 判断startTime和endTime的大小
//		if (eh - sh > 0 || (eh - sh == 0 && em - sm >= 0)) {
//			inter = (float) (eh - sh + (em - sm) / 60.0);
//			System.out.println(eh - sh + (em - sm) / 60);
//		} else {
//			inter = (float) (24 - (sh - eh + (sm - em) / 60.0));
//
//		}
//		return fnum.format(inter);
//	}

	/**
	 * 判断是否有sd卡
	 * 
	 * @return
	 */
	public static boolean hasSdcard() {
		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			return true;
		} else {
			return false;
		}
	}

//	/**
//	 * 为EditText[]对应的view（即下划线）设置获得焦点失去焦点监听事件 EditText... ets 必须做为最后一个参数，否则报错
//	 * 
//	 * @param views
//	 * @param view
//	 */
//	public static void setOnFocuedChanged(final Context context,
//			ViewGroup viewGroup, View... views) {
//		for (int i = 0; i < views.length; i++) {
//			View v = views[i];
//			final View view = viewGroup.findViewWithTag(((String) v.getTag())
//					.substring(0, ((String) v.getTag()).length() - 1));
//			v.setOnFocusChangeListener(new OnFocusChangeListener() {
//
//				@Override
//				public void onFocusChange(View v, boolean hasFocus) {
//					if (hasFocus) {
//						view.setBackgroundColor(context.getResources()
//								.getColor(R.color.publish_input_p));
//					} else {
//						view.setBackgroundColor(context.getResources()
//								.getColor(R.color.publish_input_n));
//					}
//
//				}
//			});
//		}
//	}

	/** 隐藏软键盘 **/
	public static void closeKeyBoard(Context context) {
		View view = ((Activity) context).getWindow().peekDecorView();
		if (view != null) {
			InputMethodManager inputmanger = (InputMethodManager) context
					.getSystemService(Context.INPUT_METHOD_SERVICE);
			inputmanger.hideSoftInputFromWindow(view.getWindowToken(), 0);
		}
	}
	
//	public static void getSignature(Context context) {
//		PackageInfo packageInfo;
//		Signature[] signatures;
//		StringBuilder builder = new StringBuilder();
//		String signature;
//		PackageManager manager = context.getPackageManager();
//		{
//			try {
//				/** 通过包管理器获得指定包名包含签名的包信息 **/
//				packageInfo = manager.getPackageInfo("com.example.timemarket",
//						PackageManager.GET_SIGNATURES);
//				/******* 通过返回的包信息获得签名数组 *******/
//				signatures = packageInfo.signatures;
//				/******* 循环遍历签名数组拼接应用签名 *******/
//				for (Signature signature2 : signatures) {
//					builder.append(signature2.toCharsString());
//				}
//				/************** 得到应用签名 **************/
//				signature = builder.toString();
//				Log.d("signature", signature);
//			} catch (NameNotFoundException e) {
//				e.printStackTrace();
//			}
//		}
//	}
}
