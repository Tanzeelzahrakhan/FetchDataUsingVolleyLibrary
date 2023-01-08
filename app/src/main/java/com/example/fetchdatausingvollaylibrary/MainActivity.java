package com.example.fetchdatausingvollaylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
TextView tvName,tvUserName,tvemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvName=findViewById(R.id.textView);
        tvUserName=findViewById(R.id.textView2);
        tvemail=findViewById(R.id.textView3);
        String URL="https://jsonplaceholder.typicode.com/users";

         StringRequest request= new StringRequest(URL, new Response.Listener<String>() {
             @Override
             public void onResponse(String response) {
                 try {
                     JSONArray jsonArray=new JSONArray(response);
                     JSONObject jsonObject=jsonArray.getJSONObject(0);
                     String Name=jsonObject.getString("name");
                     String Username=jsonObject.getString("username");
                     String Email=jsonObject.getString("email");
                     tvName.setText(Name);
                     tvUserName.setText(Username);
                     tvemail.setText(Email);


                 } catch (JSONException e) {
                     e.printStackTrace();
                 }
             }
         }, new Response.ErrorListener() {
             @Override
             public void onErrorResponse(VolleyError error) {

             }
         });
        RequestQueue requestQueue= Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);

    }
}