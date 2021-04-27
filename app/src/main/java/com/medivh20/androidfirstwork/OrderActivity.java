package com.medivh20.androidfirstwork;


import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.core.content.ContextCompat;

import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

public class OrderActivity extends AppCompatActivity {
    private ShapeableImageView imageMeal;
    private AppCompatEditText etNum;
    private MaterialTextView tvMealName;
    private AppCompatButton last;
    private AppCompatButton next;
    private AppCompatSeekBar sbScore;
    private MaterialTextView tvScore;
    private RadioGroup rgDinnerware;
    private MaterialCheckBox cbTea;
    private MaterialCheckBox cbPaper;
    private MaterialCheckBox cbStraw;
    private AppCompatButton btnCommit;
    private int[] imageList;
    private String[] mealNameList;
    private int index = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        initView();
        initEvent();
    }

    private void initView() {
        imageMeal = findViewById(R.id.image_order_meal);
        tvMealName = findViewById(R.id.tv_order_name);
        last = findViewById(R.id.btn_order_last);
        next = findViewById(R.id.btn_order_next);
        etNum = findViewById(R.id.et_order_meal_num);
        sbScore = findViewById(R.id.sb_order_score);
        tvScore = findViewById(R.id.tv_order_score);
        rgDinnerware = findViewById(R.id.rg_order_dinnerware);
        cbTea = findViewById(R.id.cb_order_tea);
        cbPaper = findViewById(R.id.cb_order_paper);
        cbStraw = findViewById(R.id.cb_order_straw);
        btnCommit = findViewById(R.id.btn_order_commit);
    }

    private void initEvent() {
        imageList = new int[]{R.drawable.t1,R.drawable.t2,R.drawable.t3};
        mealNameList = new String[]{"小吃套餐","牛排套餐","三明治"};
        imageMeal.setImageDrawable(ContextCompat.getDrawable(OrderActivity.this,imageList[index]));
        tvMealName.setText(mealNameList[index]);
        last.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                index = (index +2)%3;
                imageMeal.setImageDrawable(ContextCompat.getDrawable(OrderActivity.this,imageList[index]));
                tvMealName.setText(mealNameList[index]);
            }
        });
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                index = (index + 1)%3;
                imageMeal.setImageDrawable(ContextCompat.getDrawable(OrderActivity.this,imageList[index]));
                tvMealName.setText(mealNameList[index]);
            }
        });
        sbScore.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvScore.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        btnCommit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(etNum.getText().toString().isEmpty()){
                    Toast.makeText(OrderActivity.this,"请输入用餐人数",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(OrderActivity.this,"提交成功",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
