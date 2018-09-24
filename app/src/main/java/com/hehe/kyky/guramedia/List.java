package com.hehe.kyky.guramedia;


        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.Button;
        import android.widget.ListView;

public class List extends AppCompatActivity
{
    Button btnAdd;
    ListView listData;
    DataAdapter dataAdapter;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        listData = (ListView) findViewById(R.id.listData);

        btnAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(List.this, AddActivity.class));
                finish();
            }
        });



        listData.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                //untuk mau ngapain isi disini hmm...
                Intent i = new Intent(List.this, ProfileActivity.class);
                i.putExtra("POS",position);
                startActivity(i);
                finish();
            }
        });

        dataAdapter = new DataAdapter(this);
        listData.setAdapter(dataAdapter);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        dataAdapter.notifyDataSetChanged();
    }
}