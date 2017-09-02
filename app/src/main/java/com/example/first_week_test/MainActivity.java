package com.example.first_week_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.first_week_test.view.MyCustomActionBar;

/**
 * 综合练习题
 * 1.首先在values文件夹下创建attrs文件
 * 2.创建View类及View类的布局
 */
public class MainActivity extends AppCompatActivity implements MyCustomActionBar.OnButtonClickListener, MyCustomActionBar.OnButton2ClickListener {

    private MyCustomActionBar myCustomActionBar;
    private Button view_but1;
    private Button view_but2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //显示当前页面布局
        setContentView(R.layout.activity_main);
        myCustomActionBar = (MyCustomActionBar) findViewById(R.id.main_MyCustomActionBar);
        myCustomActionBar.setOnButtonClickListener(this);
        myCustomActionBar.setOn2ButtonClickListener(this);
    }

    @Override
    public void OnMyClickListener(View view) {
        Toast.makeText(this, "点击返回", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnMy2ClickListener(View view) {
        Toast.makeText(this, "点击更多", Toast.LENGTH_SHORT).show();
    }
}

