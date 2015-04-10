package com.MrGan.cope_weixin.ui;

import java.io.InputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.MrGan.cope_weixin.base.BaseActivity;
import com.MrGan.cope_weixin.utils.ImgUtils;
import com.MrGan.gan_cope_weixin_post.R;

public class MainActivity extends BaseActivity implements OnClickListener  {
	EditText contentEdit=null;
	Button testBut=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.main_activity_layout);
		if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		contentEdit = (EditText)this.findViewById(R.id.main_post_content);
		testBut = (Button)this.findViewById(R.id.main_test_button);
	}

	@Override
	protected void initData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setListener() {
		// TODO Auto-generated method stub
		testBut.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
			case R.id.main_test_button : 
				InputStream in = getResources().openRawResource(R.drawable.test); 
				
				Bitmap bit = BitmapFactory.decodeResource(getResources(), R.drawable.test);
//				Log.i("IMAGE_BASE", ""+bit.getByteCount());
//			try {
//				Log.i("IMAGE_BASE", ""+in.available());
//			} catch (IOException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//				byte[] str = ImgUtils.Bitmap2ByteByBase64(bit);
//				Log.i("IMAGE_BASE", ""+ImgUtils.Str2FileByBase64(str).length);
				ImgUtils.send(this);
			    
				Toast.makeText(getApplicationContext(), Environment.getExternalStorageDirectory().getAbsolutePath(),
				     Toast.LENGTH_LONG).show();
//				ImgUtils.save(ImgUtils.Str2FileByBase64(str), this);
				
		}
	}
	
	
}
