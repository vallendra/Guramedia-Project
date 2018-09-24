package com.hehe.kyky.guramedia;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;


public class ProfileActivity extends AppCompatActivity
{
    TextView txtNama, txtHarga, txtPenulis;
    Button btnEdit, btnDelete;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        txtNama = (TextView) findViewById(R.id.txtNama);
        txtHarga = (TextView) findViewById(R.id.txtHarga);
        txtPenulis = (TextView) findViewById(R.id.txtPenulis);
        btnEdit = (Button) findViewById(R.id.btnEdit);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        i = getIntent().getIntExtra("POS",-1);
        txtNama.setText(Data.nama.get(i));
        txtPenulis.setText(Data.penulis.get(i));
        txtHarga.setText(Data.harga.get(i));

        btnEdit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(ProfileActivity.this, EditActivity.class);
                intent.putExtra("POS",i);
                startActivity(intent);
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Data.nama.remove(i);
                Data.harga.remove(i);
                Data.penulis.remove(i);
                startActivity(new Intent(ProfileActivity.this, List.class));
                finish();
            }
        });
    }
}
