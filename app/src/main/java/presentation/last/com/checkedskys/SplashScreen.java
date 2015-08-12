package presentation.last.com.checkedskys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


public class SplashScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent i = new Intent("com.coderefer.androidsplashscreenexample.MAINACTIVITY");
                    startActivity(i);
                    finish();
                }
            }
        };
        timerThread.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
