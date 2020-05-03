package com.future.it.park.tranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONObject;

public class Porishonkan extends AppCompatActivity {

    private Button abedon;
    private LinearLayout previous;
    private TextView total,success;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_porishonkan);

        String data = getIntent().getStringExtra("data");
        System.out.println(data);

        previous = findViewById(R.id.previous);
        abedon = findViewById(R.id.abedon_kotun);

        total = findViewById(R.id.total);
        success = findViewById(R.id.success);

        try {
            JSONObject jsonObject = new JSONObject(data);
            total.setText(jsonObject.getString("total"));
            success.setText(jsonObject.getString("success"));
        }catch (Exception e){

        }

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });

        abedon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),FirstInformation.class));
                finish();
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
