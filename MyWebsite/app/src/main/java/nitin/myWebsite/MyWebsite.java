package nitin.myWebsite;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;


public class MyWebsite extends Activity {

    private WebView myWebView;//only useful if it going to be used at many places
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_java_book);

        //find web view
        myWebView = (WebView)findViewById(R.id.webView);

        //Change made on Jun 29 2019
        myWebView.getSettings().setJavaScriptEnabled(true);

        //open asset/index.html
        myWebView.loadUrl("https://nitinkc.github.io");

        String customHtml = "<html><body><h1>Hello, WebView</h1></body></html>";
        //myWebView.loadData(customHtml, "text/html", "UTF-8");

        /* Problem encountered : file:///android_asset/index.html link doesn't exist
        *Solution found in this link : https://developer.chrome.com/multidevice/webview/gettingstarted
        * Create directory called ASSETS inside src/main and call it as asset!! how foolish!!
        * */
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_java_book, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //check if the key event was the back button and if there is history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()){
            myWebView.goBack();
            return true;
        }

        //if it wasn't the back key or there is no web history, bubble up the default
        //system behaviour (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }
}
