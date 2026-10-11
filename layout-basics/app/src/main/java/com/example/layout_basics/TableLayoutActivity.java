package com.example.layout_basics;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 任务2：表格布局（TableLayout）。
 * 复刻官方 "Hello TableLayout" 菜单：stretchColumns="1" 拉伸快捷键列，
 * 两条分隔线把 Import / Export 与其他菜单项隔开。
 */
public class TableLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
    }
}
