package com.example.administrator.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    //Android 5.0以下svg作为背景使用需要添加以下代码
//    static {
//        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void jumpTo(View v){startActivity(new Intent(this,SecondActivity.class));}
}
