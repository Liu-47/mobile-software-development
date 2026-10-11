package com.example.layout_basics;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 任务4：约束布局（ConstraintLayout）—— 火星航班预订页（DEPART）。
 * 两条垂直百分比辅助线均分顶部标签栏；卡片、开关、装饰图、底部按钮
 * 全部通过约束定位，不使用嵌套布局。
 */
public class MarsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mars);
    }
}
