package org.esei.dm.launchmodetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_COUNT = "EXTRA_COUNT";
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button  =findViewById(R.id.buttonLaunchActivity2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
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
        this.count = val;
        Toast.makeText(MainActivity.this, "NEW INTENT WITH VAL " + val, Toast.LENGTH_SHORT).show();
    }
}