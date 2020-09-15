package cn.edu.bistu.cs.se.android.startservicedemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonStartServiceClick(View view) {
        Intent intent=new Intent(MainActivity.this,MyService.class);
        intent.putExtra("num",10);
        startService(intent);
    }

    public void onButtonStopServiceClick(View view) {
        Intent intent=new Intent(MainActivity.this,MyService.class);
        stopService(intent);
    }
}