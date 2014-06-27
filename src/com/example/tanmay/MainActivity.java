package com.example.tanmay;

import java.util.Random;


import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;

public class MainActivity extends Activity {

	private GaugeView mGaugeView1;
	private GaugeView mGaugeView2;
	private final Random RAND = new Random();
	//Change these values to get your required minimum and maximum
	float min=25.0f;
	float max=35.0f;
	//Change the position for the minimum and maximum on the dial with respect to 100
	float start=20.0f;
	float end=80.0f;

	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mGaugeView1 = (GaugeView) findViewById(R.id.gauge_view1);
		mGaugeView2 = (GaugeView) findViewById(R.id.gauge_view2);
		//setting configurable parameters for the gaugeview
		mGaugeView1.setMinMaxWithPosition(min, max,start,end);
		mTimer.start();
	}

	int i=11;
	private final CountDownTimer mTimer = new CountDownTimer(20000, 1000) {

		@Override
		public void onTick(final long millisUntilFinished) {
			//mGaugeView1.setTargetValue(RAND.nextInt(101));
			//mGaugeView2.setTargetValue(RAND.nextInt(101));
			if(i<min)
			mGaugeView2.setBackgroundColor(0xa00000ff);
			else if(i>=min && i<max)
			mGaugeView2.setBackgroundColor(0x00000000);
			else
			mGaugeView2.setBackgroundColor(0xa0ff0000);
			
			mGaugeView1.setTargetValue(start+(i-min)*((end-start)/(max-min)));
			mGaugeView2.setTargetValue(i);
			i=i+2;
			
		}

		@Override
		public void onFinish() {}
	};
}