package com.future.it.park.tranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class ShowInformation extends AppCompatActivity {

    private TextView name,father,mother,mobile,national_id,occupation,familymemeber,monthly_income,house_no,easy_way,comment,permanent_address;
    private MaterialDialog md;
    private Button edit,submit;
    private String URL1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_information);
        URL1 = PreferenceUtils.getIP(getApplicationContext()) + "create_recipient";

        name = findViewById(R.id.name);
        name.setText(PreferenceUtils.getUserName(getApplicationContext()));

        father = findViewById(R.id.father);
        father.setText(PreferenceUtils.getFather(getApplicationContext()));

        mother = findViewById(R.id.mother);
        mother.setText(PreferenceUtils.getMother(getApplicationContext()));

        mobile = findViewById(R.id.mobile);
        mobile.setText(PreferenceUtils.getMobile(getApplicationContext()));

        national_id = findViewById(R.id.national_id);
        national_id.setText(PreferenceUtils.getNationalId(getApplicationContext()));

        occupation = findViewById(R.id.occupation);
        occupation.setText(PreferenceUtils.getOccupation(getApplicationContext()));

        familymemeber = findViewById(R.id.familymemeber);
        familymemeber.setText(PreferenceUtils.getFamilyMember(getApplicationContext()));

        monthly_income = findViewById(R.id.monthly_income);
        monthly_income.setText(PreferenceUtils.getMonthlyIncome(getApplicationContext()));

        house_no = findViewById(R.id.house_no);
        house_no.setText(PreferenceUtils.getHouseNo(getApplicationContext()));

        easy_way = findViewById(R.id.easy_way);
        easy_way.setText(PreferenceUtils.getEasyWay(getApplicationContext()));

        comment = findViewById(R.id.comment);
        comment.setText(PreferenceUtils.getComment(getApplicationContext()));

        permanent_address= findViewById(R.id.permanent_address);
        permanent_address.setText(PreferenceUtils.getPermanentAddress(getApplicationContext()));

        edit = findViewById(R.id.edit);
        submit = findViewById(R.id.submit);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),FirstInformation.class));
                finish();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(hasInternetConnection()){
                    UploadInforamtion();
                    showLoading();
                }else{
                    showErrorAlert("Please Turn On Internet Connection!!!!!!");
                }

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }

    void showSuccessAlert(){
        boolean wrapInScrollView=true;
        final MaterialDialog md=new MaterialDialog.Builder(ShowInformation.this)
                .customView(R.layout.success_response_alert, wrapInScrollView)
                .show();
        View views = md.getCustomView();
        Button btn = views.findViewById(R.id.buttonOk);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                removePreference();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });



    }

    public void removePreference(){
        PreferenceUtils.setUserName(getApplicationContext(),"");
        PreferenceUtils.setFather(getApplicationContext(),"");

        PreferenceUtils.setMother(getApplicationContext(),"");
        PreferenceUtils.setMobile(getApplicationContext(),"");

        PreferenceUtils.setNationalId(getApplicationContext(),"");
        PreferenceUtils.setOccupation(getApplicationContext(),"");

        PreferenceUtils.setFamilyMember(getApplicationContext(),"");
        PreferenceUtils.setMonthlyIncome(getApplicationContext(),"");

        PreferenceUtils.setHouseNo(getApplicationContext(),"");

        PreferenceUtils.setEasyWay(getApplicationContext(),"");
        PreferenceUtils.setComment(getApplicationContext(),"");

        PreferenceUtils.setJela(getApplicationContext(),"");
        PreferenceUtils.setUpoJela(getApplicationContext(),"");
        PreferenceUtils.setWord(getApplicationContext(),"");
        PreferenceUtils.setVillage(getApplicationContext(),"");
        PreferenceUtils.setPermanentAddress(getApplicationContext(),"");

    }

    void showErrorAlert(String msg){
        boolean wrapInScrollView=true;
        final MaterialDialog md=new MaterialDialog.Builder(ShowInformation.this)
                .customView(R.layout.error_response_alert, wrapInScrollView)
                .show();
        View views = md.getCustomView();
        TextView textView=views.findViewById(R.id.positiontext);
        textView.setText(msg);
        Button btn = views.findViewById(R.id.buttonOk);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                md.dismiss();
            }
        });

    }

    void showLoading(){
        boolean wrapInScrollView=true;
        md=new MaterialDialog.Builder(ShowInformation.this)
                .customView(R.layout.loading_alert, wrapInScrollView)
                .show();

    }

    private boolean hasInternetConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;
        try {
            ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo[] netInfo = cm.getAllNetworkInfo();
            for (NetworkInfo ni : netInfo) {
                if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                    if (ni.isConnected())
                        haveConnectedWifi = true;
                if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                    if (ni.isConnected())
                        haveConnectedMobile = true;
            }
        } catch (Exception e){

        }

        return haveConnectedWifi || haveConnectedMobile;
    }

    public void UploadInforamtion() {
        System.out.println(uniqueCurrentTimeMS());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);
                md.dismiss();
                try {

                    JSONObject erjson = new JSONObject(response);
                    if(erjson.getString("error").equals("false")) {
                        showSuccessAlert();
                    }else{
                        showErrorAlert(erjson.getString("msg"));

                    }
                }catch (Exception e){

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                md.dismiss();
                showErrorAlert("Already Requested Using This Number Or NID !!!!");
                System.out.println(error);
            }
        }){
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("name", PreferenceUtils.getUserName(getApplicationContext()));
                params.put("father", PreferenceUtils.getFather(getApplicationContext()));
                params.put("mother", PreferenceUtils.getMother(getApplicationContext()));
                params.put("mobile", PreferenceUtils.getMobile(getApplicationContext()));
                params.put("national_id", PreferenceUtils.getNationalId(getApplicationContext()));
                params.put("occupation", PreferenceUtils.getOccupation(getApplicationContext()));
                params.put("family_member", PreferenceUtils.getFamilyMember(getApplicationContext()));
                params.put("monthly_income", PreferenceUtils.getMonthlyIncome(getApplicationContext()));
                params.put("jela", PreferenceUtils.getJela(getApplicationContext()));
                params.put("upojela", PreferenceUtils.getUpoJela(getApplicationContext()));
                params.put("word", PreferenceUtils.getWord(getApplicationContext()));
                params.put("village", PreferenceUtils.getVillage(getApplicationContext()));
                params.put("house_no", PreferenceUtils.getHouseNo(getApplicationContext()));
                params.put("easy_way", PreferenceUtils.getEasyWay(getApplicationContext()));
                params.put("comment", PreferenceUtils.getComment(getApplicationContext()));
                params.put("status", "0");
                params.put("user_id","DCK"+uniqueCurrentTimeMS());
                params.put("permanent_address",PreferenceUtils.getPermanentAddress(getApplicationContext()));

                return params;
            }
        };
        Volley.newRequestQueue(getApplicationContext()).add(stringRequest);
    }

    private  final AtomicLong LAST_TIME_MS = new AtomicLong();
    public  String uniqueCurrentTimeMS() {
        long now = System.currentTimeMillis();
        while(true) {
            long lastTime = LAST_TIME_MS.get();
            if (lastTime >= now)
                now = lastTime+1;
            if (LAST_TIME_MS.compareAndSet(lastTime, now))
                return Long.toString(now);
        }
    }
}
