package com.example.layout_basics;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 任务1：线性布局（LinearLayout）。
 * 外层竖直方向均分四行，每行水平方向用 layout_weight 分配四列宽度，
 * 第二列 weight = 2，明显比其他列宽。
 */
public class LinearLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
    }
}
