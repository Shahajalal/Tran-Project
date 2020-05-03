package com.future.it.park.tranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class FirstInformation extends AppCompatActivity {

    private LinearLayout next,previous;
    private EditText name,father,mother,mobile,national_id,occupation,familymemeber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_information);

        next = findViewById(R.id.next);
        previous = findViewById(R.id.previous);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SecondInformation.class));
                finish();
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });

        name = findViewById(R.id.name);
        name.setText(PreferenceUtils.getUserName(getApplicationContext()));
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                PreferenceUtils.setUserName(getApplicationContext(),charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        father = findViewById(R.id.father);
        father.setText(PreferenceUtils.getFather(getApplicationContext()));
        father.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                PreferenceUtils.setFather(getApplicationContext(),charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mother = findViewById(R.id.mother);
        mother.setText(PreferenceUtils.getMother(getApplicationContext()));
        mother.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                PreferenceUtils.setMother(getApplicationContext(),charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mobile = findViewById(R.id.mobile);
        mobile.setText(PreferenceUtils.getMobile(getApplicationContext()));
        mobile.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                PreferenceUtils.setMobile(getApplicationContext(),charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        national_id = findViewById(R.id.national_id);
        national_id.setText(PreferenceUtils.getNationalId(getApplicationContext()));
        national_id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                PreferenceUtils.setNationalId(getApplicationContext(),charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        occupation = findViewById(R.id.occupation);
        occupation.setText(PreferenceUtils.getOccupation(getApplicationContext()));
        occupation.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                PreferenceUtils.setOccupation(getApplicationContext(),charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        familymemeber = findViewById(R.id.familymemeber);
        familymemeber.setText(PreferenceUtils.getFamilyMember(getApplicationContext()));
        familymemeber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                PreferenceUtils.setFamilyMember(getApplicationContext(),charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }
}
