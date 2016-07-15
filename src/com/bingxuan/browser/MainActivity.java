package com.bingxuan.browser;

import android.R.anim;
import android.R.integer;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Switch;


public class MainActivity extends ActionBarActivity {

	WebView webView;
	ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.webview);
        progressBar=(ProgressBar) findViewById(R.id.progressbar);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://www.baidu.com");
        
        webView.setWebViewClient(new WebViewClient(){

			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				// TODO Auto-generated method stub
				super.onPageStarted(view, url, favicon);
				progressBar.setVisibility(android.view.View.VISIBLE);
			}

			@Override
			public void onPageFinished(WebView view, String url) {
				// TODO Auto-generated method stub
				super.onPageFinished(view, url);
				progressBar.setVisibility(android.view.View.GONE);
			}

			@Override
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				// TODO Auto-generated method stub
				super.onReceivedError(view, errorCode, description, failingUrl);
				progressBar.setVisibility(android.view.View.GONE);
			}
        
        });
    }
    public boolean onKeyDown(int keyCode,KeyEvent event){
		if (keyCode==KeyEvent.KEYCODE_BACK && webView.canGoBack()){
			webView.goBack();
			return true;
		}
    	return super.onKeyDown(keyCode,event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        menu.add(Menu.NONE,1,1,"退出").setIcon(android.R.drawable.ic_menu_close_clear_cancel);
        menu.add(Menu.NONE,2,2,"个人中心");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
		case 1:
			MainActivity.this.finish();
			break;
		case 2:
			Intent intent=new Intent(MainActivity.this,PersonalActivity.class);
			startActivity(intent);
			break;
    	}
    	return false;
    }
}
