package com.reader.rss;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.Toast;

public class FirstPage extends Activity {

	
	protected static final long DELAY_MILLONS = 3000;
	private Handler mHandler=new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			if (msg.what==0) {
				//执行完之后的动作
				Intent intent=new Intent(FirstPage.this, MyChListActivity.class);
				startActivity(intent);
				FirstPage.this.finish();
//				Toast.makeText(FirstPage.this, "Go to Activity Main", Toast.LENGTH_SHORT).show();
			}
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.first_page);
		//add show here
		
		goToMainActivity();
	}

	private void goToMainActivity() {
		// TODO Auto-generated method stub
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				mHandler.sendEmptyMessageDelayed(0, DELAY_MILLONS);
			}
		}).start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}