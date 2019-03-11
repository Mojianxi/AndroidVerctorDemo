package com.example.administrator.myapplication;

import android.annotation.TargetApi;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {
    //Android 5.0以下svg作为背景使用需要添加以下代码
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    }
    public void anim(View v){
        ImageView imageView= (ImageView) v;
        Drawable drawable=imageView.getDrawable();
        if(drawable instanceof Animatable){
            ((Animatable)drawable).start();
        }
    }
    //路径动画在5.0以下不兼容
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void animL(View view) {
      if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
          ImageView imageView = (ImageView) view;
          AnimatedVectorDrawable drawable = (AnimatedVectorDrawable) getDrawable(R.drawable.fivestar_anim);
          imageView.setImageDrawable(drawable);
          if (drawable != null) {
              drawable.start();
          }
      }
    }
}
