package com.jesse.animationDemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.animationdemo.R;

public class TweenAnimationXMLActivity extends Activity {

	private Button rotateButton = null;
	private Button scaleButton = null;
	private Button alphaButton = null;
	private Button translateButton = null;
	private ImageView image = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tween_animation);

		rotateButton = (Button) findViewById(R.id.rotateButton);
		scaleButton = (Button) findViewById(R.id.scaleButton);
		alphaButton = (Button) findViewById(R.id.alphaButton);
		translateButton = (Button) findViewById(R.id.translateButton);
		image = (ImageView) findViewById(R.id.image);

		rotateButton.setOnClickListener(new RotateButtonListener());
		scaleButton.setOnClickListener(new ScaleButtonListener());
		alphaButton.setOnClickListener(new AlphaButtonListener());
		translateButton.setOnClickListener(new TranslateButtonListener());
	}

	class AlphaButtonListener implements OnClickListener {
		public void onClick(View v) {
			// 使用AnimationUtils装载动画配置文件
			Animation animation = AnimationUtils.loadAnimation(
					TweenAnimationXMLActivity.this, R.anim.alpha);
			// 启动动画
			image.startAnimation(animation);
		}
	}

	class RotateButtonListener implements OnClickListener {
		public void onClick(View v) {
			Animation animation = AnimationUtils.loadAnimation(
					TweenAnimationXMLActivity.this, R.anim.rotate);
			image.startAnimation(animation);
		}
	}

	class ScaleButtonListener implements OnClickListener {
		public void onClick(View v) {
			Animation animation = AnimationUtils.loadAnimation(
					TweenAnimationXMLActivity.this, R.anim.scale);
			image.startAnimation(animation);
		}
	}

	class TranslateButtonListener implements OnClickListener {
		public void onClick(View v) {
			Animation animation = AnimationUtils.loadAnimation(
					TweenAnimationXMLActivity.this, R.anim.translate);
			image.startAnimation(animation);
		}
	}
}