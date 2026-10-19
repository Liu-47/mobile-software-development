package com.example.mobilelabs;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 实验二 · 任务3：约束布局（ConstraintLayout）—— 计算器界面。
 * 4 行按键各用一条水平链（Chain）等宽分布，行与行纵向依次约束。
 */
public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }
}
