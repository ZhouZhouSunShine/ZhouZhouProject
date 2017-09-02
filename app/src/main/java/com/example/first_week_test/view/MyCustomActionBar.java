package com.example.first_week_test.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.first_week_test.R;

/**
 * Created by 范晋炜 on 2017/9/2 0002.
 * com.example.first_week_test.view
 * MyCustomActionBar
 */


public class MyCustomActionBar extends LinearLayout{


    private LinearLayout linearLayout;
    private Button view_but1;
    private Button view_but2;
    private TextView view_title;
    private TypedArray typedArray;
    private int titleBg;
    private float titleSize;
    private int titleColor;
    private String title;
    private int buttonBg;
    private String buttonText;
    private float buttonSize;
    private int buttonColor;
    private String buttonText2;
    private int buttonBg2;

    public MyCustomActionBar(Context context) {
        super(context);
        initView(context,null);
    }

    public MyCustomActionBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        //加载布局
        View inflate = inflate(context, R.layout.my_action_bar_layout,this);
        //获取资源ID
        linearLayout = (LinearLayout) inflate.findViewById(R.id.container);
        view_but1 = (Button) inflate.findViewById(R.id.view_but1);
        view_but2 = (Button) inflate.findViewById(R.id.view_but2);
        view_title = (TextView) inflate.findViewById(R.id.view_title);

        view_but1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnButtonClickListener != null){
                    mOnButtonClickListener.OnMyClickListener(v);
                }
            }
        });

        view_but2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnButton2ClickListener != null){
                    mOnButton2ClickListener.OnMy2ClickListener(v);
                }
            }
        });

        if(attrs == null){
            return;
        }
        //调用方法
        initAttrs(context,attrs);
        setViewContent();
    }


    //设置控件的属性
    private void initAttrs(Context context, AttributeSet attrs) {
        if(attrs == null){
            return;
        }
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyCustomActionBar);
        //文字内容
        title = typedArray.getString(R.styleable.MyCustomActionBar_action_bar_title_text);
        //标题的背景颜色
        titleBg = typedArray.getColor(R.styleable.MyCustomActionBar_action_bar_titleBg_color, Color.GRAY);
        //标题字体大小
        titleSize = typedArray.getDimension(R.styleable.MyCustomActionBar_action_bar_title_size, 15);
        //标题文字颜色
        titleColor = typedArray.getColor(R.styleable.MyCustomActionBar_action_bar_title_text_color, Color.RED);

        //按钮的属性
        
        //按钮的文字内容
        buttonText = typedArray.getString(R.styleable.MyCustomActionBar_action_bar_button_text);
        //按钮的背景颜色
//        buttonBg = typedArray.getColor(R.styleable.MyCustomActionBar_action_bar_buttonBg_color, Color.BLUE);
//        buttonBg = typedArray.getDrawable(R.styleable.MyCustomActionBar_action_bar_buttonBg_color);
        //按钮二的背景颜色
//        buttonBg2 = typedArray.getColor(R.styleable.MyCustomActionBar_action_bar_buttonBg_color2, Color.BLUE);
        //按钮的字体大小
        buttonSize = typedArray.getDimension(R.styleable.MyCustomActionBar_action_bar_button_size, 15);
        //按钮的文字颜色
        buttonColor = typedArray.getColor(R.styleable.MyCustomActionBar_action_bar_button_color, Color.GREEN);
        //按钮二的文字
        buttonText2 = typedArray.getString(R.styleable.MyCustomActionBar_action_bar_button_text2);

    }

    private void setViewContent(){

        //设置标题
        //设置标题的背景颜色
        view_title.setBackgroundColor(titleBg);
        //设置标题的内容
        view_title.setText(title);
        //设置标题的字体大小
        view_title.setTextSize(titleSize);
        //设置标题的文字颜色
        view_title.setTextColor(titleColor);

        //设置按钮一
        //设置按钮的背景颜色
//        view_but1.setBackgroundColor(buttonBg);
        //设置按钮的内容
        view_but1.setText(buttonText);
        //设置按钮的字体大小
        view_but1.setTextSize(buttonSize);
        //设置按钮的文字颜色
        view_but1.setTextColor(buttonColor);

        //设置按钮二
        //设置按钮的背景颜色
//        view_but2.setBackgroundColor(buttonBg2);
        //设置按钮的内容
        view_but2.setText(buttonText2);
        //设置按钮的字体大小
        view_but2.setTextSize(buttonSize);
        //设置按钮的文字颜色
        view_but2.setTextColor(buttonColor);
    }

    //定义接口
    private OnButtonClickListener mOnButtonClickListener;

    public interface OnButtonClickListener{
        void OnMyClickListener(View view);
    }

    public void setOnButtonClickListener(OnButtonClickListener onButtonClickListener){
        mOnButtonClickListener = onButtonClickListener;
    }

    private OnButton2ClickListener mOnButton2ClickListener;

    public interface OnButton2ClickListener{
        void OnMy2ClickListener(View view);
    }

    public void setOn2ButtonClickListener(OnButton2ClickListener onButton2ClickListener){
        mOnButton2ClickListener = onButton2ClickListener;
    }

}
