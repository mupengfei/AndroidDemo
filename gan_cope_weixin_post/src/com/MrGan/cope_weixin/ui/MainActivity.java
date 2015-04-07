package com.MrGan.cope_weixin.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.MrGan.cope_weixin.base.BaseActivity;
import com.MrGan.gan_cope_weixin_post.R;

public class MainActivity extends BaseActivity implements OnClickListener  {
	EditText contentEdit=null;
	Button testBut=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.main_activity_layout);
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
				Toast.makeText(getApplicationContext(), contentEdit.getText(),
				     Toast.LENGTH_SHORT).show();;
		}
	}
	
	
}
