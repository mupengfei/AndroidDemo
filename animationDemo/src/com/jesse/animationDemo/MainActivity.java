package com.jesse.animationDemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.animationdemo.R;

public class MainActivity extends Activity implements OnClickListener {
	Button goTweenButton = null;
	Button goTweenXMLButton = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.main_activity);
		goTweenButton = (Button) this.findViewById(R.id.go_tween_animation);
		goTweenXMLButton = (Button) this.findViewById(R.id.go_tween_animation_XML);
		goTweenButton.setOnClickListener( this);
		goTweenXMLButton.setOnClickListener( this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		int id = arg0.getId();
		switch (id){
			case R.id.go_tween_animation: goTween();break;
			case R.id.go_tween_animation_XML: goTweenXML();break;
		}
		
	}

	private void goTween() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, TweenAnimationActivity.class);
		this.startActivity(intent);
	}

	private void goTweenXML() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, TweenAnimationXMLActivity.class);
		this.startActivity(intent);
	}

}
