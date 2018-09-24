package com.hehe.kyky.guramedia;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends Activity {

    EditText reg_email, reg_fullname, reg_password;
    Button btnRegister;
    private DbModel mDbModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        reg_email = (EditText) findViewById(R.id.reg_email);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        reg_password = (EditText) findViewById(R.id.reg_password);
        reg_fullname = (EditText) findViewById(R.id.reg_fullname);

        mDbModel = new DbModel();

        super.onCreate(savedInstanceState);
        // Set View ke register.xml
        setContentView(R.layout.register);

        TextView loginScreen = (TextView) findViewById(R.id.link_to_login);

        // Mengambil link ke Login form
        loginScreen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Menutup tampilan screen register
                // Beralih ke Login Screen/menutup screen register
                finish();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(reg_email.getText().toString().equals(""))
                {
                    Toast.makeText(RegisterActivity.this, "Input is empty. Please input email.", Toast.LENGTH_SHORT).show();
                }
                else if (reg_password.getText().toString().equals("")) {
                    Toast.makeText(RegisterActivity.this, "Input is empty. Please input password.", Toast.LENGTH_SHORT).show();
                }
                else if (reg_fullname.getText().toString().equals("")) {
                    Toast.makeText(RegisterActivity.this, "Input is empty. Please input your name.", Toast.LENGTH_SHORT).show();
                }
                else {
                    mDbModel.addUser(RegisterActivity.this, LibMy.baseurl+"register.php",reg_fullname.getText().toString(), reg_email.getText().toString(), reg_password.getText().toString());
                }
            }
        });
    }
}