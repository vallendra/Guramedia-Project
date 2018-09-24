package com.hehe.kyky.guramedia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity
{
    EditText txtHarga, txtNama, txtStok, txtDesc;
    Button btnEdit;
    String nama,harga, stok, desc, booktype;
//    Spinner bookType;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        txtNama = (EditText) findViewById(R.id.txtNama);
        txtDesc = (EditText) findViewById(R.id.txtDesc);
        txtStok = (EditText) findViewById(R.id.txtDesc);
        txtHarga = (EditText) findViewById(R.id.txtHarga);
        btnEdit = (Button) findViewById(R.id.btnEdit);
//        bookType = (Spinner) findViewById(R.id.bookType);

        i = getIntent().getIntExtra("POS", -1);

        btnEdit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                stok = txtStok.getText().toString();
                desc = txtDesc.getText().toString();
                nama = txtNama.getText().toString();
                harga = txtHarga.getText().toString();
                int i = -1;
                try
                {
                    i =Integer.parseInt(harga);
                }

                catch (Exception e)
                {
                    e.printStackTrace();
                }
                if (nama.equals(""))
                {
                    Toast.makeText(EditActivity.this, "Nama Harus Diisi", Toast.LENGTH_SHORT).show();
                }

                else if(desc.equals(""))
                {
                    Toast.makeText(EditActivity.this, "Deskripsi Harus Diisi", Toast.LENGTH_SHORT).show();
                }

                else if(stok.equals(""))
                {
                    Toast.makeText(EditActivity.this, "Stok Harus Diisi", Toast.LENGTH_SHORT).show();
                }

                else if (harga.equals(""))
                {
                    Toast.makeText(EditActivity.this, "Harga harus diisi", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Data.nama.set(i, nama);
                    Data.stok.set(i, stok);
                    Data.desc.set(i, desc);
                    Data.harga.set(i, harga);
//                    Data.booktype.set(i, booktype);
                    Toast.makeText(EditActivity.this, "Data Successfully Added", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(EditActivity.this, List.class));
                    finish();
                }
            }
        });
    }
}
