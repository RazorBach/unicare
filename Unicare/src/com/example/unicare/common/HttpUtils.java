package com.example.unicare.common;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Iterator;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class HttpUtils {
	/**
	 * 客户端向服务器发送post请求
	 * 
	 * @param url
	 *            请求action名
	 * @param jsonObject
	 *            请求数据封装成的JSONObject对象
	 * @param timeout
	 *            本次请求的超时间
	 */
	public static String sendJSONPost(String url, String jsonString)
			throws Exception {
		// 返回的jsonobject对象
		String jsonData = null;
		// 新建HttpPost对象
		HttpPost httpPost = new HttpPost(url);
		// 设置HttpParams对象参数
		HttpParams httpParams = new BasicHttpParams();
		// 防止多次连接服务器报“Make sure to release the connection before allocating
		// another one ”的错误，
		// 可以用以下的几行代码来很好的解决这个问题，大概意思就是需要释放前次连接。
		HttpConnectionParams.setConnectionTimeout(httpParams, 10000);
		HttpConnectionParams.setSoTimeout(httpParams, 10000);
		SchemeRegistry schreg = new SchemeRegistry();
		schreg.register(new Scheme("http", PlainSocketFactory
				.getSocketFactory(), 80));
		schreg.register(new Scheme("https", PlainSocketFactory
				.getSocketFactory(), 443));
		ThreadSafeClientConnManager connManager = new ThreadSafeClientConnManager(
				httpParams, schreg);
		// 新建HttpClient对象
		HttpClient httpClient = new DefaultHttpClient(connManager, httpParams);
		// 设置 Post请求的请求参数
		StringEntity se = new StringEntity(
				URLEncoder.encode(jsonString, "utf8"));
		httpPost.setEntity(se);
		// 设置报文头 (必须要设置如下报文头，否则服务器端request.getInputStream()得不到数据)
		httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
		// httpPost.setHeader("Token", LoginActivity.token);
		// 设置post请求的HTTP报头
		httpPost.setParams(httpParams);
		// HttpClient执行Post方法，获取HttpResponse响应对象
		HttpResponse response = httpClient.execute(httpPost);
		// 获取响应数据
		StatusLine statusLine = response.getStatusLine();
		if (statusLine != null && statusLine.getStatusCode() == 200) {
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String content = readInputStream(entity.getContent());
				if (content != null && content.length() != 1) {
					Log.e("content", content);
					jsonData = content;
				}
			} else {
				jsonData = null;
			}
		} else {
			jsonData = null;
			Log.d("error,code",
					statusLine.getReasonPhrase() + ","
							+ statusLine.getStatusCode());
		}

		return jsonData;
	}

	private static String readInputStream(InputStream is) throws IOException {
		if (is == null)
			return null;
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = is.read(buf)) != -1) {
			bout.write(buf, 0, len);
		}
		is.close();
		return new String(bout.toByteArray());
	}

	/**
	 * 客户端向服务器发送Get请求
	 * 
	 * @param url
	 *            请求action名
	 * @param jsonObject
	 *            请求数据封装成的JSONObject对象
	 * @param timeout
	 *            本次请求的超时间
	 */
	public static JSONObject sendJSONGet(String url, JSONObject jsonObject)
			throws Exception {
		JSONObject jsonData = new JSONObject();// 返回的jsonobject对象
		// 设置HttpParams对象参数
		HttpParams httpParams = new BasicHttpParams();
		// 防止多次连接服务器报“Make sure to release the connection before allocating
		// another one ”的错误，
		// 可以用以下的几行代码来很好的解决这个问题，大概意思就是需要释放前次连接。
		HttpConnectionParams.setConnectionTimeout(httpParams, 5000);
		HttpConnectionParams.setSoTimeout(httpParams, 5000);
		SchemeRegistry schreg = new SchemeRegistry();
		schreg.register(new Scheme("http", PlainSocketFactory
				.getSocketFactory(), 80));
		schreg.register(new Scheme("https", PlainSocketFactory
				.getSocketFactory(), 443));
		ThreadSafeClientConnManager connManager = new ThreadSafeClientConnManager(
				httpParams, schreg);
		HttpClient httpclient = new DefaultHttpClient(connManager, httpParams);
		// 设置 get请求的请求参数
		// 拼接路径字符串将参数包含进去
		if (jsonObject.length() != 0)
			url = url + "?" + getRequestData(jsonObject);
		Log.d("url", url);
		HttpGet get = new HttpGet(url);
		// 添加http头信息
		get.addHeader("Authorization", "your token ");
		get.addHeader("Content-Type", "application/json;charset=utf-8");
		get.addHeader("User-Agent", "your agent");
		// get.addHeader("Token", LoginActivity.token);

		HttpResponse response;
		response = httpclient.execute(get);
		// 检验状态码，如果成功接收数据
		StatusLine statusLine = response.getStatusLine();
		if (statusLine != null && statusLine.getStatusCode() == 200) {
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String content = readInputStream(entity.getContent());
				if (content != null && content.length() != 1) {
					jsonData = new JSONObject(content);
					// Log.e("success", jsonData.toString());
				}
			} else {
				jsonData.put("nulldata", "没有返回相关数据");
			}
		} else {
			jsonData.put("sendfail", "发送失败，可能服务器忙，请稍后再试");
			Log.d("error,code",
					statusLine.getReasonPhrase() + ","
							+ statusLine.getStatusCode());
		}
		return jsonData;
	}

	/**
	 * 封装get参数
	 * 
	 * @param sendData
	 * @return
	 * @throws JSONException
	 */
	private static String getRequestData(JSONObject sendData)
			throws JSONException {
		StringBuffer stringBuffer = new StringBuffer(); // 存储封装好的请求体信息
		Iterator it = sendData.keys();
		// 遍历jsonObject数据，添加到Map对象
		while (it.hasNext()) {
			String key = String.valueOf(it.next());
			Object o = sendData.get(key);
			String value;
			if (o.getClass() == String.class)
				value = o.toString();
			else
				value = String.valueOf(o);
			stringBuffer.append(key).append("=").append(value).append("&");
		}
		stringBuffer.deleteCharAt(stringBuffer.length() - 1); // 删除最后的一个"&"
		return stringBuffer.toString();
	}

	// /**
	// * 客户端向服务器发送Delet请求
	// *
	// * @param url
	// * 请求action名
	// * @param jsonObject
	// * 请求数据封装成的JSONObject对象
	// * @param timeout
	// * 本次请求的超时间
	// */
	// public static JSONObject sendJSONDelete(String url, JSONObject
	// jsonObject)
	// throws Exception {
	// JSONObject jsonData = new JSONObject();// 返回的jsonobject对象
	// HttpClient httpclient = new DefaultHttpClient();
	// // 设置 get请求的请求参数
	// // 拼接路径字符串将参数包含进去
	// if (jsonObject.length() != 0)
	// url = url + "?" + getRequestData(jsonObject);
	// Log.d("url", url);
	// HttpDelete del = new HttpDelete(url);
	// // 添加http头信息
	// del.addHeader("Authorization", "your token ");
	// del.addHeader("Content-Type", "application/json;charset=utf-8");
	// del.addHeader("User-Agent", "your agent");
	// del.addHeader("Token", LoginActivity.token);
	// HttpResponse response;
	// response = httpclient.execute(del);
	// // 检验状态码，如果成功接收数据
	// StatusLine statusLine = response.getStatusLine();
	// if (statusLine != null && statusLine.getStatusCode() == 200) {
	// HttpEntity entity = response.getEntity();
	// if (entity != null) {
	// String content = readInputStream(entity.getContent());
	// if (content != null && content.length() != 1) {
	// jsonData = new JSONObject(content);
	// Log.e("success", jsonData.toString());
	// }
	// } else {
	// jsonData.put("nulldata", "没有返回相关数据");
	// }
	// } else {
	// jsonData.put("sendfail", "发送失败，可能服务器忙，请稍后再试");
	// Log.d("error,code",
	// statusLine.getReasonPhrase() + ","
	// + statusLine.getStatusCode());
	// }
	// return jsonData;
	// }
}
