package com.future.it.park.tranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class SecondInformation extends AppCompatActivity {

    private LinearLayout next,previous;
    private EditText monthly_income,jela,upojela,word,village,home_no,easy_way;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_information);

        next = findViewById(R.id.next);
        previous = findViewById(R.id.previous);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ThirdInformation.class));
                finish();
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),FirstInformation.class));
                finish();
            }
        });

        monthly_income = findViewById(R.id.monthly_income);
        monthly_income.setText(PreferenceUtils.getMonthlyIncome(getApplicationContext()));
        monthly_income.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                PreferenceUtils.setMonthlyIncome(getApplicationContext(),charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        jela = findViewById(R.id.jela);
        jela.setText(PreferenceUtils.getJela(getApplicationContext()));
        jela.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                PreferenceUtils.setJela(getApplicationContext(),charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        upojela = findViewById(R.id.upojela);
        upojela.setText(PreferenceUtils.getUpoJela(getApplicationContext()));
        upojela.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                PreferenceUtils.setUpoJela(getApplicationContext(),charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        word = findViewById(R.id.word);
        word.setText(PreferenceUtils.getWord(getApplicationContext()));
        word.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                PreferenceUtils.setWord(getApplicationContext(),charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        village = findViewById(R.id.village);
        village.setText(PreferenceUtils.getVillage(getApplicationContext()));
        village.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                PreferenceUtils.setVillage(getApplicationContext(),charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        home_no = findViewById(R.id.home_no);
        home_no.setText(PreferenceUtils.getHouseNo(getApplicationContext()));
        home_no.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                PreferenceUtils.setHouseNo(getApplicationContext(),charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        easy_way = findViewById(R.id.easy_way);
        easy_way.setText(PreferenceUtils.getEasyWay(getApplicationContext()));
        easy_way.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                PreferenceUtils.setEasyWay(getApplicationContext(),charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(),FirstInformation.class));
        finish();
    }
}
