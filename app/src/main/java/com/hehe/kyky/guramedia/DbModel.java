package com.hehe.kyky.guramedia;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class DbModel {

    private AlertDialog.Builder alert;

    public void addUser(final Context context,
                        final String url,
                        final String username,
                        final String email,
                        final String password) {
        alert = new AlertDialog.Builder(context);
        RequestQueue Rq =  Volley.newRequestQueue(context);
        final Map<String,String> Params = new HashMap<String,String>();
        StringRequest Sr = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    String code = jsonObject.getString("code");
                    String message = jsonObject.getString("message");
                    alert.setTitle("Server Response");
                    alert.setMessage(message);
                    displayAlertDialogRegister(code);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Params.put("username", username);
                Params.put("email", email);
                Params.put("password", password);
                return Params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Params.put("content-type", "application/x-www-form-urlencoded");
                return Params;
            }
        };
        Rq.add(Sr);
    }

    public void loginUser(final Context context,
                          final String url,
                          final String username,
                          final String password) {

        alert = new AlertDialog.Builder(context);
        RequestQueue Rq = Volley.newRequestQueue(context);
        final Map<String, String> params = new HashMap<String, String>();
        StringRequest SR = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    String code = jsonObject.getString("code");
                    if (code.equals("login_failed")) {
                        alert.setTitle("FAILED LOGIN");
                        displayAlertDialogLogin(jsonObject.getString("message"));
                    } else {
                        Intent loginIntent = new Intent (context, List.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("username", jsonObject.getString("username"));
                        bundle.putString("email", jsonObject.getString("email"));
                        loginIntent.putExtras(bundle);
                        context.startActivity(loginIntent);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {  //tambah di ErrorListener
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){ //kasih kurawal
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                params.put("username",username);
                params.put("password", password);
                return params; //ganti
            }
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                params.put("content-Type", "application/x-www-form-urlencoded");
                return params;
            }
        };
        Rq.add(SR);
    }

    public void displayAlertDialogLogin (final String dialog) {
        alert.setMessage(dialog);
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() { //ctrl + dialog
            @Override
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        });
        AlertDialog alertDialog = alert.create();
        alertDialog.show();
    }

    public void displayAlertDialogRegister (final String dialog) {
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (dialog.equals("reg_success")) {
                    return;
                } else if (dialog.equals("reg_failed")) {
                    return;
                }
            }
        });
        AlertDialog alertDialog = alert.create();
        alertDialog.show();

    }

}
