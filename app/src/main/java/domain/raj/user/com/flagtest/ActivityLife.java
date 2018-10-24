package domain.raj.user.com.flagtest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

public class ActivityLife extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse("http://androidium.org"));
        startActivity(intent);

        TextView dd=(TextView)findViewById(R.id.click);
        dd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityLife.this,ActivityLife2.class));
            }
        });
        System.out.println("LIFE onCreate");
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.grafmeng, new FrgmentLife(), "dd")
                .disallowAddToBackStack()
                .commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("LIFE onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("LIFE onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("LIFE onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("LIFE onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("LIFE onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("LIFE onDestroy");
    }
}
