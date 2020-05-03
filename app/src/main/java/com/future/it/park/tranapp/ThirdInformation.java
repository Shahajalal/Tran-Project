package com.future.it.park.tranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class ThirdInformation extends AppCompatActivity {

    private LinearLayout previous;
    private EditText comment,permanent_address;
    private Button jachai_korun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_information);

        previous = findViewById(R.id.previous);


        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SecondInformation.class));
                finish();
            }
        });

        jachai_korun = findViewById(R.id.jachai_korun);

        jachai_korun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ShowInformation.class));
                finish();
            }
        });

        comment = findViewById(R.id.comment);
        comment.setText(PreferenceUtils.getComment(getApplicationContext()));
        comment.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                PreferenceUtils.setComment(getApplicationContext(),charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        permanent_address = findViewById(R.id.permanent_address);
        permanent_address.setText(PreferenceUtils.getPermanentAddress(getApplicationContext()));
        permanent_address.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                PreferenceUtils.setPermanentAddress(getApplicationContext(),charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(),SecondInformation.class));
        finish();
    }
}
