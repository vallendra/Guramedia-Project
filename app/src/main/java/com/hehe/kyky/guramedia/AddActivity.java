package com.hehe.kyky.guramedia;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Spinner;
        import android.widget.Toast;

public class AddActivity extends AppCompatActivity
{
    EditText txtNama, txtHarga, txtStok, txtDesc;
    Button btnAdd;
    String nama, harga, stok, desc, booktype;
//    Spinner bookType;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        txtNama = (EditText) findViewById(R.id.txtNama);
        txtHarga = (EditText) findViewById(R.id.txtHarga);
        txtStok = (EditText) findViewById(R.id.txtStok);
        txtDesc = (EditText) findViewById(R.id.txtDesc);
//        bookType = (Spinner) findViewById(R.id.bookType);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                nama = txtNama.getText().toString();
                harga = txtHarga.getText().toString();
                stok = txtStok.getText().toString();
                desc = txtDesc.getText().toString();

                if (nama.equals(""))
                {
                    Toast.makeText(AddActivity.this, "Nama harus diisi", Toast.LENGTH_SHORT).show();
                }

                else if(harga.equals(""))
                {
                    Toast.makeText(AddActivity.this, "Harga harus diisi", Toast.LENGTH_SHORT).show();
                }

                else if(stok.equals(""))
                {
                    Toast.makeText(AddActivity.this, "Stok harus diisi", Toast.LENGTH_SHORT).show();
                }

                else if (desc.equals(""))
                {
                    Toast.makeText(AddActivity.this, "Deskripsi harus diisi", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Data.nama.add(nama);
                    Data.harga.add(harga);
                    Data.stok.add(stok);
                    Data.desc.add(desc);
//                    Data.booktype.add(booktype);
                    Toast.makeText(AddActivity.this, "Data Successfully Added", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AddActivity.this, List.class));
                    finish();
                }
            }
        });

    }
}