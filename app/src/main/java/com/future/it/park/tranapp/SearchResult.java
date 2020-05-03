package com.future.it.park.tranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
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

public class SearchResult extends AppCompatActivity {

    private Button submit;
    private CheckBox checkbox;
    private MaterialDialog md;
    private String URL1;
    private TextView name,comment, easy_way, house_no,monthly_income,occupation,familymemeber,national_id,mother_name,father_name,unique_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        URL1 = PreferenceUtils.getIP(getApplicationContext()) + "update_recipient";
        String data = getIntent().getStringExtra("data");
        System.out.println(data);
        name = findViewById(R.id.name);
        comment = findViewById(R.id.comment);
        easy_way = findViewById(R.id.easy_way);
        house_no = findViewById(R.id.house_no);
        monthly_income = findViewById(R.id.monthly_income);
        occupation = findViewById(R.id.occupation);
        familymemeber = findViewById(R.id.familymemeber);
        national_id = findViewById(R.id.national_id);
        mother_name = findViewById(R.id.mother_name);
        father_name = findViewById(R.id.father_name);
        unique_id = findViewById(R.id.unique_id);
        checkbox = findViewById(R.id.checkbox);

        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(checkbox.isChecked()){
                   if(hasInternetConnection()){
                       updateStatus();
                       showLoading();
                   }else{
                       showErrorAlert("No Internet Connection");
                   }
               }else{
                   showErrorAlert("Please Confirm The CheckBox");
               }
            }
        });

        try{
            JSONObject js = new JSONObject(data);

            unique_id.setText(js.getString("user_id"));
            name.setText(js.getString("name"));
            father_name.setText(js.getString("father"));
            mother_name.setText(js.getString("mother"));
            national_id.setText(js.getString("national_id"));
            occupation.setText(js.getString("occupation"));
            familymemeber.setText(js.getString("family_member"));
            monthly_income.setText(js.getString("monthly_income"));
            house_no.setText(js.getString("house_no"));
            easy_way.setText(js.getString("easy_way"));
            comment.setText(js.getString("comment"));

        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(),SearchRecipient.class));
        finish();
    }

    void showErrorAlert(String msg){
        boolean wrapInScrollView=true;
        final MaterialDialog md=new MaterialDialog.Builder(SearchResult.this)
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
        md=new MaterialDialog.Builder(SearchResult.this)
                .customView(R.layout.loading_alert, wrapInScrollView)
                .show();

    }

    void showSuccessAlert(){
        boolean wrapInScrollView=true;
        final MaterialDialog md=new MaterialDialog.Builder(SearchResult.this)
                .customView(R.layout.success_response_alert, wrapInScrollView)
                .show();
        View views = md.getCustomView();
        Button btn = views.findViewById(R.id.buttonOk);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),SearchRecipient.class);
                startActivity(intent);
                finish();
            }
        });



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

    public void updateStatus() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                md.dismiss();
                System.out.println(response);
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
                showErrorAlert("Problem To Connection With Server!!!!!!!");
                System.out.println(error);
            }
        }){
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("unique_id", unique_id.getText().toString());
                params.put("id",PreferenceUtils.getSupportId(getApplicationContext()));
                return params;
            }
        };
        Volley.newRequestQueue(getApplicationContext()).add(stringRequest);
    }
}
