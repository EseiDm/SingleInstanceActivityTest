package org.esei.dm.launchmodetest;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button close = findViewById(R.id.buttonCloseActivity);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button launchMainActivity = findViewById(R.id.buttonLaunchMainActivity);
        launchMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this, MainActivity.class);
                count = count+1;
                i.putExtra(MainActivity.EXTRA_COUNT, count);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        int val = intent.getIntExtra(MainActivity.EXTRA_COUNT, 0);
        this.count=val;
        Toast.makeText(MainActivity2.this, "NEW INTENT WITH VAL" + val, Toast.LENGTH_SHORT).show();
    }
}