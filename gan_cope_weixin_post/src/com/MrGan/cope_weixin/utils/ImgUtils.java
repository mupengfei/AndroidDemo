package com.MrGan.cope_weixin.utils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.MrGan.gan_cope_weixin_post.R;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.CompressFormat;
import android.util.Base64;
import android.util.Log;

public class ImgUtils {
	/**
	 * 通过Base32将Bitmap转换成Base64字符串
	 * 
	 * @param bit
	 * @return
	 */
	public static String Bitmap2StrByBase64(Bitmap bit) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		bit.compress(CompressFormat.JPEG, 100, bos);// 参数100表示不压缩
		byte[] bytes = bos.toByteArray();
		return Base64.encodeToString(bytes, Base64.DEFAULT);
	}

	public static ByteArrayOutputStream Bitmap2ByteByBase64(Bitmap bit) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		bit.compress(CompressFormat.JPEG, 100, bos);// 参数100表示不压缩
		// byte[] bytes=bos.toByteArray();
		// Log.i("IMAGE_BASE", bytes.length+"");bit.geto
		// return Base64.encode(bytes, Base64.DEFAULT);
		return bos;
	}

	public static byte[] Str2FileByBase64(String str) {
		return Base64.decode(str, Base64.DEFAULT);
	}

	public static void save(byte[] bytes, Activity act) {
		try {
			File ganFile = new File("/ganpost");
			ganFile.mkdirs();
			File file = new File("/ganpost/test.png");
			file.createNewFile();
			// FileOutputStream fout =act.openFileOutput("test2.png",
			// act.MODE_WORLD_READABLE );
			FileOutputStream fout = new FileOutputStream(file);
			fout.write(bytes);

			fout.close();

		}

		catch (Exception e) {

			e.printStackTrace();

		}
	}

	public static void ss() {
		String uriAPI = "http://api.app.kankanews.com/kankan/v5/test";
		/* 建立HTTP Post连线 */
		HttpPost httpRequest = new HttpPost(uriAPI);
		// Post运作传送变数必须用NameValuePair[]阵列储存
		// 传参数 服务端获取的方法为request.getParameter("name")

		StringBuffer buf = new StringBuffer();
		buf.append("{\"phonenum\":\"11111111111\",\"newstext\":\"asdfasdfzchfadjf\",\"imagenum\":1,\"imagegroup\":{\"0\":{\"filename\":\"test.jpg\",\"base64file\":\"");
		// buf.append(strSor);
		buf.append("aaaa\"}}}");

		// String jsonStr =
		// "{\"phonenum\":\"13817157044\",\"newstext\":\"asdfasdfzchfadjf\",\"imagenum\":1,\"imagegroup\":{\"0\":{\"filename\":\"test.jpg\",\"base64file\":\""
		// + "jsojn" + "\"}}}";
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("json", buf.toString()));
		Log.i("IMAGE_JSON", buf.length() + "");
		try {
			// 发出HTTP request
			httpRequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
			// 取得HTTP response
			HttpResponse httpResponse = new DefaultHttpClient()
					.execute(httpRequest);

			// 若状态码为200 ok
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				// 取出回应字串
				String strResult = EntityUtils.toString(httpResponse
						.getEntity());
			} else {
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void send(Activity act) {
		try {
			String uriAPI = "http://api.app.kankanews.com/kankan/v5/test";
			String BOUNDARY = java.util.UUID.randomUUID().toString();
			String PREFIX = "--", LINEND = "\r\n";
			String MULTIPART_FROM_DATA = "multipart/form-data";
			String CHARSET = "UTF-8";
			URL uri;
			uri = new URL(uriAPI);
			HttpURLConnection conn = (HttpURLConnection) uri.openConnection();
			conn.setReadTimeout(5 * 1000);
			conn.setDoInput(true);// 允许输入
			conn.setDoOutput(true);// 允许输出
			conn.setUseCaches(false);
			conn.setRequestMethod("POST"); // Post方式
			conn.setRequestProperty("connection", "keep-alive");
			conn.setRequestProperty("Charsert", "UTF-8");
			conn.setRequestProperty("Content-Type", MULTIPART_FROM_DATA
					+ ";boundary=" + BOUNDARY);
			StringBuilder sb1 = new StringBuilder();    
            sb1.append(PREFIX);    
            sb1.append(BOUNDARY);    
            sb1.append(LINEND);    
            sb1.append("Content-Disposition: form-data; name=\"file\"; filename=\""    
                    + "test.jpg" + "\"" + LINEND);    
            sb1.append("Content-Type: multipart/form-data; charset="    
                    + CHARSET + LINEND);    
            sb1.append(LINEND);  
            
            String topStr =
    		 "{\"phonenum\":\"11111111111\",\"newstext\":\"asdfasdfzchfadjf\",\"imagenum\":1,\"imagegroup\":{\"0\":{\"filename\":\"test.jpg\",\"base64file\":\"";
    		String bottomStr = "\"}}}";
            
            
            DataOutputStream outStream = new DataOutputStream(    
                    conn.getOutputStream());    
            outStream.write(sb1.toString().getBytes()); 
            outStream.write(sb1.toString().getBytes());  
            outStream.write(topStr.toString().getBytes());    
            InputStream is = act.getResources().openRawResource(R.drawable.test);   
//            InputStream is = new FileInputStream(file.getValue());    
            byte[] buffer = new byte[1024];    
            int len = 0;    
            while ((len = is.read(buffer)) != -1) {    
                outStream.write(buffer, 0, len);    
            }    
            is.close();    
            outStream.write(bottomStr.toString().getBytes());   
//            outStream.write(LINEND.getBytes());   
//            InputStream inpu = conn.getInputStream();
//            StringBuffer buf = new StringBuffer();
//            byte[] bufferR = new byte[1024];    
//            while ((len = is.read(buffer)) != -1) {    
//            	buf.append(new String(buffer));    
//            }    
            Log.i("IMAGE_BASE", conn.getResponseCode() + "");
            Log.i("IMAGE_BASE", conn.getResponseMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
