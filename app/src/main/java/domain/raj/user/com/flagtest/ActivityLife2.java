package domain.raj.user.com.flagtest;

import android.app.Activity;
import android.os.Bundle;

public class ActivityLife2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("LIFE2 onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("LIFE2 onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("LIFE2 onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("LIFE2 onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("LIFE2 onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("LIFE2 onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("LIFE2 onDestroy");
    }
}
