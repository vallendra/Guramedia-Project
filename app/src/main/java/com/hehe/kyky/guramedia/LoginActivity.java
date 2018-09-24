package com.hehe.kyky.guramedia;
//Langsung login asal username password

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {

    EditText log_email, log_password;
    Button btnLogin;
    TextView registerScreen;
    private DbModel mDbModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        log_email = (EditText) findViewById(R.id.log_email);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        log_password = (EditText) findViewById(R.id.log_password);
        registerScreen = (TextView) findViewById(R.id.link_to_register);

        mDbModel = new DbModel();

        // Mengambil link ke register new account
        registerScreen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Beralih ke tampilan screen Register
                startActivity(new Intent (LoginActivity.this, RegisterActivity.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View arg0) {

                if(log_email.getText().toString().equals(""))
                {
                    Toast.makeText(LoginActivity.this, "Input is empty. Please input email.", Toast.LENGTH_SHORT).show();
                }
                else if (log_password.getText().toString().equals("")) {
                    Toast.makeText(LoginActivity.this, "Input is empty. Please input password.", Toast.LENGTH_SHORT).show();
                }
                else {
                    mDbModel.loginUser(LoginActivity.this, LibMy.baseurl + "login.php", log_email.getText().toString(), log_password.getText().toString());
                }
            }
        });


    }


}